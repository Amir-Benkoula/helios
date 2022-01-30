package ihm.composant;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import util.Constante;
/**
 * Composant graphique table
 * @author tophe
 * @version 1.0
 *
 */
public class MonJTable extends JTable {

	public MonJTable(TableModel dm) {
		super(dm);
		getTableHeader().setBackground(Constante.couleurEnteteTableau);
		getTableHeader().setFont(Constante.titreTabFont);
		setFont(Constante.texteFont);
		setRowHeight(30);
	}

}
