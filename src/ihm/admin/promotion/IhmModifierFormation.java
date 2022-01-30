package ihm.admin.promotion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import ihm.composant.MonJLabelTitre;
import ihm.composant.MonJPanel;
import service.ServiceItf;
import util.Constante;
/**
 * Fenêtre ouverte action utilisateur "modifier" aprés sélection d'une formation du tableau 
 * @author tophe
 * @version 1.0
 *
 */
public class IhmModifierFormation extends JFrame {
	private ControleurFormation controleur;
	private Formation formation;
	private Container conteneur;
	public IhmModifierFormation(ControleurFormation controleur, Formation formation) {
		this.controleur = controleur;
		this.formation = formation;
		setTitle ("Modifier Formation") ; 
		setBounds (Constante.margeFormationX, Constante.margeFormationY, Constante.fenetreSecondaireFormationX, Constante.fenetreSecondaireFormationY) ;
		setVisible(true);
		conteneur = getContentPane();
		conteneur.setLayout(new BorderLayout(10, 10));
		MonJLabelTitre titre = new MonJLabelTitre("MODIFIER Formation");
		conteneur.add(titre, BorderLayout.NORTH) ;
		conteneur.setBackground(Constante.couleurArrierePlan2);
		conteneur.add(new PanFormulairePromotion(controleur, formation),BorderLayout.CENTER);
	} 
}
