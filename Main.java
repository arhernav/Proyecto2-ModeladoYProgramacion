import java.time.LocalDate;
public class Main{

    public static void main(String[] args){
        BuilderUsuario builder = new BuilderUsuario("nombre", "contraseña");
	builder.inicioCuenta(200);
	builder.inicioAhorro(500);
	Usuario prueba = new Usuario(builder);
	System.out.printn(prueba.getProxy().cuentaProxy);

	Modelo modelo = new Modelo();
	System.out.println(modelo.usuarios);
	modelo.añadirUsuario(prueba);
	System.out.println(modelo.usuarios);
	System.out.println(modelo.añadirCuenta(33));
	System.out.println(modelo.iniciarSesion("nombre", "contraseña"));
	System.out.println(modelo.añadirCuenta(33));
	System.out.println(modelo.usuarios);
	System.out.printn(prueba.getProxy().cuentaProxy);
	
    }
    
}
