
public class Principal {

	public static void main(String[] args) {
		
		LogConsole lc = new LogConsole();
		lc.debug("qualquer menssagem");
		lc.error("qualquer menssagem");
		
		LogTela lt = new LogTela();
		lt.fatal("qualquer menssagem");
		lt.info("qualquer menssagem");
	}

}
