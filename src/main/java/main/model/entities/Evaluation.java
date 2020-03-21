<<<<<<< HEAD
package main.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import java.util.Date;


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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "EVALUATION")
@XmlRootElement
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_EVALUATION")
    private short noEvaluation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "DESIGNATION")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ETAT")
    private String etat;
    @Size(max = 64)
    @Column(name = "PERIODE")
    private String periode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBUT_REPONSE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutReponse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIN_REPONSE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finReponse;
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluation") private
	 * Collection<Droit> droitCollection;
	 * 
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")
	 * , @JoinColumn(name = "CODE_UE", referencedColumnName = "CODE_UE")
	 * , @JoinColumn(name = "CODE_EC", referencedColumnName = "CODE_EC")})
	 * 
	 * @ManyToOne(optional = false) private ElementConstitutif elementConstitutif;
	 */
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne(optional = false)
    private Enseignant noEnseignant;
    @JoinColumns({
        @JoinColumn(name = "ANNEE_UNIVERSITAIRE", referencedColumnName = "ANNEE_UNIVERSITAIRE")
        , @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")})
    @ManyToOne(optional = false)
    private Promotion promotion;
	/*
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")
	 * , @JoinColumn(name = "CODE_UE", referencedColumnName = "CODE_UE")})
	 * 
	 * @ManyToOne(optional = false) private UniteEnseignement uniteEnseignement;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluation") private
	 * Collection<RubriqueEvaluation> rubriqueEvaluationCollection;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluation") private
	 * Collection<ReponseEvaluation> reponseEvaluationCollection;
	 */

    public Evaluation() {
    }

    public Evaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Evaluation(Long idEvaluation, short noEvaluation, String designation, String etat, Date debutReponse, Date finReponse) {
        this.idEvaluation = idEvaluation;
        this.noEvaluation = noEvaluation;
        this.designation = designation;
        this.etat = etat;
        this.debutReponse = debutReponse;
        this.finReponse = finReponse;
    }

    public Long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public short getNoEvaluation() {
        return noEvaluation;
    }

    public void setNoEvaluation(short noEvaluation) {
        this.noEvaluation = noEvaluation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Date getDebutReponse() {
        return debutReponse;
    }

    public void setDebutReponse(Date debutReponse) {
        this.debutReponse = debutReponse;
    }

    public Date getFinReponse() {
        return finReponse;
    }

    public void setFinReponse(Date finReponse) {
        this.finReponse = finReponse;
    }

	/*
	 * @XmlTransient public Collection<Droit> getDroitCollection() { return
	 * droitCollection; }
	 * 
	 * public void setDroitCollection(Collection<Droit> droitCollection) {
	 * this.droitCollection = droitCollection; }
	 * 
	 * public ElementConstitutif getElementConstitutif() { return
	 * elementConstitutif; }
	 * 
	 * public void setElementConstitutif(ElementConstitutif elementConstitutif) {
	 * this.elementConstitutif = elementConstitutif; }
	 */
    public Enseignant getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Enseignant noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

	/*
	 * public UniteEnseignement getUniteEnseignement() { return uniteEnseignement; }
	 * 
	 * public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
	 * this.uniteEnseignement = uniteEnseignement; }
	 * 
	 * @XmlTransient public Collection<RubriqueEvaluation>
	 * getRubriqueEvaluationCollection() { return rubriqueEvaluationCollection; }
	 * 
	 * public void setRubriqueEvaluationCollection(Collection<RubriqueEvaluation>
	 * rubriqueEvaluationCollection) { this.rubriqueEvaluationCollection =
	 * rubriqueEvaluationCollection; }
	 * 
	 * @XmlTransient public Collection<ReponseEvaluation>
	 * getReponseEvaluationCollection() { return reponseEvaluationCollection; }
	 * 
	 * public void setReponseEvaluationCollection(Collection<ReponseEvaluation>
	 * reponseEvaluationCollection) { this.reponseEvaluationCollection =
	 * reponseEvaluationCollection; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluation != null ? idEvaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.idEvaluation == null && other.idEvaluation != null) || (this.idEvaluation != null && !this.idEvaluation.equals(other.idEvaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evaluation[ idEvaluation=" + idEvaluation + " ]";
    }
    
}
>>>>>>> ebd217bd93ae0ceadaa5247118b27c20d0e2d8ec
