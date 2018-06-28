package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Cliente;

/**
 * Interface que define os métodos de negócio da entidade Cliente.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 12/06/2008.
 */
public interface IClienteModel {

	/**
	 * Efetua o cadastro de um cliente.
	 * @param c - Cliente a ser cadastrado.
	 */
	public abstract void cadastraCliente(Cliente c);

	/**
	 * Remove o cadastro de um determinado.
	 * @param c - Cliente a ser removido.
	 */
	public abstract void removeCliente(Cliente c);
	
	/**
	 * Atualiza os dados de um determinado cliente.
	 * @param antigo - Cliente com dados desatualizados.
	 * @param novo - Cliente com dados atualizados.
	 */
	public abstract void atualizaDadosCliente(Cliente antigo, Cliente novo);
	
	/**
	 * Efetua uma busca por um determinado cliente.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome do cliente.
	 * @return ArrayList de clientes que contém o primeiro nome igual.
	 */
	public abstract ArrayList<Cliente> buscaCliente(String nome);
	
	/**
	 * Mostra todos os clientes cadastrados.
	 * @return ArrayList de clientes.
	 */
	public abstract ArrayList<Cliente> buscaCliente();
	
	/**
	 * Insere um aluguel no ArrayList de alugueis de um cliente.
	 */
	public abstract void cadastraAluguel(Cliente c, Aluguel a);
}
