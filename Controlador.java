/**
 * Clase que trabaja como intermediario entre la vista y el modelo
 */
public class Controlador{

    /* Modelo del proyecto */
    Modelo modelo;
    /* Vista de la aplicacion */
    Vista vista;

    public Controlador(){
	this.modelo = new Modelo();
	this.vista = new Vista();
    }

    public void iniciarSesion(String nombreUsuario, String contraseña){
	this.modelo.iniciarSesion(nombreUsuario, contraseña);
    }
    
    
}
