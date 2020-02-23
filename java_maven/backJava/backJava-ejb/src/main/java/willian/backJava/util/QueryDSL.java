package willian.backJava.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

public class QueryDSL {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueryDSL.class);

	QueryDSL() {
	}

	/**
	 * Metodo responsável por criar orderBy dinamicamente com base nos dados
	 * passados por parametros
	 * 
	 * @param className
	 *            Diretorio do model que receberá o orderBy
	 *            {@example willian.avstatus.model}
	 * @param model
	 *            Nome do model que possui o field {@example carro}
	 * @param field
	 *            Nome do field a ser usado no orderBy {@example nome}
	 * @param order
	 *            Tipo de ordenação a ser usada {@example ASC/DESC}
	 * @param classePadrao
	 *            Classe padrão para ser usada caso não encontre a informada
	 * 
	 * @return OrderSpecifier Com o field e ordem a ser usada
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static OrderSpecifier<Comparable> createOrderBy(String className, String model, String field, String order,
			Class<?> classePadrao) {
		LOGGER.info("Executando o metodo createOrderBy...");

		PathBuilder<?> newClass = null;
		try {
			Class<? extends Class> classe = Class.forName(className).getClass();
			newClass = new PathBuilder<>(classe, model);
		} catch (ClassNotFoundException e) {
			LOGGER.info("Não foi possivel encontrar a classe informada, usando a classe padrão");
			newClass = new PathBuilder<>(classePadrao.getClass(), model);
		}

		return new OrderSpecifier(Order.valueOf(order.toUpperCase()), newClass.getString(field));

	}

	@SuppressWarnings({ "rawtypes" })
	public static BooleanExpression createFilter(String className, String model, String field, List<Long> values,
			Class<?> classePadrao) {
		LOGGER.info("Executando o metodo createFilter...");

		PathBuilder<?> newClass = null;
		try {
			Class<? extends Class> classe = Class.forName(className).getClass();
			newClass = new PathBuilder<>(classe, model);
		} catch (ClassNotFoundException e) {
			LOGGER.info("Não foi possivel encontrar a classe informada, usando a classe padrão");
			newClass = new PathBuilder<>(classePadrao.getClass(), model);
		}
		return newClass.get(field).in(values);

	}

}
