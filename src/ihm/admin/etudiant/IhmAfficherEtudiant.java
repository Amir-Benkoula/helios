package ihm.admin.etudiant;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import ihm.composant.MonJLabelTexte;
import ihm.composant.MonJLabelTitre;
import ihm.composant.MonJPanel;
import ihm.composant.MonJTextField;
import service.ServiceItf;
import util.Constante;
/**
 * Fenêtre ouverte action utilisateur "afficher" après sélection d'un étudiant du tableau
 * @author tophe
 * @version 1.0
 *
 */
public class IhmAfficherEtudiant extends JFrame {
	private EtudiantWhithAcronyme etudiantWithAcronyme;
	private Container conteneur;
	public IhmAfficherEtudiant(EtudiantWhithAcronyme etudiantWithAcronyme) {
		this.etudiantWithAcronyme = etudiantWithAcronyme;
		setTitle ("Modifier étudiant") ; 
		setBounds (Constante.margeEtudiantX, Constante.margeEtudiantY, Constante.fenetreSecondaireEtudiantX, Constante.fenetreSecondaireEtudiantY) ;
		setVisible(true);
		conteneur = getContentPane();
		conteneur.setBackground(Constante.couleurArrierePlan2);
		conteneur.setLayout(new BorderLayout(10, 10));
		MonJLabelTitre titre = new MonJLabelTitre("AFFICHER ETUDIANT", SwingConstants.CENTER);
		conteneur.add(titre, BorderLayout.NORTH) ;		
		MonJPanel panAfficherEtudiant = new MonJPanel();
		panAfficherEtudiant.setLayout(new FlowLayout());
		panAfficherEtudiant.add(getEtudiantAfficherPanel());
		conteneur.add(panAfficherEtudiant,BorderLayout.CENTER) ;
	} 
	public MonJPanel getEtudiantAfficherPanel() {		
		MonJPanel panFormulaire = new MonJPanel();
		panFormulaire.setLayout (new GridLayout(6, 2, 20, 20));
		System.out.println("PanneauInscrireEtudiant getEtudiantPanel etudiantWhithAcronyme=" + etudiantWithAcronyme);

		panFormulaire.add(new MonJLabelTexte("Formation : "));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getAcronyme()));
		
		panFormulaire.add(new MonJLabelTexte("Nom :"));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getNom()));
		
		panFormulaire.add(new MonJLabelTexte("Prenom :"));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getPrenom()));
		
		panFormulaire.add(new MonJLabelTexte("Adresse :"));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getAdresse()));
		
		panFormulaire.add(new MonJLabelTexte("Téléphone :"));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getTelephone()));
		
		panFormulaire.add(new MonJLabelTexte("Email :"));
		panFormulaire.add(new MonJLabelTexte(etudiantWithAcronyme.getMail()));
				
		return panFormulaire;
	}
}
