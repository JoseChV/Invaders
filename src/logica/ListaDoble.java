package logica;

public class ListaDoble {

	public NodoDoble primero;
	public NodoDoble ultimo;
	public int size;
	
	public void add(Enemy valor) {
		NodoDoble nuevo = new NodoDoble(valor);
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
	public void delete(Enemy valor) {
		if(primero.getValor() == valor) {
			this.primero = primero.getSiguiente();
			if(this.primero!=null) {
				this.primero.setAnterior(null);
			}
		}else {
			NodoDoble temp = this.primero;
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
}
