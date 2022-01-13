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

    
    

    
    

    
}
