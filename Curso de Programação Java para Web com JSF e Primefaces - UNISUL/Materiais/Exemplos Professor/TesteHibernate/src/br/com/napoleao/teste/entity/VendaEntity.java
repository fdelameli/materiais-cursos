package br.com.napoleao.teste.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.napoleao.teste.enums.TipoConfirmacao;

@Entity
@Table(name = "VENDA")
public class VendaEntity implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String venda;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CONF", length = 1)
	private TipoConfirmacao confirmacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenda() {
		return venda;
	}

	public void setVenda(String venda) {
		this.venda = venda;
	}

	public TipoConfirmacao getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(TipoConfirmacao confirmacao) {
		this.confirmacao = confirmacao;
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
		VendaEntity other = (VendaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
