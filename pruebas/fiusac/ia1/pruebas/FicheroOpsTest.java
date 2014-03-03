package fiusac.ia1.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import fiusac.ia1.search.NoInformado;
import fiusac.ia1.search.Reglas;
import fiusac.ia1.utilidades.FicheroOps;

public class FicheroOpsTest {

	@Test
	public void testIniciar() {
		String confName = "c2.conf";
		FicheroOps.setConfigPath(confName);
		FicheroOps.iniciar();
		System.out.println("--- Fichero configuracion \"" + confName + "\" ---");
		System.out.println("Limite elegido: " + NoInformado.limite);
		System.out.println("Algoritmo elegido: " + NoInformado.algoritmo);
		System.out.println("Ahora el orden de las reglas son las siguientes:");
		int i = 0;
		for (Reglas regla : NoInformado.ordenReglas){
			System.out.println(++i + ".) " + regla);
		}
	}

}
