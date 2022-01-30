package util;

import java.awt.Color;
import java.awt.Font;

/**
 * Constante propriétés d'affichages
 * @author tophe
 * @version 1.0
 *
 */
public class Constante {
	
	public static int tailleFenetreX = 0;
	public static int tailleFenetreY = 0;
	
	public static int margeEtudiantX = 0;
	public static int margeEtudiantY = 0;
	public static int margeFormationX = 0;
	public static int margeFormationY = 0;
	
	public static int fenetreX = 1400;
	public static int fenetreY = 800;
	public static int fenetreSecondaireAfficherX = 1200;
	public static int fenetreSecondaireAfficherY = 600;
	public static int fenetreSecondaireFormationX = 1100;
	public static int fenetreSecondaireFormationY = 500;
	public static int fenetreSecondaireEtudiantX = 1100;
	public static int fenetreSecondaireEtudiantY = 450;
	
	public static Font titreEnteteFont = new Font("Britannic Bold", Font.BOLD, 42);
	public static Font titre2Font = new Font("Tahoma", Font.BOLD, 28);
	public static Font sloganFont = new Font("Tahoma", Font.ITALIC, 24);
	public static Font texteFont = new Font("Tahoma", Font.PLAIN, 18);
	public static Font menuFont = new Font("Tahoma", Font.PLAIN, 18);
	public static Font menuItemFont = new Font("Tahoma", Font.PLAIN, 16);
	public static Font boutonFont = new Font("Tahoma", Font.PLAIN, 20);
	public static Font texteDescriptionFont = new Font("Tahoma", Font.PLAIN, 14);
	public static Font titreTabFont = new Font("Tahoma", Font.BOLD, 20);
	public static Font copyrightFont = new Font("Tahoma", Font.BOLD, 20);
	public static Font msgErreurFont = new Font("Tahoma", Font.BOLD, 18);
	
	public static void calculerMarge() {
		margeEtudiantX = (tailleFenetreX - fenetreSecondaireEtudiantX)/2;
		margeEtudiantY = (tailleFenetreY - fenetreSecondaireEtudiantY)/2;
		margeFormationX = (tailleFenetreX - fenetreSecondaireFormationX)/2;
		margeFormationY = (tailleFenetreY - fenetreSecondaireFormationY)/2;
	}
	public static Color couleurtitreEntete = new Color(240,240,255);
	public static Color couleurArrierePlan = new Color(240,240,255);
	public static Color couleurArrierePlan2 = new Color(200, 200, 255);
	
	public static Color couleurEnteteTableau = new Color(32,136,203);
	public static Color couleurPiedPage = new Color(54,53,52);
	
	public static Color couleurbouton = new Color(210, 209, 254);
	
	
}
