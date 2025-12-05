package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BuscarNoticias {
	public static String noticia1Economia() {
		String url = "https://www.eleconomista.es";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Economia() {
		String url = "https://elpais.com/economia/";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia1Deportes() {
		String url = "https://elpais.com/deportes/";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Deportes() {
		String url = "https://www.rtve.es/deportes/";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia1Nacional() {
		String url = "https://www.rtve.es/noticias/";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Nacional() {
		String url = "https://elpais.com";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia1Internacional() {
		String url = "https://www.epochtimes.es/c-internacional?gad_source=1&gad_campaignid=23148586261&gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxR6tzzBv1-5GtNVkJHzoym_GmCZJZNazocvnJfbL-vpbA3PA4t2rhcaAl34EALw_wcB";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Internacional() {
		String url = "https://www.bbc.com/mundo";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h3").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia1Videojuegos() {
		String url = "https://www.xataka.com/categoria/videojuegos";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Videojuegos() {
		String url = "https://vandal.elespanol.com/noticias/videojuegos";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia1Politica() {
		String url = "https://www.publico.es/politica";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static String noticia2Politica() {
		String url = "https://theobjective.com/espana/politica/";

		try {
			Document doc = Jsoup.connect(url).get();

			Element titular = doc.select("h2").first();

			if (titular != null) {
				return titular.text();
			} else {
				return "No se encontro el titular";
			}

		} catch (IOException e) {
			return null;
		}
	}

	public static void seleccionarNoticias(Usuario usuario, boolean economia, boolean deportes, boolean nacional, boolean internacional, boolean videojuegos, boolean politica) {
		ArrayList<String> noticias = new ArrayList<>();
		if(economia == true) {
			noticias.add("economia");
		}
		if(deportes == true) {
			noticias.add("deportes");
		}
		if(nacional == true) {
			noticias.add("nacional");
		}
		if(internacional == true) {
			noticias.add("internacional");
		}
		if(videojuegos == true) {
			noticias.add("videojuegos");
		}
		if(politica == true) {
			noticias.add("politica");
		}
		if(noticias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes de escoger al menos una categoria ", "Error", 0);
			return;
		}else {
			String nombre = usuario.getNombreUsuario();
			File configUsuariosTXT = new File("datos/" +"config"+ nombre +".txt");
			try {
				configUsuariosTXT.createNewFile();
				try(FileWriter fw = new FileWriter(configUsuariosTXT)){
					int contador = 0;
					for(String noticia : noticias){
						if(contador == 0) {
							fw.write(noticia);
						}else {
							fw.write("\n"+noticia);
						}
						contador++;
					}
				}catch (Exception e) {
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			GestionUsuarios.loguearse(usuario);
		}
	}
	public static boolean comprobarConfiguracion(String categoria, String nombre) {
		File configUsuariosTXT = new File("datos/" +"config"+ nombre +".txt");
		try (BufferedReader br = new BufferedReader(new FileReader(configUsuariosTXT))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				if(linea == categoria) {
					return true;
				}
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
