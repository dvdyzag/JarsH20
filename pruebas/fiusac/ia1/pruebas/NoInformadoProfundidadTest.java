package fiusac.ia1.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiusac.ia1.search.NoInformado;
import fiusac.ia1.utilidades.FicheroOps;

public class NoInformadoProfundidadTest {

	@Test
	public void testIniciarAnchura() {
		FicheroOps.setConfigPath("c4.conf");
		FicheroOps.iniciar();
		NoInformado.iniciar();
	}

}
