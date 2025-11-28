package Noticias;

import java.io.Serializable;

public class Usuario implements Serializable{
	String correo;
	String nombreUsuario;
	String password;
	boolean admin;

	public Usuario(String correo, String nombreUsuario, String password, boolean admin) {
		super();
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.admin = admin;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
}
