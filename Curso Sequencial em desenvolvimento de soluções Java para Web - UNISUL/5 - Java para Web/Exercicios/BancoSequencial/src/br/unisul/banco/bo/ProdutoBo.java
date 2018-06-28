package br.unisul.banco.bo;

import java.util.List;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.dao.ProdutoDao;

public class ProdutoBo {
	
	
	public ProdutoBean buscarProdutoPorCodigo(Integer codigo) {
		ProdutoDao dao = new ProdutoDao();
		return dao.buscarProdutoPorCodigo(codigo);
	}

	
	/**
	 * Método que verifica a validação de todos os
	 * atributos de um ojbeto do tipo ProdutoBean.
	 */
	private boolean validate(ProdutoBean produto) {
		
		if (produto == null) {
			return false;
		}
		if (produto.getCodigo().equals("")) {
			return false;
		}
		if (produto.getDescricao().equals("")) {
			return false;
		}
		if (produto.getGenero().equals("")) {
			return false;
		}
		if (produto.getValor().equals("")) {
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean insertProduto(ProdutoBean produto) {
		
		if (validate(produto)) {
			ProdutoDao dao = new ProdutoDao();
			return dao.insertProduto(produto);
		} else {
			return false;
		}
	}
	
	
	public List<ProdutoBean> listarProdutos() {
		ProdutoDao dao = new ProdutoDao();
		return dao.listarProdutos();
	}
	
	
	public void exluirProduto(Integer codigo) {
		ProdutoDao dao = new ProdutoDao();
		dao.excluirProduto(codigo);
	}
	
}
