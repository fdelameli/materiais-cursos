package br.com.napoleao.teste.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
//Sequence para Oracle
//@SequenceGenerator(name = "nome_sequence_java", 
//sequenceName = "nome_sequence_banco")
public class PacienteEntity implements Serializable{

	@Id
	//Sequence para Oracle
	//@GeneratedValue(generator = "nome_sequence_java", 
	//			strategy = GenerationType.SEQUENCE)
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private LocalizacaoEntity localizacao;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_atendimento", referencedColumnName = "id")
	private AtendimentoEntity atendimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalizacaoEntity getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoEntity localizacao) {
		this.localizacao = localizacao;
	}

	public AtendimentoEntity getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(AtendimentoEntity atendimento) {
		this.atendimento = atendimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteEntity other = (PacienteEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
