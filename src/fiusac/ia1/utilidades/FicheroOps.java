package fiusac.ia1.utilidades;
import java.util.Properties;
import java.io.*;
import fiusac.ia1.search.*;
public class FicheroOps{
    public static String configName;
    static {
        configName = "configuracion.conf";
    }
	public static void iniciar(){
		File file = new File(configName);
		try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("configuracion.conf"));
        } catch (IOException e) {
            e.printStackTrace();
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
        sexto = (quintoProperty == null) ? "traslado34" : sextoProperty.trim().toLowerCase();

        sordenReglas.add(primero);
        sordenReglas.add(segundo);
        sordenReglas.add(tercero);
        sordenReglas.add(cuarto);
        sordenReglas.add(quinto);
        sordenReglas.add(sexto);
        List<Reglas> ordenReglas = new ArrayList<>(6);
        for (String regla: sordenReglas){
            switch (regla){
                case "llenar4":
                    ordenReglas.add(Reglas.LLENAR4);
                    break;
                case "llenar3":
                    ordenReglas.add(Reglas.LLENAR3);
                    break;
                case "vaciar4":
                    ordenReglas.add(Reglas.LLENAR4);
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
        switch(algoritmo){
            case "profundidad":
                algoritmo = Algoritmos.PROFUNDIDAD;
                break;
            case "anchura":
                algoritmo = Algoritmos.ANCHURA;
                break;
            case "anchuraLimitada":
                algoritmo = Algoritmos.ANCHURA_LIMITADA;
                break;
            case "profundidadLimitada":
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
        } catch(IOException e){
            System.out.println("Couldn't read limite, defaulting to "+limite);
        }
        NoInformado.algoritmo = algoritmo;
        NoInformado.limite = limite;
        NoInformado.ordenReglas = ordenReglas;
	}
}