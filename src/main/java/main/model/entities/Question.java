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
@Table(name = "QUESTION")
@XmlRootElement
public class Question implements Serializable, Comparable<Question> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUESTION")
    private Long idQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "INTITULE")
    private String intitule;
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @ManyToOne
    private Enseignant noEnseignant;
    @JoinColumn(name = "ID_QUALIFICATIF", referencedColumnName = "ID_QUALIFICATIF")
    @ManyToOne(optional = false)
    private Qualificatif qualificatif;
    
    public Question() {
    }

    public Question(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question(Long idQuestion, String type, String intitule) {
        this.idQuestion = idQuestion;
        this.type = type;
        this.intitule = intitule;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getNoEnseignant() {
        return noEnseignant;
    }

    public void setNoEnseignant(Enseignant noEnseignant) {
        this.noEnseignant = noEnseignant;
    }

    public Qualificatif getQualificatif() {
        return qualificatif;
    }	

    public void setIdQualificatif(Qualificatif Qualificatif) {
        this.qualificatif = Qualificatif;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Question[ idQuestion=" + idQuestion + " ]";
    }

	@Override
	public int compareTo(Question q) {
		
		
		int lmin = Math.min(this.intitule.length(), q.intitule.length()); 
		for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)this.intitule.charAt(i); 
            int str2_ch = (int)q.intitule.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
		if (this.intitule.length() != q.intitule.length()) { 
            return this.intitule.length() -  q.intitule.length(); 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
	}	
    
}
