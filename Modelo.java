import java.util.Hashtable;
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
    public void iniciarSesion(String nombreUsuario, String contraseña){
	if(usuarioActivo != null) return;
	Usuario usuario = this.usuarios.get(nombreUsuario);
	if(usuario == null) throw new NullPointerException("No existe el usuario");
	if(usuario.contraseña.equals(contraseña)){
	    this.usuarioActivo = usuario;
	}else{
	    throw new IllegalArgumentException("Contraseña invalida");
	}
	
    }

    
    

    
}
