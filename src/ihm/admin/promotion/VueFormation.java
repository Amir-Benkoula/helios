package ihm.admin.promotion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.Normalizer.Form;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import ihm.admin.etudiant.IhmAfficherEtudiant;
import ihm.admin.etudiant.IhmModifierEtudiant;
import ihm.composant.MonJButton;
import ihm.composant.MonJPanel;
import ihm.composant.MonJTable;
import util.Constante;

import java.awt.Color;

/**
 * Vue principale "Formation". Administrer les formations proposées par hélios.
 * Afficher tableau formation (action supprimer/afficher/modifier) et formulaire de création.
 * @author tophe
 * @version 1.0
 *
 */
public class VueFormation extends MonJPanel implements ActionListener {
	private ControleurFormation controleur;
	private PanFormulairePromotion panFormulairePromotion;
	private JTable table;
	private ModeleFormation model;
	private MonJButton btnSupprimer;
	private MonJButton btnAfficher;
	private MonJButton btnModifier;
	public VueFormation(ControleurFormation controleurPromotion, ModeleFormation model){
		this.controleur = controleurPromotion;
		this.model = model;
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10,10));		
		MonJPanel panTitrePlusForm = new MonJPanel();
		panTitrePlusForm.setLayout(new BorderLayout(10,10));		
		JLabel titre = new JLabel("FORMATIONS", SwingConstants.CENTER);
		titre.setFont(Constante.titre2Font);
		panTitrePlusForm.add(titre, BorderLayout.NORTH) ;
		panFormulairePromotion = new PanFormulairePromotion(controleurPromotion);
		panTitrePlusForm.add(panFormulairePromotion, BorderLayout.CENTER);
		panTitrePlusForm.add(panFormulairePromotion, BorderLayout.CENTER);
		add(panTitrePlusForm, BorderLayout.NORTH);

		MonJPanel panTabPlusBtns = new MonJPanel();
		panTabPlusBtns.setLayout(new BorderLayout(10,10));

		table = new MonJTable(model);
		JScrollPane tabScroll = new JScrollPane(table);
		tabScroll.setForeground(Color.white);
		add(tabScroll, BorderLayout.CENTER);

		MonJPanel panneauBtn = new MonJPanel();
		panneauBtn.setLayout(new FlowLayout());
		add(panneauBtn, BorderLayout.SOUTH);
		panneauBtn.setFont(Constante.texteFont);

		btnSupprimer = new MonJButton("Supprimer");
		btnSupprimer.addActionListener(this);
		panneauBtn.add(btnSupprimer);

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
		int index = table.getSelectedRow();
		if(index != -1) {
			if(e.getSource() == btnSupprimer){
				Formation formation = model.getFormationByIndex(index);
				int retour = -1;
				retour = JOptionPane.showConfirmDialog(null,
						"Attention Etes-vous sûr de vouloir supprimer la formation " + formation.getAcronyme() + " - " + formation.getIntitule(), 
						"Suppression formation",
						JOptionPane.OK_CANCEL_OPTION);
				System.out.println("retour=" + retour);
				if(retour == 0)
					controleur.supprimerFormation(formation.getAcronyme());
			}
			else if(e.getSource() == btnAfficher){
				System.out.println("afficher formation");
				Formation formation = model.getFormationByIndex(index);
				controleur.ihmAfficherFormation(formation);
			}
			else if(e.getSource() == btnModifier){
				System.out.println("modifier formation");
				Formation formation = model.getFormationByIndex(index);
				System.out.println("Modifier formation=" + formation);
				controleur.ihmModifierFormation(formation);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner une formation.");
		}
	}
}
