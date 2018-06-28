

import junit.framework.Test;
import junit.framework.TestCase;


public class EmailTeste extends TestCase implements Test {

	@Override
	protected void setUp() throws Exception {
		System.out.println( "Iniciando..." );
	}

	public void testEnvia() {
		assertEquals( "E-mail não enviado ", true,
				Email.envia( "Teste JUnit - Mail" ) );

	}


	@Override
	protected void tearDown() throws Exception {
		System.out.println( "Finalizando..." );
	}


}
