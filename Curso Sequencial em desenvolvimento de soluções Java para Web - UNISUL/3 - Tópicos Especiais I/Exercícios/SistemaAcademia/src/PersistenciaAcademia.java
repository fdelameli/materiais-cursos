
public interface PersistenciaAcademia {
	
	public boolean inserirAtleta(Atleta atleta);
	
	public Atleta consultarAtleta(int codigo);
	
	public boolean removerAtleta(int codigo);
	
	public boolean alterarAtleta(Atleta atleta);
	
	public Atleta[] listarAtletas();
}