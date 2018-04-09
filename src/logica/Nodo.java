package logica;

public class Nodo {
	private Enemy valor;
	private Nodo siguiente;
	
	public Nodo(Enemy valor) {
		this.valor = valor;
		this.siguiente = null;
	}
	public Enemy getValor() {
		return this.valor;
	}
	public void setValor(Enemy valor) {
		this.valor = valor;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getSiguiente() {
		return this.siguiente;
	}
}
