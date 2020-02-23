package willian.backJava.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import willian.backJava.model.Usuario;

@Stateless
public class UsuarioData {

	@Inject
	private Logger log;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Usuario> usuarioEvento;

	public Usuario salvar(Usuario usuario) throws Exception {
		entityManager.persist(usuario);
		usuarioEvento.fire(usuario);
		return usuario;
	}

	public void excluir(Usuario entity) {

		entityManager.remove(entity);
		entityManager.flush();
	}

	public void excluirPorId(Long id) {
		Usuario object = this.buscarPorId(id);
		this.excluir(object);

	}

	public Usuario buscarPorId(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	public Usuario inserir(Usuario entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	public List<Usuario> salvar(List<Usuario> entity) throws Exception {
		List<Usuario> retorno = new ArrayList<>();
		for (Usuario t : entity) {
			retorno.add(salvar(t));

		}

		return retorno;
	}

}
