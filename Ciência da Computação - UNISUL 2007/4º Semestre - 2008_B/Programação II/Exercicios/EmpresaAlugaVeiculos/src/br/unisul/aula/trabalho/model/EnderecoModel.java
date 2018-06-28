package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.trabalho.entidades.Endereco;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 17/06/2008.
 */
public class EnderecoModel implements IEnderecoModel{

	//attributes
	
	private ArrayList<Endereco> enderecos;
	
	
	//constructors
	
	/**
	 * Construtor com parâmetros
	 * @param enderecos - ArrayList de Endereços.
	 */
	public EnderecoModel (ArrayList<Endereco> enderecos) {
		super();
		this.enderecos = enderecos;
	}


	//main methods
	
	@Override
	public void atualizaDadosEndereco(Endereco antigo, Endereco novo) {
		if (validaEndereco(novo)) {
			this.enderecos.remove(antigo);
			this.enderecos.add(novo);
		} else {
			msgErro();
		}
		
	}


	@Override
	public void cadastraEndereco(Endereco e) {
		if (validaEndereco(e)){
			this.enderecos.add(e);
		} else {
			msgErro();
		}
	}


	@Override
	public ArrayList<Endereco> mostraEnderecos() {
		return this.enderecos;
	}


	@Override
	public void removeEndereco(Endereco e) {
		this.enderecos.remove(e);		
	}
	
	
	//métodos auxiliares
	
	/**
	 * Método que verifica se os atributos obrigatórios de um endereço são válidos.
	 * @param e - Endereço.
	 * @return true se os atributos são válidos ou false se não forem válidos.
	 */
	private boolean validaEndereco (Endereco e) {
		if (e == null)
			return false;
		if (e.getEstado() == null)
			return false;
		if (e.getCidade() == null)
			return false;
		if (e.getBairro() == null)
			return false;
		if (e.getRua() == null)
			return false;
		if (e.getNumero() <= 0)
			return false;
		if (e.getCep() == null)
			return false;
		
	return true;
	}
	
	/**
	 * Mostra uma menssagem de erro sempre que algum
	 * dos dados obrigatórios estiver incorreto.
	 */
	private void msgErro(){
		JOptionPane.showMessageDialog(null, "DADOS DE CADASTRO INVÁLIDOS!", "Erro de cadastro Endereço", JOptionPane.ERROR_MESSAGE);
	}
}
