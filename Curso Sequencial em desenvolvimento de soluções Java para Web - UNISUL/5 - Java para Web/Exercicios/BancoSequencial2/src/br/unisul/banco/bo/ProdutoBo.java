package br.unisul.banco.bo;

import java.util.List;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.dao.ProdutoDao;

public class ProdutoBo {

	public void insertProduto(ProdutoBean produto){
		
		//Implementar validadores
		
		ProdutoDao dao = new ProdutoDao();
		dao.insertProduto(produto);		
	}
	
	public List<ProdutoBean> listarProduto(){
		
		ProdutoDao dao = new ProdutoDao();
		return dao.listarProduto();
	}
	
	public void excluirProduto(Integer codigo){
		
		ProdutoDao dao = new ProdutoDao();
		dao.excluirProduto(codigo);		
	}
	
	public ProdutoBean buscarProdutoPorCodigo(Integer codigo){
		ProdutoDao dao = new ProdutoDao();
		return dao.buscarProdutoPorCodigo(codigo);
	}
	
	public void alterarProduto(ProdutoBean produto){
		ProdutoDao dao = new ProdutoDao();
		dao.alterarProduto(produto);
	}
	
	public List<ProdutoBean> pesquisarProduto(ProdutoBean produto){
		ProdutoDao dao = new ProdutoDao();
		return dao.pesquisarProduto(produto);		
	}
}
