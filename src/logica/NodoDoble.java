package logica;

public class NodoDoble<T> implements Nodo<T>{
	private T valor;
	private NodoDoble<T> siguiente;
	private NodoDoble<T> anterior;
	
	public NodoDoble(T valor) {
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}
	public T getValor() {
		return this.valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public void setSiguiente(NodoDoble<T> siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDoble<T> getSiguiente() {
		return this.siguiente;
	}
	public NodoDoble<T> getAnterior() {
		return this.anterior;
	}
	public void setAnterior(NodoDoble<T> anterior) {
		this.anterior = anterior;
	}
}
