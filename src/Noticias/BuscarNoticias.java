package Noticias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BuscarNoticias {
	public static String noticia1Economia() {
		String url = obtenerUrl("economia", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Economia() {
		String url = obtenerUrl("economia", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Economia() {
		String url = obtenerUrl("economia", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia1Deportes() {
		String url = obtenerUrl("deportes", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Deportes() {
		String url = obtenerUrl("deportes", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Deportes() {
		String url = obtenerUrl("deportes", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia1Nacional() {
		String url = obtenerUrl("nacional", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Nacional() {
		String url = obtenerUrl("nacional", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Nacional() {
		String url = obtenerUrl("nacional", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia1Internacional() {
		String url = obtenerUrl("internacional", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Internacional() {
		String url = obtenerUrl("internacional", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Internacional() {
		String url = obtenerUrl("internacional", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia1Videojuegos() {
		String url = obtenerUrl("videojuegos", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Videojuegos() {
		String url = obtenerUrl("videojuegos", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Videojuegos() {
		String url = obtenerUrl("videojuegos", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia1Politica() {
		String url = obtenerUrl("politica", 0);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia2Politica() {
		String url = obtenerUrl("politica", 1);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static String noticia3Politica() {
		String url = obtenerUrl("politica", 2);

		if (url == null) {
			return "Error: URL no configurada";
		}

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la informacion en " + url, "Error", 0);
			return "Error al cargar";
		}
	}

	public static void seleccionarNoticias(Usuario usuario, boolean economia, boolean deportes, boolean nacional,
			boolean internacional, boolean videojuegos, boolean politica) {
		ArrayList<String> noticias = new ArrayList<>();
		if (economia == true) {
			noticias.add("economia");
		}
		if (deportes == true) {
			noticias.add("deportes");
		}
		if (nacional == true) {
			noticias.add("nacional");
		}
		if (internacional == true) {
			noticias.add("internacional");
		}
		if (videojuegos == true) {
			noticias.add("videojuegos");
		}
		if (politica == true) {
			noticias.add("politica");
		}
		if (noticias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes de escoger al menos una categoria ", "Error", 0);
			return;
		} else {
			String nombre = usuario.getNombreUsuario();
			File configUsuariosTXT = new File("datos/configuracion.txt");

			try (FileWriter fw = new FileWriter(configUsuariosTXT, true)) {
				fw.write("\n" + nombre);
				for (String noticia : noticias) {
					fw.write(";" + noticia);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No se ha podido escribir en el archivo de configuración", "Error",
						0);
				System.exit(0);
			}

			GestionUsuarios.loguearse(usuario);
		}
	}

	public static boolean comprobarConfiguracion(String categoria, String nombre) {
		File configUsuariosTXT = new File("datos/configuracion.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(configUsuariosTXT))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos[0].trim().equals(nombre)) {
					for (int i = 1; i < datos.length; i++) {
						if (datos[i].equals(categoria)) {
							return true;
						}
					}
				}
			}
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se a podido leer el archivo de configración", "Error", 0);
			System.exit(0);
			return false;
		}
	}

	public static void guardarNoticias(Usuario usuario) {
		String nombre = usuario.getNombreUsuario();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate hoy = LocalDate.now();
		String fecha = hoy.format(formato);
		File archivoGuardar = new File("datos/historico.txt");
		try {
			if (!archivoGuardar.exists()) {
				archivoGuardar.createNewFile();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoGuardar))) {
					bw.write("Dia: " + fecha + " -- " + nombre + "\n" + EnviarNoticias.guardarNoticiasUsuario(usuario));
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "No se ha podido escribir en " + archivoGuardar, "Error", 0);
					return;
				}
			} else {
				try (FileWriter fw = new FileWriter(archivoGuardar, true)) {
					fw.write("Dia: " + fecha + " -- " + nombre + "\n" + EnviarNoticias.guardarNoticiasUsuario(usuario));
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario", "Error", 0);
					return;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo de historico", "Error", 0);
			return;
		}
		JOptionPane.showMessageDialog(null, "Noticias guardadas correctamente en " + archivoGuardar, "Confirmación", 1);
	}

	public static String obtenerUrl(String categoria, int numeroNoticia) {
		File configUrl = new File("datos/configuracion.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(configUrl))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos[0].trim().equals(categoria)) {
					return datos[numeroNoticia + 1].trim();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se a podido leer el archivo de configración", "Error", 0);
			System.exit(0);
		}

		return null;

	}
}
