package willian.backJava.util;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class AbstractJPASupport {

	private EntityManager entityManager;

	public AbstractJPASupport() {

	}

	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	@Inject
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PostConstruct
	protected void init() throws Exception {
		if (this.entityManager != null) {
			throw new Exception("Atencao! Entity Manager nao inicializado.");
		}
	}
}