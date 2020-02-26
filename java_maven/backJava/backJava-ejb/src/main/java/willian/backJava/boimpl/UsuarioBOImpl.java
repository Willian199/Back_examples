package willian.backJava.boimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import willian.backJava.bo.UsuarioBO;
import willian.backJava.dao.UsuarioDAO;
import willian.backJava.dto.UsuarioDTO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;
import willian.backJava.util.CriptografiaAES;

public class UsuarioBOImpl implements UsuarioBO {

	private static final String CHAVE = "WillKey123&";

	@Inject
	private Logger log;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> buscarTodos() {
		log.info("Executando metodo buscarTodos");
		return usuarioDAO.consultarTodos();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		log.info("Executando metodo buscarPorId");
		return usuarioDAO.buscarPorId(id);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		log.info("Executando metodo buscarPorNome");
		return usuarioDAO.buscarPorCampo("nome", nome);
	}

	@Override
	public List<Usuario> buscarPorLogin(String login) {
		log.info("Executando metodo buscarPorLogin");
		return usuarioDAO.buscarPorCampo("login", login);

	}

	@Override
	public Boolean salvar(UsuarioDTO usuarioDTO) throws Exception {
		log.info("Executando metodo salvar");

		Usuario usuario = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String data = formatter.format(new Date());
		Date dataAtual = formatter.parse(data);

		if (usuarioDTO.getId() == null) {

			usuario = new Usuario();

			usuario.setDataCadastro(dataAtual);
			usuario.setDataExclusao(null);
			usuario.setAtivo(Boolean.TRUE);
			usuario.setSenha(usuarioDTO.getSenha());

		} else {
			usuario = usuarioDAO.buscarPorId(usuarioDTO.getId());

		}

		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setDataManutencao(dataAtual);
		usuario.setDataNascimento(formatter.parse(usuarioDTO.getDataNascimento()));

		usuarioDAO.salvar(usuario);

		return Boolean.TRUE;
	}

	@Override
	public Boolean deletar(Long id) {
		log.info("Executando metodo deletar");
		usuarioDAO.excluirPorId(id);
		return Boolean.TRUE;

	}

	@Override
	public String login(UsuarioLoginDTO usuarioLoginDTO) throws Exception {
		log.info("Executando metodo login");

		// String value = CriptografiaAES.encrypt(usuarioLoginDTO.getSenha(), CHAVE);
		// System.out.println(value);
		// usuarioLoginDTO.setSenha(value);

		if (usuarioDAO.login(usuarioLoginDTO) == null) {
			throw new Exception("Login inválido");
		}

		return CriptografiaAES.encrypt(usuarioLoginDTO.getLogin() + usuarioLoginDTO.getSenha(), CHAVE);
	}

}
