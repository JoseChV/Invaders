package logica;
/**
 * Lista circular doblemente enlazada
 * @author Jose Andres Ch
 *
 * @param <T> Tipo de dato a utilizar.
 */
public class ListaDobleCirc<T> implements Lista<T>{
	public NodoDoble<T> primero;
	public int size;
	
	public void add(T valor) {
		NodoDoble<T> nuevo = new NodoDoble<T>(valor);
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
	public void delete(T valor) {
		if(primero.getValor() == valor) {
			if(this.size != 1) {
				this.primero.getAnterior().setSiguiente(primero.getSiguiente());
				this.primero.getSiguiente().setAnterior(primero.getAnterior());
				this.primero = primero.getSiguiente();
			}else {
				this.primero=null;
			}
		}else {
			NodoDoble<T> temp = this.primero;
			while(temp.getValor() != valor) {
				temp = temp.getSiguiente();
			}
			temp.getAnterior().setSiguiente(temp.getSiguiente());
			temp.getSiguiente().setAnterior(temp.getAnterior());
		}
		size --;
		System.out.println(size);
		
	}
	@Override
	public Nodo<T> getPrimero() {
		return primero;
	}
	@Override
	public Nodo<T> getUltimo() {
		return primero.getAnterior();
	}
	@Override
	public void print() {
		NodoDoble<T> temp = this.primero;
		while(temp.getSiguiente() != this.primero) {
			System.out.println(temp.getValor());
			temp = temp.getSiguiente();
		}
		System.out.println(temp);		
	}
	@Override
	public void bubbleSort() {
		
	}
}
