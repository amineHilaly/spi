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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "QUALIFICATIF")
@XmlRootElement
public class Qualificatif implements Serializable, Comparable<Qualificatif>{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUALIFICATIF")
    private Long idQualificatif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "MAXIMAL")
    private String maximal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "MINIMAL")
    private String minimal;
    

    public Qualificatif() {
    }

    public Qualificatif(Long idQualificatif) {
        this.idQualificatif = idQualificatif;
    }

    public Qualificatif(Long idQualificatif, String maximal, String minimal) {
        this.idQualificatif = idQualificatif;
        this.maximal = maximal;
        this.minimal = minimal;
    }

    public Long getIdQualificatif() {
        return idQualificatif;
    }

    public void setIdQualificatif(Long idQualificatif) {
        this.idQualificatif = idQualificatif;
    }

    public String getMaximal() {
        return maximal;
    }

    public void setMaximal(String maximal) {
        this.maximal = maximal;
    }

    public String getMinimal() {
        return minimal;
    }

    public void setMinimal(String minimal) {
        this.minimal = minimal;
    }

        @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQualificatif != null ? idQualificatif.hashCode() : 0);
        return hash;
    }


	@Override
	public String toString() {
		return "Qualificatif [idQualificatif=" + idQualificatif + ", maximal=" + maximal + ", minimal=" + minimal + "]";
	}

	@Override
	public int compareTo(Qualificatif q) {
		int lmin = Math.min(this.minimal.length(), q.minimal.length()); 
		for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)this.minimal.charAt(i); 
            int str2_ch = (int)q.minimal.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
		if (this.minimal.length() != q.minimal.length()) { 
            return this.minimal.length() -  q.minimal.length(); 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
	}
	
	
    
}
