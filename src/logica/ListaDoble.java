package logica;

public class ListaDoble<T> implements Lista<T>{

	public NodoDoble<T> primero;
	public NodoDoble<T> ultimo;
	public int size;
	
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
	public boolean empty() {
		return this.primero == null;
	}
	public void delete(T valor) {
		if(primero.getValor() == valor) {
			this.primero = primero.getSiguiente();
			if(this.primero!=null) {
				this.primero.setAnterior(null);
			}
		}else {
			NodoDoble<T> temp = this.primero;
			if(ultimo.getValor()==valor) {
				ultimo.getAnterior().setSiguiente(null);
			}else {
				while(temp.getValor() != valor) {
					temp = temp.getSiguiente();
				}
				temp.getAnterior().setSiguiente(temp.getSiguiente());
			}
				
		}
		this.size --;
		
	}
	@Override
	public Nodo<T> getPrimero() {
		return primero;
	}
	@Override
	public Nodo<T> getUltimo() {
		return ultimo;
	}
}
