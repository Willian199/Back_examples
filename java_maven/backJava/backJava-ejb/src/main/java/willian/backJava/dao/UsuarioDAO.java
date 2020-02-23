package willian.backJava.dao;

import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;

public interface UsuarioDAO extends AbstractDAO<Usuario> {

	public abstract UsuarioLoginDTO login(UsuarioLoginDTO usuarioLoginDTO);

}
