package Utilitarios;
//imports omitidos  

import Negocios.Empresa;
import Negocios.Fachada;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {

    public static void main(String[] args) {
    }

    public void enviarEmail(String razao, String fantasia, String endereco, String bairro,
            String cidade, String documentos, String telefone, String obs) {

        String usuario = "emaildag3informatica@gmail.com";
        String senha = "#g31nf#g3";
        String SMTP_HOST_NAME = "smtp.gmail.com";
        String SMTP_PORT = "465";
        String emailFromAddress = "emaildag3informatica@gmail.com";
        String emailToAddress = "emaildag3informatica@gmail.com";
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties p = new Properties();

        p.put("mail.smtp.host", "smtp.gmail.com");

        SimpleAuth auth = null;
        auth = new SimpleAuth(usuario, senha);

        p.put("mail.smtp.auth", "true");
        p.put("mail.user", usuario);
        p.put("mail.from", emailFromAddress);
        p.put("mail.to", emailToAddress);

        p.put("mail.smtp.host", SMTP_HOST_NAME);
        p.put("mail.smtp.auth", "true");
        p.put("mail.debug", "true");

        p.put("mail.smtp.port", SMTP_PORT);
        p.put("mail.smtp.socketFactory.port", SMTP_PORT);
        p.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        p.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);

        try {
            // "de" e "para"!!  
            msg.setFrom(new InternetAddress(emailFromAddress));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailToAddress));

            Empresa e = Fachada.getInstancia().consultarEmpresa("SELECT * FROM empresa WHERE ID = (SELECT MAX(ID) FROM EMITENTES)");
            msg.setSubject("Envio de solicitação de atualização de licença por: " + e.getRazao_social());

            MimeBodyPart mbp1 = new MimeBodyPart();
            MimeBodyPart mbp2 = new MimeBodyPart();
            MimeBodyPart mbp3 = new MimeBodyPart();
            mbp1.setText("DADOS DA EMPRESA: \n" + razao.toUpperCase() + "\n" + fantasia.toUpperCase() + "\n" + endereco.toUpperCase()
                    + "\n" + bairro.toUpperCase() + "\n" + cidade.toUpperCase() + "\n" + documentos + "\n" + telefone + "\n" + "Observação: " + obs);

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            msg.setContent(mp);
            // nao esqueca da data!  
            // ou ira 31/12/1969 !!!  
            msg.setSentDate(new Date());

            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    class SimpleAuth extends Authenticator {

        public String username = null;
        public String password = null;

        public SimpleAuth(String user, String pwd) {
            username = user;
            password = pwd;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}
