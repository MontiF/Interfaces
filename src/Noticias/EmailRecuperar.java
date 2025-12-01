package Noticias;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailRecuperar {	
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (SSL)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	public static void datos(String toEmail, String passwordUsuario) {
		
		final String fromEmail = "miguel.monteagudo.dosa@gmail.com";
		final String password = "oujt qvgn momv kxpt";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");	
		Authenticator auth = new Authenticator() {		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};		
		Session session = Session.getDefaultInstance(props, auth);
			
	   EmailUtilRecuperar.sendEmail(session, toEmail,"Recuperacion de Contraseña", "Su contraseña es: " +passwordUsuario);
	}
}

