import java.util.Scanner;
/**
 * vista para registrarse (crear un usuario)
 */
public class VistaRegistro implements TipoVista{

    public String user = "";
    public String password = "";
    /**
     * implementación del método en la interfaz TipoVista
     */
    @Override
    public void mostrarOpciones() {
        System.out.println("*******************************\n"
        + "ingresa el nombre de usuario deseado\n");

    }
    public String getUser(){
        return user;
    }
    public void setUser(String u){
        user = u;
    }
    public String ControladorUser(){
        if (user.equals("")){
            return "error";
        }
        return user;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String p){
        password = p;
    }
    public String controladorPassword(){
        if(password.equals("")){
            return "error";
        }
        return password;
    } 
}
