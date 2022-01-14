import java.util.LinkedList;
import java.time.LocalDate;
import java.util.Date;

/**
 * Clase que registra los gastos que ha realizado el usuario.
 */
public class Agenda{
  
  
  ////////////////////////////////////////////////////
  /////////////Clase interna//////////////////////////
  ////////////////////////////////////////////////////
  /**
   * Clase interna que sirve como apoyo para la clase Agenda.
   * Crea objetos de entrada que serán guardados en la agenda.
   */
  public class EntradaAgenda{

      /* Fecha de la entrada para la agenda */
      LocalDate fecha;

      String registro;

      /**
       * Constructor de la clase
       */
      public EntradaAgenda(LocalDate fecha, String registro){
	  this.fecha = fecha;
	  this.registro = registro;
      }

      /**
       * Metodo toString
       * @return String Representacion en cadena del objeto
       */
      @Override public String toString(){
	  return "\t" + this.fecha.toString() + "\n" +
	      this.registro + "\n" ;
      }

      

    
  }
  
  //////////////////////////////////////////
  ///////Fin clase anidada//////////////////
  //////////////////////////////////////////
  
  
  
  
  /** Lista de fechas y registros de los gastos del usuario */
    LinkedList<EntradaAgenda> entradas = new LinkedList<>();
    
    /**
     * Método para agregar nuevos registros a la agenda.
     * @param int Año de la fecha que se quiere
     * @param int mes de la fecha que se quiere
     * @param inr dia de la fecha que se quiere
     * @param registro que se guardara junto con la fecha
     */
    public void agregarEntrada(int año, int mes, int dia, String registro){
	LocalDate fecha = this.generarFecha(año, mes, dia);
	EntradaAgenda entrada = new EntradaAgenda(fecha, registro);
	this.entradas.add(entrada);
    }
    
    /**
     * Método para remover registros de la agenda.
     */
    public void removerRegistros(String registro){
	for(EntradaAgenda entrada: this.entradas){
	    if( entrada.registro.equals(registro) ) this.entradas.remove(entrada);
	}
    }
  
    /**
     * Método que imprime la fecha del registro de los gastos del usuario.
     */
    public LocalDate generarFecha(int año, int mes, int dia){
      LocalDate fecha = LocalDate.of(año, mes, dia);
      return fecha;
    }

    /**
     * Metodo toString de la clase
     * @return String representacion en cadena de la clase
     */
    @Override public String toString(){
	return this.entradas.toString();
    }

    /**
     * Metodo para obtener todos los eventos del dia
     * @return String Cadena con todos los eventos del dia
     */
    public String getEventos(){
	String supp = "";
	LocalDate fechaSistema;
	for(EntradaAgenda entrada : this.entradas){
	    if( entrada.fecha.equals(fechaSistema) ){
		supp = supp + entrada.toString();
	    }
	}
	if(supp.equals("")){
	    return "No tienes eventos hoy";
	}else{
	    return supp;
	}
    }
    
    /**
     * Metodo para enviar avisos de eventos un dia antes
     * @param String 
     */
    public String recordatorio(){
	String supp = "";
	LocalDate fechaSistema;
	for(EntradaAgenda entrada : this.entradas){
	    if( entrada.fecha.minusDays(2).equals(fechaSistema) ){
		supp = supp + entrada.toString();
	    }
	}
	if(!supp.equals("")){
	    supp = "Recuerda que en dos dias tienes los siguientes eventos: \n" + supp;
	}
	return supp;
    }
    
}
