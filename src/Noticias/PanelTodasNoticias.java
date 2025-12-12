package Noticias;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelTodasNoticias extends JPanel {
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

	private JButton botonEnviarNoticias;
	private JButton botonEconomia;
	private JButton botonDeportes;
	private JButton botonNacional;
	private JButton botonInternacional;
	private JButton botonVideojuegos;
	private JButton botonPolitica;

	private JButton botonVolver;

	private Color colorFondo = new Color(237, 242, 247);
	private Color colorTextoOscuro = new Color(45, 55, 72);
	private Color colorAzulAccion = new Color(66, 153, 225);

	public PanelTodasNoticias(Pantalla mainFrame) {
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
		labelTitulo = new JLabel("Panel de Noticias");
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
				if (JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?", "Confirmación",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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

		// Boton enviar noticias

		botonEnviarNoticias = new JButton("Enviar Noticias");
		botonEnviarNoticias.setBounds(200, 117, 300, 40);
		botonEnviarNoticias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonEnviarNoticias.setBackground(new Color(66, 153, 225));
		botonEnviarNoticias.setForeground(Color.WHITE);
		botonEnviarNoticias.setFocusPainted(false);
		botonEnviarNoticias.setBorderPainted(false);
		botonEnviarNoticias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonEnviarNoticias);
		botonEnviarNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EnviarNoticias.enviarTodasNoticias(usuarioActual);
			}
		});

		// Noticias economia
		botonEconomia = new JButton("Economia");
		botonEconomia.setBounds(70, 218, 160, 120);
		botonEconomia.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonEconomia.setForeground(new Color(45, 55, 72));
		botonEconomia.setBackground(Color.WHITE);
		botonEconomia.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonEconomia.setFocusPainted(false);
		botonEconomia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonEconomia);
		botonEconomia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasEconomia(usuarioActual);
			}
		});

		// noticias deportes
		botonDeportes = new JButton("Deportes");
		botonDeportes.setBounds(270, 369, 160, 120);
		botonDeportes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonDeportes.setForeground(new Color(45, 55, 72));
		botonDeportes.setBackground(Color.WHITE);
		botonDeportes.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonDeportes.setFocusPainted(false);
		botonDeportes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonDeportes);
		botonDeportes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasDeportes(usuarioActual);
			}
		});

		// noticias nacionales
		botonNacional = new JButton("Nacionales");
		botonNacional.setBounds(470, 369, 160, 120);
		botonNacional.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonNacional.setForeground(new Color(45, 55, 72));
		botonNacional.setBackground(Color.WHITE);
		botonNacional.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonNacional.setFocusPainted(false);
		botonNacional.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonNacional);
		botonNacional.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasNacional(usuarioActual);
			}
		});

		// Noticias internacional
		botonInternacional = new JButton("Internacionales");
		botonInternacional.setBounds(70, 369, 160, 120);
		botonInternacional.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonInternacional.setForeground(new Color(45, 55, 72));
		botonInternacional.setBackground(Color.WHITE);
		botonInternacional.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonInternacional.setFocusPainted(false);
		botonInternacional.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonInternacional);
		botonInternacional.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasInteracional(usuarioActual);
			}
		});

		// noticias videojuegos
		botonVideojuegos = new JButton("Videojuegos");
		botonVideojuegos.setBounds(270, 218, 160, 120);
		botonVideojuegos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonVideojuegos.setForeground(new Color(45, 55, 72));
		botonVideojuegos.setBackground(Color.WHITE);
		botonVideojuegos.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonVideojuegos.setFocusPainted(false);
		botonVideojuegos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonVideojuegos);
		botonVideojuegos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasVideojuegos(usuarioActual);
			}
		});

		// noticias politica
		botonPolitica = new JButton("Politica");
		botonPolitica.setBounds(470, 218, 160, 120);
		botonPolitica.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonPolitica.setForeground(new Color(45, 55, 72));
		botonPolitica.setBackground(Color.WHITE);
		botonPolitica.setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
		botonPolitica.setFocusPainted(false);
		botonPolitica.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonPolitica);
		botonPolitica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelNoticiasPolitica(usuarioActual);
			}
		});

		// volver al menu
		botonVolver = new JButton("Volver al Menú Principal");
		botonVolver.setBounds(470, 490, 200, 30);
		botonVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonVolver.setForeground(new Color(100, 100, 100));
		botonVolver.setContentAreaFilled(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.mostrarPanelAdmin(usuarioActual);
			}
		});
		add(botonVolver);

	}

	public void setUsuario(Usuario usuario) {
		this.usuarioActual = usuario;

		if (usuario != null) {
			labelUsuario.setText(usuario.getNombreUsuario());
		}
	}
}
