package Noticias;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelInicioSesion extends JPanel{
	JLabel labelUsuario;
	JTextField usuarioField;
	ImageIcon imagenOcultar;
	JLabel labelPassword;
	JPasswordField passwordField;
	JLabel errorUsuarioField;
	JButton botonInicioSesion;
	JButton botonCambioPassword;
	
	public PanelInicioSesion() {
		
		//Usuario
				labelUsuario = new JLabel("Usuario\r\n");
				labelUsuario.setBounds(287, 200, 86, 23);
				usuarioField = new JTextField();
				usuarioField.setBounds(287, 216, 86, 20);
				usuarioField.setColumns(10);
				
				//Contraseña 
				imagenOcultar = new ImageIcon("ocultar.png");
				JButton botonOcultarPassword = new JButton(imagenOcultar);
				botonOcultarPassword.setBounds(385, 261, 36, 20);
				
				labelPassword = new JLabel("Contraseña\r\n");
				labelPassword.setBounds(287, 247, 86, 14);
				
				char caracterOculto = '*'; 
				passwordField = new JPasswordField(caracterOculto);
				passwordField.setBounds(287, 261, 86, 20);
				
				errorUsuarioField = new JLabel("Usuario o contraseña incorrecta");
				errorUsuarioField.setBounds(226, 327, 251, 14);
				errorUsuarioField.setForeground(new Color(255, 0, 0));
				errorUsuarioField.setHorizontalAlignment(SwingConstants.CENTER);
				errorUsuarioField.setVisible(false);
				
				botonOcultarPassword.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        char echoActual = passwordField.getEchoChar();

				        if (echoActual == (char) 0) {
				            passwordField.setEchoChar(caracterOculto);
				        } else {
				            passwordField.setEchoChar((char) 0);
				        }
				    }
				});
				
				// iniciar sesión
				
				botonInicioSesion = new JButton("Iniciar Sesión");
				botonInicioSesion.setBounds(268, 352, 153, 23);
				botonInicioSesion.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String usuario = usuarioField.getText();
						String password = new String(passwordField.getPassword());
						if(GestionUsuarios.comprobarUsuarioYContraseña(usuario, password) == true) {
							System.out.println("Felicidades");
						}else {
							errorUsuarioField.setVisible(true);
						}
						
					}
				});
				
				//recuperar contraseña
				botonCambioPassword = new JButton("He olvidado mi contraseña\r\n");
				botonCambioPassword.setBounds(226, 386, 251, 23);
				setLayout(null);
				add(usuarioField);
				add(labelUsuario);
				add(labelPassword);
				add(passwordField);
				add(botonOcultarPassword);
				add(errorUsuarioField);
				add(botonInicioSesion);
				add(botonCambioPassword);
	}
}
