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
								cargando.actualizarProgreso(20, "Iniciando sistema...");
								Thread.sleep(1000);

								cargando.actualizarProgreso(40, "Cargando configuraciones...");
								Thread.sleep(1000);

								cargando.actualizarProgreso(60, "Verificando conexión...");
								Thread.sleep(1000);

								// cargar todo, segundo 4
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
										JOptionPane.showMessageDialog(null, "Error al crear la pantalla principal:", "Error Crítico", 0);
									}
								}

								Thread.sleep(1000);

								if (!usuariosOk) {
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

										if (window != null) {
											window.setVisible(true);
										}
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