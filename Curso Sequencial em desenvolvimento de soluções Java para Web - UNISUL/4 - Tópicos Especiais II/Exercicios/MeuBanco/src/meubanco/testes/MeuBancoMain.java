package meubanco.testes;

import javax.swing.UIManager;

import meubanco.domain.Pessoa;
import meubanco.gui.MeuBancoPrincipalFrame;
import meubanco.service.PessoaService;

/**
 * Classe para efetuar os testes de Interface Gráfica.
 * @author Fabio
 *
 */
public class MeuBancoMain {

	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
			
		} catch (Exception e) {
			
		}
		
		MeuBancoPrincipalFrame app = new MeuBancoPrincipalFrame();
		app.showPrincipalFrame();
		
		Pessoa p = new Pessoa();
		p.setCdPessoa(15);
		p.setNmPessoa("CONSTANTINO");
		
		
		try {
			PessoaService ps = new PessoaService();
			ps.getDaoBase().update(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
