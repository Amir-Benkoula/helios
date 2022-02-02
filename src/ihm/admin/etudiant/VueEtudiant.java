package ihm.admin.etudiant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import entite.EtudiantWhithAcronyme;
import ihm.composant.MonJButton;
import ihm.composant.MonJLabelTexte;
import ihm.composant.MonJLabelTitre;
import ihm.composant.MonJPanel;
import ihm.composant.MonJTable;
import ihm.composant.MonJTextField;
import util.Constante;
/**
 * Vue principale "Etudiant".
 * Administration des étduiants. Afficher tableau d'étudiants (action afficher/modifier/supprimer)
 * et forulaire d'inscription
 * @author tophe
 * @version 1.0
 *
 */
public class VueEtudiant extends MonJPanel implements ActionListener {
	private ControleurEtudiant controleur;
	private ModeleEtudiant model;
	private PanFormulaireEtudiant panFormulaireEtudiant;
	private JTable table;
	private MonJTextField filtrerField;
	private MonJButton btnSupprimer;
	private MonJButton btnAfficher;
	private MonJButton btnModifier;
	private MonJButton btnFiltrer;
	public VueEtudiant(ControleurEtudiant controleurEtudiant, ModeleEtudiant model){
		this.controleur = controleurEtudiant;
		this.model = model;
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10,10));		
		MonJPanel panTitrePlusForm = new MonJPanel();
		panTitrePlusForm.setLayout(new BorderLayout(10,10));	
		MonJLabelTexte titre = new MonJLabelTexte("ETUDIANT", SwingConstants.CENTER);
		titre.setFont(Constante.titre2Font);
		panTitrePlusForm.add(titre, BorderLayout.NORTH) ;

		panFormulaireEtudiant = new PanFormulaireEtudiant(controleur, model);
		panTitrePlusForm.add(panFormulaireEtudiant, BorderLayout.CENTER);
		add(panTitrePlusForm, BorderLayout.NORTH);

		MonJPanel panTabPlusBtns = new MonJPanel();
		panTabPlusBtns.setLayout(new BorderLayout());

		MonJPanel panFlow = new MonJPanel();
		panFlow.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		table = new MonJTable(model);
		JScrollPane tabScroll = new JScrollPane(table);
		panTabPlusBtns.add(tabScroll, BorderLayout.CENTER);

		MonJPanel panRecherche = new MonJPanel();
		panRecherche.setLayout(new FlowLayout());
		MonJTextField filtrerField = new MonJTextField(20);
		MonJLabelTexte filtrerTexte = new MonJLabelTexte("Filtrer par nom :");
		MonJButton btnFiltrer = new MonJButton("filtrer");
		btnFiltrer.addActionListener(this);
		panRecherche.setFont(Constante.texteFont);
		panRecherche.add(filtrerTexte);
		panRecherche.add(filtrerField);
		panRecherche.add(btnFiltrer);
		panTabPlusBtns.add(panRecherche, BorderLayout.NORTH);

		MonJPanel panneauBtn = new MonJPanel();
		panneauBtn.setLayout(new FlowLayout());
		btnSupprimer = new MonJButton("Supprimer");
		btnSupprimer.addActionListener(this);
		panneauBtn.setFont(Constante.texteFont);
		panneauBtn.add(btnSupprimer);
		panTabPlusBtns.add(panneauBtn, BorderLayout.SOUTH);

		add(panTabPlusBtns, BorderLayout.CENTER);

		btnAfficher = new MonJButton("afficher");
		panneauBtn.add(btnAfficher);
		btnAfficher.addActionListener(this);

		btnModifier = new MonJButton("modifier");
		panneauBtn.add(btnModifier);
		btnModifier.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed - Action boutons supprimer/afficher/modifier");
		if(e.getSource() == btnFiltrer){
			System.out.println("filtrer étudiants");
			String nom = filtrerField.getText();
			controleur.trierEtudiant(nom);
		}
		int index = table.getSelectedRow();
		if(index != -1) {
			if(e.getSource() == btnSupprimer){
				System.out.println("supprimer étudiant");
				EtudiantWhithAcronyme etudiant = model.getEtudiantWithAcronymeByIndex(index);
				int retour = JOptionPane.showConfirmDialog(null,
						"Etes-vous sûr de vouloir supprimer l'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom(), 
						"Suppression étudiant",
						JOptionPane.OK_CANCEL_OPTION);
				System.out.println("retour=" + retour);
				if(retour == 0)
					controleur.supprimerEtudiant(index);
			}
			else if(e.getSource() == btnAfficher){
				System.out.println("afficher étudiant");
				EtudiantWhithAcronyme etudiantWithAcronyme = model.getEtudiantWithAcronymeByIndex(index);
				controleur.ihmAfficherEtudiant(etudiantWithAcronyme);
			}
			else if(e.getSource() == btnModifier){
				System.out.println("modifier étudiant");
				EtudiantWhithAcronyme etudiantWithAcronyme = model.getEtudiantWithAcronymeByIndex(index);
				controleur.ihmModifierEtudiant(etudiantWithAcronyme);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner un étudiant.");
		}
	}
}
