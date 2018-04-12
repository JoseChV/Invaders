package logica;

public interface Nodo<T> {
	
	T getValor();
	Nodo<T> getSiguiente();
	Nodo<T> getAnterior();
	void setValor(T valor);
	
}
