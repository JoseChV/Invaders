package logica;
/**
 *  Lista enlazada
 * @author Jose Andres Ch
 *
 * @param <T> Tipo de datos de la lista.
 */
public interface Lista<T> {
	
	/**
	 * Añade un elemento en la lista
	 * @param enemy Elemento a añadir
	 */
	void add(T enemy);
	/**
	 * Borra un elemento de la lista
	 * @param enemy Elemento a Borrar
	 */
	void delete(T enemy);
	/**
	 * Retorna el primer nodo del la Lista
	 * @return Primer nodo
	 */
	Nodo<T> getPrimero();
	/**
	 * Retorna el ultimo nodo de la lista
	 * @return Ultimo nodo
	 */
	Nodo<T> getUltimo();
	/**
	 * Retorna True si la lista esta vacia
	 * @return Boolean
	 */
	boolean empty();
	/**
	 * Imprime todos los elementos de la lista
	 */
	void print();
	/**
	 * En caso de ser una lista circular, aplica bubble sort con respecto a la vida de los enemigos.
	 */
	void bubbleSort();
}
