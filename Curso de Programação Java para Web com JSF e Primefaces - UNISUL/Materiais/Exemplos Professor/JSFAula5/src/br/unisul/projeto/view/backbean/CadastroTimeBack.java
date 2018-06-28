package br.unisul.projeto.view.backbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unisul.projeto.core.bo.TimeBO;
import br.unisul.projeto.core.entity.JogadorEntity;
import br.unisul.projeto.core.entity.TimeEntity;

@ManagedBean(name = "cadastroTime")
@ViewScoped
public class CadastroTimeBack {

	private TimeEntity time;
	
	private JogadorEntity jogador;
	private List<JogadorEntity> jogadores;
	
	@PostConstruct
	public void postConstruct(){
		limparCampos();
	}

	private void limparCampos() {
		time = new TimeEntity();
		jogador = new JogadorEntity();
		jogadores = new ArrayList<JogadorEntity>();
	}

	public void adicionarJogador(){
		jogadores.add(jogador);
		jogador = new JogadorEntity();
	}
	
	public void salvar(){
		for (JogadorEntity jogador : jogadores) {
			jogador.setTime(time);
		}

		time.setJogadores(jogadores);
		
		new TimeBO().insert(time);
		
		limparCampos();
	}
	
	public JogadorEntity getJogador() {
		return jogador;
	}

	public void setJogador(JogadorEntity jogador) {
		this.jogador = jogador;
	}

	public TimeEntity getTime() {
		return time;
	}

	public void setTime(TimeEntity time) {
		this.time = time;
	}

	public List<JogadorEntity> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<JogadorEntity> jogadores) {
		this.jogadores = jogadores;
	}
}
