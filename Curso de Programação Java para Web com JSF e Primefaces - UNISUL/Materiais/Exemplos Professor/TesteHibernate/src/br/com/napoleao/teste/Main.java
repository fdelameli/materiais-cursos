package br.com.napoleao.teste;

import br.com.napoleao.teste.dao.AtendimentoDAO;


public class Main {

	public static void main(String[] args) {

		
//		AtendimentoEntity ate = new AtendimentoEntity();
//		ate.setIdentificao("Teste");
//
//		PacienteEntity p1 = new PacienteEntity();
//		p1.setNome("Rogerio 2");
//		p1.setAtendimento(ate);
//		
//		PacienteEntity p2 = new PacienteEntity();
//		p2.setNome("Rogerio 3");
//		p2.setAtendimento(ate);
//		
//		List<PacienteEntity> pacientes = new ArrayList<PacienteEntity>();
//		
//		pacientes.add(p1);
//		pacientes.add(p2);
//		
//		ate.setPacientes(pacientes);
//		
//		new AtendimentoDAO().cadastro(ate);
		
//		UsuarioEntity usuario = new UsuarioEntity();
//		usuario.setNome("Teste");
//		
//		EmpresaEntity empresa = new EmpresaEntity();
//		empresa.setDescricao("Teste Empresa");
//		
//		List<EmpresaEntity> emps = new ArrayList<EmpresaEntity>();
//		emps.add(empresa);
//		
//		usuario.setEmpresas(emps);
//		
//		new UsuarioDAO().cadastro(usuario);
		
//		VendaEntity v1 = new VendaEntity();
//		v1.setVenda("Venda");
//		v1.setConfirmacao(TipoConfirmacao.S);
//		new VendaDAO().cadastro(v1);
//		
//		ProdutoEntity p1 = new ProdutoEntity();
//		p1.setDescricao("Desc");
//		new ProdutoDAO().cadastro(p1);
//		
//		VendaItemEntity vit = new VendaItemEntity();
		
//		VendaItemId vitId = new VendaItemId();
//		vitId.setProduto(p1);
//		vitId.setVenda(v1);
		
//		vit.setVendaItId(vitId);
//		vit.setProduto(p1);
//		vit.setVenda(v1);
//		vit.setQtd(3);
		
//		new VendaItemDAO().cadastro(vit);
		
//		System.out.println(new VendaItemDAO().buscarPorId(VendaItemEntity.class).getQtd());
		
		new AtendimentoDAO().buscarFiltrado(null);
	}
}
