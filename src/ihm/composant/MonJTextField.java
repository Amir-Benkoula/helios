package ihm.composant;

import javax.swing.JTextField;

import util.Constante;
/**
 * Composant graphique édition de texte
 * @author tophe
 * @version 1.0
 *
 */
public class MonJTextField extends JTextField {

	public MonJTextField(int columns) {
		super(columns);
		setFont(Constante.texteFont);
	}

	public MonJTextField(String text, int columns) {
		super(text, columns);
		setFont(Constante.texteFont);
	}

	public MonJTextField(String text) {
		super(text);
		setFont(Constante.texteFont);
	}

}
