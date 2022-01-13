import java.util.Scanner;
/**
 * vista que se desplegará cuando un usuario entre a la app
 */
public class ConUsuario implements TipoVista{
    String opcion = "";
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************\n"+
        "bienvenido, para escoger una opción usa 1 o 2\n"+
        "Opciones:\n 1 para ver el saldo\n 2 para ver el historial de gastos\n"+
        "3 crear opcion de ahorro\n 4 para ver la agenda\n 5 para usar la calculadora");
        Scanner scOpcion = new Scanner(System.in);
        opcion = scOpcion.nextLine();
        System.out.println("*******************************");
    }
    /**
     * método get para obtener la cadena con la opcion seleccionada
     * @return opcion seleccionada
     */
    public String getOpcion(){
        return opcion;
    }
    /**
     * método set para modificar la opcion
     * @param u opcion
     */
    public void setOpcion(String o){
        opcion = o;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (opcion seleccionada)
     */
    public String controladorOpcion(){
        if(opcion.equals("")){
            return "error";
        }
        return opcion;
    }
}
