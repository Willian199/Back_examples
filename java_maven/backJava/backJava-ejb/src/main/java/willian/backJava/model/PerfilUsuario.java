package willian.backJava.model;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "tb_perfilUsuario", uniqueConstraints = @UniqueConstraint(columnNames = "cd_tipo"))
public class PerfilUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20)
	@Pattern(regexp = "[^0-9]*", message = "O campo tipoUsuario não pode conter números")
	@Column(name = "cd_tipo")
	private String tipo;

	@OneToMany(mappedBy = "perfilUsuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Usuario> usuario;

	public PerfilUsuario(String tipo, Usuario... usuario) {
		this.tipo = tipo;
		this.usuario = Stream.of(usuario).collect(Collectors.toSet());
		this.usuario.forEach(x -> x.setPerfilUsuario(this));
	}

}
