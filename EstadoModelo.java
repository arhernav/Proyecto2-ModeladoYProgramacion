/**
 * Clase para modelar el estado de la aplicacion
 */
public Interface EstadoModelo{

    /**
     * Metodo para iniciar sesion
     */
    public void iniciarSesion();

    /**
     * Metodo para cerrar sesion
     */
    public void cerrarSesion();

    /**
     * Metodo para añadir gastos
     */
    public void añadirGasto(Gasto gasto);

    /**
     * Metodo para revisar los gastos recicentes
     */
    public String gastosRecientes();

    /**
     * Metodo para añadir entrada a la cuenta de ahorro
     */
    public void añadirAhorro(int cantidad);

    /**
     * Metodo para revisar la cuenta de ahorro
     */
    public void revisarAhorro();

	
    
}
