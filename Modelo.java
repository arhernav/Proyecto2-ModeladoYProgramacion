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
     * Metodo para añadir un gasto a la cuenta
     * @param Gasto Gasto a añadir a la cuenta
     */
    public Gasto añadirGasto(long cantidad, String objeto, LocalDate fecha){
	if(this.usuarioActivo == null) return null;
	Gasto realizado = this.usuarioActivo.añadirGasto(cantidad, objeto, fecha);
	return realizado;
    }

    /**
     * Metodo para añadir dinero a la cuenta principal
     * @param long Cantidad añadida a la cuenta
     * @return Cantdad final de la cuenta
     */
    public long añadirCuenta(long cantidad){
	if( this.usuarioActivo == null )return -1;
	return this.usuarioActivo.añadirCuenta(cantidad);	
    }

    /**
     * Metodo para añadir dinero a la cuenta principal
     * @param long Cantidad añadida a la cuenta
     * @return Cantdad final de la cuenta
     */
    public long añadirAhorro(long cantidad){
	if( this.usuarioActivo == null )return -1;
	return this.usuarioActivo.añadirAhorro(cantidad);	
    }


    /**
     * Metodo para descontar de la cuenta principal del usuario
     * @param long Cantidad a descontar de la cuenta principal
     * @return long Total de la cuenta principal
     */
    public long descontarCuenta(long cantidad){
	if(this.usuarioActivo == null)return -1;
	return this.usuarioActivo.descontarCuenta(cantidad);
    }

    /**
     * Metodo para descontar de la cuenta principal de ahorro
     * @param long Cantidad a descontar de la cuenta de ahorro
     * @return long Total de la cuenta de ahorro
     */
    public long descontarAhorro(long cantidad){
	if(this.usuarioActivo == null)return -1;
	return this.usuarioActivo.descontarAhorro(cantidad);
    }
    
    
}
