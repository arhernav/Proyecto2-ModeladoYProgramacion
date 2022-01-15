import java.util.Scanner;
/**
 * vista que se desplegará cuando se entre sin un usuario
 */

public class SinUsuario implements TipoVista{
    /**
     * implementación del método en la interfaz TipoVista para la vista de la app
     * sin usuario
     */
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************"+
        "Esta es la vista sin usuario, para escoger una opcion ingrese unicamente el digito de la opcion que desea\n"+
        "Opciones:\n1.- para registrarse\n" +
			   "2.- Iniciar Sesion\n");
    }

    /**
     * Imprime opciones para la cuenta
     */
    public void opcionesInicioCuenta(){
	System.out.println("Desea inicar sus cuentas en 0?");
	System.out.println("1.- Iniciar cuentas en 0");
	System.out.println("2.- Ingresar valores de inicio para las cuentas");
    }

}
