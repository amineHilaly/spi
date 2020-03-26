package main.model.entities;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="element_constitutif")
public class ElementConstitutif implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ElementConstitutifPK id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	@Column(name="DESIGNATION")
	private String designation;

	@Column(name="NBH_CM")
	private int nbhCm;

	@Column(name="NBH_TD")
	private int nbhTd;

	@Column(name="NBH_TP")
	private int nbhTp;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignant;

	//uni-directional many-to-one association to UniteEnseignement
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
	private UniteEnseignement uniteEnseignement;

	public ElementConstitutif() {
	}

	public ElementConstitutifPK getId() {
		return this.id;
	}

	public void setId(ElementConstitutifPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbhCm() {
		return this.nbhCm;
	}

	public void setNbhCm(int nbhCm) {
		this.nbhCm = nbhCm;
	}

	public int getNbhTd() {
		return this.nbhTd;
	}

	public void setNbhTd(int nbhTd) {
		this.nbhTd = nbhTd;
	}

	public int getNbhTp() {
		return this.nbhTp;
	}

	public void setNbhTp(int nbhTp) {
		this.nbhTp = nbhTp;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public UniteEnseignement getUniteEnseignement() {
		return this.uniteEnseignement;
	}

	public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
		this.uniteEnseignement = uniteEnseignement;
	}

	@Override
	public String toString() {
		return "ElementConstitutif [id=" + id + ", description=" + description + ", designation=" + designation
				+ ", nbhCm=" + nbhCm + ", nbhTd=" + nbhTd + ", nbhTp=" + nbhTp + ", enseignant=" + enseignant
				+ ", uniteEnseignement=" + uniteEnseignement + "]";
	}
	
	

}