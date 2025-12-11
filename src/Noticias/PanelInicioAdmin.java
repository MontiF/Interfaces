package Noticias;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelInicioAdmin extends JPanel {
	private Usuario usuarioActual;

	private JPanel headerPanel;
	private JLabel labelTitulo;
	private JButton botonPerfil;
	private JLabel labelUsuario;
	private JLabel labelRol;
	private ImageIcon imagenPerfil;
	private JPanel panelSalir;
	private JButton botonCerrarAplicacion;
	private JButton botonCerrarSesion;

	private JButton botonConfiguracionUsuario;
	private JButton botonVerNoticias;
	private JButton botonHoraAutomatica;

	private Color colorFondo = new Color(237, 242, 247);
	private Color colorTextoOscuro = new Color(45, 55, 72);
	private Color colorAzulAccion = new Color(66, 153, 225);

	public PanelInicioAdmin(Pantalla mainFrame) {
		setLayout(null);
		setBackground(colorFondo);
		setSize(700, 600);

		headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setBounds(0, 0, 700, 80);
		headerPanel.setBorder(new LineBorder(new Color(220, 220, 220), 1));
		add(headerPanel);

		// Titulo
		labelTitulo = new JLabel("Panel de Administración");
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelTitulo.setForeground(colorTextoOscuro);
		labelTitulo.setBounds(30, 20, 300, 40);
		headerPanel.add(labelTitulo);

		// Rol
		labelRol = new JLabel("Administrador");
		labelRol.setFont(new Font("Segoe UI", Font.BOLD, 12));
		labelRol.setForeground(colorAzulAccion);
		labelRol.setHorizontalAlignment(SwingConstants.RIGHT);
		labelRol.setBounds(480, 20, 120, 20);
		headerPanel.add(labelRol);

		// Nombre Usuario
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		labelUsuario.setForeground(Color.GRAY);
		labelUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		labelUsuario.setBounds(430, 40, 170, 20);
		headerPanel.add(labelUsuario);

		// Botón de foto de perfil, para cerrar sesión

		panelSalir = new JPanel();
		panelSalir.setBounds(510, 82, 160, 72);
		panelSalir.setLayout(null);
		panelSalir.setBackground(Color.WHITE);
		panelSalir.setBorder(new LineBorder(new Color(200, 200, 200), 1));
		add(panelSalir);
		panelSalir.setVisible(false);
		
		botonCerrarAplicacion = new JButton("Cerrar Aplicación");
		botonCerrarAplicacion.setBounds(1, 1, 158, 35);
		botonCerrarAplicacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCerrarAplicacion.setForeground(new Color(180, 40, 40)); 
		botonCerrarAplicacion.setBackground(Color.WHITE);
		botonCerrarAplicacion.setBorderPainted(false);
		botonCerrarAplicacion.setFocusPainted(false);
		botonCerrarAplicacion.setHorizontalAlignment(SwingConstants.LEFT);
		botonCerrarAplicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panelSalir.add(botonCerrarAplicacion);

		botonCerrarSesion = new JButton("Cerrar sesión");
		botonCerrarSesion.setBounds(1, 36, 158, 35);
		botonCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCerrarSesion.setForeground(new Color(45, 55, 72));
		botonCerrarSesion.setBackground(Color.WHITE);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setFocusPainted(false);
		botonCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		botonCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelSalir.add(botonCerrarSesion);

		imagenPerfil = new ImageIcon("images/perfil.png");
		botonPerfil = new JButton(imagenPerfil);
		botonPerfil.setBounds(610, 15, 50, 50);
		botonPerfil.setBorder(null);
		botonPerfil.setContentAreaFilled(false);
		botonPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		headerPanel.add(botonPerfil);

		botonPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean estado = panelSalir.isVisible();
				panelSalir.setVisible(!estado);
				if (estado) {
					panelSalir.setSize(160, 72);
				}
			}
		});
		
		botonCerrarAplicacion.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
	            }
			}
		});
		
		botonCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarInicioSesion();
			}
		});

		// Configurar Usuario
		botonConfiguracionUsuario = new JButton("Configurar Usuarios");
		botonConfiguracionUsuario.setBounds(70, 260, 160, 120);
		botonConfiguracionUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonConfiguracionUsuario.setForeground(new Color(45, 55, 72));
		botonConfiguracionUsuario.setBackground(Color.WHITE);
		botonConfiguracionUsuario.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonConfiguracionUsuario.setFocusPainted(false);
		botonConfiguracionUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonConfiguracionUsuario);

		botonConfiguracionUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarGestionUsuarios(usuarioActual);
			}
		});

		// Ver noticias
		botonVerNoticias = new JButton("Ver Noticias");
		botonVerNoticias.setBounds(270, 260, 160, 120);
		botonVerNoticias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonVerNoticias.setForeground(new Color(45, 55, 72));
		botonVerNoticias.setBackground(Color.WHITE);
		botonVerNoticias.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonVerNoticias.setFocusPainted(false);
		botonVerNoticias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonVerNoticias);
		botonVerNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarTodasNoticias(usuarioActual);
			}
		});

		// Hora Automatica
		botonHoraAutomatica = new JButton("Consultar Hora");
		botonHoraAutomatica.setBounds(470, 260, 160, 120);
		botonHoraAutomatica.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonHoraAutomatica.setForeground(new Color(45, 55, 72));
		botonHoraAutomatica.setBackground(Color.WHITE);
		botonHoraAutomatica.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonHoraAutomatica.setFocusPainted(false);
		botonHoraAutomatica.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonHoraAutomatica);
		botonHoraAutomatica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, HoraAutomatica.leerHora() +":00", "Hora Automatica", 1);
			}
		});

	}

	public void setUsuario(Usuario usuario) {
		this.usuarioActual = usuario;

		if (usuario != null) {
			labelUsuario.setText(usuario.getNombreUsuario());
		}
	}
}