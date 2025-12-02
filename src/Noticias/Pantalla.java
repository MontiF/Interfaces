package Noticias;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pantalla extends JFrame{
	
	private JPanel contentPane;
    private CardLayout cardLayout;
    
    private PanelInicioSesion panelInicio;
    private PanelInicioUsuario panelUsuario;
    private PanelInicioAdmin panelAdmin; 
    private PanelRecuperarPassword panelPassword;
    private PanelGestionUsuario panelGestionUsuario;
	
	public Pantalla() {
		setTitle("Noticias");
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);
		
		panelInicio = new PanelInicioSesion(this);
		panelUsuario = new PanelInicioUsuario();
		panelAdmin = new PanelInicioAdmin(this);
		panelPassword = new PanelRecuperarPassword(this);
		panelGestionUsuario = new PanelGestionUsuario(this);
		
		contentPane.add(panelInicio, "Login");
        contentPane.add(panelUsuario, "AplicacionUsuario");
        contentPane.add(panelAdmin, "AplicacionAdmin");
        contentPane.add(panelPassword, "RecuperarPassword");
        contentPane.add(panelGestionUsuario, "ConfigurarUsuarios");
        
        cardLayout.show(contentPane, "Login");
		
	}
	public void mostrarPanelUsuario(Usuario usuario) {
		panelUsuario.setUsuario(usuario);
        cardLayout.show(contentPane, "AplicacionUsuario");
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
	public void mostrarGestionUsuarios(Usuario usuario){
		panelGestionUsuario.setUsuario(usuario);
		cardLayout.show(contentPane, "ConfigurarUsuarios");
	}
	
	
	
}
