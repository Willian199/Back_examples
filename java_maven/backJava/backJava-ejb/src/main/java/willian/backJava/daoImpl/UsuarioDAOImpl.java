package willian.backJava.daoImpl;

import static willian.backJava.model.QUsuario.usuario;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.sql.JPASQLQuery;

import willian.backJava.dao.UsuarioDAO;
import willian.backJava.dto.UsuarioLoginDTO;
import willian.backJava.model.Usuario;

@Stateless
public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario> implements UsuarioDAO {

	@Override
	@PostConstruct
	protected void init() {
		setEntityClass(Usuario.class);

	}

	@Override
	public UsuarioLoginDTO login(UsuarioLoginDTO usuarioLoginDTO) {

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(usuario.senha.eq(usuarioLoginDTO.getSenha()));
		booleanBuilder.and(usuario.login.eq(usuarioLoginDTO.getLogin()));

		JPASQLQuery<Usuario> query = sqlQuery().from(usuario);
		query.where(booleanBuilder);

		return query.select(Projections.constructor(UsuarioLoginDTO.class, usuario.login.stringValue(),
				usuario.senha.stringValue())).fetchFirst();

	}
}
