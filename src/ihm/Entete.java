package ihm;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ihm.composant.MonJPanel;
import util.Constante;
/**
 * Haut de page de l'application. Est constitué d'un titre, d'un logo, du nom
 * de l'entreprise et du sloga.
 * @author tophe
 * @version 1.0
 *
 */
public class Entete extends JPanel {
	public Entete() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(10,10));		
		setBackground(Constante.couleurArrierePlan2);
		JLabel img = new JLabel("");
		String chemin = "TatoutApriC.png";
		String resource = getClass().getClassLoader().getResource(chemin).getPath();
		img.setIcon(new ImageIcon(resource));
		setAlignmentX( Component.LEFT_ALIGNMENT );
		add(img, BorderLayout.WEST);
		MonJPanel panTitrePlusSlogan = new MonJPanel();
		panTitrePlusSlogan.setBackground(Constante.couleurArrierePlan2);
		panTitrePlusSlogan.setLayout (new GridLayout(2, 1, 20, 20));
		JLabel titre = new JLabel("HELIOS FORMATION", SwingConstants.CENTER);
		titre.setFont(Constante.titreEnteteFont);
		titre.setForeground(Constante.couleurtitreEntete);
		panTitrePlusSlogan.add(titre);
		JLabel slogan = new JLabel("\"L'école de l'innovation et de l'expertise informatique\"", SwingConstants.CENTER);
		slogan.setFont(Constante.sloganFont);
		slogan.setForeground(Color.red);
		panTitrePlusSlogan.add(slogan) ;
		add(panTitrePlusSlogan, BorderLayout.CENTER) ;
	}
}
