package fiusac.ia1.pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fiusac.ia1.jarras.Jarra;
import fiusac.ia1.jarras.JarraException;

public class JarraTest {

	@Test
	public void testLlenarVacio() {
		Jarra j = new Jarra(4);
		try {
			j = j.llenar();
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Jarra esta llena");
		}
		assertEquals(j.getOcupacidad(), 4);
	}
	@Test
	public void testLlenarLleno() {
		Jarra j = new Jarra(4, 4);
		int salida = 0;
		try {
			j = j.llenar();
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			salida = 1;
			System.out.println("Jarra esta llena");
		}
		assertEquals(salida, 1);
	}
	@Test
	public void testVacioVacio() {
		Jarra j = new Jarra(4);
		int salida = 0;
		try {
			j = j.vaciar();
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			salida = 1;
			System.out.println("Jarra esta vacio");
		}
		assertEquals(salida, 1);
	}
	@Test
	public void testVacioLleno() {
		Jarra j = new Jarra(4, 4);
		try {
			j = j.vaciar();
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Jarra esta vacio");
		}
		assertEquals(j.getOcupacidad(), 0);
	}
	@Test
	public void testTraslado34(){
		Jarra j4 = new Jarra(4), j3 = new Jarra(3);
		List<Jarra> r;
		try {
			r = j3.traslado(j4);
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Jarra 3 esta vacia, o Jarra 4 esta llena");
		}
		try {
			j3 = j3.llenar();
			r = j3.traslado(j4);
			assertEquals(r.get(1).getOcupacidad(), 3);
			assertEquals(r.get(0).getOcupacidad(), 0);
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Algo ocurrio en traslado 3->4");
		}
	}
	@Test
	public void testTraslado43(){
		Jarra j4 = new Jarra(4), j3 = new Jarra(3);
		List<Jarra> r;
		try {
			r = j4.traslado(j3);
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Jarra 4 esta vacia, o Jarra 3 esta llena");
		}
		try {
			j4 = j4.llenar();
			r = j4.traslado(j3);
			assertEquals(r.get(1).getOcupacidad(), 3);
			assertEquals(r.get(0).getOcupacidad(), 1);
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Algo ocurrio en traslado 4->3");
		}
	}
	@Test
	public void testTraslado43_algo3(){
		Jarra j4 = new Jarra(4), j3 = new Jarra(3,1); // j3 contiene 1 L
		List<Jarra> r;
		try {
			j4 = j4.llenar();
			r = j4.traslado(j3);
			assertEquals(r.get(1).getOcupacidad(), 3);
			assertEquals(r.get(0).getOcupacidad(), 2);
		} catch (JarraException e) {
			// TODO Auto-generated catch block
			System.out.println("Algo ocurrio en traslado 4->3");
		}
	}

}
