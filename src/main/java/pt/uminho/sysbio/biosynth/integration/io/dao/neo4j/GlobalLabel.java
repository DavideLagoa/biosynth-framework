package pt.uminho.sysbio.biosynth.integration.io.dao.neo4j;

import org.neo4j.graphdb.Label;

public enum GlobalLabel implements Label {
	KEGG,
	Orthology,
	KeggPathway, KeggOrthology,
	EnzymeCommission,
	MetabolicModel,
	SuperMetabolite, Metabolite, MetaboliteProperty,
	Reaction, ReactionProperty,
	MetabolicPathway, 
	BioCyc,
	SubcellularCompartment,
}
