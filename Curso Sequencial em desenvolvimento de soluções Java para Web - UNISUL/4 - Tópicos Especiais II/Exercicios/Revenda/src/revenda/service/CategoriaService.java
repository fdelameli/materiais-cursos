package revenda.service;

import revenda.dao.CategoriaDAO;
import framework.service.ServiceBase;

public class CategoriaService extends ServiceBase {

	public CategoriaService() throws Exception {
		super(new CategoriaDAO());
	}

	
	
}
