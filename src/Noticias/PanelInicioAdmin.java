package Noticias;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

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
	private JPanel panelSalirYAcerca;
	private JButton botonCerrarSesion;
	private JTextArea textoAcercaDe;
	private JSeparator separador;

	private JButton botonConfiguracionUsuario;
	private JButton botonVerNoticias;
	private JButton botonHoraAutomatica;

	private Color colorFondo = new Color(237, 242, 247);
	private Color colorTextoOscuro = new Color(45, 55, 72);
	private Color colorAzulAccion = new Color(66, 153, 225);
	private JButton botonAcercaDe;

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

		panelSalirYAcerca = new JPanel();
		panelSalirYAcerca.setBounds(510, 82, 160, 75);
		panelSalirYAcerca.setLayout(null);
		panelSalirYAcerca.setBackground(Color.WHITE);
		panelSalirYAcerca.setBorder(new LineBorder(new Color(200, 200, 200), 1));
		add(panelSalirYAcerca);
		panelSalirYAcerca.setVisible(false);

		botonCerrarSesion = new JButton("Cerrar sesión");
		botonCerrarSesion.setBounds(1, 1, 158, 35);
		botonCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCerrarSesion.setForeground(new Color(45, 55, 72));
		botonCerrarSesion.setBackground(Color.WHITE);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setFocusPainted(false);
		botonCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		botonCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelSalirYAcerca.add(botonCerrarSesion);

		botonAcercaDe = new JButton("Acerca de");
		botonAcercaDe.setBounds(1, 36, 158, 35);
		botonAcercaDe.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonAcercaDe.setForeground(new Color(45, 55, 72));
		botonAcercaDe.setBackground(Color.WHITE);
		botonAcercaDe.setBorderPainted(false);
		botonAcercaDe.setFocusPainted(false);
		botonAcercaDe.setHorizontalAlignment(SwingConstants.LEFT);
		botonAcercaDe.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelSalirYAcerca.add(botonAcercaDe);

		separador = new JSeparator();
		separador.setBounds(10, 75, 140, 2);
		separador.setForeground(new Color(230, 230, 230));
		separador.setVisible(false);
		panelSalirYAcerca.add(separador);

		textoAcercaDe = new JTextArea("Versión 1.0\n\nDesarrollador:\nMiguel Monteagudo");
		textoAcercaDe.setBounds(10, 85, 140, 90);
		textoAcercaDe.setEditable(false);
		textoAcercaDe.setOpaque(false);
		textoAcercaDe.setLineWrap(true);
		textoAcercaDe.setWrapStyleWord(true);
		textoAcercaDe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textoAcercaDe.setForeground(Color.GRAY);
		textoAcercaDe.setVisible(false);
		panelSalirYAcerca.add(textoAcercaDe);

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
				boolean estado = panelSalirYAcerca.isVisible();
				panelSalirYAcerca.setVisible(!estado);
				if (estado) {
					textoAcercaDe.setVisible(false);
					separador.setVisible(false);
					panelSalirYAcerca.setSize(160, 75);
				}
			}
		});

		botonCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarInicioSesion();
			}
		});

		botonAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean mostrar = !textoAcercaDe.isVisible();
				textoAcercaDe.setVisible(mostrar);
				separador.setVisible(mostrar);
				if (mostrar) {
					panelSalirYAcerca.setSize(160, 155);
				} else {
					panelSalirYAcerca.setSize(160, 75);
				}
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