package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.dto.Cliente;

/**
 * Interface que define os métodos de negócio da entidade Cliente.
 * @author Fabio Dela Bruna / Márcio Teixeira Ozório.
 * @since 13/05/2008.
 */
public interface IClienteModel {
	
	/**
	 * Efetua o cadastro de um cliente.
	 * @param c - Cliente a ser cadastrado.
	 * @throws IllegalArgumentException
	 * @return true se cadastrado com sucesso ou false se não.
	 */
	public abstract boolean cadastraCliente(Cliente c)
			throws IllegalArgumentException;

	/**
	 * Remove o cadastro de um determinado.
	 * @param c - Cliente a ser removido.
	 */
	public abstract void removeCliente(Cliente c);
	
	/**
	 * Atualiza os dados de um determinado cliente.
	 * @param antigo - Cliente com dados desatualizados.
	 * @param novo - Cliente com dados atualizados.
	 * @throws IllegalArgumentException
	 */
	public abstract void atualizaDadosCliente(Cliente antigo, Cliente novo) 
			throws IllegalArgumentException;
	
	/**
	 * Efetua uma busca por um determinado cliente.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome do cliente.
	 * @return Cliente encontrado ou null se não encontrado.
	 */
	public abstract Cliente buscaCliente(String nome, String sobrenome);
	
	/**
	 * Mostra todos os clientes cadastrados.
	 * @return ArrayList de clientes.
	 */
	public abstract ArrayList<Cliente> mostraClientes();

}
