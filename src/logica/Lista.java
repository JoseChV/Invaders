package logica;

public interface Lista<T> {
	


	void add(T enemy);
	
	void delete(T enemy);
	
	Nodo<T> getPrimero();
	
	Nodo<T> getUltimo();
	
	boolean empty();

}
