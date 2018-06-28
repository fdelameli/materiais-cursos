package revenda.gui;

import revenda.domain.Montadora;
import revenda.service.MontadoraService;
import framework.gui.CadastrarEditarBase;
import framework.gui.ListFrameBase;
import framework.service.ServiceBase;

/**
 * Classe que representa a tela para gerenciar as montadoras.
 * A tela permite buscar, editar, exclui ou criar uma montadora.
 * 
 * @author Fabio Dela Bruna.
 * 
 */
public class MontadoraList extends ListFrameBase {

	private static final long serialVersionUID = 1L;
	
	
	
	public MontadoraList(String dsTitulo) {
		super(dsTitulo);
	}

	

	@Override
	protected ServiceBase createServiceBase() throws Exception {
		return new MontadoraService();
	}

	@Override
	protected CadastrarEditarBase criaJanelaCadastrarEditar(Object obj) throws Exception {
		Montadora m = (Montadora) obj;
		
		if (obj == null)
			return new CadastrarEditarMontadora("Cadastrar");
		if (obj != null)
			return new CadastrarEditarMontadora(m, "Editar");
		
		return null;
	}
	
	
}
