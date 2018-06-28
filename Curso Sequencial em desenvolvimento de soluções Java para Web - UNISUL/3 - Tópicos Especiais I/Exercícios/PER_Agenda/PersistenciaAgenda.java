public interface PersistenciaAgenda {
	
	public boolean inserirContato(Contato contato);
	
	public Contato consultarContato(int numero);
	
	public boolean removerContato(int numero);
	
	public boolean alterarContato(Contato contato);
	
	public Contato[] listarContatos();
}