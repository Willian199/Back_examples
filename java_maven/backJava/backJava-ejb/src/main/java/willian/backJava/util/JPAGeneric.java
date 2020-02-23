package willian.backJava.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.PostgreSQLTemplates;

public abstract class JPAGeneric<T> {

	@Inject
	private EntityManager entityManager;

	public JPASQLQuery<T> sqlQuery() {
		return new JPASQLQuery<>(entityManager, PostgreSQLTemplates.DEFAULT);
	}

	public JPAQuery<T> jpaQuery() {
		return new JPAQuery<>(entityManager, JPQLTemplates.DEFAULT);
	}

	public JPAQueryFactory jpaFactory() {
		return new JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager);
	}

	public JPQLQuery<T> jpaSubQuery(EntityPath<T> table) {
		return JPAExpressions.selectFrom(table);
	}
}
