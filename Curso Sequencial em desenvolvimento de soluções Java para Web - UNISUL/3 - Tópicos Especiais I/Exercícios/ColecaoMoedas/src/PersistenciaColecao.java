
public interface PersistenciaColecao {
	
	/**
	 * Método para inserir uma moeda.
	 * @param moeda - objeto do tipo Moeda.
	 * @return true se a moeda for inserida ou false se não for inserida.
	 */
	public boolean inserirMoeda(Moeda moeda);
	
	/**
	 * Método para consultar uma moeda atravéz do código.
	 * @param codigo - código da moeda.
	 * @return moeda encontrada ou null se não encontrar nenhuma moeda com o código específico.
	 */
	public Moeda consultarMoeda(int codigo);
	
	/**
	 * Método para remover uma moeda atravéz do código.
	 * @param codigo - código da moeda.
	 * @return true se a moeda for excluída ou false se não for excluída.
	 */
	public boolean removerMoeda(int codigo);
	
	/**
	 * Método para alterar os dados de uma determinada moeda.
	 * @param moeda - moeda a ser alterada.
	 * @return true se a moeda for alterada ou false se não for alterada.
	 */
	public boolean alterarMoeda(Moeda moeda);
	
	/**
	 * Método para listar todas as moedas cadastradas.
	 * @return array de moedas.
	 */
	public Moeda[] listarMoedas();
}