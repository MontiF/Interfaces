package Noticias;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.setVisible(true);
					GestionUsuarios.comprobarArchivoUsuarios();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
