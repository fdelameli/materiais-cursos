package meubanco.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import meubanco.dao.PessoaDAO;
import meubanco.domain.Pessoa;
import framework.dao.ConexaoBanco;

public class TesteConexao {

	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			Connection con = ConexaoBanco.getInstance().getConnection();
			System.out.println("Conexao estabelecida com sucesso!");
			
			PessoaDAO pessoaDao = new PessoaDAO();
			
			Pessoa newPessoa = new Pessoa();
			newPessoa.setCdPessoa(200);
			newPessoa.setNmPessoa("Aurelio Filho");
			pessoaDao.delete(newPessoa);
			
			List<Pessoa> pessoaList = new ArrayList<Pessoa>();
			pessoaList = pessoaDao.findAll();
			for (Pessoa pessoa : pessoaList) {
				System.out.println("Codigo: " + pessoa.getCdPessoa() + "  --  Nome: " + pessoa.getNmPessoa());
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				ConexaoBanco.getInstance().closeConnection();
				System.out.println("Conexao fechada com sucesso!");
			} catch (Exception e){
				System.err.println("Erro ao fechar conexao");
			}
		}
	}
		
}
