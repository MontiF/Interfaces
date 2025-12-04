package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HoraAutomatica {

	public static String leerHora() {
		File horaTXT = new File("datos/horaEnvio.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(horaTXT))) {
			String linea;

			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}
				String hora = linea;
				return hora;
			}
		} catch (IOException e) {

		}
		return null;
	}

}
