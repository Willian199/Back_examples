package willian.backJava.dao;

import java.util.List;

public interface AbstractDAO<T> {

	T buscarPorId(Long id);

	T inserir(T entity);

	void excluir(T entity);

	List<T> consultarTodos();

	T salvar(T entity) throws Exception;

	void excluirPorId(Long id);

	List<T> salvar(List<T> entity) throws Exception;

	List<T> buscarPorCampo(String campo, String valor);

}