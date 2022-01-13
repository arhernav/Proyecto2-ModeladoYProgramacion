import java.util.Scanner;
/**
 * vista que se desplegará cuando se entre sin un usuario
 */

public class SinUsuario implements TipoVista{
    String opcion = "";
    /**
     * implementación del método en la interfaz TipoVista para la vista de la app
     * sin usuario
     */
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************"+
        "Esta es la vista sin usuario, para escoger una opción usa 1 o 2\n"+
        "Opciones:\n 1 para registrarse\n 2 para usar la calculadora");
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
