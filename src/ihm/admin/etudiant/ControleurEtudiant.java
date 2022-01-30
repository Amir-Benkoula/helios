package ihm.admin.etudiant;

import java.util.ArrayList;
import java.util.List;
import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import ihm.ControleurMenu;
import service.ServiceItf;
/**
 * Contr�leur page "Etudiants". Appel les services expos�s suivant les actions utilisateurs
 * et met � jour le mod�le.
 * @author tophe
 * @version 1.0
 *
 */
public class ControleurEtudiant {
	private VueEtudiant vue;
	private ModeleEtudiant model;
	private ServiceItf service;
	private IhmModifierEtudiant ihmModifierEtudiant;
	public ControleurEtudiant(ServiceItf service, ModeleEtudiant model) {
		System.out.println("Constructeur ControleurEtudiant");
		this.service = service;
		this.model = model;
		List<EtudiantWhithAcronyme> etudiants = service.readAllEtudiantWithAcronyme();
		model.setEtudiants(etudiants);
		List<String> strAcronymes = service.readAllAcronyme();
		System.out.println("strAcronymes=" + strAcronymes);
		model.setPromotions(strAcronymes.toArray(new String[0])); 
	}
	public void ajouterEtudiant(EtudiantWhithAcronyme etudiantWhithAcronyme){
		service.inscrire(etudiantWhithAcronyme);
		model.setEtudiants(service.readAllEtudiantWithAcronyme());
	}
	public void supprimerEtudiant(int index) {
		EtudiantWhithAcronyme etudiantWhithAcronyme = model.getEtudiantWithAcronymeByIndex(index);
		service.supprimerEtudiant(etudiantWhithAcronyme.getId(), etudiantWhithAcronyme.getAcronyme());
		model.setEtudiants(service.readAllEtudiantWithAcronyme());
	}
	public void trierEtudiant(String nom) {
		model.setEtudiants(service.readLikeName(nom));
	}
	public void modifierEtudiant(EtudiantWhithAcronyme etudiantWhithAcronyme) {
		service.modifier(etudiantWhithAcronyme);
		model.setEtudiants(service.readAllEtudiantWithAcronyme());
		ihmModifierEtudiant.dispose();
	}
	public void ihmAfficherEtudiant(EtudiantWhithAcronyme etudiantWithAcronyme) {
		new IhmAfficherEtudiant(etudiantWithAcronyme);
	}
	public void ihmModifierEtudiant(EtudiantWhithAcronyme etudiantWithAcronyme) {
		ihmModifierEtudiant = new IhmModifierEtudiant(this, etudiantWithAcronyme, model);
	}
}
