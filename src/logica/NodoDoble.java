package logica;

public class NodoDoble {
	private Enemy valor;
	private NodoDoble siguiente;
	private NodoDoble anterior;
	
	public NodoDoble(Enemy valor) {
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}
	public Enemy getValor() {
		return this.valor;
	}
	public void setValor(Enemy valor) {
		this.valor = valor;
	}
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDoble getSiguiente() {
		return this.siguiente;
	}
	public NodoDoble getAnterior() {
		return this.anterior;
	}
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
}
