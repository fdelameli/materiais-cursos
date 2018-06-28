
public class LogConsole extends LogBase {

	protected void log(String tipo, String data, String message) {
		System.out.println(tipo + ": " + data + ": " + message);
	}

}
