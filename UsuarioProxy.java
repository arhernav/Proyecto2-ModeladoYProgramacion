public class UsuarioProxy implements Proxy{
    Usuario cliente;
    public String getUsuario(){
        return cliente.getUsuario();
    }
    public String getContraseña(){
        return cliente.getContraseña();
    }
}
