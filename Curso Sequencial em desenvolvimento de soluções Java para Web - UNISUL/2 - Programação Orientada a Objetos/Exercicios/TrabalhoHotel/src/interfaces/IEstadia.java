package interfaces;

import java.util.ArrayList;

import entidades.Cliente;
import entidades.Estadia;
import entidades.Quarto;
import entidades.Reserva;


/**
 * Interface que define os métodos de negócio da entidade Estadia.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public interface IEstadia {
	
	/**
	 * Efetua o cadastro de uma Estadia.
	 * @param e - Estadia a ser cadastrada.
	 */
	public abstract void cadastraEstadia(Estadia e);
	
	/**
	 * Gera uma estadia atravéz de uma determinada reserva.
	 * @param r - Reserva.
	 */
	public abstract void geraEstadia(Reserva r);
	
	/**
	 * Efetua uma busca pelas estadias de determiando cliente.
	 * @param c - Cliente.
	 * @return ArrayList de estadias (se o cliente tiver estadias) ou null se não tiver.
	 */
	public abstract ArrayList<Estadia> buscaEstadia(Cliente c);
	
	/**
	 * Efetua uma busca pelas estadias que foram feitas para determinado quarto.
	 * @param q - Quarto.
	 * @return ArrayList de estadias (se o quarto tiver estadias feitas) ou null se não tiver.
	 */
	public abstract ArrayList<Estadia> buscaEstadia(Quarto q);
	
	/**
	 * Mostra o histórico de todas as estadias cadastradas.
	 * @return ArrayList de Estadias.
	 */
	public abstract ArrayList<Estadia> buscaEstadia();

}
