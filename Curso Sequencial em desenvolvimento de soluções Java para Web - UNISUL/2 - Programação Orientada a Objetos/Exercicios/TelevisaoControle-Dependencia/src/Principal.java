
public class Principal {
 
	public static void main(String[] args) {
		
		ControleRemoto controle = new ControleRemoto();
		Televisao tv = new Televisao();
		
		controle.aumentarVolumeTV(tv);
		
		controle.desligarTV(tv);
	}
}
