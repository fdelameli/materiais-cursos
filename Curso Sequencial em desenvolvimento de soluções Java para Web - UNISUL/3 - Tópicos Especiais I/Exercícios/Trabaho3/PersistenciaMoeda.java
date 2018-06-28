
public interface PersistenciaMoeda {
	
	public boolean inserirMoeda(Moeda moeda);
	
	public Moeda consultarMoeda(int codigo);
	
	public boolean removerMoeda(int codigo);
	
	public boolean alterarMoeda(Moeda moeda);
	
	public Moeda[] listarMoedas();

}
