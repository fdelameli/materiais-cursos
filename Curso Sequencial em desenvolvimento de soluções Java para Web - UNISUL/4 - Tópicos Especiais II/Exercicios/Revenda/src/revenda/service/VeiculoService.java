package revenda.service;

import revenda.dao.VeiculoDAO;
import framework.service.ServiceBase;

public class VeiculoService extends ServiceBase {

	public VeiculoService() throws Exception {
		super(new VeiculoDAO());
	}

	
	
}
