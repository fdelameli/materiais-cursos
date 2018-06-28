
public interface ILog {
	
	//constantes em uma interface
	
	public final static String DEBUG = "DEBUG";
	public final static String INFO = "INFO";
	public final static String WARNING = "WARNING";
	public final static String ERROR = "ERROR";
	public final static String FATAL = "FATAL";
	

	
	//métodos (são todos abstratos)
	
	public void debug(String message);
	
	public void error(String message);
	
	public void fatal (String message);
	
	public void info(String message);
	
	public void warning(String message);

	
}
