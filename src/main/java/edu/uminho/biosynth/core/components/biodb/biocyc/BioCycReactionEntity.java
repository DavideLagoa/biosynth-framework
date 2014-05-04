package edu.uminho.biosynth.core.components.biodb.biocyc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.uminho.biosynth.core.components.GenericReaction;
import edu.uminho.biosynth.core.components.biodb.biocyc.components.BioCycReactionCrossReferenceEntity;
import edu.uminho.biosynth.core.components.biodb.biocyc.components.BioCycReactionEcNumberEntity;
import edu.uminho.biosynth.core.components.biodb.biocyc.components.BioCycReactionLeftEntity;
import edu.uminho.biosynth.core.components.biodb.biocyc.components.BioCycReactionRightEntity;

@Entity
@Table(name="biocyc_reaction")
public class BioCycReactionEntity extends GenericReaction {

	private static final long serialVersionUID = 1L;
	
	@Column(name="orphan", nullable=true)
	private Boolean orphan;
	public Boolean getOrphan() { return orphan;}
	public void setOrphan(Boolean orphan) { this.orphan = orphan;}
	
//	@Column(name="ec_number", nullable=true, length=63)
//	private String ecNumber;
//	public String getEcNumber() { return ecNumber;}
//	public void setEcNumber(String ecNumber) { this.ecNumber = ecNumber;}
//	
//	@Column(name="ec_number_official", nullable=true)
//	private Boolean ecNumberOfficial;
//	public Boolean getEcNumberOfficial() { return ecNumberOfficial;}
//	public void setEcNumberOfficial(Boolean ecNumberOfficial) { this.ecNumberOfficial = ecNumberOfficial;}
	
	@Column(name="physio_relevant", nullable=true)
	private Boolean physiologicallyRelevant;
	public Boolean getPhysiologicallyRelevant() { return physiologicallyRelevant;}
	public void setPhysiologicallyRelevant(Boolean physiologicallyRelevant) { this.physiologicallyRelevant = physiologicallyRelevant;}

	@Column(name="reaction_direction", nullable=true, length=127)
	private String reactionDirection;
	public String getReactionDirection() { return reactionDirection;}
	public void setReactionDirection(String reactionDirection) { this.reactionDirection = reactionDirection;}
	
	@Column(name="gibbs", nullable=true)
	private Double gibbs;
	public Double getGibbs() { return gibbs;}
	public void setGibbs(Double gibbs) { this.gibbs = gibbs;}

	@ElementCollection
	@CollectionTable(name="biocyc_reaction_parent", joinColumns=@JoinColumn(name="reaction_id"))
	@Column(name="parent_entry", length=255)
	private List<String> parents = new ArrayList<> ();
	public List<String> getParents() { return parents;}
	public void setParents(List<String> parents) { this.parents = parents;}

	@ElementCollection
	@CollectionTable(name="biocyc_reaction_pathway", joinColumns=@JoinColumn(name="reaction_id"))
	@Column(name="pathway_entry", length=255)
	private List<String> pathways = new ArrayList<> ();
	public List<String> getPathways() { return pathways;}
	public void setPathways(List<String> pathways) { this.pathways = pathways;}

	@ElementCollection
	@CollectionTable(name="biocyc_reaction_enzymatic", joinColumns=@JoinColumn(name="reaction_id"))
	@Column(name="enzymatic_reaction_entry", length=255)
	private List<String> enzymaticReactions = new ArrayList<> ();
	public List<String> getEnzymaticReactions() { return enzymaticReactions;}
	public void setEnzymaticReactions(List<String> enzymaticReactions) { this.enzymaticReactions = enzymaticReactions;}

	@Column(name="ENZYME", length=63) private String enzyme;
	public String getEnzyme() { return enzyme; }
	public void setEnzyme(String enzyme) { this.enzyme = enzyme;}
	
	@Column(name="ORIENTATION") private String direction;
	public String getDirection() { return direction;}
	public void setDirection(String direction) { this.direction = direction;}

	@OneToMany(mappedBy = "bioCycReactionEntity", cascade = CascadeType.ALL)
	private List<BioCycReactionLeftEntity> left = new ArrayList<> ();
	public List<BioCycReactionLeftEntity> getLeft() { return left;}
	public void setLeft(List<BioCycReactionLeftEntity> left) {
		for (BioCycReactionLeftEntity entity : left) {
			entity.setBioCycReactionEntity(this);
		}
		this.left = left;
	}

	@OneToMany(mappedBy = "bioCycReactionEntity", cascade = CascadeType.ALL)
	private List<BioCycReactionRightEntity> right = new ArrayList<> ();
	public List<BioCycReactionRightEntity> getRight() { return right;}
	public void setRight(List<BioCycReactionRightEntity> right) {
		for (BioCycReactionRightEntity entity : right) {
			entity.setBioCycReactionEntity(this);
		}
		this.right = right;
	}
	
	@OneToMany(mappedBy = "bioCycReactionEntity", cascade = CascadeType.ALL)
	private List<BioCycReactionEcNumberEntity> ecNumbers = new ArrayList<> ();
	public List<BioCycReactionEcNumberEntity> getEcNumbers() { return ecNumbers;}
	public void setEcNumbers(List<BioCycReactionEcNumberEntity> ecNumbers) {
		for (BioCycReactionEcNumberEntity entity : ecNumbers) {
			entity.setBioCycReactionEntity(this);
		}
		this.ecNumbers = ecNumbers;
	}

	@OneToMany(mappedBy = "bioCycReactionEntity", cascade = CascadeType.ALL)
	private List<BioCycReactionCrossReferenceEntity> crossReferences = new ArrayList<> ();
	public List<BioCycReactionCrossReferenceEntity> getCrossReferences() {
		return crossReferences;
	}
	public void setCrossReferences(
			List<BioCycReactionCrossReferenceEntity> crossReferences) {
		for (BioCycReactionCrossReferenceEntity entity : crossReferences) {
			entity.setBioCycReactionEntity(this);
		}
		this.crossReferences = crossReferences;
	}
	
	@Override
	public String toString() {
		final char sep = '\n';
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(sep);
		sb.append("physio. rel.:").append(this.getPhysiologicallyRelevant()).append(sep);
		sb.append("ecn:").append(this.getEcNumbers()).append(sep);
		sb.append("orphan:").append(this.getOrphan()).append(sep);
		sb.append("left:").append(this.getLeft()).append(sep);
		sb.append("right:").append(this.getRight()).append(sep);
		sb.append("parents:").append(this.getParents()).append(sep);
		sb.append("pathways:").append(this.getPathways()).append(sep);
		sb.append("enzymatic reactions:").append(this.getEnzymaticReactions()).append(sep);
		sb.append("xref:").append(this.getCrossReferences());
//		sb.append("molWeight:").append(this.molWeight).append(sep);
//		sb.append("gibbs:").append(this.gibbs).append(sep);
//		sb.append("Smiles:").append(this.smiles).append(sep);
//		sb.append("InChI:").append(this.inChI).append(sep);
		return sb.toString();
	}
}
