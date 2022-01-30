package ihm.admin.promotion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import entite.Etudiant;
import entite.Formation;

/**
 * Données affichées par les vues "Formation"
 * @author tophe
 * @version 1.0
 *
 */
public class ModeleFormation extends AbstractTableModel { 
	private String nomColonne[] = new String[]{"ACRONYME","INTITULE","NOMBRE HEURE"};
	private List<Formation> formations = new ArrayList<>();
	public ModeleFormation() {}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
		fireTableDataChanged();
	}
	public Formation getFormationByIndex(int index) {
		return formations.get(index);
	}
	@Override
	public int getColumnCount() {
		return nomColonne.length;
	}         
	@Override
	public int getRowCount() {
		return formations.size();
	}
	@Override
	public String getColumnName(int index) {
		return nomColonne[index];
	}
	@Override
	public Object getValueAt(int ligne, int colonne) {
		Formation formation = formations.get(ligne);
		System.out.println("formation=" + formation);
		Object retour=null;
		switch (colonne) {
			case 0:
				retour = formation.getAcronyme();
				break;
			case 1:
				retour = formation.getIntitule();
				break;
			case 2:
				retour = formation.getNbrHeure();
				break;
			default:
				break;
		}
		return retour;
	}
} 
