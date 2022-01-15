/**
 * Clase proxy para proteger la informacion del usuario
 * 
 */
public class UsuarioProxy implements Proxy{

    /* Usuario actual */
    Usuario cliente;
    /* Cuenta proxy */
    long cuentaProxy;
    /* Cuenta Ahorro */
    long ahorroProxy;
    
    /**
     * Constructor de la clase
     * @param Usuario
     */
    public UsuarioProxy(Usuario usuario){
	this.cliente = usuario;
	this.cuentaProxy = usuario.cuenta;
	this.ahorroProxy = usuario.cuentaAhorro;
    }

    /**
     * Metodo para añadir ganancias a la cuenta
     * @param long Cantidad de dinero que se sumara a la cuenta
     * @return long Cantidad final de la cuenta
     */
    public long añadirCuenta(long cantidad){
	if(cantidad < 0) return -1;
	this.cuentaProxy = this.cuentaProxy + cantidad;
	return this.cuentaProxy;
    }

    /**
     * Metodo para añadir ganancias a la cuenta de ahorro
     * @param long Cantidad de dinero que se sumara a la cuenta de ahorro
     * @return long Cantidad final de la cuenta de ahorro
     */
    public long añadirAhorro(long cantidad){
	if(cantidad < 0) return -1;
	this.ahorroProxy += cantidad;
	return this.ahorroProxy;
    }

    /**
     * Metodo para añadir ganancias a la cuenta de ahorro
     * @param long Cantidad de dinero que se sumara a la cuenta de ahorro
     * @return long Cantidad final de la cuenta de ahorro
     */
    public long descontarAhorro(long cantidad){
	if(cantidad < 0) return -1;
	this.ahorroProxy -= cantidad;
	return this.ahorroProxy;
    }

    /**
     * Metodo para desocntar dinero de la cuenta principal
     * @param long Cantidad a descontar
     * @return long Cantidad final de la cuenta
     */
    public long descontarCuenta(long cantidad){
	if(cantidad < 0) return -1;
	this.cuentaProxy -= cantidad;
	return this.cuentaProxy;
    }


    /**
     * Metodo que le solicita al usuario original que actualie sus datos de acuerdo al proxy
     */
    public void actualizarOriginal(){
	this.cliente.actualizacionProxy();
    }
    

    
}
