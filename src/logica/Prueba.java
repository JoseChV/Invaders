package logica;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Phantom;

public class Prueba {

	public static void main(String[] args) {
		Lista<Enemy> b = new ListaCirc<Enemy>();
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 0));
		b.add(new Phantom(null, null, 0, 0, 0, 0, 0, 0, 1));
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 2));
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 3));
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 4));
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 5));
		b.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0, 6));
		Nodo<Enemy> e = b.getPrimero();
		boolean primero = true;
		while(e!=b.getPrimero() || primero==true) {
			primero = false;
			System.out.println(e.getValor());
			b.delete(e.getValor());
			e = e.getSiguiente();
			
			
		}
		if(b.empty()) {
			System.out.println("a");
		}
	}

}
