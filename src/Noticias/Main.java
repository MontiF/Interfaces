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
					cargando.setVisible(true);

					new Thread(new Runnable() {

						Pantalla window = null;

						@Override
						public void run() {
							try {
								// SEGUNDO 1
								cargando.actualizarProgreso(20, "Iniciando sistema...");
								Thread.sleep(1000);

								// SEGUNDO 2
								cargando.actualizarProgreso(40, "Cargando configuraciones...");
								Thread.sleep(1000);

								// SEGUNDO 3
								cargando.actualizarProgreso(60, "Verificando conexión...");
								Thread.sleep(1000);

								// SEGUNDO 4: Cargar todo
								cargando.actualizarProgreso(80, "Comprobando usuarios y generando interfaz...");

								boolean usuariosOk = GestionUsuarios.inicializarUsuarios();

								if (usuariosOk) {
									try {
										EventQueue.invokeAndWait(new Runnable() {
											public void run() {
												window = new Pantalla();
											}
										});
									} catch (InvocationTargetException | InterruptedException e) {
										e.printStackTrace();
									}
								}

								Thread.sleep(1000);

								if (!usuariosOk) {
									cargando.actualizarProgreso(0, "");
									JOptionPane.showMessageDialog(null, "Carga Fallida", "error", 0);
									System.exit(0);
								}

								// SEGUNDO 5
								cargando.actualizarProgreso(100, "Finalizando carga...");
								Thread.sleep(1000);

								EventQueue.invokeLater(new Runnable() {
									public void run() {
										cargando.setVisible(false);
										cargando.dispose();

										if (window != null) {
											window.setVisible(true);
										}
									}
								});

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}).start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}