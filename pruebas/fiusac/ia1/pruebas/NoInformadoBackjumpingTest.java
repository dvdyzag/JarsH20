package fiusac.ia1.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiusac.ia1.search.NoInformado;
import fiusac.ia1.utilidades.FicheroOps;

public class NoInformadoBackjumpingTest {

	@Test
	public void testIniciarAnchura() {
		FicheroOps.setConfigPath("c5.conf");
		FicheroOps.iniciar();
		NoInformado.iniciar();
	}
}
