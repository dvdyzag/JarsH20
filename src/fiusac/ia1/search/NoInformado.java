package fiusac.ia1.search;
import java.util.*;
public class NoInformado{
	private static Nodo inicial;
	private static int nodos_visitados;
	private static int nodos_creados;
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
		System.out.println("Numero de nodos creados: " + nodos_creados);
		System.out.println("Numero de nodos visitados: " + nodos_visitados);
	}
	/*
	 * Cola FIFO
	 * */
	private static void anchura(){
		nodos_visitados = 1;
		nodos_creados = 1;
		// Ver si nodo inicial es objetivo
		inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.add(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.remove(0); // extraer primer nodo de la lista
			List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
			nodos_creados += sucesores.size(); // # de nodos creados
			// System.out.println("Sucesores creados: " + sucesores.size());
			nodos_visitados++; // # visitados
			for (Nodo sucesor: sucesores){ // por cada sucesor
				
				if (sucesor.isObjetivo()){ // si sucesor es objetivo
					// mostar solución y salir
					System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
					imprimirRecorrido(sucesor);
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
	private static void imprimirRecorrido(Nodo hoja){
		Nodo padre = hoja.getPadre();
		if (padre != null){
			imprimirRecorrido(padre);
		}
		System.out.println(hoja);
	}
	/*private static boolean esObjetivo(Nodo n){
		return n.esObjetivo();
	}*/
}