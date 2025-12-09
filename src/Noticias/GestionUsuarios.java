package Noticias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static void loguearse(Usuario usuario) {
		File usuariosTXT = new File("datos/usuarios.txt");
		List<String> lineasParaGuardar = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(usuariosTXT))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos.length == 5) {
					String nombreEnFichero = datos[1].trim();

					if (nombreEnFichero.equals(usuario.getNombreUsuario())) {
						String lineaModificada = datos[0] + ";" + datos[1] + ";" + datos[2] + ";" + datos[3] + ";true";
						lineasParaGuardar.add(lineaModificada);
					} else {
						lineasParaGuardar.add(linea);
					}
				} else {
					lineasParaGuardar.add(linea);
				}
			}
		} catch (IOException e) {
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(usuariosTXT))) {
			for (String l : lineasParaGuardar) {
				bw.write(l);
				bw.newLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo guardar el estado de login", "Error", 0);
			return;
		}
		
		listaUsuarios.clear();
		inicializarUsuarios();
	}
		

	public static boolean inicializarUsuarios() {
		File usuariosTXT = new File("datos/usuarios.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(usuariosTXT))) {
			String linea;

			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos.length == 5) {
					String email = datos[0].trim();
					String nombre = datos[1].trim();
					String password = datos[2].trim();
					boolean admin = Boolean.parseBoolean(datos[3].trim());
					boolean logueado = Boolean.parseBoolean(datos[4].trim());

					Usuario nuevoUsuario = new Usuario(email, nombre, password, admin, logueado);
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
		if (listaUsuarios.size() <= 4) {
			JOptionPane.showMessageDialog(null, "La aplicación no soporta menos usuarios", "Error", 0);
			return;
		}
		String nombreUsuario = JOptionPane.showInputDialog(null, "Introduce el nombre del Usuario a borrar");
		if (null == nombreUsuario) {
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "Error", 0);
			return;
		}
		if (nombreUsuario.equals(usuarioActual.getNombreUsuario())) {
			JOptionPane.showMessageDialog(null, "No te puedes borrar a ti mismo", "Error", 0);
			return;
		} else if (nombreUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un nombre", "Error", 0);
			return;
		}
		Usuario usuarioBorrar = obtenerUsuarioCompleto(nombreUsuario);
		if (usuarioBorrar == null) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", 0);
			return;
		}
		borrarUsuario(nombreUsuario);
	}

	private static void borrarUsuario(String nombreUsuarioBorrar) {
		File usuariosTXT = new File("datos/usuarios.txt");
		File configUsuariosTXT = new File("datos/" +"config"+ nombreUsuarioBorrar +".txt");
		List<String> lineasParaGuardar = new ArrayList<>();
		boolean usuarioEncontrado = false;

		try (BufferedReader br = new BufferedReader(new FileReader(usuariosTXT))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos.length == 5) {
					String nombre = datos[1].trim();

					if (nombre.equals(nombreUsuarioBorrar)) {
						usuarioEncontrado = true;
						continue;
					}
				}
				lineasParaGuardar.add(linea);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer: " + e.getMessage(), "Error", 0);
			return;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(usuariosTXT))) {
			for (String l : lineasParaGuardar) {
				bw.write(l);
				bw.newLine();
			}
			JOptionPane.showMessageDialog(null, "Usuario borrado", "Confirmación", 1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el archivo", "Error", 0);
			return;
		}
		configUsuariosTXT.delete();
		listaUsuarios.clear();
		inicializarUsuarios();

	}

	public static void agregarUsuarios() {
		if (listaUsuarios.size() >= 11) {
			JOptionPane.showMessageDialog(null, "La aplicación no soporta mas usuarios", "Error", 0);
			return;
		}
		String nombreUsuario = JOptionPane.showInputDialog(null, "Introduce el nombre del Usuario a crear");
		if (null == nombreUsuario) {
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "Error", 0);
			return;
		}
		if (nombreUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un nombre", "Error", 0);
			return;
		}
		Usuario usuarioAgregar = obtenerUsuarioCompleto(nombreUsuario);
		if (usuarioAgregar != null) {
			JOptionPane.showMessageDialog(null, "Usuario ya existente", "Error", 0);
			return;
		}

		String correo = JOptionPane.showInputDialog(null, "Introduce el correo del usuario");
		if (null == correo) {
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "Error", 0);
			return;
		}
		if (correo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduce un correo", "Error", 0);
			return;
		}
		usuarioAgregar = obtenerUsuarioCompletoCorreo(correo);
		if (usuarioAgregar != null) {
			JOptionPane.showMessageDialog(null, "Correo ya vinculado", "Error", 0);
			return;
		}
		String password = JOptionPane.showInputDialog(null, "Introduce una contraseña");
		if (null == password) {
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "Error", 0);
			return;
		}
		String esAdmin = JOptionPane.showInputDialog(null, "¿Es Admin? (true/false)");
		esAdmin.toLowerCase();
		if (null == esAdmin) {
			JOptionPane.showMessageDialog(null, "Se a cancelado la operación", "Error", 0);
			return;
		}
		if (!esAdmin.equals("false") && !esAdmin.equals("true")) {
			JOptionPane.showMessageDialog(null, "Debe de ser true o false", "Error", 0);
			return;
		}
		agregarUsuario(nombreUsuario, correo, password, esAdmin);
	}

	private static void agregarUsuario(String nombreUsuario, String correo, String password, String esAdminBool) {
		listaUsuarios.clear();
		File usuariosTXT = new File("datos/usuarios.txt");
		try (FileWriter fw = new FileWriter(usuariosTXT, true)) {
			fw.write("\n" + correo + ";" + nombreUsuario + ";" + password + ";" + esAdminBool + ";false");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario", "Error", 0);
			return;
		}
		inicializarUsuarios();
	}
}