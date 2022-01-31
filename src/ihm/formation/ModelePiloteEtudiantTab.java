package ihm.pilote.formation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;

public class ModelePiloteEtudiantTab extends AbstractTableModel { 
	private String nomColonne[] = new String[]{"NOM","PRENOM"};
	private List<Etudiant> etudiants;
	public ModelePiloteEtudiantTab() {
		
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
		fireTableDataChanged();
	}
	@Override
	public int getColumnCount() {
		return nomColonne.length;
	}         
	@Override
	public int getRowCount() {
		return etudiants.size();
	}
	@Override
	public String getColumnName(int index) {
		return nomColonne[index];
	}
	@Override
	public Object getValueAt(int ligne, int colonne) {
		Etudiant etudiant = etudiants.get(ligne);
		Object retour=null;
		switch (colonne) {
		case 0:
			retour = etudiant.getNom();
			break;
		case 1:
			retour = etudiant.getPrenom();
			break;
			default:
				break;
		}
		return retour;
	}
} 
