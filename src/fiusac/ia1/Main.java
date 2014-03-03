package fiusac.ia1;

import fiusac.ia1.search.NoInformado;
import fiusac.ia1.utilidades.FicheroOps;

public class Main{
	public static void main(String[] args){
		if (args.length > 0){
			FicheroOps.setConfigPath(args[0]);			
		}
		FicheroOps.iniciar();
		NoInformado.iniciar();
	}
}
