package ihm;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.Constante;
/**
 * Pied de page avec copyrigth
 * @author tophe
 * @version 1.0
 *
 */
public class PiedPage extends JPanel {

	public PiedPage() {
		super();
		setBackground(Constante.couleurPiedPage);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel copyrigth = new JLabel("@helios");
		copyrigth.setForeground(Color.white);
		copyrigth.setFont(Constante.copyrightFont);
		add(copyrigth);
	}
	
}
