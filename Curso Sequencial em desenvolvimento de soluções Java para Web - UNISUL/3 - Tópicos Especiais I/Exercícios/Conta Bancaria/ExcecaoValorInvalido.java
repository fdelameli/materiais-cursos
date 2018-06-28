/**
 * Exceção que será disparada quando um determinado valor for
 *   inválido para depósitos, retiradas e transferências.
 *   
 * @author Fabio Dela Bruna.
 *
 */
public class ExcecaoValorInvalido extends RuntimeException {

	public ExcecaoValorInvalido(String reason) {
		super(reason);
	}
}
