package willian.backJava.serviceImpl;

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
import javax.inject.Inject;

import willian.backJava.bo.UsuarioBO;
import willian.backJava.dto.UsuarioDTO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;
import willian.backJava.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioBO usuarioBO;

	@Override
	public List<Usuario> buscarTodos() {

		return usuarioBO.buscarTodos();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioBO.buscarPorId(id);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return usuarioBO.buscarPorNome(nome);
	}

	@Override
	public List<Usuario> buscarPorLogin(String login) {
		return usuarioBO.buscarPorLogin(login);
	}

	@Override
	public Boolean salvar(UsuarioDTO usuarioDTO) throws ParseException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return usuarioBO.salvar(usuarioDTO);
	}

	@Override
	public Boolean deletar(Long id) {
		return usuarioBO.deletar(id);
	}

	@Override
	public String login(UsuarioLoginDTO usuarioLoginDTO) throws Exception {
		return usuarioBO.login(usuarioLoginDTO);
	}

}
