package Noticias;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelInicioSesion extends JPanel {

    private JLabel labelTitulo;
    private JLabel labelUsuario;
    private JTextField usuarioField;
    private JLabel labelPassword;
    private JPasswordField passwordField;
    private JLabel errorUsuarioField;
    private JButton botonInicioSesion;
    private JButton botonCambioPassword;
    private JButton botonOcultarPassword;
    
    private ImageIcon imagenOcultar;
    private ImageIcon imagenMostrar;

    public PanelInicioSesion(Pantalla mainFrame) {
    	
        setLayout(null);
        setBackground(new Color(237, 242, 247));
        setSize(700, 600);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBounds(150, 75, 400, 450);
        
        cardPanel.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
        
        add(cardPanel);

        labelTitulo = new JLabel("Bienvenido");
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        labelTitulo.setForeground(new Color(45, 55, 72));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 30, 400, 40);
        cardPanel.add(labelTitulo);
        
        //Usuario
        labelUsuario = new JLabel("Usuario");
        labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelUsuario.setForeground(new Color(100, 100, 100));
        labelUsuario.setBounds(50, 90, 300, 20);
        cardPanel.add(labelUsuario);

        usuarioField = new JTextField();
        usuarioField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usuarioField.setBounds(50, 115, 300, 35);
        usuarioField.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(usuarioField);

        // Contraseña
        labelPassword = new JLabel("Contraseña");
        labelPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelPassword.setForeground(new Color(100, 100, 100));
        labelPassword.setBounds(50, 170, 300, 20);
        cardPanel.add(labelPassword);
        
        char caracterOculto = '•'; 
        passwordField = new JPasswordField();
        passwordField.setEchoChar(caracterOculto);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBounds(50, 195, 250, 35);
        passwordField.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(passwordField);

        // Botón (Mostrar/Ocultar)
        imagenOcultar = new ImageIcon("images/ocultar.png");
        imagenMostrar = new ImageIcon("images/mostrar.png");
        
        botonOcultarPassword = new JButton(imagenMostrar);
        botonOcultarPassword.setBounds(305, 195, 45, 35);
        botonOcultarPassword.setBackground(Color.WHITE);
        botonOcultarPassword.setBorder(null);
        botonOcultarPassword.setContentAreaFilled(false);
        botonOcultarPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        botonOcultarPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char echoActual = passwordField.getEchoChar();
                if (echoActual == (char) 0) {
                    passwordField.setEchoChar(caracterOculto);
                    botonOcultarPassword.setIcon(imagenMostrar);
                } else {
                    passwordField.setEchoChar((char) 0);
                    botonOcultarPassword.setIcon(imagenOcultar);
                }
            }
        });
        cardPanel.add(botonOcultarPassword);

        // Mensaje de Error
        errorUsuarioField = new JLabel("Usuario o contraseña incorrecta");
        errorUsuarioField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        errorUsuarioField.setBounds(0, 240, 400, 20);
        errorUsuarioField.setForeground(new Color(229, 62, 62));
        errorUsuarioField.setHorizontalAlignment(SwingConstants.CENTER);
        errorUsuarioField.setVisible(false);
        cardPanel.add(errorUsuarioField);

        // Botón Iniciar Sesión
        botonInicioSesion = new JButton("INICIAR SESIÓN");
        botonInicioSesion.setBounds(50, 270, 300, 40);
        botonInicioSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonInicioSesion.setBackground(new Color(66, 153, 225));
        botonInicioSesion.setForeground(Color.WHITE);
        botonInicioSesion.setFocusPainted(false);
        botonInicioSesion.setBorderPainted(false); 
        botonInicioSesion.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

        botonInicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String password = new String(passwordField.getPassword());
                
                if(GestionUsuarios.comprobarUsuarioYContraseña(usuario, password)) {
                	usuarioField.setText("");
                	passwordField.setText("");
                    Usuario usuarioIniciado = GestionUsuarios.obtenerUsuarioCompleto(usuario);
                	if(usuarioIniciado.getAdmin()) {
                        mainFrame.mostrarPanelAdmin(usuarioIniciado);
                    } else {
                        mainFrame.mostrarPanelUsuario(usuarioIniciado);
                    }
                } else {
                    errorUsuarioField.setVisible(true);
                }
            }
        });
        cardPanel.add(botonInicioSesion);
        
        //Recuperar contraseña
        botonCambioPassword = new JButton("¿Olvidaste tu contraseña?");
        botonCambioPassword.setBounds(50, 330, 300, 30);
        botonCambioPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        botonCambioPassword.setForeground(new Color(100, 100, 100));
        botonCambioPassword.setContentAreaFilled(false);
        botonCambioPassword.setBorderPainted(false); 
        botonCambioPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botonCambioPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.mostrarRecuperarContraseña();
            }
        });
        cardPanel.add(botonCambioPassword);
    }
}
