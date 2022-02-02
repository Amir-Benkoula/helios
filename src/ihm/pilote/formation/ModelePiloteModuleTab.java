package ihm.pilote.formation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import entite.Module;

public class ModelePiloteModuleTab extends AbstractTableModel { 
	private String nomColonne[] = new String[]{"INTITULE"};
	private List<Module> modules;
	public ModelePiloteModuleTab() {
		
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
		fireTableDataChanged();
	}
	@Override
	public int getColumnCount() {
		return nomColonne.length;
	}         
	@Override
	public int getRowCount() {
		return modules.size();
	}
	@Override
	public String getColumnName(int index) {
		return nomColonne[index];
	}
	@Override
	public Object getValueAt(int ligne, int colonne) {
		Module module = modules.get(ligne);
		Object retour=null;
		switch (colonne) {
		case 0:
			retour = module.getIntitule();
			break;
		default:
			break;
		}
		return retour;
	}
} 
