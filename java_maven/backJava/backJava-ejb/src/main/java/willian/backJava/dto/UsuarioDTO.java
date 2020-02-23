package willian.backJava.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioDTO {

	private Long id;

	private String nome;

	private String email;

	private String dataNascimento;

	private String dataCadastro;

	private String dataManutencao;

	private String dataExclusao;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20)
	private String login;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String senha;

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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(String dataExclusao) {
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

}
