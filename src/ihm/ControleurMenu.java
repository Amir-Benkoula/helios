package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ihm.admin.etudiant.ControleurEtudiant;
import ihm.admin.etudiant.ModeleEtudiant;
import ihm.admin.etudiant.VueEtudiant;
import ihm.admin.promotion.ControleurFormation;
import ihm.admin.promotion.ModeleFormation;
import ihm.admin.promotion.VueFormation;
import ihm.composant.MonJMenuItem;
import ihm.pilote.formation.ControleurPiloteFormation;
import ihm.pilote.formation.ModelPilote;
import ihm.pilote.formation.VuePiloteFormation;
import service.ServiceItf;
import util.Constante;
/**
 * Contr�leur principale. S�lectionne le contr�leur de la page �
 * afficher via la s�lection menu
 * @author tophe
 * @version 1.0
 *
 */
public class ControleurMenu extends JFrame implements ActionListener {
	private ServiceItf service;
	private JMenuBar barreMenus ; 
	private JMenu administration, pilote ; 
	private MonJMenuItem etudiantItem; 
	private MonJMenuItem promotionItem, piloteListeFormationItem;
	private Container conteneur;
	private JPanel panneauCourant;
	
	public ControleurMenu(ServiceItf service) {
		this.service = service;
		setTitle ("Tatoutapri") ; 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Constante.tailleFenetreX = dim.width;
		Constante.tailleFenetreY = dim.height - 40;
		Constante.calculerMarge();
		setBounds (0, 0, Constante.tailleFenetreX, Constante.tailleFenetreY) ;
		conteneur = getContentPane();	
		conteneur.setLayout(new BorderLayout(5, 5));
		conteneur.add(new Entete(), BorderLayout.NORTH);
		conteneur.add(new PiedPage(), BorderLayout.SOUTH);
		barreMenus = new JMenuBar() ; 
		setJMenuBar(barreMenus) ; 
		administration = new JMenu ("Administration");
		administration.setFont(Constante.menuFont);
		barreMenus.add(administration) ; 
		promotionItem = new MonJMenuItem ("Formation"); 
		
		administration.add(promotionItem); 
		promotionItem.addActionListener (this);
		etudiantItem = new MonJMenuItem ("Etudiant"); 
		administration.add(etudiantItem); 
		etudiantItem.addActionListener (this);  	
		initIhmComposant();

		pilote = new JMenu("Pilote");
		pilote.setFont(Constante.menuFont);
		barreMenus.add(pilote); 
		piloteListeFormationItem = new MonJMenuItem("Liste formations"); 
		pilote.add(piloteListeFormationItem); 
		piloteListeFormationItem.addActionListener(this); 

		String resource = getClass().getClassLoader().getResource("icone.png").getPath();
	    Image icon = Toolkit.getDefaultToolkit().getImage(resource);  
	    setIconImage(icon);  
		setVisible(true);
	} 
	public void actionPerformed(ActionEvent e) { 
		conteneur.remove(panneauCourant);
		Object source = e.getSource() ; 
		System.out.println ("Action avec chaine de commande = " + e.getActionCommand() ) ; 
		if(source == etudiantItem) {  
			System.out.println ("** Action option etudiant") ; 
			ModeleEtudiant modeleEtudiant = new ModeleEtudiant();
			ControleurEtudiant controleurEtudiant = new ControleurEtudiant(service, modeleEtudiant);
			panneauCourant = new VueEtudiant(controleurEtudiant, modeleEtudiant);
		}
		else if(source == promotionItem) {    
			System.out.println ("** Action option promotion") ; 
			ModeleFormation modeleFormation = new ModeleFormation();
			ControleurFormation controleurFormation = new ControleurFormation(service, modeleFormation);
			VueFormation vueFormation = new VueFormation(controleurFormation, modeleFormation);
			panneauCourant = vueFormation;
		}
		else if(source == piloteListeFormationItem) {    
			System.out.println ("** Action option pilote liste formations") ;
			System.out.println ("** Action option promotion") ; 
			ModelPilote modelPilote = new ModelPilote();
			ControleurPiloteFormation controleurPiloteFormation = new ControleurPiloteFormation(service, modelPilote, this);
			VuePiloteFormation vuePiloteFormation = new VuePiloteFormation(controleurPiloteFormation, modelPilote);
			panneauCourant = vuePiloteFormation;
		}
		conteneur.add(panneauCourant, BorderLayout.CENTER);
		conteneur.revalidate();
	} 	

	public void updateDisplay(JPanel vue) {
		conteneur.remove(panneauCourant);
		panneauCourant = vue;
		conteneur.add(panneauCourant, BorderLayout.CENTER);
		conteneur.revalidate();
	}
	public void initIhmComposant() {
		ModeleEtudiant modeleEtudiant = new ModeleEtudiant();
		ControleurEtudiant controleurEtudiant = new ControleurEtudiant(service, modeleEtudiant);
		panneauCourant = new VueEtudiant(controleurEtudiant, modeleEtudiant);
		conteneur.add(panneauCourant, BorderLayout.CENTER);
		conteneur.revalidate();
	}
}
