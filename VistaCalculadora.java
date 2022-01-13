import java.util.Scanner;
/**
 * vista de la calculadora
 */
public class VistaCalculadora implements TipoVista{
    int numero1;
    int numero2;
    String operador;
    /**
     * implementación del método en la interfaz TipoVista para la vista 
     * de la calculadora
     */
    @Override
    public void mostrarOpciones(){
        System.out.println("*******************************\n"+
        "Bienvenido a nuestra calculadora, para poder realizar operaciones\n"+
        "es necesario introducir dos números y el símbolo de a operación\n"+
        "los símbolos válidos para la calculadora son: '+' '-' '*' '/' y  '%' para sacar porcentajes\n"+
        "NOTA: para el porcentaje es necesario que el primer número sea el monto de dinero y el segundo el porcentaje a sacar.\n"+
        "NOTA: para la división el primer número es el divisor y el segundo el dividendo \n "+
        "ingrese el primer número:");
        Scanner scN1 = new Scanner(System.in);
        numero1 = scN1.nextInt();
        System.out.println("ingrese el segundo número:");
        Scanner scN2 = new Scanner(System.in);
        numero2 = scN2.nextInt();
        System.out.println("ingrese el operador:");
        Scanner scOperador = new Scanner(System.in);
        operador = scOperador.nextLine();

    }
    public int getNumero(){
        return numero1;
    } 
    public int getNumero2(){
        return numero2;
    }
    public String getOperador(){
        return operador;
    }
    public void setNumero1( int n){
        numero1 = n;
    }
    public void setNumero2(int n){
        numero2 = n;
    }
    public void setOperador(String o){
        operador = o;
    }
    public static void main(String[] args) {
        VistaCalculadora prueba = new VistaCalculadora();
        prueba.mostrarOpciones();
    }
}