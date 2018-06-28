

/**
 * @author Fabio
 * @version 1.0
 * @created 17-mai-2008 16:35:42
 */
public class Controle {

	private Televisao televisao;

	
	public Controle(){

	}

	
	public boolean ligarTV(){
		return this.televisao.ligar();
	}

	public boolean desligarTV(){
		return this.televisao.desligar();
	}

	public boolean aumentarVolumeTV(){
		return this.televisao.aumentarVolume();
	}

	public boolean diminuirVolumeTV(){
		return this.televisao.diminuirVolume();
	}

	public boolean trocarCanalTV(int canal){
		return this.televisao.trocarCanal(canal);
	}

}