package interfaces;

import java.util.ArrayList;

import entidades.Cliente;
import entidades.Quarto;
import entidades.Reserva;


/**
 * Interface que define os métodos de negócio da entidade Reserva.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public interface IReserva {

	/**
	 * Método para efetuar o cadastro de uma reserva.
	 * @param r - Reserva a ser cadastrada.
	 */
	public abstract void cadastraReserva(Reserva r);
	
	/**
	 * Método para atualizar os dados de uma determinada reserva.
	 * @param nova - Reserva com dados atualizados.
	 * @param antiga - Reserva com dados desatualiados.
	 */
	public abstract void atualizaDadosReserva(Reserva nova, Reserva antiga);
	
	/**
	 * Método que efetua uma busca por reservas feitas para um determinado quarto.
	 * @param q - Quarto.
	 * @return ArrayList de Reservas.
	 */
	public abstract ArrayList<Reserva> buscaReserva(Quarto q);
	
	/**
	 * Método que efetua uma busca por reservas feitas para um determinado cliente.
	 * @param c - Cliente.
	 * @return ArrayList de Cliente.
	 */
	public abstract ArrayList<Reserva> buscaReserva(Cliente c);
	
	/**
	 * Efetua uma busca por todas as reservas feitas.
	 * @return ArrayList de Reservas realizadas.
	 */
	public abstract ArrayList<Reserva> buscaReserva();
	
	/**
	 * Método para remover o cadastro de uma determinada reserva.
	 * @param r - Reserva.
	 */
	public abstract void removeReserva(Reserva r);
	
	
}
