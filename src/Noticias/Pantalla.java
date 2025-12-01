package Noticias;

import java.awt.Panel;
import javax.swing.JFrame;


public class Pantalla extends JFrame{
	
	public Pantalla() {
		setTitle("Noticias");
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		getContentPane().setLayout(null);
		
		PanelInicioSesion panelInicio = new PanelInicioSesion();
		
		panelInicio.setBounds(0, 0, 700, 600);
		
		add(panelInicio);
	}
}
