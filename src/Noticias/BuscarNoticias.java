package Noticias;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class BuscarNoticias {
	public static String noticia1Economia() {
		String url = "https://www.eleconomista.es";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Economia() {
		String url = "https://elpais.com/economia/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia1Deportes() {
		String url = "https://elpais.com/deportes/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Deportes() {
		String url = "https://www.rtve.es/deportes/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h3").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia1Nacional() {
		String url = "https://www.rtve.es/noticias/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h3").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Nacional() {
		String url = "https://www.abc.es/espana/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia1Internacional() {
		String url = "https://www.epochtimes.es/c-internacional?gad_source=1&gad_campaignid=23148586261&gclid=Cj0KCQiA_8TJBhDNARIsAPX5qxR6tzzBv1-5GtNVkJHzoym_GmCZJZNazocvnJfbL-vpbA3PA4t2rhcaAl34EALw_wcB";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h3").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Internacional() {
		String url = "https://www.bbc.com/mundo";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h3").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia1Videojuegos() {
		String url = "https://www.xataka.com/categoria/videojuegos";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Videojuegos() {
		String url = "https://vandal.elespanol.com/noticias/videojuegos";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia1Politica() {
		String url = "https://www.publico.es/politica";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
	public static String noticia2Politica() {
		String url = "https://theobjective.com/espana/politica/";
		
		try {
			Document doc = Jsoup.connect(url).get();
			
			Element titular = doc.select("h2").first();
			
			if(titular != null) {
				return titular.text();
			}else {
				return "No se encontro el titular";
			}
				
		}catch(IOException e) {
			return null;
		}
	}
}

