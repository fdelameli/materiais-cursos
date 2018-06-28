package br.unisul.aula.trabalho.model;


/**
 * Interface que define os métodos de negócio da entidade Funcionario.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 18/06/2008.
 */
public interface IReceitaModel {

	/**
	 * Método que retorna o total bruto do dinheiro ganho até o momento.
	 * @param alugueis - ArrayList de Alugueis.
	 * @return Total Bruto.
	 */
	public abstract double getTotalBruto();
	
	/**
	 * Método que retorna o total de dispesas.
	 * @param funcionarios - ArrayList de Funcionarios.
	 * @return Total de Dispesas.
	 */
	public abstract double getTotalDispesa();

	/**
	 * Método que retorna o total líquido (lucro ou prejuízo).
	 * @param alugueis - ArrayList de Alugueis.
	 * @param funcionarios - ArrayList de funcionarios.
	 * @return Total Líquido.
	 */
	public double getTotalLiquido();
}
