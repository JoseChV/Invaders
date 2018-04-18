package logica;

import entidades.Banshee;
import entidades.Enemy;

public class Prueba {

	public static void main(String[] args) {
		Lista<Enemy> lista = new ListaDobleCirc();
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		lista.add(new Banshee(null, null, 0, 0, 0, 0, 0, 0));
		
		for(Nodo<Enemy> b = lista.getPrimero(); b.getSiguiente() != lista.getPrimero() ; b = b.getSiguiente()) {
			System.out.println(b);
			lista.delete(b.getValor());
		}
		System.out.println();
		for(Nodo<Enemy> b = lista.getPrimero(); b.getSiguiente() != lista.getPrimero() ; b = b.getSiguiente()) {
			System.out.println(b);
		}
	}

}
