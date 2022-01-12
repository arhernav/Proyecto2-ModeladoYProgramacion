import java.util.LinkedList;

/**
 * Clase que contiene la información del Usuario requerida en la aplicación.
 */ 
public class Usuario{
  
  //Lista de gastos del usuario.
  LinkedList<Gasto> gastos;
  
  /** Nombre del usuario */
  String nombreUsuario;
  /** Contraseña del usuario para iniciar sesión */
  String contraseña;
  /** */
  Gasto gastosRecientes;
  /** Opción de ahorro (sólo si el usuario lo activa) */
  boolean opcionAhorro;
  /** Cuenta del usuario */
  long cuenta;
  /** Cuenta de ahorro (sólo si el usuario lo activa) */
  long cuentaAhorro;
 
  //Método que muestra la lista de gastos del usuario.
  //////////////////////
  
}
}