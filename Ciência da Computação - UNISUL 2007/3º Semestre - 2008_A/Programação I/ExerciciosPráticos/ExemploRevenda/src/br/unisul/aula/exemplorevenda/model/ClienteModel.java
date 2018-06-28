package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.exemplorevenda.entidade.Cliente;

/**
 * Classe de negócio.
 * @author Fabio Dela Bruna
 * @since 04/05/2008
 */
public class ClienteModel implements IClienteModel {
	
	// atributos
	
	private ArrayList<Cliente> clientes;

	
	// construtores
	
	/**
	 * Construtor default
	 */
	public ClienteModel(){
		super();
	}
	
	/**
	 * Construtor com paramêtros
	 * @param clientes - ArrayList de clientes
	 */
	public ClienteModel(ArrayList<Cliente> clientes){
		super();
		this.clientes = clientes;
	}

	
	//	 métodos principais
	
	@Override
	public void atualizaCliente(Cliente novo, Cliente antigo) {
		if(validaCliente(novo))
			antigo = novo;
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Cliente",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public Cliente buscaCliente(String nome, String cpf) {
		if((nome != null && nome.length() > 1) && cpf == null){
			for(Cliente c : this.clientes){
				if(c.getNome().equals(nome)){
					return c;
				}
			}
		}else if(cpf != null && cpf.length() > 0){
			for(Cliente c : this.clientes){
				if(c.getCpf().equals(cpf)){
					return c;
				}
			}
		}else if((cpf != null && cpf.length() > 0) && (nome != null && nome.length() > 1)){
			for(Cliente c : this.clientes){
				if(c.getCpf().equals(cpf) && c.getNome().equals(nome)){
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public void cadastraCliente(Cliente c) {
		if(validaCliente(c))
			this.clientes.add(c);
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Cliente",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public ArrayList<Cliente> mostraClientes() {
		return this.clientes;
	}

	@Override
	public void removeCliente(Cliente c) {
		this.clientes.remove(c);
	}
	

	

	/**
	 * Verifica se todos os atributos obrigatórios estão devidamente preenchidos.
	 * @param c - cliente
	 * @return - false or true.
	 */
	private boolean validaCliente(Cliente c){
		if(c == null)
			return false;
		if(c.getNome() == null || c.getNome().length() <= 1)
			return false;
		if(c.getCpf() == null || c.getCpf().length() < 0)
			return false;
		if(c.getFone1() == null || c.getFone1().length() < 8)
			return false;
		
		return true;
	}
	

}
