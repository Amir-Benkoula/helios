package ihm.composant;

import javax.swing.JMenuItem;

import util.Constante;
/**
 * Composant graphique item menu
 * @author tophe
 * @version 1.0
 *
 */
public class MonJMenuItem extends JMenuItem {

	public MonJMenuItem(String text) {
		super(text);
		setFont(Constante.menuItemFont);
	}

}
