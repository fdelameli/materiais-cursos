package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Cliente;

/**
 * Interface que estabelece os métodos de negócio da entidade Cliente
 * @author Fabio Dela Bruna
 * @since 04/05/2008
 */
public interface IClienteModel {
	
	
	/**
	 * Cadastra um cliente na revenda.
	 * @param c - Cliente
	 */
	public abstract void cadastraCliente(Cliente c);
	
	/**
	 * Remove um cliente da revenda.
	 * @param c - Cliente
	 */
	public abstract void removeCliente(Cliente c);
	
	/**
	 * Atualiza os dados cadastrais de um cliente.
	 * @param novo - Dados atualizados.
	 * @param antigo - Dados desatualizados.
	 */
	public abstract void atualizaCliente(Cliente novo, Cliente antigo);
	
	/**
	 * Busca um cliente específico.
	 * @param nome - Nome do cliente
	 * @param cpf - CPR do cliente
	 * @return Cliente encontrado ou null se não encontrou
	 */
	public abstract Cliente buscaCliente(String nome, String cpf);
	
	/**
	 * Mostra os clientes cadastrados na revenda.
	 * @return Lista de clientes.
	 */
	public abstract ArrayList<Cliente> mostraClientes();

}
