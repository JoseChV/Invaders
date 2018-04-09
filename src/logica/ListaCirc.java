package logica;

public class ListaCirc {
	public Nodo primero;
	public int size;
	
	public void add(Enemy valor) {
		Nodo nuevo = new Nodo(valor);
		if(empty()==true) {
			this.primero = nuevo;
		}else {
			Nodo temp = this.primero;
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
	public void delete(Enemy valor) {
		if(primero.getValor() == valor) {
			if(this.size != 1) {
				Nodo temp = this.primero;
				while(temp.getSiguiente() != this.primero) {
					temp = temp.getSiguiente();
				}
				this.primero = primero.getSiguiente();
				temp.setSiguiente(this.primero);
			}else {
				this.primero=null;
			}
		}else {
			Nodo temp = this.primero;
			while(temp.getSiguiente().getValor() != valor) {
				temp = temp.getSiguiente();
			}
			Nodo siguiente = temp.getSiguiente().getSiguiente();
			temp.setSiguiente(siguiente);
		}
		size --;
		
	}
	

}
