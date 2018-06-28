package br.unisul.transportadora.testes;

import br.unisul.transportadora.dao.TransportadoraDao;

public class TesteDao {

	public static void main(String[] args) {
		
		Integer codigo = null;
		
		TransportadoraDao dao = new TransportadoraDao();
		codigo = dao.getMaxValueFromCodigo();
		
		System.out.println(codigo+1);
	}
}
