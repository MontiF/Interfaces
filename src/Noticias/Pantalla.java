package Noticias;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pantalla extends JFrame{
	
	private JPanel contentPane;
    private CardLayout cardLayout;
    
	
	public Pantalla() {
		setTitle("Noticias");
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);
		
		PanelInicioSesion panelInicio = new PanelInicioSesion(this);
		PanelInicioUsuario panelUsuario = new PanelInicioUsuario();
		PanelInicioAdmin panelAdmin = new PanelInicioAdmin();
		PanelRecuperarPassword panelPassword = new PanelRecuperarPassword(this);
		
		contentPane.add(panelInicio, "Login");
        contentPane.add(panelUsuario, "AplicacionUsuario");
        contentPane.add(panelAdmin, "AplicacionAdmin");
        contentPane.add(panelPassword, "RecuperarPassword");
        
        cardLayout.show(contentPane, "Login");
		
	}
	public void mostrarPanelUsuario() {
        cardLayout.show(contentPane, "AplicacionUsuario");
    }
	public void mostrarPanelAdmin() {
		cardLayout.show(contentPane, "AplicacionAdmin");
	}
	public void mostrarRecuperarContraseña() {
		cardLayout.show(contentPane, "RecuperarPassword");
	}
	
	
	
}
