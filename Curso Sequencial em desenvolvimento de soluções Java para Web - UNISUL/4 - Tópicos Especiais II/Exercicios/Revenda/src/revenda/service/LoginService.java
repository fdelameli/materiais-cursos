package revenda.service;

import revenda.dao.LoginDAO;
import framework.service.ServiceBase;

public class LoginService extends ServiceBase {

	public LoginService() throws Exception {
		super(new LoginDAO());
	}

}
