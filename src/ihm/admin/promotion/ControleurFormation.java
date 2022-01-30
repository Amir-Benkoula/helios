package ihm.admin.promotion;

import java.util.ArrayList;
import java.util.List;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import service.ServiceItf;
/**
 * Contrôleur page "Formations". Appel les services exposés suivant les actions utilisateurs
 * et met à jour le modéle.
 * @author tophe
 * @version 1.0
 *
 */
public class ControleurFormation {
	private ModeleFormation model;
	private ServiceItf service;
	private IhmModifierFormation ihmModifierFormation;
	public ControleurFormation(ServiceItf service, ModeleFormation model) {
		System.out.println("Constructeur ControleurPromotion");
		this.service = service;
		this.model = model;
		model.setFormations(service.readAllSansEtudiant());
	}
	public void ajouterPromotion(Formation formation) {
		service.create(formation);
		model.setFormations(service.readAllSansEtudiant());
	}	
	public void supprimerFormation(String acronyme) {
		service.supprimerFormation(acronyme);
		model.setFormations(service.readAllSansEtudiant());
	}
	public void modifierFormation(Formation formation) {
		service.modifier(formation);
		model.setFormations(service.readAllSansEtudiant());
		ihmModifierFormation.dispose();
	}
	public void ihmAfficherFormation(Formation formation) {
		new IhmAfficherFormation(formation);
	}
	public void ihmModifierFormation(Formation formation) {
		ihmModifierFormation = new IhmModifierFormation(this, formation);
	}
}
