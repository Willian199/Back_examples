package willian.backJava.bo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.ParseException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import willian.backJava.dto.UsuarioDTO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;

public interface UsuarioBO {

	public abstract List<Usuario> buscarTodos();

	public abstract Usuario buscarPorId(Long id);

	public abstract List<Usuario> buscarPorNome(String nome);

	public abstract List<Usuario> buscarPorLogin(String login);

	public abstract Boolean salvar(UsuarioDTO usuarioDTO) throws ParseException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;

	public abstract Boolean deletar(Long id);

	public abstract String login(UsuarioLoginDTO usuarioLoginDTO) throws Exception;

}
