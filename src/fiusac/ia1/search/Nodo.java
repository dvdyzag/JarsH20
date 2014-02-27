package fiusac.ia1.search;
import java.util.*;
public class Nodo{
	private Jarra jarra4L, jarra3L;
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
	private Nodo(Jarra jarra4L, Jarra jarra3L){
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
		for (Reglas regla:NoInformado.ordenReglas){
			try{
				switch(regla){
					case LLENAR4:
						//llenar Jarra de 4L
						n = new Nodo(jarra4L.llenar(), jarra3L);//(4L, 3L)
					case LLENAR3:
						//llenar Jarra de 3L
						n = new Nodo(jarra4L, jarra3L.llenar());//(4L, 3L)
					case VACIAR4:
						//vaciar Jarra de 4L
						n = new Nodo(jarra4L.vaciar(), jarra3L);//(4L, 3L)
					case VACIAR3:
						//vacia Jarra de 3L
						n = new Nodo(jarra4L, jarra3L.vaciar());//(4L, 3L)
					case TRASLADO43:
						//traladar Jarra de 4L a Jarra de 3L
						List<Jarra> retorno = jarra4L.traslado(jarra3L);
						n = new Nodo(retorno.get(0), retorno.get(1));//(4L, 3L)
					case TRASLADO34:
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
	@Override
	public String toString(){
		return String.format("Jarra 4L {%s} Jarra 3L {%s}", jarra4L, jarra3L);
	}
}