package main.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import java.util.Date;


/**
 * The persistent class for the evaluation database table.
 * 
 */
@Entity
@Table(name = "EVALUATION")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVALUATION")
	private int idEvaluation;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignant;

	//uni-directional many-to-one association to ElementConstitutif
	@ManyToOne
	@JoinColumnsOrFormulas(value = {
	        @JoinColumnOrFormula(column = @JoinColumn(name="CODE_EC", referencedColumnName="CODE_EC")),
	        @JoinColumnOrFormula(formula = @JoinFormula(value="CODE_FORMATION", referencedColumnName="CODE_FORMATION")),
	        @JoinColumnOrFormula(formula = @JoinFormula(value="CODE_UE", referencedColumnName="CODE_UE"))
	        }) 

	private ElementConstitutif elementConstitutif;


	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ANNEE_UNIVERSITAIRE", referencedColumnName="ANNEE_UNIVERSITAIRE"),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION")
		})
	private Promotion promotion;


	@Column(name="NO_EVALUATION")
	private byte noEvaluation;


	@Column(name="DESIGNATION")
	private String designation;


	@Column(name="ETAT")
	private String etat;


	@Column(name="PERIODE")
	private String periode;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DEBUT_REPONSE")
	private Date debutReponse;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FIN_REPONSE")
	private Date finReponse;

	

	//uni-directional many-to-one association to UniteEnseignement
	@ManyToOne
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(formula = @JoinFormula(value="CODE_FORMATION", referencedColumnName="CODE_FORMATION")),
		@JoinColumnOrFormula(column = @JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE"))
		})
	private UniteEnseignement uniteEnseignement;

	public Evaluation() {
	}

	public int getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public Date getDebutReponse() {
		return this.debutReponse;
	}

	public void setDebutReponse(Date debutReponse) {
		this.debutReponse = debutReponse;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getFinReponse() {
		return this.finReponse;
	}

	public void setFinReponse(Date finReponse) {
		this.finReponse = finReponse;
	}

	public byte getNoEvaluation() {
		return this.noEvaluation;
	}

	public void setNoEvaluation(byte noEvaluation) {
		this.noEvaluation = noEvaluation;
	}

	public String getPeriode() {
		return this.periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public ElementConstitutif getElementConstitutif() {
		return this.elementConstitutif;
	}

	public void setElementConstitutif(ElementConstitutif elementConstitutif) {
		this.elementConstitutif = elementConstitutif;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public UniteEnseignement getUniteEnseignement() {
		return this.uniteEnseignement;
	}

	public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
		this.uniteEnseignement = uniteEnseignement;
	}

}