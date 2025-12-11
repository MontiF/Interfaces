package Noticias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class BarraMenu {

	public static JMenuBar getBarraMenu(Pantalla mainFrame) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuAyuda = new JMenu("Información");

		JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
		itemAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "Versión 1.0\n\nDesarrollador:\nMiguel Monteagudo", "Acerca de",1);
			}
		});

		menuAyuda.add(itemAcercaDe);
		menuBar.add(menuAyuda);

		return menuBar;
	}
}
