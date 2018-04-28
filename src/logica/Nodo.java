package logica;
/**
 * Nodo que contiene datos en las listas.
 * @author Jose Andres Ch
 *
 * @param <T> tipo de dato que contiene.
 */
public interface Nodo<T> {
	/**
	 * Retorna el valor contenido
	 * @return valor
	 */
	T getValor();
	/**
	 * Retorna el nodo siguiente
	 * @return Siguiente
	 */
	Nodo<T> getSiguiente();
	/**
	 * Retorna el nodo anterior. Puede ser nulo
	 * @return Anterior
	 */
	Nodo<T> getAnterior();
	/**
	 * Ingresa un valor en el nodo
	 * @param valor dato a ingresar.
	 */
	void setValor(T valor);
	
}
