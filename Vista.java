import java.util.Scanner;
/**
 *Clase para manejar las vistas de la aplicacion
 */
public class Vista{

    /* Vista actual de la tienda */
    TipoVista vistaActual;


    /**
     * Metodo generalizado para facilitar el recibimiento de entradas por edio de la terminal
     * @param int Numero de opciones que se le van a dar al usuario
     * @param String Mensaje que se mostrara en caso de que la entrada no sea valida
     * @return int Entrada dada por el usuario
     */
    public int entradaOpciones(int opciones, String mensaje){
    int opcionElegida = opciones + 1;
    boolean opcionValida = false;
    Scanner escaner = new Scanner(System.in);
    do{
      if(escaner.hasNextInt()){
        opcionElegida = escaner.nextInt();
        if(opcionElegida <= opciones && opcionElegida > 0){
          opcionValida = true;
        }else{
          System.out.println(mensaje);
        }
      }else{    
        escaner.nextLine();
        System.out.println(mensaje);
      }
    }while(!opcionValida);
    return opcionElegida;
  }

    /**
   * Metodo para recibir entrada de la terminal
   * @return String Cadena ingresada por el usuario a travez de la terminal
   */
  public String entrada(){
    Scanner escaner = new Scanner(System.in);
    String entrada = "";
    if(escaner.hasNextLine()){
      entrada = escaner.nextLine();
    }
    return entrada;
  }

    
}
