package Noticias;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCarga cargando = new PantallaCarga();
					cargando.setVisible(true);
					 new Thread(new Runnable() {
	                        @Override
	                        public void run() {
	                            cargarPrograma(cargando);
	                        }
	                    }).start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void cargarPrograma(PantallaCarga cargando) {
			
				 try {
			            //SEGUNDO 1
			            cargando.actualizarProgreso(20 ,"Iniciando sistema...");
			            Thread.sleep(1000); 

			            //SEGUNDO 2
			            cargando.actualizarProgreso(40, "Cargando configuraciones...");
			            Thread.sleep(1000);

			            //SEGUNDO 3
			            cargando.actualizarProgreso(60, "Verificando conexión a base de datos...");
			            Thread.sleep(1000);

			            //SEGUNDO 4: Comprobar todo
			            cargando.actualizarProgreso(80, "Comprobando archivo de usuarios...");
			            
			            boolean usuariosOk = GestionUsuarios.inicializarUsuarios();
			            
			            Thread.sleep(1000);

			            if (!usuariosOk) {
			                cargando.actualizarProgreso(0, "");
			                JOptionPane.showMessageDialog(null, "Carga Fallida", "error", 0);
			            	System.exit(0);
			            }

			            //SEGUNDO 5
			            cargando.actualizarProgreso(100, "Finalizando carga...");
			            Thread.sleep(1000);

			            EventQueue.invokeLater(() -> {
			                cargando.setVisible(false);
			                cargando.dispose();
			                
			                Pantalla window = new Pantalla();
			                window.setVisible(true);
			            });

			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
			}
		});
	}

}
