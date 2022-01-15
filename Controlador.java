import java.time.LocalDate;
/**
 * Clase que trabaja como intermediario entre la vista y el modelo
 */
public class Controlador{

    /* Modelo del proyecto */
    Modelo modelo;
    /* Vista de la aplicacion */
    Vista vista;

    public Controlador(){
	this.modelo = new Modelo();
	this.vista = new Vista();
    }

    public void iniciarSesion(){
	this.vista.salida("Ingrese su nombre de usuario");
	String nombreUsuario = this.vista.entrada();
	this.vista.salida("Ingrese su contraseña");
	String contraseña = this.vista.entrada();
	if(this.modelo.iniciarSesion(nombreUsuario, contraseña) == null){
	    this.vista.salida("Nombre de usuario o contraseña incorrectos");
	}
    }

    public void cerrarSesion(){
	this.modelo.cerrarSesion();
    }

    public void registrarse(){
	this.vista.vistaRegistro.mostrarOpciones();
	this.vista.salida("Indique su nombre de usuario deseado");
	String nombreSupp = this.vista.entrada();
	this.vista.salida("Indique su contraseña deseada");
	String contraseñaSupp = this.vista.entrada();
	BuilderUsuario builder = new BuilderUsuario(nombreSupp, contraseñaSupp);
	this.vista.sinUsuario.opcionesInicioCuenta();
	if(this.vista.entradaOpciones(2, "Digite solo el numero de la opcion que desea") == 2){
	    this.vista.salida("Indique la cantidad en la que desea iniciar su cuenta");
	    builder.inicioCuenta(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	    this.vista.salida("Indique la cantidad en la que desea iniciar su cuenta");
	    builder.inicioAhorro(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	}
	Usuario usuarioNuevo = builder.build();
	this.modelo.añadirUsuario(usuarioNuevo);
	this.vista.salida("Se registro al usuario " + usuarioNuevo.toString());
    }

    public void eliminarUsuario(){
	this.vista.salida("Ingrese su nombre de usuario");
	String nombreSupp = this.vista.entrada();
	this.vista.salida("Ingrese su contraseña");
	String contraseñaSupp = this.vista.entrada();
	this.modelo.eliminarUsuario(nombreSupp, contraseñaSupp);
    }

    public void revisarCuenta(){
	this.vista.salida("Tu cuenta principal tiene: " + this.modelo.revisarCuenta());
    }

    public void revisarCuentaAhorro(){
	this.vista.salida("Tu cuenta de ahorro tiene: " + this.modelo.revisarCuentaAhorro());
    }

    public void manejarCuenta(){
	this.vista.conUsuario.opcionesCuentas();
	if(this.vista.entradaOpciones(2, "Digite una de las opciones mencionadas") == 1){
	    this.modelo.añadirCuenta(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	}else{
	    this.modelo.descontarCuenta(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	}
    }

    public void manejarCuentaAhorro(){
	this.vista.conUsuario.opcionesCuentas();
	if(this.vista.entradaOpciones(2, "Digite una de las opciones mencionadas") == 1){
	    this.modelo.añadirAhorro(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	}else{
	    this.modelo.descontarAhorro(this.vista.entradaLong(Long.MAX_VALUE, "No se pueden ingresar numeros negativos ni mayores a 9,223,372,036,854,775,807"));
	}
    }

    public void añadirEntrada(){
	this.vista.salida("Que fecha quiere para esta entrada de la agenda");
	this.vista.salida("Año de la entrada");
	int año = this.vista.entradaOpciones(3000, "No se pueden agendar cosas mas alla del año 3000");
	this.vista.salida("Mes de la entrada");
	int mes = this.vista.entradaOpciones(12, "No hay mas de 12 meses en el año");
	this.vista.salida("Dia de la entrada");
	int dia = this.vista.entradaOpciones(31, "No hay mas de 30 dias en el mes");
	this.vista.salida("Cual es el evento de la entrada");
	String evento = this.vista.entrada();
	LocalDate fecha = LocalDate.of(año, mes, dia);
	this.modelo.agregarEntrada(fecha, evento);
	this.vista.salida("Su evento" + evento + "quedo agendado para " + fecha.toString());	
    }

    public void revisarAgenda(){
	this.vista.salida(this.modelo.getAgenda());
    }

    public void añadirGasto(){
	this.vista.salida("Cuando se realizo el gasto?");
	LocalDate fecha = this.recibirFecha();
	this.vista.salida("En que se realizo el gasto");
	String gasto = this.vista.entrada();
	this.vista.salida("De cuanto fue el gasto");
	long cantidad = this.vista.entradaLong(Long.MAX_VALUE, "Ingrese solo la cantidad del gasto");
	this.modelo.añadirGasto(cantidad, gasto, fecha);
	
    }

    public void revisarGastos(){
	this.vista.salida(this.modelo.getGastosRecientes());
    }

    public LocalDate recibirFecha(){
	this.vista.salida("Año de la entrada");
	int año = this.vista.entradaOpciones(3000, "No se pueden agendar cosas mas alla del año 3000");
	this.vista.salida("Mes de la entrada");
	int mes = this.vista.entradaOpciones(12, "No hay mas de 12 meses en el año");
	this.vista.salida("Dia de la entrada");
	int dia = this.vista.entradaOpciones(31, "No hay mas de 30 dias en el mes");
	return LocalDate.of(año, mes, dia);
    }

    public void ejecucionPrincipal(){
	boolean terminar = false;

	//Ejecucion
	do{
	    //Mientras no haya usuario
	    do{
		this.menuSinUsuario();
	    }while(!this.modelo.checarUsuario());

	    //Mientras haya usuario
	    while(this.modelo.checarUsuario()){
		this.menuConUsuario();
	    }
	}while(true);
	
    }

    public void menuSinUsuario(){
	this.vista.sinUsuario.mostrarOpciones();
	switch(this.vista.entradaOpciones(3, "Indique la opcion que desea")){
	case 1: this.registrarse();
	    break;
	case 2: this.iniciarSesion();
	    break;
	case 3: System.out.println("Proximamente");
	}
    }

    public String diario(){
	if(this.modelo.getEventos().equals("")){
	    return "No hay eventos hoy";
	}else{
	    return "Eventos de hoy\n" + this.modelo.getEventos();
	}
    }
    
    public void menuConUsuario(){
	
	this.vista.salida(this.diario());
	this.vista.conUsuario.mostrarOpciones();
	switch(this.vista.entradaOpciones(9, "Indique unicamente el numero de la opcion")){
	case 1: this.revisarCuenta();
	    break;
	case 2: this.revisarCuentaAhorro();
	    break;
	case 3: this.manejarCuenta();
	    break;
	case 4: this.manejarCuentaAhorro();
	    break;
	case 5: this.añadirEntrada();
	    break;
	case 6: this.revisarAgenda();
	    break;
	case 7: this.añadirGasto();
	    break;
	case 8: this.revisarGastos();
	    break;
	case 9: this.cerrarSesion();
	    break;
	}
    }
    
    
}
