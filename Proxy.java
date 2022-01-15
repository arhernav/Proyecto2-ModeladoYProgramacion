/**
 * Interfaz para asegurar el correcto funcionamento de proxy
 */
public interface Proxy {

    public long añadirCuenta(long cantidad);

    public long añadirAhorro(long cantidad);

    public long descontarAhorro(long cantidad);

    public long descontarCuenta(long cantidad);

}
