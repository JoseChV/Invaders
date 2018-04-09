package logica;

public class Prueba {

	public static void main(String[] args) {
		ListaDobleCirc a = new ListaDobleCirc();
		Enemy b = new Enemy();
		Enemy b2 = new Enemy();
		Enemy b3 = new Enemy();
		Enemy b4 = new Enemy();
		Enemy b5 = new Enemy();
		a.add(b);
		a.add(b2);
		a.add(b3);
		a.add(b4);
		a.add(b5);
		NodoDoble e = a.primero;
		int i = 0;
		while( i < a.size) {
			System.out.println(e.getValor());
			e = e.getSiguiente();
			i++;
		}
		i=0;
		a.delete(b);
		a.delete(b2);
		a.delete(b3);
		a.delete(b4);
		a.delete(b5);
		System.out.println();
		e = a.primero;
		while(i< 10){
			System.out.println(e.getValor());
			e = e.getSiguiente();
			i++;
		}
		
	}

}
