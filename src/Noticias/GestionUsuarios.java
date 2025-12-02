package Noticias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class GestionUsuarios {

private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();	
	
	public static boolean comprobarArchivoUsuarios(){
		File usuariosTXT = new File("datos/usuarios.txt");
			if(!usuariosTXT.exists()) {
				try {
					usuariosTXT.createNewFile();
					imprimirUsuarios(usuariosTXT);
				} catch (IOException e) {
					System.err.println("Error: " +e.getMessage());
				}

			}else if(usuariosTXT.length() <= 0){
				imprimirUsuarios(usuariosTXT);
			}else {
				inicializarUsuarios();
			}
			return true;
				
	}
	
	private static void imprimirUsuarios(File usuariosTXT) {
		
		try (FileOutputStream FicheroEscritura = new FileOutputStream(usuariosTXT);
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {
					Usuario usuario1 = new Usuario("miguelmonteagudoferia@gmail.com", "Miguel", "1234", false);
					Usuario usuario2 = new Usuario("sebastian.silva1.dosa@gmail.com", "Sebas", "4321", false);
					Usuario usuario3 = new Usuario("roberto.rodriguez.dosa@gmail.com", "Roberto", "1111", false);
					Usuario usuario4 = new Usuario("", "Admin", "admin1", true);
					
				listaUsuarios.add(usuario1);
				listaUsuarios.add(usuario2);
				listaUsuarios.add(usuario3);
				listaUsuarios.add(usuario4);
				
				escritura.writeObject(listaUsuarios); 
			
		} catch (FileNotFoundException e) {
			System.err.println("Error: " +e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
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
	
	public static void inicializarUsuarios(){
		try (FileInputStream ficheroEntrada = new FileInputStream("datos/usuarios.txt");
				ObjectInputStream entrada = new ObjectInputStream(ficheroEntrada)) {

		        	listaUsuarios = (ArrayList<Usuario>) entrada.readObject();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
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

	public static void borrarUsuarios(Usuario usuarioActual) {
		String nombreUsuario = JOptionPane.showInputDialog(null, "Introduce el nombre del Usuario a borrar");
		String nombreUsuarioActual = usuarioActual.getNombreUsuario();
		if(nombreUsuario == nombreUsuarioActual) {
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
		JOptionPane.showMessageDialog(null, "Usuario borrado", "confirmación" , 0);
	}
	public static void agregarUsuario() {
		
	}
}

