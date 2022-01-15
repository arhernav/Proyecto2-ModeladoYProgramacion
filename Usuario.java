import java.util.LinkedList;
import java.time.LocalDate;

/**
 * Clase que contiene la información del Usuario requerida en la aplicación.
 */ 
public class Usuario implements Proxy{
    
  //Lista de gastos del usuario.
  LinkedList<Gasto> gastos;
  /** Nombre del usuario */
  String nombreUsuario;
  /** Contraseña del usuario para iniciar sesión */
  String contraseña;
  /** Cuenta del usuario */
  long cuenta;
  /** Cuenta de ahorro (sólo si el usuario lo activa) */
  long cuentaAhorro;
    /** Agenda del usuario */
    Agenda agenda;
    /** Instancia unica de proxy para el usuario*/
    UsuarioProxy usuarioProxy;
 
  //Método que muestra la lista de gastos del usuario.
  //////////////////////

    /**
     * Constructor de clase temporal
     * Se usara para hacer pruebas hasta saber que builder funciona
     */
    private Usuario(String nombreUsuario, String contraseña, boolean opcionAhorro, long cuenta, long cuentaAhorro){
	this.nombreUsuario = nombreUsuario;
	this.contraseña = contraseña;
	this.cuenta = cuenta;
	this.cuentaAhorro = cuentaAhorro;
	this.agenda = new Agenda();
	this.gastos = new LinkedList<Gasto>();
	this.usuarioProxy = new UsuarioProxy(this);
    }

    

    /**
     * Constructor de usuario a base de un builder
     * @param BuilderUsuario Constructor de usuario
     */
    public Usuario(BuilderUsuario constructor){
	this.nombreUsuario = constructor.nombreUsuario;
	this.contraseña = constructor.contraseña;
	this.cuenta = constructor.cuenta;
	this.cuentaAhorro = constructor.cuentaAhorro;
	this.agenda = new Agenda();
	this.gastos = new LinkedList<Gasto>();
	this.usuarioProxy = new UsuarioProxy(this);
    }

    /**
     * Metodo que actualiza la informacion del usuairo de acuerdo al proxy
     */ 
    protected void actualizacionProxy(){
	this.cuenta = this.usuarioProxy.cuentaProxy;
	this.cuentaAhorro = this.usuarioProxy.ahorroProxy;
    }

    /**
     * Metodo para obtener la unica instancia de proxy para este usurio
     * @return UsuarioProxy Proxy exclusivo de este usuario
     */
    public UsuarioProxy getUsuarioProxy(){
	return this.usuarioProxy;
    }

    /**
     * Getter para el nombre de usuario
     * @return String nombre de usuario del usuario
     */
    public String getUsuario(){
	return this.nombreUsuario;
    }

    /**
     * Getter para la contraseña
     * @return String Contraseña del usuario
     */
    public String getContraseña(){
	return this.contraseña;
    }

    /**
     * Metodo para añadir gastos al historial
     * @param long Cantidad gastada
     * @param String Objeto en el que se gasto el dinero
     * @param LocalDate fecha en la que se realizo el gasto
     */
    public Gasto añadirGasto(long cantidad, String objeto, LocalDate fecha){
	Gasto gasto = new Gasto(cantidad, objeto, fecha);
	this.gastos.add(gasto);
	return gasto;
    }

    /**
     * Metodo para añadir ganancias a la cuenta
     * @param long Cantidad de dinero que se sumara a la cuenta de ahorro
     * @return long Cantidad final de la cuenta
     */
    public long añadirCuenta(long cantidad){
	if(cantidad < 0) return -1;
	this.cuenta += cantidad;
	return this.cuenta;
    }

    /**
     * Metodo para desocntar dinero de la cuenta principal
     * @param long Cantidad a descontar
     * @return long Cantidad final de la cuenta
     */
    public long descontarCuenta(long cantidad){
	if(cantidad < 0) return -1;
	this.cuenta -= cantidad;
	return this.cuenta;
    }
    
    /**
     * Metodo para añadir ganancias a la cuenta de ahorro
     * @param long Cantidad de dinero que se sumara a la cuenta de ahorro
     * @return long Cantidad final de la cuenta de ahorro
     */
    public long añadirAhorro(long cantidad){
	if(cantidad < 0) return -1;
	this.cuentaAhorro += cantidad;
	return this.cuentaAhorro;
    }

    /**
     * Metodo para añadir ganancias a la cuenta de ahorro
     * @param long Cantidad de dinero que se sumara a la cuenta de ahorro
     * @return long Cantidad final de la cuenta de ahorro
     */
    public long descontarAhorro(long cantidad){
	if(cantidad < 0) return -1;
	this.cuentaAhorro -= cantidad;
	return this.cuentaAhorro;
    }

    

    /**
     * Metodo para revisar el dinero en la cuenta
     * @return long Cantidad de dinereo en la cuenta
     */
    public long getCuenta(){
	return this.cuenta;
    }
    /**
     * Metodo para revisar el dinero en la cuenta de ahorro
     * @return long Cantidad de dinereo en la cuenta de ahorro
     */
    public long getCuentaAhorro(){
	return this.cuentaAhorro;
    }

    /**
     * Metodo para revsara los gastos recientes
     * @String String conteniendo la lista de gastos que se han hecho desde que se dio de alta la aplicacion
     */
    public String getGastosRecientes(){
	if(this.gastos.isEmpty())
	    return "No se ha registrado ningun gasto en la cuenta";
	String supp = "";
	for(Gasto gasto : this.gastos){
	    supp += "\n" + gasto.toString();
	}
	return supp;
    }

    /**
     * Metodo para añadir una entrada a la agenda
     * @param int año
     * @param int mes
     * @param int dia
     * @param String registro
     */
    public String agregarEntrada(int año, int mes, int dia, String registro){
	LocalDate fecha = LocalDate.of(año, mes, dia);
	this.agenda.agregarEntrada(año, mes, dia ,  registro);
	return registro + "fue agendado para " + fecha.toString();
    }

    /**
     * Metodo para añadir una entrada a la agenda
     * @param LocalDate fecha
     * @param String registro
     */
    public String agregarEntrada(LocalDate fecha, String registro){
	this.agenda.agregarEntrada(fecha ,  registro);
	return registro + "fue agendado para " + fecha.toString();
    }

    /**
     * Metodo que devuelve todos los eventos agendados
     * @return String String conteniendo todos los eventos de la agenda
     */
    public String revisarAgenda(){
	return this.agenda.toString();
    }
    
    /**
     * Metodo que devuelve un String con los eventos agendados del dia
     * @return String String conteniendo los eventos del dia
     */
    public String getEventos(){
	return this.agenda.getEventos();
    }

    /**
     * Metodo toString 
     * @rturn String representacion en cadena del objeto
     */
    @Override public String toString(){
	return this.nombreUsuario + " Cuenta: " + this.cuenta;
    }


    
}
