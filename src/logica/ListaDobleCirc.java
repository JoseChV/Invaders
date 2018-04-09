package logica;

public class ListaDobleCirc {
	public NodoDoble primero;
	public int size;
	
	public void add(Enemy valor) {
		NodoDoble nuevo = new NodoDoble(valor);
		if(empty()==true) {
			this.primero = nuevo;
			primero.setSiguiente(primero);
			primero.setAnterior(primero);
		}else {
			nuevo.setSiguiente(primero);
			nuevo.setAnterior(primero.getAnterior());
			primero.setAnterior(nuevo);
			nuevo.getAnterior().setSiguiente(nuevo);
			}
		size ++;
	}
	public boolean empty() {
		return this.primero == null;
	}
	public void delete(Enemy valor) {
		if(primero.getValor() == valor) {
			if(this.size != 1) {
				this.primero.getAnterior().setSiguiente(primero.getSiguiente());
				this.primero.getSiguiente().setAnterior(primero.getAnterior());
				this.primero = primero.getSiguiente();
			}else {
				this.primero=null;
			}
		}else {
			NodoDoble temp = this.primero;
			while(temp.getValor() != valor) {
				temp = temp.getSiguiente();
			}
			temp.getAnterior().setSiguiente(temp.getSiguiente());
			temp.getSiguiente().setAnterior(temp.getAnterior());
		}
		size --;
		
	}
}
