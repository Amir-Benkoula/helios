package ihm.pilote.formation;

import java.util.List;

import entite.Etudiant;
import entite.Formation;

public class ModelPilote {
	private String[] strAcronymes;
	private Formation formation;
	private ModelePiloteEtudiantTab modelEtudiantTab;
	private ModelePiloteModuleTab modeleModuleTab;
	private int index;

	public ModelPilote() {
		modelEtudiantTab = new ModelePiloteEtudiantTab();
		modeleModuleTab = new ModelePiloteModuleTab();
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
		// RENSEIGNER LES ETUDIANTS DU TABLEAU A AFFICHER
		modelEtudiantTab.setEtudiants(formation.getEtudiants());
		modeleModuleTab.setModules(formation.getModules());
	}
	public String[] getStrAcronymes() {
		return strAcronymes;
	}
	public void setStrAcronymes(String[] strAcronymes) {
		this.strAcronymes = strAcronymes;
	}
	public ModelePiloteEtudiantTab getModelEtudiantTab() {
		return modelEtudiantTab;
	}
	public void setModelEtudiantTab(ModelePiloteEtudiantTab modelEtudiantTab) {
		this.modelEtudiantTab = modelEtudiantTab;
	}
	public ModelePiloteModuleTab getModeleModuleTab() {
		return modeleModuleTab;
	}
	public void setModeleModuleTab(ModelePiloteModuleTab modeleModuleTab) {
		this.modeleModuleTab = modeleModuleTab;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
