package main.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import main.model.entities.Promotion;


/**
 * The persistent class for the ETUDIANT database table.
 * 
 */
@Entity
public class Etudiant implements Serializable, Comparable<Etudiant> {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
	@Column(name="NO_ETUDIANT")
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

	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ANNEE_UNIVERSITAIRE", referencedColumnName="ANNEE_UNIVERSITAIRE"),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION")
		})
	private Promotion promotion;

	public Etudiant() {
	}
	
	public Etudiant(String noEtudiant) {
        this.noEtudiant = noEtudiant;
    }

	public Etudiant(@NotNull @Size(min = 1, max = 50) String noEtudiant, @NotNull @Size(min = 1, max = 50) String nom,
			@NotNull @Size(min = 1, max = 50) String prenom, @NotNull @Size(min = 1, max = 1) String sexe,
			@NotNull Date dateNaissance, @NotNull @Size(min = 1, max = 255) String lieuNaissance,
			@NotNull @Size(min = 1, max = 50) String nationalite, @Size(max = 20) String telephone,
			@Size(max = 20) String mobile, @NotNull @Size(min = 1, max = 255) String email,
			@Size(max = 255) String emailUbo, @NotNull @Size(min = 1, max = 255) String adresse,
			@Size(max = 10) String codePostal, @NotNull @Size(min = 1, max = 255) String ville,
			@NotNull @Size(min = 1, max = 5) String paysOrigine,
			@NotNull @Size(min = 1, max = 6) String universiteOrigine, BigInteger groupeTp, BigInteger groupeAnglais,
			Promotion promotion) {
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
		this.promotion = promotion;
	}

	public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public String getNoEtudiant() {
		return this.noEtudiant;
	}

	public void setNoEtudiant(String noEtudiant) {
		this.noEtudiant = noEtudiant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailUbo() {
		return this.emailUbo;
	}

	public void setEmailUbo(String emailUbo) {
		this.emailUbo = emailUbo;
	}

	public BigInteger getGroupeAnglais() {
		return this.groupeAnglais;
	}

	public void setGroupeAnglais(BigInteger groupeAnglais) {
		this.groupeAnglais = groupeAnglais;
	}

	public BigInteger getGroupeTp() {
		return this.groupeTp;
	}

	public void setGroupeTp(BigInteger groupeTp) {
		this.groupeTp = groupeTp;
	}

	public String getLieuNaissance() {
		return this.lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPaysOrigine() {
		return this.paysOrigine;
	}

	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUniversiteOrigine() {
		return this.universiteOrigine;
	}

	public void setUniversiteOrigine(String universiteOrigine) {
		this.universiteOrigine = universiteOrigine;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Promotion getPromotionn() {
		return this.promotion;
	}

	public void setPromotionn(Promotion promotion) {
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return "Etudiant [noEtudiant=" + noEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", nationalite="
				+ nationalite + ", telephone=" + telephone + ", mobile=" + mobile + ", email=" + email + ", emailUbo="
				+ emailUbo + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", paysOrigine=" + paysOrigine + ", universiteOrigine=" + universiteOrigine + ", groupeTp=" + groupeTp
				+ ", groupeAnglais=" + groupeAnglais + ", promotion=" + promotion + "]";
	}

	@Override
	public int compareTo(Etudiant e) {
		return this.getNom().compareTo(e.getNom());
	}
	
	

}