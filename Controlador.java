/**
 * Clase que trabaja como intermediario entre la vista y el modelo
 */
public class Controlador{

    /* Modelo del proyecto */
    Modelo modelo;
    /* Vista de la aplicacion */

    public Controlador(){
	this.modelo = new Modelo();
    }

    public void iniciarSesion(String nombreUsuario, String contraseña){
	this.modelo.iniciarSesion(nombreUsuario, contraseña);
    }

    public static void main(String[] args){
	Controlador controlador = new Controlador();
	try{
	    controlador.iniciarSesion("hola", "cd");
	}catch(NullPointerException e){
	    System.out.println("Usuario no existente");
	}
    }
    
}
