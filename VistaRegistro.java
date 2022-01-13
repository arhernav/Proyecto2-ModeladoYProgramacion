import java.util.Scanner;
/**
 * vista para registrarse (crear un usuario)
 */
public class VistaRegistro implements TipoVista{
    /*se guardará el nombre de usuario en esta cadena */
    public String user = "";
    /*se guardará la contraseña en esta cadena*/
    public String password = "";
    /**
     * implementación del método en la interfaz TipoVista
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("*******************************\n"
        + "ingresa el nombre de usuario deseado\n");
        Scanner scUser = new Scanner(System.in);
        user = scUser.nextLine();
        System.out.println("\n ingresa tu contraseña:\n");
        Scanner scPassword = new Scanner(System.in);
        password = scPassword.nextLine();
        System.out.println("*******************************");
        scUser.close();
        scPassword.close();

    }
    /**
     * método get para obtener la cadena con el user name
     * @return user 
     */
    public String getUser(){
        return user;
    }
    /**
     * método set para modificar el usuario
     * @param u cadena con el nuevo user name
     */
    public void setUser(String u){
        user = u;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (user)
     */
    public String ControladorUser(){
        if (user.equals("")){
            return "error";
        }
        return user;
    }
    /**
     * método get para obtener la cadena con la contraseña
     * @return user 
     */
    public String getPassword(){
        return password;
    }
    /**
     * método set para modificar la contraseña
     * @param u cadena con la nueva contraseña
     */
    public void setPassword(String p){
        password = p;
    }
    /**
     * método para ver lo que metío el usuario en la vista y usarlo en controlador
     * @return cadena llenada en términal (password)
     */
    public String controladorPassword(){
        if(password.equals("")){
            return "error";
        }
        return password;
    } 
    
}
