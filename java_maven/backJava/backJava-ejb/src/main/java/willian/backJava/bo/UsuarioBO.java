package willian.backJava.bo;

import java.util.List;

import willian.backJava.dto.UsuarioDTO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;

public interface UsuarioBO {

	public abstract List<Usuario> buscarTodos();

	public abstract Usuario buscarPorId(Long id);

	public abstract List<Usuario> buscarPorNome(String nome);

	public abstract List<Usuario> buscarPorLogin(String login);

	public abstract Boolean salvar(UsuarioDTO usuarioDTO) throws Exception;

	public abstract Boolean deletar(Long id);

	public abstract String login(UsuarioLoginDTO usuarioLoginDTO) throws Exception;

}
