package Noticias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ObtenerDatosEmail {
	public static String datosEnvio(String dato){
		File configEnvio = new File("datos/configuracion.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(configEnvio))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				if (linea.trim().isEmpty()) {
					continue;
				}
				
				String[] datos = linea.split(";");
				
				if (datos[0].trim().equals(dato)) {
					return datos[1].trim();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se a podido leer el archivo de configración", "Error", 0);
			System.exit(0);
		}
		
		return null;
		
	}
}
