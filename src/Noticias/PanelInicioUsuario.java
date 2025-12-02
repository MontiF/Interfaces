package Noticias;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelInicioUsuario extends JPanel{
	private Usuario usuarioActual;
	
	public PanelInicioUsuario() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(150, 105, 164, 63);
		add(lblNewLabel);
		
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioActual = usuario;
	}
}
