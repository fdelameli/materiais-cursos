package meubanco.gui;

import meubanco.service.PessoaService;
import framework.gui.ListFrameBase;
import framework.service.ServiceBase;

public class PessoaList extends ListFrameBase {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Construtor default.
	 */
	public PessoaList() {
		super("Pessoas");
	}
	
	
	@Override
	protected ServiceBase createServiceBase() throws Exception {
		return new PessoaService();
	}

	@Override
	protected String getLabelLista() {
		return "Listagem de Pessoas";
	}
	

}
