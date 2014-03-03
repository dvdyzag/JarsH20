package fiusac.ia1.search;
import java.util.*;
public class NoInformado{
	public static int limite;
	public static Algoritmos algoritmo;
	public static final List<Reglas> ordenReglas;
	private static final List<Nodo> lista;
	static {
		 ordenReglas = new ArrayList<>(6);
		 lista = new ArrayList<>();
	}
	public static void iniciar(){
		switch (algoritmo){
			case ANCHURA:
				anchura();
				break;
			case PROFUNDIDAD:
				profundidad();
				break;
			case ANCHURA_LIMITADA:
				anchura_limitada();
				break;
			case PROFUNDIDAD_LIMITADA:
				profundidad_limitada();
				break;
			case BACKJUMPING:
				backjumping();
				break;
		}
	}
	/*
	 * Cola FIFO
	 * */
	private static void anchura(){
		// Ver si nodo inicial es objetivo
		Nodo inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.add(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.remove(0); // extraer primer nodo de la lista
			List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
			// System.out.println("Sucesores creados: " + sucesores.size());
			for (Nodo sucesor: sucesores){ // por cada sucesor
				if (sucesor.isObjetivo()){ // si sucesor es objetivo
					// mostar solución y salir
					System.out.println("Solucion: " + sucesor);
					return;
				}
				lista.add(sucesor);// agregar sucesor AL INICIO de la lista
			} 
		} // fin de do while
	}
	private static void profundidad(){
		
	}
	private static void anchura_limitada(){
		
	}
	private static void profundidad_limitada(){
		
	}
	private static void backjumping(){
		
	}
	/*private static boolean esObjetivo(Nodo n){
		return n.esObjetivo();
	}*/
}