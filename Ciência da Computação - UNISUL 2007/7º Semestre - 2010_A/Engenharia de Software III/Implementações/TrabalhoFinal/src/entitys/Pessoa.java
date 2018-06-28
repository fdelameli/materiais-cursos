package entitys;

/**
 * Classe abstrata pessoa que será estendida por Candidato.
 * @author Allan
 *
 */
abstract class Pessoa {
	
	private int codigo;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Pessoa(int codigo){
		this.codigo = codigo;
	}
	
	public Pessoa(){
		this(0);
			
		}

	
	
	
	
	
	
	
	
	
	

}
