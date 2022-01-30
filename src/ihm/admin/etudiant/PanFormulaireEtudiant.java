package ihm.admin.etudiant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import entite.EtudiantWhithAcronyme;
import entite.Formation;
import ihm.composant.MonJButton;
import ihm.composant.MonJLabelTexte;
import ihm.composant.MonJPanel;
import ihm.composant.MonJTextField;
import util.Constante;
/**
 * Formulaire de cr�ation et modification d'un �tudiant.  
 * @author tophe
 * @version 1.0
 *
 */
public class PanFormulaireEtudiant extends MonJPanel implements ActionListener {
	private JComboBox<String> acronymeCombo; 
	private MonJTextField nomField;
	private MonJTextField prenomField;
	private MonJTextField adresseField;
	private MonJTextField telephoneField;
	private MonJTextField mailField;
	private MonJButton creerModifierBouton;
	private ModeleEtudiant model;
	private ControleurEtudiant controleur; 
	private EtudiantWhithAcronyme etudiantWithAcronyme;
	private boolean modifierMode = false;
	/**
	 * Instanciation d'un formulaire de création "étudiant"
	 * @param controleur contrôleur "Etudiant" - callback action utilisateur
	 * @param model données des étudiants
	 */
	public PanFormulaireEtudiant(ControleurEtudiant controleur, ModeleEtudiant model) {
		this.controleur = controleur;
		this.model = model;
		modifierMode = false;
		creerModifierFormulaire();
	}
	/**
	 * Instanciation d'un formulaire de modification "étudiant"
	 * @param controleur contrôleur "Etudiant" - action utilissateur
	 * @param etudiantWithAcronyme étudiant sélectionné tableau
	 * @param model données des étudiants 
	 */
	public PanFormulaireEtudiant(ControleurEtudiant controleur, EtudiantWhithAcronyme etudiantWithAcronyme, ModeleEtudiant model) {
		this.controleur = controleur;
		this.etudiantWithAcronyme = etudiantWithAcronyme;
		this.model = model;
		modifierMode = true;
		creerModifierFormulaire();
	}
	private void creerModifierFormulaire() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		if(modifierMode == true) {
			MonJPanel panModifier = new MonJPanel();
			panModifier.setLayout(new BorderLayout(10, 10));
			panModifier.add(getEtudiantFormulairePremierChampsPanel(), BorderLayout.NORTH);
			panModifier.add(getEtudiantFormulaireDerniersChampsPanel(), BorderLayout.CENTER);
			MonJPanel panBtn = new MonJPanel(new FlowLayout());
			creerModifierBouton = new MonJButton("modifier");
			creerModifierBouton.addActionListener(this);
			panBtn.add(creerModifierBouton);
			panModifier.add(panBtn, BorderLayout.SOUTH);
			add(panModifier);
		}
		else {
			add(getEtudiantFormulairePremierChampsPanel(), BorderLayout.NORTH);
			add(getEtudiantFormulaireDerniersChampsPanel(), BorderLayout.CENTER);
			creerModifierBouton = new MonJButton("inscire");
			creerModifierBouton.addActionListener(this);
			add(creerModifierBouton);
		}
	}

	public MonJPanel getEtudiantFormulairePremierChampsPanel() {		
		MonJPanel panFormulairePremierChamps = new MonJPanel();
		panFormulairePremierChamps.setLayout (new GridLayout(3, 2, 20, 20));
		panFormulairePremierChamps.add(new MonJLabelTexte("Acronyme : "));
		if(modifierMode == true) {	
			panFormulairePremierChamps.add(new MonJLabelTexte(etudiantWithAcronyme.getAcronyme()));
		}
		else {
			acronymeCombo = new JComboBox<>(model.getPromotions());
			panFormulairePremierChamps.add(acronymeCombo).setFont(Constante.texteFont);
		}
		panFormulairePremierChamps.add(new MonJLabelTexte("Nom :"));
		if(modifierMode == true) {	
			nomField = new MonJTextField(etudiantWithAcronyme.getNom(), 20);
		}
		else {
			nomField = new MonJTextField(20);
		}
		panFormulairePremierChamps.add(nomField);
		panFormulairePremierChamps.add(new MonJLabelTexte("Prenom :"));
		if(modifierMode == true) {	
			prenomField = new MonJTextField(etudiantWithAcronyme.getPrenom(), 20);
		}
		else {
			prenomField = new MonJTextField(20);
		}
		panFormulairePremierChamps.add(prenomField);
		
		return panFormulairePremierChamps;
	}
	public MonJPanel getEtudiantFormulairePremiersChampPanel() {		
		MonJPanel panFormulairePremierChamps = new MonJPanel();
		panFormulairePremierChamps.setLayout (new GridLayout(3, 2, 20, 20));
		System.out.println("PanneauInscrireEtudiant getEtudiantPanel etudiantWhithAcronyme=" + etudiantWithAcronyme);

		panFormulairePremierChamps.add(new MonJLabelTexte("Acronyme : "));
		if(modifierMode == true) {
			panFormulairePremierChamps.add(new MonJLabelTexte(etudiantWithAcronyme.getAcronyme()));
		}
		else {
			acronymeCombo = new JComboBox<>(model.getPromotions());
			panFormulairePremierChamps.add(acronymeCombo).setFont(Constante.texteFont);
		}
		panFormulairePremierChamps.add(new MonJLabelTexte("Nom :"));
		if(modifierMode == true) {
			nomField = new MonJTextField(etudiantWithAcronyme.getNom(), 20);
		}
		else {
			nomField = new MonJTextField(20);
		}
		panFormulairePremierChamps.add(nomField);
		panFormulairePremierChamps.add(new MonJLabelTexte("Prenom :"));
		if(modifierMode == true) {
			prenomField = new MonJTextField(etudiantWithAcronyme.getPrenom(), 20);
		}
		else {
			prenomField = new MonJTextField(20);
		}
		panFormulairePremierChamps.add(prenomField);
		
		return panFormulairePremierChamps;
	}
	public MonJPanel getEtudiantFormulaireDerniersChampsPanel() {		
		MonJPanel panFormulaireDerniersChamps = new MonJPanel();
		panFormulaireDerniersChamps.setLayout (new GridLayout(3, 2, 20, 20));
		System.out.println("PanneauInscrireEtudiant getEtudiantPanel etudiantWhithAcronyme=" + etudiantWithAcronyme);

		panFormulaireDerniersChamps.add(new MonJLabelTexte("Adresse :"));
		if(modifierMode == true) {
			adresseField = new MonJTextField(etudiantWithAcronyme.getAdresse(), 20);
		}
		else {
			adresseField = new MonJTextField(20);
		}
		panFormulaireDerniersChamps.add(adresseField);
		panFormulaireDerniersChamps.add(new MonJLabelTexte("Téléphone :"));
		if(modifierMode == true) {
			telephoneField = new MonJTextField(etudiantWithAcronyme.getTelephone(), 20);
		}
		else {
			telephoneField = new MonJTextField(20);
		}
		panFormulaireDerniersChamps.add(telephoneField);
		panFormulaireDerniersChamps.add(new MonJLabelTexte("Email :"));
		if(modifierMode == true) {
			mailField = new MonJTextField(etudiantWithAcronyme.getMail(), 20);
		}
		else {
			mailField = new MonJTextField(20);
			panFormulaireDerniersChamps.add(mailField);
		}
		
		return panFormulaireDerniersChamps;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("creerModifierEtudiant - Action listener" + e.getSource() );
		String nom = nomField.getText();
		String prenom = prenomField.getText();	
		String adresse = adresseField.getText();
		String telephone = telephoneField.getText();
		String mail = mailField.getText();
		if(modifierMode == true) {
			System.out.println("Bouton modifier étudiant");
			etudiantWithAcronyme.setNom(nom);
			etudiantWithAcronyme.setPrenom(prenom);
			etudiantWithAcronyme.setAdresse(adresse);
			etudiantWithAcronyme.setTelephone(telephone);
			etudiantWithAcronyme.setMail(mail);
			controleur.modifierEtudiant(etudiantWithAcronyme);
		}
		else {
			System.out.println("Bouton inscrire étudiant");
			int selectAcronymeId = acronymeCombo.getSelectedIndex(); 
			String acronyme = null;
			if(selectAcronymeId != -1) {
				acronyme = model.getAcronymeByIndex(selectAcronymeId);
				System.out.println("Sélection:" + acronyme); 
			}
			
			EtudiantWhithAcronyme etudiantWhithAcronyme = new EtudiantWhithAcronyme(nom, prenom, adresse, telephone, mail, acronyme);
			controleur.ajouterEtudiant(etudiantWhithAcronyme);
			nomField.setText("");
			prenomField.setText("");
			adresseField.setText("");
			telephoneField.setText("");
			mailField.setText("");
		}
	}
}
