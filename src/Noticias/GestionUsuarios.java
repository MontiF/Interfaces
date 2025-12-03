package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class GestionUsuarios {

private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();	

	public static boolean comprobarUsuarioYContraseña(String usuario, String password) {
		for (Usuario e : listaUsuarios) {
			if (e.getNombreUsuario().equals(usuario) && e.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	public static boolean esAdmin(String usuario) {
		for (Usuario u : listaUsuarios) {
	        if (u.getNombreUsuario().equals(usuario)) {
	            return u.getAdmin();
	        }
	    }
			return false;
	}
	
	public static boolean existeUsuarios(String nombre) {
		for (Usuario u : listaUsuarios) {
	        if (u.getNombreUsuario().equals(nombre)) {
	            return true;
	        }
	    }
		return false;
	}
	
	public static boolean inicializarUsuarios(){
		File usuariosTXT = new File("datos/usuarios.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(usuariosTXT))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {

            	if (linea.trim().isEmpty()) {
                    System.out.println("Ignorada: Línea vacía.");
                    continue;
                }
            	
                String[] datos = linea.split(";");

                if (datos.length == 4) {
                    String email = datos[0].trim();
                    String nombre = datos[1].trim();
                    String password = datos[2].trim();
                    boolean admin = Boolean.parseBoolean(datos[3].trim());

                    Usuario nuevoUsuario = new Usuario(email, nombre, password, admin);
                    listaUsuarios.add(nuevoUsuario);
                }
            }
            return true;
        } catch (IOException e) {
        	return false;
        }
	}
	
	public static String obtenerCorreo(String nombreUsuario) {
		for (Usuario u : listaUsuarios) {
	        if (u.getNombreUsuario().equals(nombreUsuario)) {
	            return u.getCorreo();
	        }
	    }
		return null;
	}
	
	public static String obtenerPassword(String nombreUsuario) {
		for (Usuario u : listaUsuarios) {
	        if (u.getNombreUsuario().equals(nombreUsuario)) {
	            return u.getPassword();
	        }
	    }
		return null;
	}
	public static Usuario obtenerUsuarioCompleto(String nombre) {
		for (Usuario u : listaUsuarios) {
	        if (u.getNombreUsuario().equals(nombre)) {
	            return u;
	        }
	    }
		return null;
	}
	public static Usuario obtenerUsuarioCompletoCorreo(String correo) {
		for (Usuario u : listaUsuarios) {
	        if (u.getCorreo().equals(correo)) {
	            return u;
	        }
	    }
		return null;
	}

	public static void borrarUsuarios(Usuario usuarioActual) {
		String nombreUsuario = JOptionPane.showInputDialog(null, "Introduce el nombre del Usuario a borrar");
		if (null==nombreUsuario){
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "error" , 0);
			return;
		}
		if(nombreUsuario.equals(usuarioActual.getNombreUsuario())) {
			JOptionPane.showMessageDialog(null, "No te puedes borrar a ti mismo", "error" , 0);
			return;
		}else if(nombreUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un nombre", "error" , 0);
			return;
		}
		Usuario usuarioBorrar = obtenerUsuarioCompleto(nombreUsuario);
		if (usuarioBorrar == null) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", "error" , 0);
			return;
		}
		borrarUsuario();
	}
	private static void borrarUsuario() {
		
		JOptionPane.showMessageDialog(null, "Usuario borrado", "confirmación" , 0);
	}
	public static void agregarUsuarios() {
		String nombreUsuario = JOptionPane.showInputDialog(null, "Introduce el nombre del Usuario a crear");
		if (null==nombreUsuario){
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "error" , 0);
			return;
		}
		if(nombreUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un nombre", "error" , 0);
			return;
		}
		Usuario usuarioAgregar = obtenerUsuarioCompleto(nombreUsuario);
		if(usuarioAgregar != null) {
			JOptionPane.showMessageDialog(null, "Usuario ya existente", "error", 0);
			return;
		}
		
		String correo = JOptionPane.showInputDialog(null, "Introduce el correo del usuario");
		if (null==correo){
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "error" , 0);
			return;
		}
		if(correo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Introduce un correo", "error" , 0);
			return;
		}
		usuarioAgregar = obtenerUsuarioCompletoCorreo(correo);
		if(usuarioAgregar !=null) {
			JOptionPane.showMessageDialog(null, "Correo ya vinculado", "error", 0);
			return;
		}
		String password = JOptionPane.showInputDialog(null, "Introduce una contraseña");
		if (null==password){
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "error" , 0);
			return;
		}
		String esAdminStri = JOptionPane.showInputDialog(null, "¿Es Admin? (true/false)");
		esAdminStri.toLowerCase();
		if (null==esAdminStri){
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "error" , 0);
			return;
		}
		if(esAdminStri != "false" || esAdminStri != "true") {
			JOptionPane.showConfirmDialog(null, "El dato debe ser true o false");
		}
		boolean esAdminBool;
		if(esAdminStri == "true") {
			esAdminBool = true;
		}else {
			esAdminBool = false;
		}
		agregarUsuario(nombreUsuario, correo, password, esAdminBool);
	}
	
	private static void agregarUsuario(String nombreUsuario, String correo, String password, boolean esAdminBool) {
		File usuariosTXT = new File("datos/usuarios.txt");
		try (FileWriter fw = new FileWriter(usuariosTXT)) {
			fw.write(correo + ";" + nombreUsuario + ";" + password + ";" +esAdminBool);
		} catch (IOException e) {
		}
	}
}

