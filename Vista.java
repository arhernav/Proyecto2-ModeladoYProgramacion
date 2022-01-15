import java.util.Scanner;
/**
 *Clase para manejar las vistas de la aplicacion
 */
public class Vista{

    /* Vista actual de la tienda */
    TipoVista vistaActual;
    public ConUsuario conUsuario = new ConUsuario();
    public SinUsuario sinUsuario = new SinUsuario();
    public VistaRegistro vistaRegistro = new VistaRegistro();
    public VistaCalculadora vistaCalculadora = new VistaCalculadora();

    /**
     * Metodo generalizado para facilitar el recibimiento de entradas por medio de la terminal
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
     * Metodo generalizado para facilitar el recibimiento de entradas por medio de la terminal
     * @param int Numero de opciones que se le van a dar al usuario
     * @param String Mensaje que se mostrara en caso de que la entrada no sea valida
     * @return int Entrada dada por el usuario
     */
    public long entradaLong(long opciones, String mensaje){
    long opcionElegida = opciones + 1;
    boolean opcionValida = false;
    Scanner escaner = new Scanner(System.in);
    do{
      if(escaner.hasNextLong()){
        opcionElegida = escaner.nextLong();
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
    boolean entradaValida =  false;
    String entrada = "";
    do{
	if(escaner.hasNextLine()){
	    entrada = escaner.nextLine();
	    if(!entrada.equals("")){
		entradaValida = true;
	    }else{
		System.out.println("Introdusca su entrada");
	    }
	}else{
	    escaner.nextLine();
	    System.out.println("Introdusca su entrada");
	}
    }while(entradaValida != true);
    return entrada;
  }

    /**
     * Metodo para imprimir una salida en la terminal
     */
    public void salida(String salida){
	System.out.println(salida);
    }

    
}
