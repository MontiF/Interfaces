package Noticias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailEnviar {
	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (SSL) Use
	 * Authentication: Yes Port for SSL: 465
	 */
	static Session session;

	public static void datos() {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ObtenerDatosEmail.datosEnvio("fromEmail"), ObtenerDatosEmail.datosEnvio("passwordEmail"));
			}
		};
		session = Session.getDefaultInstance(props, auth);

	}

	public static void EmailRecuperacion(String toEmail, String passwordUsuario) {
		datos();
		EmailUtil.sendEmail(session, toEmail, "Recuperacion de Contraseña", "Su contraseña es: " + passwordUsuario);
	}

	public static void EmailNoticias(String toEmail, String correoCompleto) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate hoy = LocalDate.now();
		LocalDateTime locaDate = LocalDateTime.now();
		int hora = locaDate.getHour();
		int minutos = locaDate.getMinute();

		datos();
		if(minutos < 10) {
			EmailUtil.sendEmail(session, toEmail, "NOTICIAS DAM",
					"Noticias: " + hoy + "(" + hora + ":" + "0"+minutos + ") \n" + correoCompleto);
		}else {
			EmailUtil.sendEmail(session, toEmail, "NOTICIAS DAM",
				"Noticias: " + hoy + "(" + hora + ":" + minutos + ") \n" + correoCompleto);
		}
	}

}
