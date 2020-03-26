/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.io.Serializable;
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
@Table(name = "RUBRIQUE_EVALUATION")
@XmlRootElement
public class RubriqueEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RUBRIQUE_EVALUATION")
    private Long idRubriqueEvaluation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDRE")
    private short ordre;
    @Size(max = 64)
    @Column(name = "DESIGNATION")
    private String designation;
    @JoinColumn(name = "ID_EVALUATION", referencedColumnName = "ID_EVALUATION")
    @ManyToOne(optional = false)
    private Evaluation idEvaluation;
    @JoinColumn(name = "ID_RUBRIQUE", referencedColumnName = "ID_RUBRIQUE")
    @ManyToOne
    private Rubrique idRubrique;
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRubriqueEvaluation")
	 * private Collection<QuestionEvaluation> questionEvaluationCollection;
	 */

    public RubriqueEvaluation() {
    }

    public RubriqueEvaluation(Long idRubriqueEvaluation) {
        this.idRubriqueEvaluation = idRubriqueEvaluation;
    }

    public RubriqueEvaluation(Long idRubriqueEvaluation, short ordre) {
        this.idRubriqueEvaluation = idRubriqueEvaluation;
        this.ordre = ordre;
    }

    public Long getIdRubriqueEvaluation() {
        return idRubriqueEvaluation;
    }

    public void setIdRubriqueEvaluation(Long idRubriqueEvaluation) {
        this.idRubriqueEvaluation = idRubriqueEvaluation;
    }

    public short getOrdre() {
        return ordre;
    }

    public void setOrdre(short ordre) {
        this.ordre = ordre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Evaluation getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Evaluation idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Rubrique getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(Rubrique idRubrique) {
        this.idRubrique = idRubrique;
    }

    @XmlTransient
	/*
	 * public Collection<QuestionEvaluation> getQuestionEvaluationCollection() {
	 * return questionEvaluationCollection; }
	 * 
	 * public void setQuestionEvaluationCollection(Collection<QuestionEvaluation>
	 * questionEvaluationCollection) { this.questionEvaluationCollection =
	 * questionEvaluationCollection; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubriqueEvaluation != null ? idRubriqueEvaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubriqueEvaluation)) {
            return false;
        }
        RubriqueEvaluation other = (RubriqueEvaluation) object;
        if ((this.idRubriqueEvaluation == null && other.idRubriqueEvaluation != null) || (this.idRubriqueEvaluation != null && !this.idRubriqueEvaluation.equals(other.idRubriqueEvaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RubriqueEvaluation[ idRubriqueEvaluation=" + idRubriqueEvaluation + " ]";
    }
    
}
