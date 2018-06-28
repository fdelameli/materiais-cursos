import java.text.DateFormat;
import java.util.Date;


public abstract class LogBase implements ILog {

	private DateFormat df = DateFormat.getDateTimeInstance();
	
	
	protected String getDate() {
		Date date = new Date();
		return df.format(date);
	}
	
	
	public void debug(String message) {
		log(DEBUG, getDate(), message);
	}
	
	public void error(String message) {
		log(ERROR, getDate(), message);
	}
	
	public void fatal (String message) {
		log(FATAL, getDate(), message);
	}
	
	public void info(String message) {
		log(INFO, getDate(), message);
	}
	
	public void warning(String message) {
		log(WARNING, getDate(), message);
	}
	
	
	protected abstract void log (String tipo, String data, String message);
}
