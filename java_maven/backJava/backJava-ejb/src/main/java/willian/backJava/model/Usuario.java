package willian.backJava.model;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.inject.Model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "tb_usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "tx_email", "tx_login" }))
@Model
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 60)
	@Pattern(regexp = "[^0-9]*", message = "O campo usuário não pode conter números")
	@Column(name = "tx_nome")
	private String nome;

	@Email
	@Column(name = "tx_email", nullable = false)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento", nullable = false)
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro", nullable = false, updatable = false, insertable = true)
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_manutencao", nullable = false)
	private Date dataManutencao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_exclusao", nullable = true)
	private Date dataExclusao;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(name = "tx_login")
	private String login;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	@Column(name = "tx_senha")
	private String senha;

	@Column(name = "fl_ativo", columnDefinition = "boolean default true")
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_tipo", insertable = false, updatable = false)
	private PerfilUsuario perfilUsuario;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

}
