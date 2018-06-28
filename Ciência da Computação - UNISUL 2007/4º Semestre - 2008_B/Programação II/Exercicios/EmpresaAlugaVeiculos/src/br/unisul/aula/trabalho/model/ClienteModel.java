package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.util.CPFValidator;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 17/06/2008.
 */
public class ClienteModel implements IClienteModel {

	//attributes
	
	private ArrayList<Cliente> clientes;
	
	
	//constructors
	
	/**
	 * Construtor com parâmetros.
	 * @param clientes - ArrayList de Clientes.
	 */
	public ClienteModel (ArrayList<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}
	
	
	//main methods
	
	@Override
	public void atualizaDadosCliente(Cliente antigo, Cliente novo) {
		if (validaCliente(novo)) {
			novo.setCodigo(antigo.getCodigo());
			this.clientes.remove(antigo);
			this.clientes.add(novo);
		} else {
			msgErro();
		}
	}

	@Override
	public ArrayList<Cliente> buscaCliente(String nome) {
		ArrayList<Cliente> c = new ArrayList<Cliente>();
		
		for (int i = 0; i < this.clientes.size(); i++) {
			if(this.clientes.get(i).getNome().contains(nome))
				c.add(this.clientes.get(i));
		}
		return c;
	}

	@Override
	public void cadastraCliente(Cliente c) {
		if (validaCliente(c)) {
			this.clientes.add(c);
		} else {
			msgErro();
		}
	}

	@Override
	public ArrayList<Cliente> buscaCliente() {
		return this.clientes;
	}

	@Override
	public void removeCliente(Cliente c) {
		this.clientes.remove(c);
	}
	
	@Override
	public void cadastraAluguel(Cliente c, Aluguel a) {
		c.getAlugueis().add(a);
	}
	
	
	//métodos auxiliares

	/**
	 * Método que verifica se os atributos obrigatórios de um ciente são válidos.
	 * @param c - Cliente.
	 * @return true se os atributos são válidos ou false se não forem válidos.
	 */
	private boolean validaCliente(Cliente c){
		if(c == null)
			return false;
		if(c.getNome() == null)
			return false;
		if(CPFValidator.validaCpf(c.getCpf()) == false)
			return false;
		if(c.getFone1() == null)
			return false;

		return true;
	}

	/**
	 * Mostra uma menssagem de erro sempre que algum
	 * dos dados obrigatórios estiver incorreto.
	 */
	private void msgErro(){
		JOptionPane.showMessageDialog(null, "DADOS DE CADASTRO INVÁLIDOS!", "Erro de cadastro Cliente", JOptionPane.ERROR_MESSAGE);
	}
	

}
