package Noticias;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Pantalla extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;

	private PanelInicioSesion panelInicio;

	private PanelInicioUsuario panelUsuario;
	private PanelConfiguracionNoticiasUsuario panelConfiguracionNoticiasUsuario;
	private PanelInicioAdmin panelAdmin;

	private PanelRecuperarPassword panelPassword;
	private PanelGestionUsuario panelGestionUsuario;
	private PanelTodasNoticias panelTodasNoticias;
	private PanelNoticiasEconomia panelNoticiasEconomia;
	private PanelNoticiasDeportes panelNoticiasDeportes;
	private PanelNoticiasNacional panelNoticiasNacional;
	private PanelNoticiasInternacional panelNoticiasInternacional;
	private PanelNoticiasVideojuegos panelNoticiasVideojuegos;
	private PanelNoticiasPolitica panelNoticiasPolitica;

	public Pantalla() {
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Seguro que quiere salir?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
			}
		});
		
		ImageIcon icono = new ImageIcon("images/logo.png");
		setIconImage(icono.getImage());
		setTitle("Noticias");
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setResizable(false);

		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		setContentPane(contentPane);

		panelInicio = new PanelInicioSesion(this);

		panelUsuario = new PanelInicioUsuario(this);
		panelConfiguracionNoticiasUsuario = new PanelConfiguracionNoticiasUsuario(this);
		panelAdmin = new PanelInicioAdmin(this);
		panelPassword = new PanelRecuperarPassword(this);
		panelGestionUsuario = new PanelGestionUsuario(this);
		panelTodasNoticias = new PanelTodasNoticias(this);
		panelNoticiasEconomia = new PanelNoticiasEconomia(this);
		panelNoticiasDeportes = new PanelNoticiasDeportes(this);
		panelNoticiasNacional = new PanelNoticiasNacional(this);
		panelNoticiasInternacional = new PanelNoticiasInternacional(this);
		panelNoticiasVideojuegos = new PanelNoticiasVideojuegos(this);
		panelNoticiasPolitica = new PanelNoticiasPolitica(this);

		contentPane.add(panelInicio, "Login");
		contentPane.add(panelUsuario, "AplicacionUsuario");
		contentPane.add(panelConfiguracionNoticiasUsuario, "ConfiguracionNoticiasUsuario");
		contentPane.add(panelAdmin, "AplicacionAdmin");
		contentPane.add(panelPassword, "RecuperarPassword");
		contentPane.add(panelGestionUsuario, "ConfigurarUsuarios");
		contentPane.add(panelTodasNoticias, "TodasNoticias");
		contentPane.add(panelNoticiasEconomia, "NoticiasEconomia");
		contentPane.add(panelNoticiasDeportes, "NoticiasDeportes");
		contentPane.add(panelNoticiasNacional, "NoticiasNacional");
		contentPane.add(panelNoticiasInternacional, "NoticiasInternacional");
		contentPane.add(panelNoticiasVideojuegos, "NoticiasVideojuegos");
		contentPane.add(panelNoticiasPolitica, "NoticiasPolitica");
		
		comprobarHora();
		
	}

	private void comprobarHora() {
		Thread hilo = new Thread(() -> {
			while(true) {
				try {	
					int horaAutomatica = Integer.parseInt(HoraAutomatica.leerHora());
					LocalDateTime locaDate = LocalDateTime.now();
					int hora = locaDate.getHour();
					int minutos = locaDate.getMinute();
					if(hora == horaAutomatica && minutos == 0) {
						GestionUsuarios.enviarCorreoTodosUsuarios();
					}
					
					Thread.sleep(60000);
				}catch(InterruptedException e) {
					break;
				}catch (Exception e) {
					
				}
			}
		});
		hilo.setDaemon(true);
		hilo.start();
	}

	public void mostrarPanelUsuario(Usuario usuario) {
		panelUsuario.setUsuario(usuario);
		cardLayout.show(contentPane, "AplicacionUsuario");
	}

	public void mostrarConfiguracionUsuario(Usuario usuario) {
		panelConfiguracionNoticiasUsuario.setUsuario(usuario);
		cardLayout.show(contentPane, "ConfiguracionNoticiasUsuario");
	}

	public void mostrarPanelAdmin(Usuario usuario) {
		panelAdmin.setUsuario(usuario);
		cardLayout.show(contentPane, "AplicacionAdmin");
	}

	public void mostrarRecuperarContraseña() {
		cardLayout.show(contentPane, "RecuperarPassword");
	}

	public void mostrarInicioSesion() {
		cardLayout.show(contentPane, "Login");
	}

	public void mostrarGestionUsuarios(Usuario usuario) {
		panelGestionUsuario.setUsuario(usuario);
		cardLayout.show(contentPane, "ConfigurarUsuarios");
	}

	public void mostrarTodasNoticias(Usuario usuario) {
		panelTodasNoticias.setUsuario(usuario);
		cardLayout.show(contentPane, "TodasNoticias");
	}

	public void mostrarPanelNoticiasEconomia(Usuario usuario) {
		panelNoticiasEconomia.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasEconomia");

	}

	public void mostrarPanelNoticiasDeportes(Usuario usuario) {
		panelNoticiasDeportes.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasDeportes");
	}

	public void mostrarPanelNoticiasNacional(Usuario usuario) {
		panelNoticiasNacional.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasNacional");
	}

	public void mostrarPanelNoticiasInteracional(Usuario usuario) {
		panelNoticiasInternacional.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasInternacional");
	}

	public void mostrarPanelNoticiasVideojuegos(Usuario usuario) {
		panelNoticiasVideojuegos.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasVideojuegos");
	}

	public void mostrarPanelNoticiasPolitica(Usuario usuario) {
		panelNoticiasPolitica.setUsuario(usuario);
		cardLayout.show(contentPane, "NoticiasPolitica");
	}

}
