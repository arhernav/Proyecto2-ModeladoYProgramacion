import  java.time.LocalDate;
/**
 * Clase que ayuda a llevar un control de los gastos del usuario.
 */
public class Gasto{

  /** Nombre del objeto comprado */
  String objetoComprado;
  /** Precio del objeto comprado */
  long cantidad;
    /** Fecha del gasto*/
    LocalDate fechaGasto;

    /**
     * Constructor de la clase
     */
    public Gasto(long cantidad, String objetoComprado, LocalDate fechaGasto){
	this.objetoComprado = objetoComprado;
	this.cantidad = cantidad;
	this.fechaGasto = fechaGasto;
    }
  
  /**
   * Método que muestra al usuario el nombre del objeto que compró y su precio.
   * @return String - Objeto comprado y precio.
   */
  @Override
  public String toString(){
      return objetoComprado + "....... $" + cantidad + "( " + this.fechaGasto + ")"; 
  }
  
}
