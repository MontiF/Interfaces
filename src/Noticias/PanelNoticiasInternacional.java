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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelNoticiasInternacional extends JPanel {
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

	private JLabel webNoticia1;
	private JLabel webNoticia2;
	private JLabel webNoticia3;
	private JTextArea noticia1;
	private JTextArea noticia2;
	private JTextArea noticia3;

	private JButton botonVolver;

	private Color colorFondo = new Color(237, 242, 247);
	private Color colorTextoOscuro = new Color(45, 55, 72);
	private Color colorAzulAccion = new Color(66, 153, 225);

	public PanelNoticiasInternacional(Pantalla mainFrame) {
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
		labelTitulo = new JLabel("Noticias Internacionales");
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		labelTitulo.setForeground(colorTextoOscuro);
		labelTitulo.setBounds(30, 20, 300, 40);
		headerPanel.add(labelTitulo);

		// Rol
		labelRol = new JLabel("Rol");
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

		// volver
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(470, 490, 200, 30);
		botonVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botonVolver.setForeground(new Color(100, 100, 100));
		botonVolver.setContentAreaFilled(false);
		botonVolver.setBorderPainted(false);
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (usuarioActual.getAdmin() == true) {
					mainFrame.mostrarTodasNoticias(usuarioActual);
				} else {
					mainFrame.mostrarPanelUsuario(usuarioActual);
				}
			}
		});
		add(botonVolver);

		// 1 noticia
		webNoticia1 = new JLabel("Epochtimes");
		webNoticia1.setBounds(10, 123, 160, 34);
		webNoticia1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		add(webNoticia1);
		noticia1 = new JTextArea(BuscarNoticias.noticia1Internacional());
		noticia1.setLineWrap(true);
		noticia1.setEditable(false);
		noticia1.setWrapStyleWord(true);
		noticia1.setBounds(10, 154, 660, 148);
		noticia1.setOpaque(false);
		noticia1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		add(noticia1);

		// 2 noticia
		webNoticia2 = new JLabel("BBC");
		webNoticia2.setBounds(10, 245, 160, 34);
		webNoticia2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		add(webNoticia2);
		noticia2 = new JTextArea(BuscarNoticias.noticia2Internacional());
		noticia2.setLineWrap(true);
		noticia2.setEditable(false);
		noticia2.setWrapStyleWord(true);
		noticia2.setBounds(10, 272, 660, 94);
		noticia2.setOpaque(false);
		noticia2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		add(noticia2);

		// 3 noticia
		webNoticia3 = new JLabel("Europappress");
		webNoticia3.setBounds(10, 356, 160, 34);
		webNoticia3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		add(webNoticia3);
		noticia3 = new JTextArea(BuscarNoticias.noticia3Internacional());
		noticia3.setLineWrap(true);
		noticia3.setEditable(false);
		noticia3.setWrapStyleWord(true);
		noticia3.setBounds(10, 388, 660, 123);
		noticia3.setOpaque(false);
		noticia3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		add(noticia3);

	}

	public void setUsuario(Usuario usuario) {
		this.usuarioActual = usuario;

		if (usuario != null) {
			labelUsuario.setText(usuario.getNombreUsuario());
			if (usuario.getAdmin() == true) {
				labelRol.setText("Administrador");
			} else {
				labelRol.setText("Usuario");
			}
		}

	}
}
