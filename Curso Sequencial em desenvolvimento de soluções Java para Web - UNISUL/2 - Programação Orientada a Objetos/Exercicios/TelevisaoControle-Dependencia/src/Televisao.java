

/**
 * @author Fabio
 * @version 1.0
 * @created 17-mai-2008 15:54:05
 */
public class Televisao {

	private boolean estado;
	private int volume;
	private int canal;

	
	
	public Televisao(){
		this.estado = false;
		this.volume = 0;
		this.canal = 0;
	}

	
	
	public boolean ligar(){
		if(this.estado == false){
			this.estado = true;
			return true;
		} else {	
			System.out.println("ERRO: a tv já está ligada!");
			return false;
		}
	}

	public boolean desligar(){
		if(this.estado == true){
			this.estado = false;
			return true;
		} else {
			mostraErro();
			return false;
		}
	}


	public boolean aumentarVolume(){
		if(this.estado == true){
			this.volume ++;
			return true;
		} else {
			mostraErro();
			return false;
		}
	}


	public boolean diminuirVolume(){
		if(this.estado == true){
			this.volume --;
			return true;
		} else {
			mostraErro();
			return false;
		}
	}


	public boolean trocarCanal(int canal){
		if(this.estado == true){
			this.canal = canal;
			return true;
		} else {
			mostraErro();
			return false;
		}
	}
	
	
	private void mostraErro(){
		System.out.println("ERRO: a tv está desligada!");
	}

}