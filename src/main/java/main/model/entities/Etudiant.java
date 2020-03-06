/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "ETUDIANT")
@XmlRootElement
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NO_ETUDIANT")
    private String noEtudiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXE")
    private String sexe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NATIONALITE")
    private String nationalite;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "EMAIL_UBO")
    private String emailUbo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 10)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "VILLE")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PAYS_ORIGINE")
    private String paysOrigine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "UNIVERSITE_ORIGINE")
    private String universiteOrigine;
    @Column(name = "GROUPE_TP")
    private BigInteger groupeTp;
    @Column(name = "GROUPE_ANGLAIS")
    private BigInteger groupeAnglais;
    
    public Etudiant() {
    }

    public Etudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public Etudiant(String noEtudiant, String nom, String prenom, String sexe, Date dateNaissance, String lieuNaissance, String nationalite, String email, String adresse, String ville, String paysOrigine, String universiteOrigine) {
        this.noEtudiant = noEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.paysOrigine = paysOrigine;
        this.universiteOrigine = universiteOrigine;
    }

    public String getNoEtudiant() {
        return noEtudiant;
    }

    public void setNoEtudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailUbo() {
        return emailUbo;
    }

    public void setEmailUbo(String emailUbo) {
        this.emailUbo = emailUbo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public String getUniversiteOrigine() {
        return universiteOrigine;
    }

    public void setUniversiteOrigine(String universiteOrigine) {
        this.universiteOrigine = universiteOrigine;
    }

    public BigInteger getGroupeTp() {
        return groupeTp;
    }

    public void setGroupeTp(BigInteger groupeTp) {
        this.groupeTp = groupeTp;
    }

    public BigInteger getGroupeAnglais() {
        return groupeAnglais;
    }

    public void setGroupeAnglais(BigInteger groupeAnglais) {
        this.groupeAnglais = groupeAnglais;
    }

	public Etudiant(@NotNull @Size(min = 1, max = 50) String noEtudiant, @NotNull @Size(min = 1, max = 50) String nom,
			@NotNull @Size(min = 1, max = 50) String prenom, @NotNull @Size(min = 1, max = 1) String sexe,
			@NotNull Date dateNaissance, @NotNull @Size(min = 1, max = 255) String lieuNaissance,
			@NotNull @Size(min = 1, max = 50) String nationalite, @Size(max = 20) String telephone,
			@Size(max = 20) String mobile, @NotNull @Size(min = 1, max = 255) String email,
			@Size(max = 255) String emailUbo, @NotNull @Size(min = 1, max = 255) String adresse,
			@Size(max = 10) String codePostal, @NotNull @Size(min = 1, max = 255) String ville,
			@NotNull @Size(min = 1, max = 5) String paysOrigine,
			@NotNull @Size(min = 1, max = 6) String universiteOrigine, BigInteger groupeTp, BigInteger groupeAnglais) {
		super();
		this.noEtudiant = noEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.telephone = telephone;
		this.mobile = mobile;
		this.email = email;
		this.emailUbo = emailUbo;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.paysOrigine = paysOrigine;
		this.universiteOrigine = universiteOrigine;
		this.groupeTp = groupeTp;
		this.groupeAnglais = groupeAnglais;
	}

        
}
