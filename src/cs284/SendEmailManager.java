package cs284;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.net.ssl.SSLSession;
public class SendEmailManager {
	private final String USER_NAME = "noreplycs284.650002.2";  // GMail user name (just the part before "@gmail.com")
    private final String PASSWORD = "CS284650002"; // GMail password
    private final String HOST = "smtp.gmail.com";
    private String course ,section;
    
    
    
    
   
    
    
    public SendEmailManager(String course,String section) {
		// TODO Auto-generated constructor stub
    	this.course = course;
    	this.section = section;
    	
	}
    
    
    
    public static boolean CheckInternetConnection() {
		try {
			URL url = new URL("http://www.google.co.th/");
			URLConnection conn = url.openConnection();
			conn.connect();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
    
 
    public   boolean sendFromGMail(String[] to, String subject, String body) {
        Properties props = System.getProperties();
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        catch (AddressException ae) {
            ae.printStackTrace();
            return false;
        }
        catch (MessagingException me) {
            me.printStackTrace();
            return false;
        }
        
       
    }
    
    
    public   boolean sendFromGMail(String to, String mailSubject, String name ,String ID ,String grade) {
        Properties props = System.getProperties();
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(to);

            // To get the array of addresses
           

            
                message.addRecipient(Message.RecipientType.TO, toAddress);
            
            
            message.setSubject("ประกาศผลการศึกษา");
            message.setText("เรียนคุณ : "+name+"\t"+ "รหัสนักศึกษา : " +ID +"\n" +"ได้เกรด : "+grade +"\tCourse: " +course +"\tSectrion: "+section);
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        }
        catch (AddressException ae) {
            ae.printStackTrace();
            return false;
        }
        catch (MessagingException me) {
            me.printStackTrace();
            return false;
        }
        
       
    }
    
    
    public static void main(String[] args) {
    	String[] mail = {"pongzadenoza@gmail.com","pongzadenoza@gmail.com"};
    	SendEmailManager mailmng = new SendEmailManager("course1","section");
    	
    	mailmng.sendFromGMail(mail, "ประกาศผลการศึกษา", "เรียนคุณxxx\t รหัสนักศึกษา xxxx \n ได้เกรด : A");
	}
}
