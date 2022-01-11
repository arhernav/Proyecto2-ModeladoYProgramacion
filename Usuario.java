/**
 * Clase que contiene la información del Usuario requerida en la aplicación.
 */ 
public class Usuario{
  
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
  
}