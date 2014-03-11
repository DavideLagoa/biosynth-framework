package edu.uminho.biosynth.core.data.integration.neo4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import edu.uminho.biosynth.core.components.biodb.chebi.ChebiMetaboliteEntity;
import edu.uminho.biosynth.core.components.biodb.chebi.components.ChebiMetaboliteNameEntity;
import edu.uminho.biosynth.core.data.io.dao.IMetaboliteDao;

public class Neo4jChebiMetaboliteDaoImpl extends AbstractNeo4jDao<ChebiMetaboliteEntity> implements IMetaboliteDao<ChebiMetaboliteEntity>{

	public Neo4jChebiMetaboliteDaoImpl(GraphDatabaseService graphdb) {
		super(graphdb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ChebiMetaboliteEntity find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChebiMetaboliteEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(ChebiMetaboliteEntity cpd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", cpd.getId());
		params.put("entry", cpd.getEntry());
		params.put("name", cpd.getName().toLowerCase());
		params.put("formula", cpd.getFormula());
		params.put("stars", cpd.getStars());
		params.put("mass", cpd.getMass());
		params.put("inchi", cpd.getInchi());
		params.put("inchikey", cpd.getInchiKey());
		params.put("smiles", cpd.getSmiles());
		params.put("source", cpd.getSource());
		
		engine.execute("MERGE (cpd:ChEBI:Compound {entry:{entry}}) ON CREATE SET "
				+ "cpd.created_at=timestamp(), cpd.updated_at=timestamp(), "
				+ "cpd.name={name}, cpd.formula={formula}, cpd.mass={mass}, "
				+ "cpd.stars={stars}, cpd.inchi={inchi}, cpd.inchikey={inchikey}, "
				+ "cpd.smiles={smiles}, cpd.source={source} "
				+ "ON MATCH SET "
				+ "cpd.updated_at=timestamp(), "
				+ "cpd.name={name}, cpd.formula={formula}, cpd.mass={mass}, "
				+ "cpd.stars={stars}, cpd.inchi={inchi}, cpd.inchikey={inchikey}, "
				+ "cpd.smiles={smiles}, cpd.source={source} "
				, params);
		
		if (params.get("charge") != null) {
			engine.execute("MERGE (c:Charge {charge:{charge}}) ", params);
			engine.execute("MATCH (cpd:ChEBI:Compound {entry:{entry}}), (c:Charge {charge:{charge}}) MERGE (cpd)-[r:HasCharge]->(c)", params);
		}
		if (params.get("formula") != null) {
			engine.execute("MERGE (f:Formula {formula:{formula}}) ", params);
			engine.execute("MATCH (cpd:ChEBI:Compound {entry:{entry}}), (f:Formula {formula:{formula}}) MERGE (cpd)-[r:HasFormula]->(f)", params);
		}
		if (params.get("smiles") != null) {
			engine.execute("MERGE (s:SMILES {smiles:{smiles}}) ", params);
			engine.execute("MATCH (cpd:ChEBI:Compound {entry:{entry}}), (s:SMILES {smiles:{smiles}}) MERGE (cpd)-[r:HasSMILES]->(s)", params);
		}
		for (ChebiMetaboliteNameEntity name : cpd.getNames()) {
			params.put("name", name.getName().toLowerCase());
			engine.execute("MERGE (n:Name {name:{name}}) ", params);
			engine.execute("MATCH (cpd:ChEBI:Compound {entry:{entry}}), (n:Name {name:{name}}) MERGE (cpd)-[r:HasName]->(n)", params);
		}
		return null;
	}

	@Override
	protected ChebiMetaboliteEntity nodeToObject(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serializable> getAllMetaboliteIds() {
		engine.execute("MATCH (cpd:ChEBI) RETURN collect(cpd.entry);");
		return null;
	}

}
