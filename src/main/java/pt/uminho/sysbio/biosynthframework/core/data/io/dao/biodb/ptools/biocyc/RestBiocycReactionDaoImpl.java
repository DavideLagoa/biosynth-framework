package pt.uminho.sysbio.biosynthframework.core.data.io.dao.biodb.ptools.biocyc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycReactionCrossReferenceEntity;
import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycReactionEcNumberEntity;
import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycReactionEntity;
import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycReactionLeftEntity;
import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycReactionRightEntity;
import pt.uminho.sysbio.biosynthframework.core.data.io.dao.biodb.ptools.biocyc.parser.BioCycReactionXMLParser;
import pt.uminho.sysbio.biosynthframework.io.ReactionDao;

@Repository
public class RestBiocycReactionDaoImpl extends AbstractRestfullBiocycDao 
		implements ReactionDao<BioCycReactionEntity> {

	private static Logger LOGGER = LoggerFactory.getLogger(RestBiocycReactionDaoImpl.class);
	
	public void createFolderIfNotExists(String path) {
		File file = new File(path);
		
		if (!file.exists()) {
			LOGGER.info(String.format("Make Dir %s", path));
			file.mkdirs();
		}
	}
	
	@Override
	public BioCycReactionEntity getReactionById(Long id) {
		throw new RuntimeException("Unsupported Operation");
	}

	@Override
	public BioCycReactionEntity getReactionByEntry(String entry) {
		String restRxnQuery = String.format(RestBiocycReactionDaoImpl.xmlGet, pgdb, entry);
		BioCycReactionEntity rxn = null;
		
		LOGGER.debug(String.format("Query: %s", restRxnQuery));
		try {
			String localPath = String.format("%s/%s/reaction/", this.getLocalStorage(), pgdb);
			createFolderIfNotExists(localPath);
			localPath = localPath.concat(entry + ".xml");
			String xmlDoc = null;
			
			LOGGER.debug(String.format("Local Path: %s", localPath));
			xmlDoc = this.getLocalOrWeb(restRxnQuery, localPath);
			BioCycReactionXMLParser parser = new BioCycReactionXMLParser(xmlDoc);
			
			if (!parser.isValid()) {
				return null;
			}
			
			
//			String source = parser.getSource();
			String frameId = parser.getFrameId();
			String entry_ = parser.getEntry();
			List<BioCycReactionEcNumberEntity> ecNumberEntities = parser.getEcNumbers();
			List<BioCycReactionLeftEntity> leftEntities = parser.getLeft();
			List<BioCycReactionRightEntity> rightEntities = parser.getRight();
			List<BioCycReactionCrossReferenceEntity> crossReferences = parser.getCrossReferences();
			List<String> parentStrings = parser.getParents();
			List<String> pathwayStrings = parser.getPathways();
			List<String> enzymaticReactionStrings = parser.getEnzymaticReactions();
			Boolean orphan = parser.isOrphan();
			Boolean physioRel = parser.isPhysiologicallyRelevant();
			Double gibbs = parser.getGibbs();
			String direction = parser.getReactionDirection();
			Boolean translocation = false;
			
			
			Set<String> compartments = new HashSet<> ();
			for (BioCycReactionLeftEntity l : leftEntities) compartments.add(l.getCompartment());
			for (BioCycReactionRightEntity r : rightEntities) compartments.add(r.getCompartment());
			if (compartments.size() > 1) {
				LOGGER.debug("Multiple compartments found: " + compartments);
				translocation = true;
			}
			
			rxn = new BioCycReactionEntity();
			rxn.setEntry(entry_);
			rxn.setTranslocation(translocation);
			rxn.setFrameId(frameId);
			rxn.setReactionDirection(direction);
			rxn.setGibbs(gibbs);
			rxn.setEcNumbers(ecNumberEntities);
			rxn.setPhysiologicallyRelevant(physioRel);
			rxn.setParents(parentStrings);
			rxn.setPathways(pathwayStrings);
			rxn.setEnzymaticReactions(enzymaticReactionStrings);
			rxn.setOrphan(orphan);
			rxn.setLeft(leftEntities);
			rxn.setRight(rightEntities);
			rxn.setCrossreferences(crossReferences);
			rxn.setSource(pgdb);
			
			
		} catch (IOException e) {
			LOGGER.error(String.format("IO ERROR - %s", e.getMessage()));
		}
		
		
		return rxn;
	}

	@Override
	public BioCycReactionEntity saveReaction(BioCycReactionEntity reaction) {
		throw new RuntimeException("Unsupported Operation");
	}

	@Override
	public Set<Long> getAllReactionIds() {
		throw new RuntimeException("Unsupported Operation");
	}

	@Override
	public Set<String> getAllReactionEntries() {
		List<String> rxnEntryList = new ArrayList<>();
		
		try {
			String params = String.format("[x:x<-%s^^%s]", pgdb, "reactions");
			String restXmlQuery = String.format(xmlquery, URLEncoder.encode(params, "UTF-8"));
			String localPath = String.format("%s/%s/query/", this.getLocalStorage(), pgdb);
			createFolderIfNotExists(localPath);
			localPath = localPath.concat("reaction.xml");
			String httpResponseString = getLocalOrWeb(restXmlQuery, localPath);
			JSONObject jsDoc = XML.toJSONObject(httpResponseString);
			JSONArray compoundJsArray = jsDoc.getJSONObject("ptools-xml").getJSONArray("Reaction");
			for (int i = 0; i < compoundJsArray.length(); i++) {
				String entry = compoundJsArray.getJSONObject(i).getString("frameid");
//				if ( this.entryPrefix.length() > 0) {
//					entry = entryPrefix + ":" + entry;
//				}
				rxnEntryList.add( entry);
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(String.format("UnsupportedEncodingException [%s]", e.getMessage()));
		} catch (JSONException e) {
			LOGGER.error(String.format("JSONException [%s]", e.getMessage()));
		} catch (IOException e) {
			LOGGER.error(String.format("IOException [%s]", e.getMessage()));
		}
		
		return new HashSet<String> (rxnEntryList);
	}

}
