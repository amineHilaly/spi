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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "PROMOTION")
@XmlRootElement
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromotionPK promotionPK;
    @Size(max = 16)
    @Column(name = "SIGLE_PROMOTION")
    private String siglePromotion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NB_MAX_ETUDIANT")
    private short nbMaxEtudiant;
    @Column(name = "DATE_REPONSE_LP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseLp;
    @Column(name = "DATE_REPONSE_LALP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponseLalp;
    @Column(name = "DATE_RENTREE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRentree;
    @Size(max = 12)
    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;
    @Size(max = 5)
    @Column(name = "PROCESSUS_STAGE")
    private String processusStage;
    @Size(max = 255)
    @Column(name = "COMMENTAIRE")
    private String commentaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Formation formation;

    public Promotion() {
    }

	public PromotionPK getPromotionPK() {
		return promotionPK;
	}

	public void setPromotionPK(PromotionPK promotionPK) {
		this.promotionPK = promotionPK;
	}

	public String getSiglePromotion() {
		return siglePromotion;
	}

	public void setSiglePromotion(String siglePromotion) {
		this.siglePromotion = siglePromotion;
	}

	public short getNbMaxEtudiant() {
		return nbMaxEtudiant;
	}

	public void setNbMaxEtudiant(short nbMaxEtudiant) {
		this.nbMaxEtudiant = nbMaxEtudiant;
	}

	public Date getDateReponseLp() {
		return dateReponseLp;
	}

	public void setDateReponseLp(Date dateReponseLp) {
		this.dateReponseLp = dateReponseLp;
	}

	public Date getDateReponseLalp() {
		return dateReponseLalp;
	}

	public void setDateReponseLalp(Date dateReponseLalp) {
		this.dateReponseLalp = dateReponseLalp;
	}

	public Date getDateRentree() {
		return dateRentree;
	}

	public void setDateRentree(Date dateRentree) {
		this.dateRentree = dateRentree;
	}

	public String getLieuRentree() {
		return lieuRentree;
	}

	public void setLieuRentree(String lieuRentree) {
		this.lieuRentree = lieuRentree;
	}

	public String getProcessusStage() {
		return processusStage;
	}

	public void setProcessusStage(String processusStage) {
		this.processusStage = processusStage;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Promotion(PromotionPK promotionPK, @Size(max = 16) String siglePromotion, @NotNull short nbMaxEtudiant,
			Date dateReponseLp, Date dateReponseLalp, Date dateRentree, @Size(max = 12) String lieuRentree,
			@Size(max = 5) String processusStage, @Size(max = 255) String commentaire, Formation formation) {
		super();
		this.promotionPK = promotionPK;
		this.siglePromotion = siglePromotion;
		this.nbMaxEtudiant = nbMaxEtudiant;
		this.dateReponseLp = dateReponseLp;
		this.dateReponseLalp = dateReponseLalp;
		this.dateRentree = dateRentree;
		this.lieuRentree = lieuRentree;
		this.processusStage = processusStage;
		this.commentaire = commentaire;
		this.formation = formation;
	}    
    
    
}
