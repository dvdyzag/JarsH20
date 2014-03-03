package fiusac.ia1.utilidades;
import java.util.Properties;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import fiusac.ia1.search.*;
public class FicheroOps{
	public static String user_dir;
    private static Path configPath;
    static {
    	user_dir = System.getProperty("user.dir");
    	configPath = Paths.get(user_dir, "c1.conf");
    }
    public static void setConfigPath(String configFile){
    	configPath = Paths.get(configFile);
    }
    /*
     * 
     */
	public static void iniciar(){
		File file = configPath.toFile();
		try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Configuracion no encontrada");
        }

        String primero, segundo, tercero, cuarto, quinto, sexto;
        List<String> sordenReglas = new ArrayList<>(6);
        
        String primeroProperty = properties.getProperty("primero");
        primero = (primeroProperty == null) ? "llenar4" : primeroProperty.trim().toLowerCase();

        String segundoProperty = properties.getProperty("segundo");
        segundo = (segundoProperty == null) ? "llenar3" : segundoProperty.trim().toLowerCase();
        
        String terceroProperty = properties.getProperty("tercero");
        tercero = (terceroProperty == null) ? "vaciar4" : terceroProperty.trim().toLowerCase();

        String cuartoProperty = properties.getProperty("cuarto");
        cuarto = (cuartoProperty == null) ? "vaciar3" : cuartoProperty.trim().toLowerCase();

        String quintoProperty = properties.getProperty("quinto");
        quinto = (quintoProperty == null) ? "traslado43" : quintoProperty.trim().toLowerCase();

        String sextoProperty = properties.getProperty("sexto");
        sexto = (sextoProperty == null) ? "traslado34" : sextoProperty.trim().toLowerCase();

        sordenReglas.add(0, primero);
        sordenReglas.add(1 ,segundo);
        sordenReglas.add(2, tercero);
        sordenReglas.add(3, cuarto);
        sordenReglas.add(4, quinto);
        sordenReglas.add(5, sexto);
        List<Reglas> ordenReglas = NoInformado.ordenReglas;
        for (String regla: sordenReglas){
            switch (regla){
                case "llenar4":
                    ordenReglas.add(Reglas.LLENAR4);
                    break;
                case "llenar3":
                    ordenReglas.add(Reglas.LLENAR3);
                    break;
                case "vaciar4":
                    ordenReglas.add(Reglas.VACIAR4);
                    break;
                case "vaciar3":
                    ordenReglas.add(Reglas.VACIAR3);
                    break;
                case "traslado43":
                    ordenReglas.add(Reglas.TRASLADO43);
                    break;
                case "traslado34":
                    ordenReglas.add(Reglas.TRASLADO34);
                    break;
            }
        }

        String algoritmoProperty = properties.getProperty("algoritmo").trim().toLowerCase();
        Algoritmos algoritmo;
        switch(algoritmoProperty){
            case "profundidad":
                algoritmo = Algoritmos.PROFUNDIDAD;
                break;
            case "anchura":
                algoritmo = Algoritmos.ANCHURA;
                break;
            case "anchuralimitada":
                algoritmo = Algoritmos.ANCHURA_LIMITADA;
                break;
            case "profundidadlimitada":
                algoritmo = Algoritmos.PROFUNDIDAD_LIMITADA;
                break;
            case "backjumping":
                algoritmo = Algoritmos.BACKJUMPING;
                break;
            default:
                algoritmo = Algoritmos.PROFUNDIDAD;
        }
        String limiteProperty = properties.getProperty("limite");
        int limite = 3;
        try {
            limite = Integer.parseInt(limiteProperty);
        } catch(Exception e){
            System.out.println("Couldn't read limite, defaulting to "+limite);
        }
        NoInformado.algoritmo = algoritmo;
        NoInformado.limite = limite;
        //NoInformado.ordenReglas = ordenReglas;
	}
}
