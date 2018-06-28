package revenda.gui;

import java.awt.Event;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import revenda.service.CategoriaService;
import revenda.service.MontadoraService;
import revenda.service.VeiculoService;
import framework.gui.ListFrameBase;
import framework.gui.PrincipalFrameBase;
import framework.gui.components.MenuBase;
import framework.gui.components.MenuItemBase;
import framework.gui.util.Messages;

public class FramePrincipal extends PrincipalFrameBase {

	private static final long serialVersionUID = 1L;
	
	private CategoriaList categoriaList;
	private VeiculoList veiculoList;
	private MontadoraList montadoraList;
	private MenuItemBase menuItemCategoria;
	private MenuItemBase menuItemVeiculo;
	private MenuItemBase menuItemMontadora;
	private MenuItemBase menuItemRelVeiculo;
	private MenuItemBase menuItemRelMontadora;
	private MenuItemBase menuItemRelCategoria;
	private MenuItemBase menuItemAlterarSenha;
	private MenuItemBase menuItemSair;

	
	public FramePrincipal() {
		super("Revenda Tabajara");
	}

	
	
	@Override
	protected ListFrameBase menuItemClick(Object source) {
		if (source == menuItemCategoria) {
			return abreFrameCategoriaList();
		}
		
		if (source == menuItemVeiculo) {
			return abreFrameVeiculoList();
		}
		if (source == menuItemMontadora) {
			return abreFrameMontadoraList();
		}
		
		if (source == menuItemRelCategoria) {
			montaRelatorioCategoria();
		}
		
		if (source == menuItemRelMontadora) {
			montaRelatorioMontadora();
		}
		
		if (source == menuItemRelVeiculo) {
			montaRelatorioVeiculo();
		}
		
		if (source == menuItemSair) {
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?",
					"Fechar programa!", JOptionPane.YES_NO_OPTION);
			if (opcao == 0)
				System.exit(0);
		}

		return null;
	}
	
	@Override
	protected void montaMenuArquivo(MenuBase menuArquivo) {
		menuItemSair = new MenuItemBase("Sair");
		menuItemSair.setMnemonic(KeyEvent.VK_S);
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));
		menuItemSair.addActionListener(this);
		menuArquivo.add(menuItemSair);
	}

	@Override
	protected void montaMenuCadastro(MenuBase menuCadastro) {
		menuItemCategoria = new MenuItemBase("Categoria");
		menuItemCategoria.setMnemonic(KeyEvent.VK_C);
		menuItemCategoria.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		menuItemCategoria.addActionListener(this);
		menuCadastro.add(menuItemCategoria);
		
		menuItemMontadora = new MenuItemBase("Montadoras");
		menuItemMontadora.setMnemonic(KeyEvent.VK_M);
		menuItemMontadora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
		menuItemMontadora.addActionListener(this);
		menuCadastro.add(menuItemMontadora);
		
		menuItemVeiculo = new MenuItemBase("Veículo");
		menuItemVeiculo.setMnemonic(KeyEvent.VK_V);
		menuItemVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
		menuItemVeiculo.addActionListener(this);
		menuCadastro.add(menuItemVeiculo);
		
	}

	@Override
	protected void montaMenuRelatorio(MenuBase menuRelatorio) {
		menuItemRelCategoria = new MenuItemBase("Categorias");
		menuItemRelCategoria.setMnemonic(KeyEvent.VK_T);
		menuItemRelCategoria.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		menuItemRelCategoria.addActionListener(this);
		menuRelatorio.add(menuItemRelCategoria);
		
		menuItemRelMontadora = new MenuItemBase("Montadoras");
		menuItemRelMontadora.setMnemonic(KeyEvent.VK_D);
		menuItemRelMontadora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
		menuItemRelMontadora.addActionListener(this);
		menuRelatorio.add(menuItemRelMontadora);
		
		menuItemRelVeiculo = new MenuItemBase("Veículos");
		menuItemRelVeiculo.setMnemonic(KeyEvent.VK_L);
		menuItemRelVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
		menuItemRelVeiculo.addActionListener(this);
		menuRelatorio.add(menuItemRelVeiculo);
		
	}
	
	@Override
	protected void montaMenuSeguranca(MenuBase menuSeguranca) {
		menuItemAlterarSenha = new MenuItemBase("Alterar Login");
		menuItemAlterarSenha.setMnemonic(KeyEvent.VK_N);
		menuItemAlterarSenha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.SHIFT_MASK));
		menuItemAlterarSenha.addActionListener(this);
		menuSeguranca.add(menuItemAlterarSenha);
		
	}
	
	
	// MÉTODOS PRIVADOS AUXILIARES \\
	
	
	private ListFrameBase abreFrameCategoriaList() {
		if (categoriaList != null) {
			categoriaList.dispose();
			categoriaList = null;
		}
		categoriaList = new CategoriaList("Categorias");
		categoriaList.showList();
		return categoriaList;
	}

	private ListFrameBase abreFrameMontadoraList() {
		if (montadoraList != null) {
			montadoraList.dispose();
			montadoraList = null;
		}
		montadoraList = new MontadoraList("Montadoras");
		montadoraList.showList();
		return montadoraList;
	}

	private ListFrameBase abreFrameVeiculoList() {
		if (veiculoList != null) {
			veiculoList.dispose();
			veiculoList = null;
		}
		veiculoList = new VeiculoList("Veículos");
		veiculoList.showList();
		return veiculoList;
	}
	
	
	/**
	 * Este método monta um relatório de Categorias.
	 */
	private void montaRelatorioCategoria() {
		try {
			// Pega o esqueleto do relatório
			JasperReport esqueletoRelatorio = (JasperReport)JRLoader.loadObject(
					getClass().getResourceAsStream("/report/RelCategoria.jasper"));
			
			// Transforma a lista em DataSourse.
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new CategoriaService().findAll());
			
			// Preenche o relatório com os dados.
			JasperPrint relatorioFinal = JasperFillManager.fillReport(esqueletoRelatorio, null, ds);
			
			// Gera o relatório em arquivo PDF
//			JasperExportManager.exportReportToPdfFile(relatorioFinal, "RelPessoa.pdf");
			
			// Visualiza o relatório no visualizador padrão do Jasper.
			JasperViewer.viewReport(relatorioFinal, false);
			
		} catch (Exception e) {
			Messages.showError("Erro ao montar Relatório");
			e.printStackTrace();
		}
	}
	
	/**
	 * Este método monta um relatório de Categorias.
	 */
	private void montaRelatorioMontadora() {
		try {
			// Pega o esqueleto do relatório
			JasperReport esqueletoRelatorio = (JasperReport)JRLoader.loadObject(
					getClass().getResourceAsStream("/report/RelMontadora.jasper"));
			
			// Transforma a lista em DataSourse.
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new MontadoraService().findAll());
			
			// Preenche o relatório com os dados.
			JasperPrint relatorioFinal = JasperFillManager.fillReport(esqueletoRelatorio, null, ds);
			
			// Gera o relatório em arquivo PDF
//			JasperExportManager.exportReportToPdfFile(relatorioFinal, "RelPessoa.pdf");
			
			// Visualiza o relatório no visualizador padrão do Jasper.
			JasperViewer.viewReport(relatorioFinal, false);
			
		} catch (Exception e) {
			Messages.showError("Erro ao montar Relatório");
			e.printStackTrace();
		}
	}
	
	/**
	 * Este método monta um relatório de Categorias.
	 */
	private void montaRelatorioVeiculo() {
		try {
			// Pega o esqueleto do relatório
			JasperReport esqueletoRelatorio = (JasperReport)JRLoader.loadObject(
					getClass().getResourceAsStream("/report/RelVeiculo.jasper"));
			
			// Transforma a lista em DataSourse.
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new VeiculoService().findPersonalizable());
			
			// Preenche o relatório com os dados.
			JasperPrint relatorioFinal = JasperFillManager.fillReport(esqueletoRelatorio, null, ds);
			
			// Gera o relatório em arquivo PDF
//			JasperExportManager.exportReportToPdfFile(relatorioFinal, "RelPessoa.pdf");
			
			// Visualiza o relatório no visualizador padrão do Jasper.
			JasperViewer.viewReport(relatorioFinal, false);
			
		} catch (Exception e) {
			Messages.showError("Erro ao montar Relatório");
			e.printStackTrace();
		}
	}

}
