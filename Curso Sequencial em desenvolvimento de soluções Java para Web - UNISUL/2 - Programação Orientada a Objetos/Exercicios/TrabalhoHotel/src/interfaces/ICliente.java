package interfaces;

import java.util.ArrayList;

import entidades.Cliente;


/**
 * Interface que define os métodos de negócio da entidade Cliente.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public interface ICliente {
	
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
	 * Efetua uma busca por todos os clientes de um determinado nome.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome do cliente.
	 * @return ArrayList de Clientes encontrado ou null se não encontrado.
	 */
	public abstract ArrayList<Cliente> buscaCliente(String nome);
	
	/**
	 * Mostra todos os clientes cadastrados.
	 * @return ArrayList de clientes.
	 */
	public abstract ArrayList<Cliente> buscaCliente();

}
