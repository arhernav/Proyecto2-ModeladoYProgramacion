import java.util.Scanner;
/**
 * vista de la calculadora
 */
public class VistaCalculadora implements TipoVista{
    String numero1 = "";
    String numero2 = "";
    String operador = "";
    /**
     * implementación del método en la interfaz TipoVista para la vista 
     * de la calculadora
     */
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************\n"+
        "Bienvenido a nuestra calculadora, esta calculadora solo trabaja con enteros, para poder realizar operaciones\n"+
        "es necesario introducir dos números y el símbolo de a operación\n"+
        "los símbolos válidos para la calculadora son: '+' '-' '*' '/' y  '%' para sacar porcentajes\n"+
        "NOTA: para el porcentaje es necesario que el primer número sea el monto de dinero y el segundo el porcentaje a sacar.\n"+
        "NOTA: para la división el primer número es el divisor y el segundo el dividendo \n "+
        "ingrese el primer número:");
        Scanner scN1 = new Scanner(System.in);
        numero1 = scN1.nextLine();
        System.out.println("ingrese el segundo número:");
        Scanner scN2 = new Scanner(System.in);
        numero2 = scN2.nextLine();
        System.out.println("ingrese el operador:");
        Scanner scOperador = new Scanner(System.in);
        operador = scOperador.nextLine();

    }
    /**
     * método get para obtener la cadena con el primer número
     * @return primer número
     */
    public String getNumero1(){
        return numero1;
    } 
    /**
     * método get para obtener la cadena con el segundo número
     * @return segundo número
     */
    public String getNumero2(){
        return numero2;
    }
    /**
     * método get para obtener la cadena con el operador
     * @return operador
     */
    public String getOperador(){
        return operador;
    }
    /**
     * método set para modificar el número 1
     * @param u cadena con el número
     */
    public void setNumero1( String n){
        numero1 = n;
    }
    /**
     * método set para modificar el número 2
     * @param u cadena con el número
     */
    public void setNumero2(String n){
        numero2 = n;
    }
    /**
     * método set para modificar el operador
     * @param u operador
     */
    public void setOperador(String o){
        operador = o;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (número 1)
     */
    public String controladorN1(){
        if(numero1.equals("") ){
            return "error";
        }
        return numero1;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (número 2)
     */
    public String controladorN2(){
        if(numero2.equals("")){
            return "error";
        }
        return numero2;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (operador)
     */
    public String controladorOperador(){
        if(operador.equals("")){
            return "error";
        }
        return operador;
    }

    public static void main(String[] args) {
        VistaCalculadora prueba = new VistaCalculadora();
        prueba.mostrarOpciones();
    }
}