package logica;

public class ListaCirc<T> implements Lista<T>{
	public NodoSimple<T> primero;
	public int size;
	
	public void add(T valor) {
		NodoSimple<T> nuevo = new NodoSimple<T>(valor);
		if(empty()==true) {
			this.primero = nuevo;
		}else {
			NodoSimple<T> temp = this.primero;
			while(temp.getSiguiente() != this.primero) {
				temp = temp.getSiguiente();
			}
			temp.setSiguiente(nuevo);
		}
		nuevo.setSiguiente(primero);
		size ++;
	}
	public boolean empty() {
		return this.primero == null;
	}
	public void delete(T valor) {
		if(primero.getValor() == valor) {
			if(this.size != 1) {
				NodoSimple<T> temp = this.primero;
				while(temp.getSiguiente() != this.primero) {
					temp = temp.getSiguiente();
				}
				this.primero = primero.getSiguiente();
				temp.setSiguiente(this.primero);
			}else {
				this.primero=null;
			}
		}else {
			NodoSimple<T> temp = this.primero;
			while(temp.getSiguiente().getValor() != valor) {
				temp = temp.getSiguiente();
			}
			NodoSimple<T> siguiente = temp.getSiguiente().getSiguiente();
			temp.setSiguiente(siguiente);
		}
		size --;
		
	}
	@Override
	public Nodo<T> getPrimero() {
		return primero;
	}
	@Override
	public Nodo<T> getUltimo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
