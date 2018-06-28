package br.unisul.projeto.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "login", length = 40, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 40, nullable = false)
	private String senha;
	
	@Column(name = "email", length = 100)
	private String email;

	@JoinColumn(name = "id_tipo_usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoUsuarioEntity tipoUsuario;
	
	public TipoUsuarioEntity getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nome=" + nome + ", login="
				+ login + ", senha=" + senha + ", email=" + email + "]";
	}
	
}
