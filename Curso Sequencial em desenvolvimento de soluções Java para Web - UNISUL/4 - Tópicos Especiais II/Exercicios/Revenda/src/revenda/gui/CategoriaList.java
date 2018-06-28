package revenda.gui;

import java.awt.event.ActionListener;

import revenda.domain.Categoria;
import revenda.service.CategoriaService;

import framework.gui.CadastrarEditarBase;
import framework.gui.ListFrameBase;
import framework.service.ServiceBase;

public class CategoriaList extends ListFrameBase implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	
	
	public CategoriaList(String dsTitulo) {
		super(dsTitulo);
	}

	

	@Override
	protected ServiceBase createServiceBase() throws Exception {
		return new CategoriaService();
	}



	@Override
	protected CadastrarEditarBase criaJanelaCadastrarEditar(Object obj) throws Exception {
		Categoria c = (Categoria) obj;
		if (obj == null)
			return new CadastrarEditarCategoria("Cadastrar");
		if (obj != null)
			return new CadastrarEditarCategoria(c, "Editar");
		
		return null;
	}

	
	
	
}
