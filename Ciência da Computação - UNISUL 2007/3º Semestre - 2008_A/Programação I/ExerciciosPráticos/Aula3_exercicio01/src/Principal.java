import br.unisul.aula.exercicio.entidade.Conta;
import br.unisul.aula.exercicio.entidade.Pessoa;
import br.unisul.aula.exercicio.negocio.ContaBancaria;


/**
 * Classe principal do programa
 * @author Fabio Dela Bruna
 * @since 04/03/2008
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ContaBancaria cb = new ContaBancaria();
		
		Conta c = new Conta();
		c.setAgencia("0201-1");
		c.setNumeroConta("15118-5");
		c.setSaldo(1000.00);
		c.setSenha("ABC");
		c.setHistorico("");
		
		Pessoa p = new Pessoa ("Fabio", 15, 'M',c );
		
		cb.saque(300, p);
		cb.deposito(250, p);
		
		System.out.println(p.getConta().getHistorico());

	}

}
