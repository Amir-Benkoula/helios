package ihm.composant;

import javax.swing.JLabel;

import util.Constante;
/**
 * Composant graphique label texte
 * @author tophe
 * @version 1.0
 *
 */
public class MonJLabelTexte extends JLabel {

	public MonJLabelTexte(String text) {
		super(text);
		setFont(Constante.texteFont);
	}

	public MonJLabelTexte(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		setFont(Constante.texteFont);
	}
	

}
