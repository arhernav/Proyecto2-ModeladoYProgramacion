import java.util.Scanner;
/**
 * vista que se desplegará cuando un usuario entre a la app
 */
public class ConUsuario implements TipoVista{
    String opcion = "";
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************\n"+
        "bienvenido, para escoger una opción ingresa unicamente el digito de la opcion\n"+
        "Opciones:\n" +
			   "1.- Revisar la cuent principal\n" +
			   "2.- Revisar la cuenta de ahorros\n" +
			   "3.- Añadir o retirar de la cuenta principal\n" +
			   "4.- Añadir o retirar de la cuenta de ahorro\n" +
			   "5.- Añadir una entrada a la agenda\n" +
			   "6.- Revisar la agenda\n" +
			   "7.- Añadir un nuevo gasto\n" +
			   "8.- Revisar los gastos recientes\n" +
			   "9.- Cerrar sesion\n");
    }

    public void opcionesCuentas(){
	System.out.println("Desea añadir o retirar de su cuenta");
	System.out.println("1.- Añadir dinero a la cuenta");
	System.out.println("2.- Retirar de la cuenta");	
    }
}
