package Noticias;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCarga cargando = new PantallaCarga();

					new Thread(new Runnable() {

						Pantalla window = null;

						@Override
						public void run() {
							window = new Pantalla();
							cargando.setVisible(true);
							try {
								cargando.actualizarProgreso(20, "Iniciando sistema...");
								Thread.sleep(1000);

								cargando.actualizarProgreso(40, "Cargando configuraciones...");
								Thread.sleep(1000);

								cargando.actualizarProgreso(60, "Verificando conexión...");
								Thread.sleep(1000);

								cargando.actualizarProgreso(80, "Comprobando usuarios y generando interfaz...");

								boolean usuariosOk = GestionUsuarios.inicializarUsuarios();

								Thread.sleep(1000);

								if (!usuariosOk || window == null) {
									cargando.actualizarProgreso(0, "");
									JOptionPane.showMessageDialog(null, "Carga Fallida", "error", 0);
									System.exit(0);
								}

								cargando.actualizarProgreso(100, "Finalizando carga...");
								Thread.sleep(1000);

								EventQueue.invokeLater(new Runnable() {
									public void run() {
										cargando.setVisible(false);
										cargando.dispose();

										window.setVisible(true);
									}
								});

							} catch (InterruptedException e) {
								JOptionPane.showMessageDialog(null, "Se ha interrumpido la carga", "Error", 0);
							}
						}
					}).start();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No se ha podido iniciar el programa", "Error", 0);
				}
			}
		});
	}
}