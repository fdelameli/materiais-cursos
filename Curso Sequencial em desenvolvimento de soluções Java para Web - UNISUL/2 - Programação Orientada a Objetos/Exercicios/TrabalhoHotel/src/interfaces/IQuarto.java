package interfaces;

import java.util.ArrayList;

import entidades.Quarto;


/**
 * Interface que define os métodos de negócio da entidade Quarto.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public interface IQuarto {

	/**
	 * Método para cadastrar um determinado quarto no hotel.
	 * @param q - quarto a ser cadastrado.
	 */
	public abstract void cadastraQuarto(Quarto q);
	
	/**
	 * Método para remover um determinado quarto do hotel.
	 * @param q - quarto a ser removido.
	 */
	public abstract void removeQuarto(Quarto q);
	
	/**
	 * Método que mostra todos os quartos cadastrados.
	 * @return - ArrayList de Quartos.
	 */
	public abstract ArrayList<Quarto> mostraQuartos();
}
