package ihm.pilote.formation;

import java.util.ArrayList;
import java.util.List;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import entite.Module;
import ihm.IhmPrincipale;
import service.ServiceItf;

public class ControleurPiloteFormation {
	private ModelPilote modelPilote;
	private ServiceItf service;
	private IhmPrincipale ihmPrincipale;
	public ControleurPiloteFormation(ServiceItf service, ModelPilote modelPilote, IhmPrincipale ihmPrincipale) {
		System.out.println("Constructeur ControleurPromotion");
		this.service = service;
		this.modelPilote = modelPilote;
		this.service = service;
		this.ihmPrincipale = ihmPrincipale;
		
		String[] strAcronymes = service.readAllAcronyme().toArray(new String[0]);
		modelPilote.setStrAcronymes(strAcronymes);
		
		Formation formation = service.readAvecEtudiant(strAcronymes[0]);
		modelPilote.setFormation(formation);
		int indexFormation = getIndexFormation(formation, strAcronymes);
		modelPilote.setIndex(indexFormation);
	
	}
	private int getIndexFormation(Formation formation, String[] strAcronymes) {
		for(int i=0; i<strAcronymes.length; i++) {
			if(strAcronymes[i].equals(formation.getAcronyme())) {
				return i;
			}
		}
		return -1;
	}
	public void seclectFormation(int index) {
		System.out.println("ControleurPiloteFormation - seclectFormation index=" + index);
		String[] strAcronymes = modelPilote.getStrAcronymes();
		String acronyme = strAcronymes[index];
		System.out.println("ControleurPiloteFormation - seclectFormation acronyme=" + acronyme);
		Formation formation = service.readAvecEtudiant(acronyme);
		System.out.println("ControleurPiloteFormation - seclectFormation formation=" + formation);
		modelPilote.setFormation(formation);
		int indexFormation = getIndexFormation(formation, strAcronymes);
		modelPilote.setIndex(indexFormation);
		VuePiloteFormation vue = new VuePiloteFormation(this, modelPilote);
		ihmPrincipale.updateDisplay(vue);
		
	}
	public void ajouterModule(Module module, String acronyme) {
		service.ajouterModuleFormation(module, acronyme);
		Formation formation = service.readAvecEtudiant(acronyme);
		modelPilote.setFormation(formation);
	}
}
