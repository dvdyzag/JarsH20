package fiusac.ia1.search;
import java.util.*;
public class Nodo{
	private Jarra jarra4L, jarra3L;
	public static final List<Integer> ordenReglas;
	static {
		 ordenReglas = new ArrayList<>(6);
	}
	/*
	* Este Constructor es utilizado unica y exclusivamente para el nodo inicial
	*/
	public Nodo(){
		jarra4L = new Jarra(4);
		jarra3L = new Jarra(3);
	}
	/*
	* Este Constructor es utilizado para crear nodos sucesores
	* @param jarr4L Jarra de 4 Litros de capacidad
	* @param jarr3L Jarra de 3 Litros de capacidad
	*/
	public Nodo(Jarra jarra4L, Jarra jarra3L){
		this.jarra4L = jarra4L;
		this.jarra3L = jarra3L;
	}
	/*
	* Genera sucesores del Nodo actual
	* @return Lista de sucedores creados segun el orden de las reglas
	*/
	public List<Nodo> generarSucesores(){
		List<Nodo> sucesores = new ArrayList<>(6);
		Nodo n = null;
		for (regla:ordenReglas){
			try{
				switch(regla){
					case 1:
						//llenar Jarra de 4L
						n = new Nodo(jarra4L.llenar(), jarra3L);//(4L, 3L)
					case 2:
						//llenar Jarra de 3L
						n = new Nodo(jarra4L, jarra3L.llenar());//(4L, 3L)
					case 3:
						//vaciar Jarra de 4L
						n = new Nodo(jarra4L.vaciar(), jarra3L);//(4L, 3L)
					case 4:
						//vacia Jarra de 3L
						n = new Nodo(jarra4L, jarra3L.vaciar());//(4L, 3L)
					case 5:
						//traladar Jarra de 4L a Jarra de 3L
						List<Jarra> retorno = jarra4L.traslado(jarra3L);
						n = new Nodo(retorno.get(0), retorno.get(1));//(4L, 3L)
					case 6:
						//traladar Jarra de 3L a Jarra de 4L
						retorno = jarra3L.traslado(jarra4L);
						n = new Nodo(retorno.get(1), retorno.get(0)); //(4L, 3L)
				}
				sucesores.add(n);
			} catch(JarraException je){
				System.out.println("Regla no aplicable");
			}
			
		}
		return sucesores;
	}
}