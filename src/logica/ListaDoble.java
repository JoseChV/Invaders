package logica;
/**
 * Lista doblemente enlazada
 * @author Jose Andres Ch
 *
 * @param <T> tipo de dato que se va a manejar en la lista.
 */
public class ListaDoble<T> implements Lista<T>{

	public NodoDoble<T> primero;
	public NodoDoble<T> ultimo;
	public int size;
	
	/**
	 * @param <T> dato a ingresar en la lista.
	 */
	public void add(T valor) {
		NodoDoble<T> nuevo = new NodoDoble<T>(valor);
		if(empty()) {
			this.primero = nuevo;
			this.ultimo = nuevo;
		}else {
			this.ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(this.ultimo);
			this.ultimo = nuevo;
		}
		this.size ++;
	}
	/**
	 * @return boolean Es true si la lista es vacia.
	 */
	public boolean empty() {
		return this.primero == null;
	}
	/**
	 * @param <T> dato a borrar de la lista.
	 */
	public void delete(T valor) {
		if(primero.getValor() == valor) {
			this.primero = primero.getSiguiente();
			if(this.primero!=null) {
				this.primero.setAnterior(null);
			}
		}else {
			NodoDoble<T> temp = this.primero;
			while(temp.getValor() != valor) {
				temp = temp.getSiguiente();
			}
			NodoDoble<T> siguiente = temp.getSiguiente();
			if(siguiente==ultimo) {
				ultimo = temp.getAnterior();
				ultimo.setSiguiente(null);
			}else {
				temp.getAnterior().setSiguiente(siguiente);
			}
		}

		this.size --;

	}
	/**
	 * @param Nodo<T> Primer nodo de la lista
	 */
	@Override
	public Nodo<T> getPrimero() {
		return primero;
	}
	/**
	 * @param Nodo<T> Ultimo nodo de la lista
	 */
	@Override
	public Nodo<T> getUltimo() {
		return ultimo;
	}
	/**
	 * Imprime todos los elementos de la lista.
	 */
	@Override
	public void print() {
		NodoDoble<T> e = this.primero;
		while(e != null) {
			System.out.println(e);
		}
	}
	@Override
	public void bubbleSort() {
		
	}
}
