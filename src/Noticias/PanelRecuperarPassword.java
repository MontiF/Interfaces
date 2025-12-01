package Noticias;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelRecuperarPassword extends JPanel{
	private JTextField fieldUsuario;
	private JLabel labelUsuario;
	private JButton correoRecuperacion;
	
	public PanelRecuperarPassword(Pantalla mainFrame) {
		setLayout(null);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(178, 64, 46, 14);
		add(labelUsuario);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(178, 86, 86, 20);
		add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		correoRecuperacion = new JButton("Enviar Correo");
		correoRecuperacion.setBounds(178, 174, 89, 23);
		add(correoRecuperacion);
		
		correoRecuperacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = fieldUsuario.getText();
				CorreoRecuperacion.enviar(nombre);
			}
		});
		
	}
}
