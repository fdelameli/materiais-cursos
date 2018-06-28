package break_continue;
import javax.swing.JOptionPane;
/**o comando import serve para importa outras classes*/
class break_continue{

	static int n;

	public static void main(String[] args) {


		for( int i=0 ; i<=10 ; i++ ) {
			//referencia: <http://www.et.ufpr.br/dieval/lpoo/comandos.html>
			if( i%2 == 1 )
				continue;
			System.out.println( i );
			if (i%2 != 1)
				break;
		}
	}
}




