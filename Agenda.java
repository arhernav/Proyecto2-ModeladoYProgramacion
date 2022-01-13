import java.util.LinkedList;
import java.time.LocalDate;

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
    
    /**
     * Método que imprime la fecha del registro de los gastos del usuario.
     */
    public void generarFecha(int diaMes, int mes, int año){
      LocalDate fecha = LocalDate.of(año, mes, diaMes);
      DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd - MM - YYYY");
      System.out.println(fechaFormato.format(fecha));
    }
    
    /**
     * Método que devuelve el registro de los gastos del usuario.
     * @return String - Registro de los gastos.
     */
    public String realizarRegistro(String registro){
      return registro; 
    }
    
  }
  
  //////////////////////////////////////////
  ///////Fin clase anidada//////////////////
  //////////////////////////////////////////
  
  
  
  
  /** Lista de fechas y registros de los gastos del usuario */
  LinkedList<EntradaAgenda> entradas = new LinkedList<>();
  
  /**
   * Método para agregar nuevos registros a la agenda.
   */
  public void agregarRegistros(String fecha, String registro){
    entradas.add(fecha);
    entradas.add(registro);
  }
  
  /**
   * Método para remover registros de la agenda.
   */
  public void removerRegistros(String fecha, String registro){
    entradas.remove(fecha);
    entradas.remove(registro);
  }
  
  /**
   * Método busca concidencias entre la lista de fechas y la fecha del día de hoy
   * para notificar al usuario sobre los pagos que tiene que realizar
   * con un día de anticipación.
   */
  public void pagosARealizar(){
    ////////////////////////////////
    /**
     * LocalDate -> CompareTo
     */
  }
  
  /********************Calendario*/
  
}