package fiusac.ia1.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiusac.ia1.jarras.Jarra;
import fiusac.ia1.search.Nodo;

public class NodoTest {

	@Test
	public void testEsObjetivo() {
		Nodo n = new Nodo();
		assertEquals(n.isObjetivo(), false);
		n = new Nodo(new Jarra(4,1), new Jarra(3));
		assertEquals(n.isObjetivo(), false);
		n = new Nodo(new Jarra(4,2), new Jarra(3));
		assertEquals(n.isObjetivo(), true);
	}

}
