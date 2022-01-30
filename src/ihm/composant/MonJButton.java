package ihm.composant;

import javax.swing.JButton;

import util.Constante;
/**
 * Composant graphique bouton
 * @author tophe
 * @version 1.0
 *
 */
public class MonJButton extends JButton {

	public MonJButton(String text) {
		super(text);
		setBackground(Constante.couleurbouton);
		setFont(Constante.boutonFont);
	}

}
