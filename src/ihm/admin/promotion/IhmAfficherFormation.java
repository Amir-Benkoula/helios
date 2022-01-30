package ihm.admin.promotion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import ihm.composant.MonJLabelTexte;
import ihm.composant.MonJLabelTitre;
import ihm.composant.MonJPanel;
import ihm.composant.MonJTextField;
import service.ServiceItf;
import util.Constante;

/**
 * Fenêtre ouverte action utilisateur "afficher" aprés sélection d'une formation du tableau
 * @author tophe
 * @version 1.0
 *
 */
public class IhmAfficherFormation extends JFrame {
	private ControleurFormation controleur;
	private Formation formation;
	private Container conteneur;
	public IhmAfficherFormation(Formation formation) {
		this.formation = formation;
		setTitle ("Afficher formation") ; 
		setBounds (Constante.margeFormationX, Constante.margeFormationY, Constante.fenetreSecondaireFormationX, Constante.fenetreSecondaireFormationY) ;
		setVisible(true);
		conteneur = getContentPane();
		conteneur.setBackground(Constante.couleurArrierePlan);
		conteneur.setLayout(new BorderLayout(10, 10));		
		
		MonJLabelTitre titre = new MonJLabelTitre("AFFICHER Formation");
		conteneur.add(titre, BorderLayout.NORTH) ;
		conteneur.setBackground(Constante.couleurArrierePlan2);
		
		MonJPanel pan = new MonJPanel(new FlowLayout(FlowLayout.CENTER, 40, 6));
		
		MonJPanel panFormulaire = new MonJPanel();
		panFormulaire.setLayout(new BorderLayout(20, 10));
		MonJPanel panSansDescr = new MonJPanel();
		panSansDescr.setLayout (new GridLayout(4, 2, 20, 20));
		
		panSansDescr.add(new MonJLabelTexte("Acronyme : "));
		panSansDescr.add(new MonJLabelTexte(formation.getAcronyme()));

		panSansDescr.add(new MonJLabelTexte("Intitulé :"));
		panSansDescr.add(new MonJLabelTexte(formation.getIntitule()));
		
		panSansDescr.add(new MonJLabelTexte("Nombre heures :"));
		panSansDescr.add(new MonJLabelTexte(Integer.toString(formation.getNbrHeure())));
		
		panSansDescr.add(new MonJLabelTexte("Description :"));
		panFormulaire.add(panSansDescr, BorderLayout.CENTER);
		
		JTextArea descriptionArea = new JTextArea(formation.getDescription());
		descriptionArea.setFont(Constante.texteDescriptionFont);
		descriptionArea.setEditable(false);
		panFormulaire.add(descriptionArea, BorderLayout.SOUTH);
		
		pan.add(panFormulaire);
		conteneur.add(pan, BorderLayout.CENTER);
		
	} 
}
