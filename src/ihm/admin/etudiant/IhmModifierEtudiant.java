package ihm.admin.etudiant;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import ihm.composant.MonJLabelTitre;
import ihm.composant.MonJPanel;
import service.ServiceItf;
import util.Constante;
/**
 * Fen�tre ouverte action utilisateur "modifier" apr�s s�lection d'un �tudiant du tableau 
 * @author tophe
 * @version 1.0
 *
 */
public class IhmModifierEtudiant extends JFrame {
	private ControleurEtudiant controleur;
	private EtudiantWhithAcronyme etudiantWithAcronyme;
	private ModeleEtudiant model;
	private Container conteneur;
	public IhmModifierEtudiant(ControleurEtudiant controleur, EtudiantWhithAcronyme etudiantWithAcronyme, ModeleEtudiant model) {
		this.controleur = controleur;
		this.etudiantWithAcronyme = etudiantWithAcronyme;
		this.model = model;
		setTitle ("Modifier étudiant") ; 
		setBounds (Constante.margeEtudiantX, Constante.margeEtudiantY, Constante.fenetreSecondaireEtudiantX, Constante.fenetreSecondaireEtudiantY) ;
		setVisible(true);
		conteneur = getContentPane();
		conteneur.setLayout(new BorderLayout(10, 10));
		conteneur.setBackground(Constante.couleurArrierePlan2);
		MonJLabelTitre titre = new MonJLabelTitre("MODIFIER ETUDIANT", SwingConstants.CENTER);
		conteneur.add(titre, BorderLayout.NORTH) ;
		conteneur.add(new PanFormulaireEtudiant(controleur, etudiantWithAcronyme, model));
	} 
}
