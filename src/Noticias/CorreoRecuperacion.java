package Noticias;

public class CorreoRecuperacion {
	public static void enviar(String nombreUsuario) {
		String correo = GestionUsuarios.obtenerCorreo(nombreUsuario);
		if(correo == null) {
			System.out.println("Usuario no encontrado");
		}else {
			String passwordUsuario = GestionUsuarios.obtenerPassword(nombreUsuario);
			EmailEnviar.EmailRecuperacion(correo, passwordUsuario);
		}
		
	}
}
