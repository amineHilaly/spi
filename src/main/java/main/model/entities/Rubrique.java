/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DOSI
 */
@Entity
@Table(name = "RUBRIQUE")
@XmlRootElement
public class Rubrique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RUBRIQUE")
    private Long idRubrique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "ORDRE")
    private BigInteger ordre;
	/*
	 * @OneToMany(mappedBy = "idRubrique") private Collection<RubriqueEvaluation>
	 * rubriqueEvaluationCollection;
	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubrique") private
	 * Collection<RubriqueQuestion> rubriqueQuestionCollection;
	 */
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne
    private Enseignant noEnseignant;

    public Rubrique() {
    }

    public Rubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
    }

    public Rubrique(Long idRubrique, String type, String designation) {
        this.idRubrique = idRubrique;
        this.type = type;
        this.designation = designation;
    }

    public Long getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigInteger getOrdre() {
        return ordre;
    }

    public void setOrdre(BigInteger ordre) {
        this.ordre = ordre;
    }

	/*
	 * @XmlTransient public Collection<RubriqueEvaluation>
	 * getRubriqueEvaluationCollection() { return rubriqueEvaluationCollection; }
	 * 
	 * public void setRubriqueEvaluationCollection(Collection<RubriqueEvaluation>
	 * rubriqueEvaluationCollection) { this.rubriqueEvaluationCollection =
	 * rubriqueEvaluationCollection; }
	 */

    @XmlTransient
	/*
	 * public Collection<RubriqueQuestion> getRubriqueQuestionCollection() { return
	 * rubriqueQuestionCollection; }
	 * 
	 * public void setRubriqueQuestionCollection(Collection<RubriqueQuestion>
	 * rubriqueQuestionCollection) { this.rubriqueQuestionCollection =
	 * rubriqueQuestionCollection; }
	 */
    public Enseignant getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Enseignant noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubrique != null ? idRubrique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rubrique)) {
            return false;
        }
        Rubrique other = (Rubrique) object;
        if ((this.idRubrique == null && other.idRubrique != null) || (this.idRubrique != null && !this.idRubrique.equals(other.idRubrique))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Rubrique [idRubrique=" + idRubrique + ", type=" + type + ", designation=" + designation + ", ordre="
				+ ordre + ", noEnseignant="
				+ noEnseignant + "]";
	}

    
    
    
}
