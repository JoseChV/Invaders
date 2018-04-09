package logica;

public class ListaSimple {
	
	public Nodo primero;
	public int size;
	
	public void add(Enemy valor) {
		Nodo nuevo = new Nodo(valor);
		if(empty()==true) {
			this.primero = nuevo;
		}else {
			Nodo temp = this.primero;
			while(temp.getSiguiente() != null) {
				temp = temp.getSiguiente();
			}
			temp.setSiguiente(nuevo);
		}
		this.size ++;
	}
	public boolean empty() {
		return this.primero == null;
	}
	public void delete(Enemy valor) {
		if(primero.getValor() == valor) {
			this.primero = primero.getSiguiente();
		}else {
			Nodo temp = this.primero;
			while(temp.getSiguiente().getValor() != valor) {
				temp = temp.getSiguiente();
			}
			Nodo siguiente = temp.getSiguiente().getSiguiente();
			temp.setSiguiente(siguiente);
		}
		this.size ++;
	}
	
}

