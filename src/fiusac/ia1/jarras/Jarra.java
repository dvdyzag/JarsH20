package fiusac.ia1.jarras;
import java.util.*;
public class Jarra {
	private final int capacidad;
	private int ocupacidad;
	/*
	* Inicia la Jarra de capacidad dada y vacia
	* @param capacidad Capacidad de la Jarra mayor que 0
	*/
	public Jarra (int capacidad){
		this.capacidad = capacidad;
	}
	public int getOcupacidad(){
		return ocupacidad;
	}
	/*
	* Inicia la Jarra de capacidad y ocupacidad dada
	* @param capacidad Capacidad de la Jarra mayor que 0
	* @param ocupacidad Ocupacidad de la Jarra mayor que 0 y menor o igual que capacidad
	*/
	public Jarra(int capacidad, int ocupacidad){
		this.capacidad = capacidad;
		if (ocupacidad > capacidad)
			this.ocupacidad = capacidad; // arreglar el error
		else
			this.ocupacidad = ocupacidad; // todo esta dentro de los limites del mundo real
	}
	private int getLibres(){
		return capacidad - ocupacidad;
	}
	/*
	* Presuncion que ocupacidad nunca sera menor que 0
	* @returns True si la Jarra se encuentra vacia
	*/
	private boolean isVacio(){
		return ocupacidad == 0;
	}
	/*
	* Presuncion que la ocupacidad nunca sera mayor que su capacidad
	* @returns True si la Jarra se encuentra llena
	*/
	private boolean isLleno(){
		return ocupacidad == capacidad;
	}
	/*
	* Suma cantidad de litros a la Jarra
	* @param cantidad Siempre mayor a 0
	*/
	/*public void addLitros(int cantidad){
		if (cantidad <= getLibres())
			ocupacidad += cantidad;
		else
			return; //exception
	}*/
	/*
	* Llena la Jarra al tope
	*/
	public Jarra llenar() throws JarraException{
		if (isLleno())
			throw new JarraLlenoException(this);
		Jarra clon = clone();
		clon.ocupacidad = capacidad;
		return clon;
	}
	/*
	* Desocupa el liquido de la Jarra
	*/
	public Jarra vaciar() throws JarraException{
		if (isVacio())
			throw new JarraVacioException(this);
		Jarra clon = clone();
		clon.ocupacidad = 0;
		return clon;
	}
	/*
	* Tralada el liquido de la Jarra jdestino a esta Jarra
	* @param jdestino Instancia de Jarra distinto a la actual
	*/
	public List<Jarra> traslado(Jarra jdestino) throws JarraException{
		if (isVacio())//yo estoy vacio origen
			throw new JarraVacioException(this);
		if (jdestino.isLleno())//destino
			throw new JarraLlenoException(jdestino);
		Jarra origen = clone(), destino = jdestino.clone();
		int destino_libre = jdestino.getLibres();
		
		int traslado = Math.min(ocupacidad, destino_libre);
		origen.ocupacidad -= traslado;
		destino.ocupacidad += traslado;
		
		List<Jarra> jarras = new ArrayList<>(2);
		jarras.add(origen);
		jarras.add(destino);
		return jarras;
	}
	/*
	* @return Representacion de estado de la Jarra
	*/
	@Override
	public String toString(){
		return String.format("Capacidad: %d, Ocupacidad: %d, Libres: %d", capacidad, ocupacidad, getLibres());
	}
	/*
	* @return Instancia Jarra copia
	*/
	@Override
	public Jarra clone(){
		return new Jarra(capacidad, ocupacidad);
	}
}