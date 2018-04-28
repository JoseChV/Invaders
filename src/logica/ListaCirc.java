package logica;

import entidades.Enemy;
/**
 * Lista enlazada circularmente
 * @author Jose Andres Ch
 *
 * @param <T> Tipo de dato a utilizar.
 */
public class ListaCirc<T> implements Lista<T>{
	private NodoSimple<T> primero;
	private int size;
	
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
	public void print() {
		NodoSimple<T> temp = this.primero;
		while(temp.getSiguiente() != this.primero) {
			System.out.println(temp.getValor());
			temp = temp.getSiguiente();
		}
		System.out.println(temp);
	}
	
	@Override
	public Nodo<T> getPrimero() {
		return primero;
	}
	@Override
	public Nodo<T> getUltimo() {
		NodoSimple<T> temp = this.primero;
		while(temp.getSiguiente() != this.primero) {
			temp = temp.getSiguiente();
		}
		return temp;
	}
	@Override
	public void bubbleSort() {
		if(size>1) {
			for(int i = 0; i < size; i++) {
				NodoSimple<Enemy> prev = (NodoSimple<Enemy>) this.getUltimo();
				NodoSimple<Enemy> current = (NodoSimple<Enemy>)this.primero;
				NodoSimple<Enemy> next = current.getSiguiente();
				for(int j = 0; j < size; j++) {
					System.out.println(prev.getValor().getHp() + "   " +current.getValor().getHp() + "   " + next.getValor().getHp());
					if(next == this.getUltimo()) {
						j = size;
						System.out.println("break");
					}else if(next.getValor().getHp() > current.getValor().getHp()) {
						System.out.println(true);
						NodoSimple<Enemy> temp = current;
						current.setValor(next.getValor());
						next.setValor(temp.getValor());
						
					}
					prev = prev.getSiguiente();
					current = current.getSiguiente();
					next = next.getSiguiente();
					
				}
			}
		}
		
	}
}
	

