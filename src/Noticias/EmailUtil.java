package Noticias;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailUtil {
	/**
	 *
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// Configurar Cabeceras
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(
					new InternetAddress(ObtenerDatosEmail.datosEnvio("noReply"), ObtenerDatosEmail.datosEnvio("de")));
			msg.setReplyTo(InternetAddress.parse(ObtenerDatosEmail.datosEnvio("noReply"), false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al enviar el correo", "Error", 0);
		}
	}
}
