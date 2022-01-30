package entite;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
/**
 * Classe métier étudiant. Association Etudiant/Formation bidirectionnelle.
 * @author tophe
 * @version 1.0
 */
@Entity
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String mail;
	@ManyToOne
	Formation formation;
	
	public Etudiant() {}
	public Etudiant(String nom, String prenom, String adresse, String telephone, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
	}
	@Override
	public String toString() {
		return String.format("%d %s - %s - %s - %s - %s - %s", id, nom, prenom, adresse, telephone, mail, formation.getAcronyme());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
}
