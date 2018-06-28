


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Clavison
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
class SimpleAuth extends Authenticator {

	public String username = null;
	public String password = null;


	public SimpleAuth( String user, String pwd ) {
		username = user;
		password = pwd;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication( username, password );
	}
}
