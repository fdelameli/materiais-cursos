 package revenda.service;

import revenda.dao.MontadoraDAO;
import framework.service.ServiceBase;

public class MontadoraService extends ServiceBase {

	
	/**
	 * Construtor default.
	 * @throws Exception
	 */
	public MontadoraService() throws Exception {
		super(new MontadoraDAO());
	}
		
	
}
