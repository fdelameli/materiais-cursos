

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Email {

	public static boolean envia( String texto ) {
		try {
			Properties props = new Properties();
			props.put( "mail.smtp.host", "smtp.gmail.com" );
			props.put( "mail.smtp.auth", "true" );
			props.put( "mail.debug", "false" );
			props.put( "mail.smtp.port", "465" );
			props.put( "mail.smtp.socketFactory.port", "465" );
			props.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
			props.put( "mail.smtp.socketFactory.fallback", "false" );

			SimpleAuth auth = new SimpleAuth( "modafck188@gmail.com", "salcifufu" );


			Session s = Session.getDefaultInstance( props, auth );
			s.setDebug( false );

			Message email = new MimeMessage( s );
			email.setFrom( new InternetAddress( "modafck188@gmail.com" ) );
			email.setRecipient( Message.RecipientType.TO, new InternetAddress( "fabiodelabruna@hotmail.com" ) );

			email.setSubject( "Título" );
			// email.setContent(texto,"text/plain");

			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText( texto );

			MimeBodyPart mbp2 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource( "C://modafuck.rar" );
			mbp2.setDataHandler( new DataHandler( fds ) );

			Multipart mp = new MimeMultipart();
			mp.addBodyPart( mbp1 );
			mp.addBodyPart( mbp2 );

			email.setContent( mp );

			Transport.send( email );

			return true;
		} catch ( Exception e ) {
			System.err.println( "Erro:" );
			e.printStackTrace();
			return false;
		}
	}
}
