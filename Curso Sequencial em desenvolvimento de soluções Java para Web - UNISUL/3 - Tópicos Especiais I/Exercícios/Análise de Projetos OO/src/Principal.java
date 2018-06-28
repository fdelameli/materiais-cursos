import junit.framework.Assert;

import org.junit.Test;

public class Principal {

	@Test
	public void testeSoma() {
		Calculadora c = new Calculadora();
		c.somar(2, 2);
		Assert.assertEquals(4, c.somar(2, 2));
	}
}
