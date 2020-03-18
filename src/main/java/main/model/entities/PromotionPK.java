/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DOSI
 */
@Embeddable
public class PromotionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @ManyToOne(optional=false)
    @JoinColumn(name="code_formation")
    private Formation Formation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ANNEE_UNIVERSITAIRE")
    private String anneeUniversitaire;

    public PromotionPK() {
    }

    
    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }


	public Formation getFormation() {
		return Formation;
	}


	public void setFormation(Formation formation) {
		Formation = formation;
	}


	public PromotionPK(main.model.entities.@NotNull @Size(min = 1, max = 8) Formation formation,
			@NotNull @Size(min = 1, max = 10) String anneeUniversitaire) {
		super();
		Formation = formation;
		this.anneeUniversitaire = anneeUniversitaire;
	}

	
	
}
