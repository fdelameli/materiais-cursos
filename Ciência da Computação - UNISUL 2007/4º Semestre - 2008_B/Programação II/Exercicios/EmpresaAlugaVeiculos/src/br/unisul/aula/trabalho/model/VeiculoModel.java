package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.trabalho.entidades.Veiculo;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 17/06/2008.
 */
public class VeiculoModel implements IVeiculoModel {

	//attributes
	
	private ArrayList<Veiculo> veiculos;
	
	
	//constructors
	
	/**
	 * Construtor com parâmetros.
	 * @param veiculos - ArrayList de Veiculos.
	 */
	public VeiculoModel (ArrayList<Veiculo> veiculos) {
		super();
		this.veiculos = veiculos;
	}

	@Override
	public void atualizaDadosVeiculo(Veiculo novo, Veiculo antigo) {
		if (validaVeiculo(novo)) {
			novo.setCodigo(antigo.getCodigo());
			this.veiculos.remove(antigo);
			this.veiculos.add(novo);
		} else {
			msgErro();
		}
	}

	@Override
	public void cadastraVeiculo(Veiculo v) {
		if (validaVeiculo(v)) {
			this.veiculos.add(v);
		} else {
			msgErro();
		}
	}

	@Override
	public void removeVeiculo(Veiculo v) {
		this.veiculos.remove(v);
	}
	
	@Override
	public ArrayList<Veiculo> mostraVeiculos() {
		return this.veiculos;
	}
	
	
	//métodos auxiliares
	
	/**
	 * Método que verifica se os atributos obrigatórios de um ciente são válidos.
	 * @param v - Veículo.
	 * @return true se os atributos são válidos ou false se não forem válidos.
	 */
	private boolean validaVeiculo (Veiculo v) {
		if (v == null)
			return false;
		if (v.getMarca() == null)
			return false;
		if (v.getModelo() == null)
			return false;
		if (v.getPlaca() == null)
			return false;
		if (v.getNumeroRenavam() == null)
			return false;
		if (v.getValor() <= 0.0)
			return false;
		
	return true;
	}
	
	/**
	 * Mostra uma menssagem de erro sempre que algum
	 * dos dados obrigatórios estiver incorreto.
	 */
	private void msgErro(){
		JOptionPane.showMessageDialog(null, "DADOS DE CADASTRO INVÁLIDOS!", "Erro de cadastro Veículo", JOptionPane.ERROR_MESSAGE);
	}
}
