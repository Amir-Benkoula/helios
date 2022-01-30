package ihm.composant;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import util.Constante;
/**
 * Composant graphique panneau
 * @author tophe
 * @version 1.0
 *
 */
public class MonJPanel extends JPanel {

	public MonJPanel() {
		super();
		setBackground(Constante.couleurArrierePlan);
	}

	public MonJPanel(LayoutManager layout) {
		super(layout);
		setBackground(Constante.couleurArrierePlan);
	}
	

}
