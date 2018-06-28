
import br.unisul.estrutura.aula.Pessoa;
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pessoa pessoa0 = new Pessoa("Fabio", 'M', 18, "070.071.939-75", "198.128.508");
		Pessoa pessoa1 = new Pessoa();
		
		pessoa1.setCpf("07007193975");
		pessoa1.setIdade(18);
		pessoa1.setNome("Fabio");
		pessoa1.setPelo(true);
		pessoa1.setQtdMembros(4);
		pessoa1.setQtdOlhos(2);
		pessoa1.setReproducao(1);
		pessoa1.setRg("1723892182");
		pessoa1.setSexo('M');
		
		
		System.out.println("Quantidade de Membros: " +pessoa1.getQtdMembros());

	}

}
