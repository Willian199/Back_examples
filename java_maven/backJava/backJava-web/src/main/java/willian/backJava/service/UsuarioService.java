package willian.backJava.service;

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
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import willian.backJava.dto.UsuarioDTO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;

@Path("/usuarioService")
@RequestScoped
public interface UsuarioService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> buscarTodos();

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarPorId(@PathParam("id") Long id);

	@GET
	@Path("/buscarPorNome")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> buscarPorNome(@QueryParam("nome") String nome);

	@GET
	@Path("/buscarPorLogin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> buscarPorLogin(@QueryParam("login") String login);

	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean salvar(UsuarioDTO usuarioDTO) throws ParseException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;

	@DELETE
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean deletar(@QueryParam("id") Long id);

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(UsuarioLoginDTO usuarioLoginDTO) throws Exception;

}
