

import com.br.lhmanager.util.CPFValidator;


public class TesteCPF {

	public static void main( String[] args ) {
		
		System.out.println(CPFValidator.validaCpf( "070.071.939-35" ));
		System.out.println();
		System.out.println(CPFValidator.validaCpf( "523.234.543-34" ));
		
	}
	
	
}
