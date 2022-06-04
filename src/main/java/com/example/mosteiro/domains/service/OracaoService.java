package com.example.mosteiro.domains.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.example.mosteiro.domains.dto.Oracao;

@Service
public class OracaoService {
	
	public void enviaEmail(Oracao oracao) {
		
		String htmlEmail = buildHtml(oracao);
		List<String> emails = new ArrayList<>();
		emails.add("EMAILQUEVAIRECEBER1");
		emails.add("EMAILQUEVAIRECEBER2");
		emails.add("EMAILQUEVAIRECEBER3");
		sendEmailClient(emails, htmlEmail);
		
	}
	
	private void sendEmailClient(List<String> emails, String htmlEmail) {
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication()
           {
                 return new PasswordAuthentication("COLOQUEAQUISEU@GMAIL.COM","SUA SENHA");
           }
	    });
	    
	    session.setDebug(true);

	    try {
	    	Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress("COLOQUEAQUISEU@GMAIL.COM"));

		    emails.forEach(email -> {
		    	try {
		    		Address[] toUserAddress = InternetAddress.parse(email);
				    message.setRecipients(Message.RecipientType.TO, toUserAddress);
				    message.setSubject("Oração recebida do site!");
				    message.setContent(htmlEmail, "text/html");
				    Transport.send(message);
				} catch (Exception e) {}
		    });

		} catch (Exception e) {}
	}
	
	private String buildHtml(Oracao oracao) {
		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE html><html><style>table,th,td {border: 1px solid black;}");
		html.append("body {display: flex; justify-content: center; margin-top: 10px; }</style>");
		html.append("<body><table style=\"width: 650px\"><thead><tr><th colspan=\"4\">Oração recebida do site!</th>");
		html.append("</tr></thead><tbody><tr><td>Nome</td><td>E-mail</td><td>Telefone</td></tr><tr>");
		html.append("<td>" + oracao.getName() + "</td>");
		html.append("<td>" + oracao.getEmail() + "</td>");
		html.append("<td>" + oracao.getPhone() + "</td>");
		html.append("</tr></tbody><tfoot><tr><td colspan=\"4\">Mensagem</td></tr><tr><td colspan=\"4\">" + oracao.getMessage() + "</td>");
		html.append("</tr></tfoot></table></body></html>");
		return html.toString();
	}
}
