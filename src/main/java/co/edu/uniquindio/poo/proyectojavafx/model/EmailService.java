package co.edu.uniquindio.poo.proyectojavafx.model;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailService {

    private final String remitente = "hospitaluq@gmail.com";      // ← Cambia esto
    private final String contrasena = "dwnc efzr ubus ffzq";              // ← O contraseña de aplicación

    private final Properties propiedades;

    public EmailService() {
        propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) {
        try {
            Session sesion = Session.getInstance(propiedades, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitente, contrasena);
                }
            });

            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            Transport.send(mensaje);
            System.out.println("Correo enviado exitosamente.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
            return false;
        }
    }
}
