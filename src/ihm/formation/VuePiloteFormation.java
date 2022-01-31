package ihm.formation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.Normalizer.Form;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import entite.Module;
import ihm.admin.etudiant.IhmAfficherEtudiant;
import ihm.admin.etudiant.IhmModifierEtudiant;
import util.Constante;

import java.awt.Color;

public class VuePiloteFormation extends JPanel {
	private ControleurPiloteFormation controleur;
	private PanneauFormulaireModule panneauFormulaireModule;
	private ModelPilote modelPilote;
	private JComboBox<String> acronymeCombo; 
	public VuePiloteFormation(ControleurPiloteFormation controleur, ModelPilote modelPilote){
		this.controleur = controleur;
		this.modelPilote = modelPilote;
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10,10));		
		System.out.println("CONSTRUCTEUR VuePiloteFormation formation=" + modelPilote.getFormation().getAcronyme());
		JLabel titre = new JLabel("PILOTE FORMATION - " + modelPilote.getFormation().getAcronyme() + 
				" - " + modelPilote.getFormation().getIntitule(), SwingConstants.CENTER);
		titre.setFont(Constante.titre2Font);
		add(titre, BorderLayout.NORTH) ;

		JPanel panneauContenu = new JPanel();
		panneauContenu.setLayout(new BorderLayout(20,20));
		
		JPanel panneauComboAcronyme = new JPanel();
		panneauComboAcronyme.setLayout(new FlowLayout(10, 10, 10));
		acronymeCombo = new JComboBox<>(modelPilote.getStrAcronymes());
		acronymeCombo.setSelectedIndex(modelPilote.getIndex());
		acronymeCombo.setFont(Constante.texteFont);
		panneauComboAcronyme.add(acronymeCombo);
		
		panneauContenu.add(panneauComboAcronyme, BorderLayout.NORTH);	
		add(panneauContenu, BorderLayout.CENTER) ;
		
		JPanel panneauTab = new JPanel();
		panneauTab.setLayout (new GridLayout(3, 1, 20, 20));
		JTable tableEtudiant = new JTable(modelPilote.getModelEtudiantTab());
		tableEtudiant.getTableHeader().setBackground(Constante.couleurEnteteTableau);
		tableEtudiant.getTableHeader().setFont(Constante.titreTabFont);
		tableEtudiant.setFont(Constante.texteFont);
		tableEtudiant.setRowHeight(30);
		JScrollPane tabScroll1 = new JScrollPane(tableEtudiant);
		panneauTab.add(tabScroll1, BorderLayout.NORTH);
		panneauContenu.add(panneauTab, BorderLayout.CENTER);
		
		JTable tableModule = new JTable(modelPilote.getModeleModuleTab());
		tableModule.getTableHeader().setBackground(Constante.couleurEnteteTableau);
		tableModule.getTableHeader().setFont(Constante.titreTabFont);
		tableModule.setFont(Constante.texteFont);
		tableModule.setRowHeight(30);
		JScrollPane tabScroll2 = new JScrollPane(tableModule);
		panneauTab.add(tabScroll2, BorderLayout.CENTER);
		
		acronymeCombo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	int selectAcronymeId = acronymeCombo.getSelectedIndex(); 
		    	System.out.println("VuePiloteFormation - Action combo selectAcronymeId=" + selectAcronymeId);
		    	controleur.seclectFormation(selectAcronymeId);
		    }
		});
		
		panneauFormulaireModule = new PanneauFormulaireModule(controleur, modelPilote);
		panneauTab.add(panneauFormulaireModule, BorderLayout.SOUTH);
	}
}
class PanneauFormulaireModule extends JPanel implements ActionListener {
	private JTextField intituleField;
	private JButton ajouterModuleBouton;
	private ControleurPiloteFormation controleur; 
	private ModelPilote modelPilote; 
	public PanneauFormulaireModule(ControleurPiloteFormation controleur, ModelPilote modelPilote) {
		this.controleur = controleur;
		this.modelPilote = modelPilote;
		setLayout(new FlowLayout());
		add(getModulePanel());
		ajouterModuleBouton = new JButton("CREER");
		ajouterModuleBouton.addActionListener(this);
		add(ajouterModuleBouton);
	}
	public JPanel getModulePanel() {		
		JPanel panel = new JPanel();
		panel.setLayout (new GridLayout(1, 2, 20, 20));
		panel.add(new JLabel("Intitul� :")).setFont(Constante.texteFont);
		intituleField = new JTextField(10);
		panel.add(intituleField).setFont(Constante.texteFont);

		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("InscrireEtudiant - Action listener");
		if(e.getSource() == ajouterModuleBouton){
			System.out.println("Bouton ajouter promotion");
			String intitule = intituleField.getText();
			Module module = new Module(intitule);
			controleur.ajouterModule(module, modelPilote.getFormation().getAcronyme());
			intituleField.setText("");
		}

	}
}
