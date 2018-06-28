import javax.swing.JOptionPane;

import br.unisul.aula.dto.Endereco;
import br.unisul.aula.dto.Pessoa;
import br.unisul.aula.exception.ValidacaoException;
import br.unisul.aula.model.ClasseExemplo;


public class Principal {

	public static void main(String[] args) {
		
		ClasseExemplo classeExemplo = new ClasseExemplo();
		
		Endereco end = new Endereco(2008, "Estrada Geral Azambuja", "88725-000", "Pedras Grandes", "Santa Catarina");
		
		Pessoa p = new Pessoa(/*"Fabio", 19, 'M', "Brasileiro", end, true*/);
		p.setDisponivel(true);
//		p.setEndereco(end);
		p.setIdade(19);
		p.setNacionalidade("Brasileiro");
		p.setNome("Fabio");
		p.setSexo('M');
		
		try {
			classeExemplo.inserePessoa(p);
		} catch (ValidacaoException ve) {
			JOptionPane.showMessageDialog(null, ve.getMessage());
		}
	}
}
