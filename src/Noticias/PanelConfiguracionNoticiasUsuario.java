package Noticias;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class PanelConfiguracionNoticiasUsuario extends JPanel {
	private Usuario usuarioActual;

	private JPanel headerPanel;
	private JLabel labelTitulo;
	private JButton botonPerfil;
	private JLabel labelUsuario;
	private JLabel labelRol;
	private ImageIcon imagenPerfil;
	private JPanel panelSalirYAcerca;
	private JButton botonCerrarAplicacion;
	private JButton botonCerrarSesion;
	private JTextArea textoAcercaDe;
	private JSeparator separador;

	private JRadioButton radioEconomia;
	private JRadioButton radioDeportes;
	private JRadioButton radioNacional;
	private JRadioButton radioInternacional;
	private JRadioButton radioVideojuegos;
	private JRadioButton radioPolitica;
	private JButton botonSeleccionarNoticias;

	private Color colorFondo = new Color(237, 242, 247);
	private Color colorTextoOscuro = new Color(45, 55, 72);
	private Color colorAzulAccion = new Color(66, 153, 225);
	private JButton botonAcercaDe;

	public PanelConfiguracionNoticiasUsuario(Pantalla mainFrame) {

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
		labelTitulo = new JLabel("Configración Noticias");
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelTitulo.setForeground(colorTextoOscuro);
		labelTitulo.setBounds(30, 20, 300, 40);
		headerPanel.add(labelTitulo);

		// Rol
		labelRol = new JLabel("Usuario");
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
		panelSalirYAcerca.setBounds(510, 82, 160, 110);
		panelSalirYAcerca.setLayout(null);
		panelSalirYAcerca.setBackground(Color.WHITE);
		panelSalirYAcerca.setBorder(new LineBorder(new Color(200, 200, 200), 1));
		add(panelSalirYAcerca);
		panelSalirYAcerca.setVisible(false);
		
		botonCerrarAplicacion = new JButton("Cerrar Aplicación");
		botonCerrarAplicacion.setBounds(1, 1, 158, 35);
		botonCerrarAplicacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCerrarAplicacion.setForeground(new Color(180, 40, 40)); 
		botonCerrarAplicacion.setBackground(Color.WHITE);
		botonCerrarAplicacion.setBorderPainted(false);
		botonCerrarAplicacion.setFocusPainted(false);
		botonCerrarAplicacion.setHorizontalAlignment(SwingConstants.LEFT);
		botonCerrarAplicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panelSalirYAcerca.add(botonCerrarAplicacion);

		botonCerrarSesion = new JButton("Cerrar sesión");
		botonCerrarSesion.setBounds(1, 36, 158, 35);
		botonCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonCerrarSesion.setForeground(new Color(45, 55, 72));
		botonCerrarSesion.setBackground(Color.WHITE);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setFocusPainted(false);
		botonCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		botonCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelSalirYAcerca.add(botonCerrarSesion);

		botonAcercaDe = new JButton("Acerca de");
		botonAcercaDe.setBounds(1, 71, 158, 35);
		botonAcercaDe.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		botonAcercaDe.setForeground(new Color(45, 55, 72));
		botonAcercaDe.setBackground(Color.WHITE);
		botonAcercaDe.setBorderPainted(false);
		botonAcercaDe.setFocusPainted(false);
		botonAcercaDe.setHorizontalAlignment(SwingConstants.LEFT);
		botonAcercaDe.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelSalirYAcerca.add(botonAcercaDe);

		separador = new JSeparator();
		separador.setBounds(10, 110, 140, 2);
		separador.setForeground(new Color(230, 230, 230));
		separador.setVisible(false);
		panelSalirYAcerca.add(separador);

		textoAcercaDe = new JTextArea("Versión 1.0\n\nDesarrollador:\nMiguel Monteagudo");
		textoAcercaDe.setBounds(10, 120, 140, 90);
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
					panelSalirYAcerca.setSize(160, 110);
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

		botonAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean mostrar = !textoAcercaDe.isVisible();
				textoAcercaDe.setVisible(mostrar);
				separador.setVisible(mostrar);
				if (mostrar) {
					panelSalirYAcerca.setSize(160, 200);
				} else {
					panelSalirYAcerca.setSize(160, 110);
				}
			}
		});

		radioEconomia = new JRadioButton("Economía");
		radioEconomia.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioEconomia.setBounds(250, 215, 200, 30);
		add(radioEconomia);

		radioDeportes = new JRadioButton("Deportes");
		radioDeportes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioDeportes.setBounds(250, 265, 200, 30);
		add(radioDeportes);

		radioNacional = new JRadioButton("Nacionales");
		radioNacional.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioNacional.setBounds(250, 315, 200, 30);
		add(radioNacional);

		radioVideojuegos = new JRadioButton("Videojuegos");
		radioVideojuegos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioVideojuegos.setBounds(250, 365, 200, 30);
		add(radioVideojuegos);

		radioPolitica = new JRadioButton("Política");
		radioPolitica.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioPolitica.setBounds(250, 415, 200, 30);
		add(radioPolitica);

		radioInternacional = new JRadioButton("Internacionales");
		radioInternacional.setFont(new Font("Segoe UI", Font.BOLD, 14));
		radioInternacional.setBounds(250, 465, 200, 30);
		add(radioInternacional);

		botonSeleccionarNoticias = new JButton("Seleccionar Noticias");
		botonSeleccionarNoticias.setBounds(200, 117, 300, 40);
		botonSeleccionarNoticias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonSeleccionarNoticias.setBackground(new Color(66, 153, 225));
		botonSeleccionarNoticias.setForeground(Color.WHITE);
		botonSeleccionarNoticias.setFocusPainted(false);
		botonSeleccionarNoticias.setBorderPainted(false);
		botonSeleccionarNoticias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(botonSeleccionarNoticias);
		botonSeleccionarNoticias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ecomonia = radioEconomia.isSelected();
				boolean deportes = radioDeportes.isSelected();
				boolean nacional = radioNacional.isSelected();
				boolean internacional = radioInternacional.isSelected();
				boolean videojuegos = radioVideojuegos.isSelected();
				boolean politica = radioPolitica.isSelected();
				BuscarNoticias.seleccionarNoticias(usuarioActual, ecomonia, deportes, nacional, internacional,
						videojuegos, politica);
				mainFrame.mostrarPanelUsuario(usuarioActual);
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
