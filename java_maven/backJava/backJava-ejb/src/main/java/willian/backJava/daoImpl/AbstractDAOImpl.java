package willian.backJava.daoImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import willian.backJava.dao.AbstractDAO;
import willian.backJava.util.JPAGeneric;

@Stateless
public abstract class AbstractDAOImpl<T> extends JPAGeneric<T> implements AbstractDAO<T> {

	private Class<T> entityClass;

	@Inject
	private EntityManager entityManager;

	/**
	 * Para toda classe DAO que extende essa classe precisa ter @override do init
	 * Adicionar também @PostConstruct
	 * 
	 * Na implementação do metodo definir o EntityManager e o model
	 * setEntityManager(em); setEntityClass(Usuario.class);
	 * 
	 */
	@PostConstruct
	abstract protected void init();

	protected void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected Class<T> getEntityClass() {
		return this.entityClass;
	}

	protected CriteriaQuery<T> getCriteriaQuery() {
		return entityManager.getCriteriaBuilder().createQuery(entityClass);
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void excluir(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void excluirPorId(Long id) {
		T object = this.buscarPorId(id);
		this.excluir(object);

	}

	@Override
	public List<T> consultarTodos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		query.from(entityClass);
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public T buscarPorId(Long id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public T inserir(T entity) {
		entityManager.persist(entity);
		entityManager.flush();

		return entity;
	}

	@Override
	public T salvar(T entity) throws Exception {
		try {
			Long id = (Long) entity.getClass().getMethod("getId").invoke(entity);

			if (id != null && id != 0L) {
				entityManager.merge(entity);
			} else {
				entityManager.persist(entity);
			}

			entityManager.flush();

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {

			throw new Exception("Não foi possivel salvar o item");
		}

		return entity;

	}

	@Override
	public List<T> salvar(List<T> entity) throws Exception {
		List<T> retorno = new ArrayList<>();
		for (T t : entity) {
			retorno.add(salvar(t));

		}

		return retorno;
	}

	@Override
	public List<T> buscarPorCampo(String campo, String valor) {

		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> fromQuery = query.from(entityClass);

		query.where(builder.equal(fromQuery.get(campo), valor));

		query.select(fromQuery);

		return entityManager.createQuery(query).getResultList();

	}
}
