package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HoraAutomatica {

	public static String leerHora() {
		File configuracionTXT = new File("datos/configuracion.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(configuracionTXT))) {
			String linea;

			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}

				String[] datos = linea.split(";");

				if (datos[0].trim().equals("hora")) {
					String hora = datos[1].trim();
					return hora;
				}

			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido comprobar la hora automatica", "Error", 0);
		}
		return null;
	}

}
