import java.util.Hashtable;
import java.time.LocalDate;
/**
 *Clase para la parte del modelo
 *Maneja la logistica del programa y el almacenamiento de los usuarios
 */
public class Modelo{

    /* Hashtable que almacena los usuarios de la aplicacion */
    protected Hashtable<String, Usuario> usuarios;

    /* Usuario que esta usando la aplicacion */
    protected Usuario usuarioActivo;

    
    public Modelo(){
	this.usuarios = new Hashtable<String, Usuario>();
	this.usuarioActivo = null;
    }

    /**
     * Metodo para iniciar sesion en la aplicacion
     */
    public Usuario iniciarSesion(String nombreUsuario, String contraseña){
	Usuario usuarioSupp = this.usuarios.get(nombreUsuario);
	if(usuarioSupp == null) return null;
	if(usuarioSupp.contraseña.equals(contraseña)){
	    this.usuarioActivo = usuarioSupp;
	    return usuarioSupp;
	}else{
	    return null;
	}
    }

    /**
     * Metodo para cerrar sesion
     */
    public void cerrarSesion(){
	this.usuarioActivo = null;
    }

    /**
     * Metodo para añadir un gasto a la cuenta que ademas reduce la cantidad de dinero de la cuenta
     * @param Gasto Gasto a añadir a la cuenta
     * @return Gasto Gasto creado que se añadio a la lista de gastos
     */
    public Gasto añadirGasto(long cantidad, String objeto, LocalDate fecha){
	if(this.usuarioActivo == null) return null;
	Gasto realizado = this.usuarioActivo.añadirGasto(cantidad, objeto, fecha);
	this.descontarCuenta(cantidad);
	return realizado;
    }

    /**
     * Metodo para añadir dinero a la cuenta principal
     * @param long Cantidad añadida a la cuenta
     * @return Cantdad final de la cuenta
     */
    public long añadirCuenta(long cantidad){
	if(this.usuarioActivo == null) return -1;
	UsuarioProxy proxy = this.usuarioActivo.getUsuarioProxy();
	long  d = proxy.añadirCuenta(cantidad);
	proxy.actualizarOriginal();
	return d;
    }

    /**
     * Metodo para añadir dinero a la cuenta principal
     * @param long Cantidad añadida a la cuenta
     * @return Cantdad final de la cuenta
     */
    public long añadirAhorro(long cantidad){
        if(this.usuarioActivo == null) return -1;
	UsuarioProxy proxy = this.usuarioActivo.getUsuarioProxy();
	long d = proxy.añadirAhorro(cantidad);
	proxy.actualizarOriginal();
	return d;
    }


    /**
     * Metodo para descontar de la cuenta principal del usuario
     * @param long Cantidad a descontar de la cuenta principal
     * @return long Total de la cuenta principal
     */
    public long descontarCuenta(long cantidad){
        if(this.usuarioActivo == null) return -1;
	UsuarioProxy proxy = this.usuarioActivo.getUsuarioProxy();
	long d = proxy.descontarCuenta(cantidad);
	proxy.actualizarOriginal();
	return d;
    }

    /**
     * Metodo para descontar de la cuenta principal de ahorro
     * @param long Cantidad a descontar de la cuenta de ahorro
     * @return long Total de la cuenta de ahorro
     */
    public long descontarAhorro(long cantidad){
        if(this.usuarioActivo == null) return -1;
	UsuarioProxy proxy = this.usuarioActivo.getUsuarioProxy();
	long d = proxy.descontarAhorro(cantidad);
	proxy.actualizarOriginal();
	return d;
    }

    /**
     * Metodo para revisar los gastos recientes del usuario
     * @return String String conteniendo los datos recientes del usuario. Mensaje solicitando que se inicie sesion si no hay un usuario activo
     */
    public String getGastosRecientes(){
	if(this.usuarioActivo == null) return "Por favor inicie sesion";
	return this.usuarioActivo.getGastosRecientes();
    }

    /**
     * Metodo para añadir a la agenda
     * @param LocalDate fecha del registro que se quiere añadir
     * @param String registro que se quiere añadir
     */
    public String agregarEntrada(LocalDate fecha, String registro){
	if(this.usuarioActivo == null)return null;
	return this.usuarioActivo.agregarEntrada(fecha, registro);
    }

    /**
     * Metodo para obtener la agenda del usuario
     * @return String Representacion en cadena de la agenda del usuario
     */
    public String getAgenda(){
	if(this.usuarioActivo == null) return "Porfavor inicie sesion";
	return this.usuarioActivo.agenda.toString();
    }

    /**
     * Metodo para registrar usuarios nuevos (añadir observadores)
     * @param Usuario
     */
    public Usuario añadirUsuario(Usuario usuario){
	if(usuario == null)throw new IllegalArgumentException("No se puede añadir null");
	if(this.usuarios.contains(usuario.nombreUsuario)) return null;
	this.usuarios.put(usuario.nombreUsuario, usuario);
	return this.usuarios.get(usuario.nombreUsuario);
    }

    /**
     * Metodo para eliminar un usuario del sistema
     * @param String Nombre del usuario a eliminar
     * @param String Contraseña del usuario a eliminar
     */
    public Usuario eliminarUsuario(String nombreUsuario, String contraseña){
	Usuario supp = this.usuarios.get(nombreUsuario);
	if(supp == null) return null;
	if(supp.contraseña.equals(contraseña)){
	    this.usuarios.remove(nombreUsuario);
	    return supp;
	}else{
	    return null;
	}
    }
    
    /**
     * @param String Cadena con los eventos del dia del usuario. Cadena vacia si no hay nada
     */
    public String getEventos(){
	if(this.usuarioActivo == null )return "";
	if(!this.usuarioActivo.getEventos().equals(""))return "No hay eventos para el dia de hoy o para mañana";
	return this.usuarioActivo.getEventos();
    }

    /**
     * Metodo para obtener los recordatorios de dos dias despues
     * @return String String con los eventos que sucederan en dos dias
     */
    public String recordatorio(){
	if(this.usuarioActivo == null) return "";
	return this.usuarioActivo.agenda.recordatorio();
    }
    
    
}
