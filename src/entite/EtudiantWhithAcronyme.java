package entite;


import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
/**
 * Classe de mise en forme des données Etudiant pour affichage.
 * @author tophe
 * @version 1.0
 *
 */
public class EtudiantWhithAcronyme implements Serializable {
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String mail;
	private String acronyme;	
	
	public EtudiantWhithAcronyme() {}

	public EtudiantWhithAcronyme(String nom, String prenom, String adresse, String telephone, String mail,
			String acronyme) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.acronyme = acronyme;
	}
	public EtudiantWhithAcronyme(Etudiant etudiant) {
		this.id = etudiant.getId();
		this.nom = etudiant.getNom();
		this.prenom = etudiant.getPrenom();
		this.adresse = etudiant.getAdresse();
		this.telephone = etudiant.getTelephone();
		this.mail = etudiant.getMail();
		this.acronyme = etudiant.getFormation().getAcronyme();
		System.out.println("EtudiantWhithAcronyme id=" + id + ", acronyme=" + acronyme);
	}
	public Etudiant getEtudiant() {
		Etudiant etudiant = new Etudiant(nom, prenom, adresse, telephone, mail);
		etudiant.setId(id);
		return etudiant;
	}
	
	@Override
	public String toString() {
		return "EtudiantWhithAcronyme [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", mail=" + mail + ", acronyme=" + acronyme + "]";
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	public Long getId() {
		return id;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setId(Long id) {
		this.id = id;
	}	
}
