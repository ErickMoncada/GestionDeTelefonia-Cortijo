/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import app.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Sebas
 */
public class RecuperarPass {

    public int EnviarCodigo(String usuario) throws AddressException, MessagingException {
        //se trata de enviar el correo electronico conj el codigo correspondiente
        int codigo = 0;
        String DireccionCorreo;
        try {
            ResultSet rs;
            PreparedStatement ps;
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT Usuario, Correo FROM VistaUsuariosApp WHERE Usuario = ?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            //se comprueba si existe el usuario, de lo contrario se envia codigo 0 que significa que no encontro usuario
            if (rs.next()) {
                DireccionCorreo =rs.getString("Correo");
                Properties props = new Properties();
                
                props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com");      
                props.setProperty("mail.smtp.startls.enable", "true");
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.ssl", "true");
                
                Session session=Session.getDefaultInstance(props);
                
                String correoRemitente = "correo de asistencia";
                String passRemitente="password";
                String correoReceptor=DireccionCorreo;
                String asunto = "Recuperacion de Contraseña";
                codigo=numeroAleatorio();
                String mensaje ="Tu codigo para recuperar la contraseña es: "+codigo+" sigue los pasos en la aplicacion";
                
                MimeMessage message = new MimeMessage(session);
                try{
                    message.setFrom(new InternetAddress(correoRemitente));                   
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(correoReceptor));
                    message.setSubject(asunto);
                    message.setText(mensaje);
                    Transport t = session.getTransport("smtp");
                    t.connect(correoRemitente,passRemitente);
                    t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                    t.close();
                }catch(MessagingException ex){
                    System.out.println("no se pudo"+ ex);
                }
            }  
           
             
        } catch (SQLException ex) {
            Logger.getLogger(RecuperarPass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    }

    public int numeroAleatorio() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000; // Genera un número aleatorio entre 10000 y 99999 (ambos inclusive)
        return randomNumber;
    }

    public String Encriptar(String textoOriginal){
     try {
            // Obtener una instancia de MessageDigest con el algoritmo deseado (por ejemplo, SHA-256)
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Convertir el texto original a un arreglo de bytes
            byte[] bytesTextoOriginal = textoOriginal.getBytes();

            // Calcular el hash del arreglo de bytes
            byte[] hash = messageDigest.digest(bytesTextoOriginal);

            // Convertir el hash a una representación legible en hexadecimal
            StringBuilder hashHex = new StringBuilder();
            for (byte b : hash) {
                hashHex.append(String.format("%02x", b));
            }
            return  hashHex.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
     return "error";
    }
}
