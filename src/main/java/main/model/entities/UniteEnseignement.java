package main.model.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="unite_enseignement")
@NamedQuery(name="UniteEnseignement.findAll", query="SELECT u FROM UniteEnseignement u")
public class UniteEnseignement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UniteEnseignementPK id;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	@Column(name="SEMESTRE")
	private String semestre;
	

	@Column(name="NBH_CM")
	private BigDecimal nbhCm;

	@Column(name="NBH_TD")
	private Float nbhTd;

	@Column(name="NBH_TP")
	private Float nbhTp;
	
	

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignant;

	//uni-directional many-to-one association to Formation
	@ManyToOne
	@JoinColumn(name="CODE_FORMATION", insertable=false, updatable=false)
	private Formation formation;

	public UniteEnseignement() {
	}

	public UniteEnseignementPK getId() {
		return this.id;
	}

	public void setId(UniteEnseignementPK id) {
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

	public BigDecimal getNbhCm() {
		return this.nbhCm;
	}

	public void setNbhCm(BigDecimal nbhCm) {
		this.nbhCm = nbhCm;
	}

	public Float getNbhTd() {
		return this.nbhTd;
	}

	public void setNbhTd(Float nbhTd) {
		this.nbhTd = nbhTd;
	}

	public Float getNbhTp() {
		return this.nbhTp;
	}

	public void setNbhTp(Float nbhTp) {
		this.nbhTp = nbhTp;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "UniteEnseignement [id=" + id + ", designation=" + designation + ", description=" + description
				+ ", semestre=" + semestre + ", nbhCm=" + nbhCm + ", nbhTd=" + nbhTd + ", nbhTp=" + nbhTp
				+ ", enseignant=" + enseignant + ", formation=" + formation + "]";
	}
	
	

}