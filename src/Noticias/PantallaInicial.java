package Noticias;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PantallaInicial {

	private JFrame frame;
	private JTextField usuarioField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial window = new PantallaInicial();
					window.frame.setVisible(true);
					GestionUsuarios.comprobarArchivoUsuarios();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Usuario
		JLabel labelUsuario = new JLabel("Usuario\r\n");
		labelUsuario.setBounds(171, 26, 46, 14);
		frame.getContentPane().add(labelUsuario);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(171, 39, 110, 20);
		frame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		//Contraseña 
		ImageIcon imagenOcultar = new ImageIcon("ocultar.png");
		JButton botonOcultarPassword = new JButton(imagenOcultar);
		botonOcultarPassword.setBounds(294, 86, 46, 23);
		frame.getContentPane().add(botonOcultarPassword);
		
		JLabel labelPassword = new JLabel("Contraseña\r\n");
		labelPassword.setBounds(171, 77, 75, 14);
		frame.getContentPane().add(labelPassword);
		
		char caracterOculto = '*'; 
		JPasswordField passwordField = new JPasswordField(caracterOculto);
		passwordField.setBounds(171, 89, 110, 20); 
		frame.getContentPane().add(passwordField);
		
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
		
		JButton botonInicioSesion = new JButton("Iniciar Sesión");
		botonInicioSesion.setBounds(171, 144, 110, 23);
		frame.getContentPane().add(botonInicioSesion);
		
		botonInicioSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = usuarioField.getText();
				String password = new String(passwordField.getPassword());
				if(GestionUsuarios.comprobarUsuarioYContraseña(usuario, password) == true) {
					System.out.println("Felicidades");
				}else {
					System.out.println("Tonto");
				}
				
			}
		});
		
		//recuperar contraseña
		JButton botonCambioPassword = new JButton("He olvidado mi contraseña\r\n");
		botonCambioPassword.setBounds(134, 227, 184, 23);
		frame.getContentPane().add(botonCambioPassword);
		
	}
}
