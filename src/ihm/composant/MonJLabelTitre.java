package ihm.composant;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import util.Constante;
/**
 * Composant graphique label titre
 * @author tophe
 * @version 1.0
 *
 */
public class MonJLabelTitre extends JLabel {
	
	public MonJLabelTitre(String text) {
		super(text, SwingConstants.CENTER);
		setFont(Constante.titre2Font);
	}

	public MonJLabelTitre(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		setFont(Constante.titre2Font);
	}
}
