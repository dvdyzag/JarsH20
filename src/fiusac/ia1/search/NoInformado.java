package fiusac.ia1.search;
import java.util.*;
public class NoInformado{
	// private static Nodo inicial;
	// private static List<Nodo> lista;
	private static int nodos_visitados, nodos_novisitados, nodos_creados, nivel;
	public static int limite;
	public static Algoritmos algoritmo;
	public static final List<Reglas> ordenReglas;
	static {
		 ordenReglas = new ArrayList<>(6);
		 nivel = 0;
		 // lista = new ArrayList<>();
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
		System.out.println("-- ESTADISTICAS --");
		System.out.println("Nivel: " + nivel);
		System.out.println("Numero de nodos creados: " + nodos_creados);
		System.out.println("Numero de nodos visitados: " + nodos_visitados);
		System.out.println("Numero de nodos no visitados: " + nodos_novisitados);
		System.out.println("Algoritmo de busqueda no informada utilizado: " + algoritmo);
		// System.out.println("Numero de nodos no visitados: " + (nodos_creados-nodos_visitados));
	}
	/*
	 * Cola FIFO
	 * */
	private static void anchura(){
		List<Nodo> lista = new ArrayList<>();
		nodos_visitados = 1;
		nodos_creados = 1;
		nodos_novisitados = 0;
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
			nodos_creados += sucesores.size(); // # de nodos creados
			// System.out.println("Sucesores creados: " + sucesores.size());
			nodos_visitados++; // # visitados
			for (Nodo sucesor: sucesores){ // por cada sucesor
				
				if (sucesor.isObjetivo()){ // si sucesor es objetivo
					// mostar solución y salir
					System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
					imprimirRecorrido(sucesor);
					System.out.println("-- SOLUCION: --");
					System.out.println(sucesor);
					nodos_novisitados = lista.size();
					nivel = sucesor.getNivel();
					return;
				}
				lista.add(sucesor);// agregar sucesor AL FINAL de la lista
			} 
		} // fin de do while
		// no encontro solucion
	}
	private static void profundidad(){
		Stack<Nodo> lista = new Stack<>();
		nodos_visitados = 1;
		nodos_creados = 1;
		// Ver si nodo inicial es objetivo
		Nodo inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.push(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.pop(); // extraer primer nodo de la lista
			List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
			nodos_creados += sucesores.size(); // # de nodos creados
			// System.out.println("Sucesores creados: " + sucesores.size());
			nodos_visitados++; // # visitados
			for (Nodo sucesor: sucesores){ // por cada sucesor
				
				if (sucesor.isObjetivo()){ // si sucesor es objetivo
					// mostar solución y salir
					System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
					imprimirRecorrido(sucesor);
					System.out.println("-- SOLUCION: --");
					System.out.println(sucesor);
					nodos_novisitados = lista.size();
					nivel = sucesor.getNivel();
					return;
				}
				lista.push(sucesor);// agregar sucesor AL INICIO de la lista
			} 
		} // fin de do while
	}
	private static void anchura_limitada(){
		List<Nodo> lista = new ArrayList<>();
		nodos_visitados = 1;
		nodos_creados = 1;
		nodos_novisitados = 0;
		// Ver si nodo inicial es objetivo
		Nodo inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.add(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.remove(0); // extraer primer nodo de la lista
			nodos_visitados++; // # visitados
			if (n.getNivel() < limite){
				List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
				nodos_creados += sucesores.size(); // # de nodos creados
				// System.out.println("Sucesores creados: " + sucesores.size());
				for (Nodo sucesor: sucesores){ // por cada sucesor
					
					if (sucesor.isObjetivo()){ // si sucesor es objetivo
						// mostar solución y salir
						System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
						imprimirRecorrido(sucesor);
						System.out.println("-- SOLUCION: --");
						System.out.println(sucesor);
						nodos_novisitados = lista.size();
						nivel = sucesor.getNivel();
						return;
					}
					lista.add(sucesor);// agregar sucesor AL FINAL de la lista
				}
			} else {
				// se supero el limite
				System.out.println("-- -- SOLUCION NO ENCONTRADA -- --");
				nodos_novisitados = lista.size();
				nivel = n.getNivel();
				System.out.println(String.format("Nivel {%d} supera el limite {%d}", nivel, limite));
				return;
			}
		} // fin de do while
		// no encontro solucion
	}
	private static void profundidad_limitada(){
		Stack<Nodo> lista = new Stack<>();
		nodos_visitados = 1;
		nodos_creados = 1;
		nodos_novisitados = 0;
		// Ver si nodo inicial es objetivo
		Nodo inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.push(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.pop(); // extraer primer nodo de la lista
			nodos_visitados++; // # visitados 
			nivel = n.getNivel();
			if (nivel < limite){
				List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
				nodos_creados += sucesores.size(); // # de nodos creados
				// System.out.println("Sucesores creados: " + sucesores.size());
				for (Nodo sucesor: sucesores){ // por cada sucesor
					
					if (sucesor.isObjetivo()){ // si sucesor es objetivo
						// mostar solución y salir
						System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
						imprimirRecorrido(sucesor);
						System.out.println("-- SOLUCION: --");
						System.out.println(sucesor);
						nodos_novisitados = lista.size();
						nivel = sucesor.getNivel();
						return;
					}
					lista.push(sucesor);// agregar sucesor AL INICIO de la lista
				}
			} //
			// System.out.println("topo con limite " + limite);
		} // fin de do while
		// no encontro solucion
		// se supero el limite
		System.out.println("-- -- SOLUCION NO ENCONTRADA -- --");
		nodos_novisitados = lista.size();
		System.out.println(String.format("Nivel {%d} supera el limite {%d}", nivel, limite));
	}
	private static void backjumping(){
		Stack<Nodo> lista = new Stack<>();
		nodos_visitados = 1;
		nodos_creados = 1;
		nodos_novisitados = 0;
		// Ver si nodo inicial es objetivo
		Nodo inicial = new Nodo();
		if (inicial.isObjetivo()){
			System.out.println("Solucion: " + inicial);
			return; // salir
		}
		lista.push(inicial); // inicializar la lista con nodo inicial
		for (;!lista.isEmpty();){ // do while improvisado
			Nodo n = lista.pop(); // extraer primer nodo de la lista
			nodos_visitados++; // # visitados
			nivel = n.getNivel();
			if (nivel < limite){
				List<Nodo> sucesores = n.generarSucesores(); // generar sus sucesores en orden indicado
				nodos_creados += sucesores.size(); // # de nodos creados
				// System.out.println("Sucesores creados: " + sucesores.size());
				for (Nodo sucesor: sucesores){ // por cada sucesor
					
					if (sucesor.isObjetivo()){ // si sucesor es objetivo
						// mostar solución y salir
						System.out.println("-- -- Imprimiendo el recorrido solucion -- --");
						imprimirRecorrido(sucesor);
						System.out.println("-- SOLUCION: --");
						System.out.println(sucesor);
						nodos_novisitados = lista.size();
						nivel = sucesor.getNivel();
						return;
					}
					lista.push(sucesor);// agregar sucesor AL INICIO de la lista
				}
			} else {
				cicloLimpiar: while(!lista.isEmpty()){
					//System.out.println("Crash");
					int npico = lista.peek().getNivel(); // obtener el nivel del nodo encima de la pila
					if (npico > 1){ // eliminar el nodo no sucesor del nodo inicial
						//System.out.println(lista.pop()); // expulsar de la pila
						lista.pop();
					} else {
						break cicloLimpiar; // solo quedaron sucesores del nodo inicial
					}
				}
			} //
			// System.out.println("topo con limite " + limite);
		} // fin de do while
		// no encontro solucion
		// se supero el limite
		System.out.println("-- -- SOLUCION NO ENCONTRADA -- --");
		nodos_novisitados = nodos_creados - nodos_visitados;
		System.out.println(String.format("Nivel {%d} supera el limite {%d}", nivel, limite));
	}
	private static void imprimirRecorrido(Nodo hoja){
		Nodo padre = hoja.getPadre();
		if (padre != null){
			imprimirRecorrido(padre);
		}
		System.out.println(hoja);
	}
}