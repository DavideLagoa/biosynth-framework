package edu.uminho.biosynth.core.data.io.parser.biocyc;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycMetaboliteCrossreferenceEntity;
import pt.uminho.sysbio.biosynthframework.biodb.biocyc.BioCycMetaboliteEntity;
import pt.uminho.sysbio.biosynthframework.core.data.io.dao.biodb.ptools.biocyc.parser.BioCycMetaboliteXMLParser;
import pt.uminho.sysbio.biosynthframework.core.data.io.dao.biodb.ptools.biocyc.parser.BioCycReactionXMLParser;
import pt.uminho.sysbio.biosynthframework.util.IOUtils;

public class TestBiocycXmlParser {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCpd1() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_vanillin.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testCpd2() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_water.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testCpd3() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_aryl_aldehyde.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testCpd4() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_alcohol.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testCpd5() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_benzyl_alcohol.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testCpd6() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/cpd_meta_aryl_alcohol.txt");
		BioCycMetaboliteXMLParser parser = new BioCycMetaboliteXMLParser(xmlString);
		Long id = 0L;
		String source = parser.getSource();
		String entry = parser.getEntry();
		String metaboliteClass = parser.getEntityClass();
		String formula = parser.getFormula();
		String name = parser.getName();
		String comment = parser.getComment();
		Integer charge = parser.getCharge();
		Double molWeight = parser.getMolWeight();
		Double cmlMolWeight = parser.getCmlMolWeight();
		String smiles = parser.getSmiles();
		String inchi = parser.getInchi();
		Double gibbs = parser.getGibbs();
		List<BioCycMetaboliteCrossreferenceEntity> crossReferences = parser.getCrossReferences();
		List<String> synonyms = parser.getSynonym();
		List<String> reactions = parser.getReactions();
		List<String> parents = parser.getParents();
		List<String> instances = parser.getInstanses();
		List<String> subclasses = parser.getSubclasses();
		
		BioCycMetaboliteEntity cpd = new BioCycMetaboliteEntity();
		cpd.setId(id);
		cpd.setEntry(entry);
		cpd.setSource(source);
		cpd.setMetaboliteClass(metaboliteClass);
		cpd.setFormula(formula);
		cpd.setName(name);
		cpd.setComment(comment);
		cpd.setCharge(charge);
		cpd.setMolWeight(molWeight);
		cpd.setCmlMolWeight(cmlMolWeight);
		cpd.setSmiles(smiles);
		cpd.setInChI(inchi);
		cpd.setGibbs(gibbs);
		cpd.setSynonyms(synonyms);
		cpd.setCrossReferences(crossReferences);
		cpd.setReactions(reactions);
		cpd.setParents(parents);
		cpd.setInstances(instances);
		cpd.setSubclasses(subclasses);
		
		System.out.println(cpd);
	}
	
	@Test
	public void testc() throws Exception {
		String xmlString = IOUtils.readFromFile("./src/test/resources/rxn_meta_1_2_1_67_rxn.txt");
		BioCycReactionXMLParser parser = new BioCycReactionXMLParser(xmlString);
		parser.parseContent();
//		fail("Not yet implemented");
	}

}
