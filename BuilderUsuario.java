/** 
 * Clase para facilitar la construccion de usuarios
 */
public class BuilderUsuario{

    String nombreUsuario;

    String contraseña;

    long cuenta;

    long cuentaAhorro;

    /**
     * Constructor de la clase
     * @param String Nombre de usuario
     * @param String Contraseña
     */
    public BuilderUsuario(String nombreUsuario, String contraseña){
	this.nombreUsuario = nombreUsuario;
	this.contraseña = contraseña;
	this.cuenta = 0;
	this.cuentaAhorro = 0;
    }

    /**
     * Metodo para establecer el inicio de la cuenta del usuario
     * @param long Cantidad con la que se desea iniciar la cuenta
     */
    public void inicioCuenta(long cantidad){
	this.cuenta = cantidad;
    }

    /**
     * Metodo para establecer el inicio de la cuenta de ahorro del usuario
     * @param long Cantidad con la que iniciara la cuenta de ahorro del usuario
     */
    public void inicioAhorro(long cantidad){
	this.cuentaAhorro = cantidad;
    }

    /**
     * Metodo build
     * @return Usuario Instancia de usuario con la informacion dada
     */
    public Usuario build(){
	return new Usuario(this);
    }
    



    
}
