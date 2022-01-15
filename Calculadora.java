/**
 * clase que simula una calculadora solo con 5 operaciones
 */
public class Calculadora {
    String numero;
    String numero2;
    String resultado;
    int aux1;
    int aux2;
    int aux3;
    /**
     * metodo suma de 2 numeros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la suma de n1 y n2
     */
    public String suma(String n1, String n2){
        n1 = n1.replaceAll(" ", "");
        n2 = n2.replaceAll(" ", "");
        aux1 = Integer.parseInt(n1);
        aux2 = Integer.parseInt(n2);
        aux3 = aux1 + aux2;
        resultado = aux3+"";
        return resultado;
    }
    /**
     * metodo resta de 2 numeros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la resta de n1 y n2
     */
    public String resta(String n1, String n2){
        n1 = n1.replaceAll(" ", "");
        n2 = n2.replaceAll(" ", "");
        aux1 = Integer.parseInt(n1);
        aux2 = Integer.parseInt(n2);
        aux3 = aux1 - aux2;
        resultado = aux3+"";
        return resultado;
    }
    /**
     * metodo producto de 2 numeros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return producto de n1 y n2
     */
    public String producto(String n1, String n2){
        n1 = n1.replaceAll(" ", "");
        n2 = n2.replaceAll(" ", "");
        aux1 = Integer.parseInt(n1);
        aux2 = Integer.parseInt(n2);
        aux3 = aux1 * aux2;
        resultado = aux3+"";
        return resultado;
    }
    /**
     * metodo division de 2 numeros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la division de n1 y n2
     */
    public String division(String n1, String n2){
        n1 = n1.replaceAll(" ", "");
        n2 = n2.replaceAll(" ", "");
        aux1 = Integer.parseInt(n1);
        aux2 = Integer.parseInt(n2);
        aux3 = aux1 / aux2;
        resultado = aux3+"";
        return resultado;
    }
    /**
     * metodo porcentaje de 2 numeros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return porcentaje de n1 y n2
     */
    public String porcentaje(String n1, String n2){
        n1 = n1.replaceAll(" ", "");
        n2 = n2.replaceAll(" ", "");
        aux1 = Integer.parseInt(n1);
        aux2 = Integer.parseInt(n2);
        aux3 = (aux1 * aux2)/100;
        resultado = aux3+"";
        return resultado;
    }
    
    
}
