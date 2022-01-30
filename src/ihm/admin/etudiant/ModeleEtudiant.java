package ihm.admin.etudiant;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
/**
 * Données affichées par les vues "Etudiant"
 * @author tophe
 * @version 1.0
 *
 */
public class ModeleEtudiant extends AbstractTableModel { 
	private String nomColonne[] = new String[]{"NOM","PRENOM", "FORMATION", "ADRESSE", "TELEPHONE", "MAIL"};
	private String[] promotions = null;
	private List<EtudiantWhithAcronyme> etudiantsWithAcronyme = new ArrayList<>();
	public ModeleEtudiant() {}
	public void setEtudiants(List<EtudiantWhithAcronyme> etudiantsWithAcronyme) {
		this.etudiantsWithAcronyme = etudiantsWithAcronyme;
		fireTableDataChanged();
	}
	public EtudiantWhithAcronyme getEtudiantWithAcronymeByIndex(int index) {
		return etudiantsWithAcronyme.get(index);
	}
	@Override
	public int getColumnCount() {
		return nomColonne.length;
	}         
	@Override
	public int getRowCount() {
		return etudiantsWithAcronyme.size();
	}
	@Override
	public String getColumnName(int index) {
		return nomColonne[index];
	}
	@Override
	public Object getValueAt(int ligne, int colonne) {
		EtudiantWhithAcronyme etudiant = etudiantsWithAcronyme.get(ligne);
		Object retour=null;
		switch (colonne) {
		case 0:
			retour = etudiant.getNom();
			break;
		case 1:
			retour = etudiant.getPrenom();
			break;
		case 2:
			retour = etudiant.getAcronyme();
			break;
		case 3:
			retour = etudiant.getAdresse();
			break;
		case 4:
			retour = etudiant.getTelephone();
			break;
		case 5:
			retour = etudiant.getMail();
			break;
		default:
			break;
		}
		return retour;
	}
	public String[] getPromotions() {
		return promotions;
	}
	public void setPromotions(String[] promotions) {
		this.promotions = promotions;
	}
	public String getAcronymeByIndex(int index){
		return promotions[index];
	}
} 
