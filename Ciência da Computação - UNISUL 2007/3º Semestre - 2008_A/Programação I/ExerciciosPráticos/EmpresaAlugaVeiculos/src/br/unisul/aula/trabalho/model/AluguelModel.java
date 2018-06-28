package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Veiculo;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 17/06/2008.
 */
public class AluguelModel implements IAluguelModel {

	//attributes
	
	private ArrayList<Aluguel> alugueis;
	
	
	//constructors
	
	/**
	 * Construtor com parâmetros.
	 * @param alugueis - ArrayList de Alugueis.
	 */
	public AluguelModel (ArrayList<Aluguel> alugueis) {
		super();
		this.alugueis = alugueis;
	}

	
	//main methods

	@Override
	public void cadastraAluguel(Aluguel a) {
		if (validaAluguel(a.getVeiculo())) {
			this.alugueis.add(a);
			a.getVeiculo().setAlugado(true);
		} else {
			msgErro();
		}
	}


	@Override
	public ArrayList<Aluguel> buscaAluguel() {
		return this.alugueis;
	}


	@Override
	public ArrayList<Aluguel> buscaAluguel(Cliente c) {
		return c.getAlugueis();
	}


	@Override
	public ArrayList<Aluguel> buscaAluguel(Veiculo v) {
		ArrayList<Aluguel> a = new ArrayList<Aluguel>();
		
		for (int i = 0; i < this.alugueis.size(); i++) {
			if (this.alugueis.get(i).getVeiculo().equals(v))
				a.add(this.alugueis.get(i));
		}
		return a;
	}
	
	
	//metodos auxiliares


	/**
	 * Método que verifica se os atributos obrigatórios de um aluguel são válidos.
	 * @param v - Veiculo.
	 * @return true se os atributos são válidos ou false se não forem válidos.
	 */
	private boolean validaAluguel(Veiculo v) {
		if (v == null)
			return false;
		if (v.isAlugado())
			return false;
		
		return true;
	}
	
	/**
	 * Mostra uma menssagem de erro sempre que algum
	 * dos dados obrigatórios estiver incorreto.
	 */
	private void msgErro(){
		JOptionPane.showMessageDialog(null, "DADOS DE CADASTRO INVÁLIDOS!\nTalvez este veículo já esteja alugado.", "Erro ao efetuar Aluguel", JOptionPane.ERROR_MESSAGE);
	}
	
}
