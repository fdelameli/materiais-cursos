package revenda.gui;

import revenda.domain.Veiculo;
import revenda.service.VeiculoService;
import framework.gui.CadastrarEditarBase;
import framework.gui.ListFrameBase;
import framework.service.ServiceBase;

public class VeiculoList extends ListFrameBase {

	private static final long serialVersionUID = 1L;

	
	public VeiculoList(String dsTitulo) {
		super(dsTitulo);
	}

	
	@Override
	protected ServiceBase createServiceBase() throws Exception {
		return new VeiculoService();
	}

	@Override
	protected CadastrarEditarBase criaJanelaCadastrarEditar(Object obj) throws Exception {
		Veiculo v = (Veiculo) obj;
		
		if (obj == null)
			return new CadastrarEditarVeiculo("Cadastrar");
		if (obj != null)
			return new CadastrarEditarVeiculo(v, "Editar");
		
		return null;
	}


	
}
