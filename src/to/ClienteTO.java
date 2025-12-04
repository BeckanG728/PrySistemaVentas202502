
package to;

/**
 * @author
 */
public class ClienteTO {
    private int idCliente;
    private String ruc;
    private String nombre;
    private String direccion;
    private int idDistrito;
    private String telefono;
    private String celular;
    private String email;
    private String observacion;
    private int estado;

    // Constructor vacío
    public ClienteTO() {
    }

    // Constructor completo
    public ClienteTO(int idCliente, String ruc, String nombre, String direccion,
                   int idDistrito, String telefono, String celular,
                   String email, String observacion, int estado) {
        this.idCliente = idCliente;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idDistrito = idDistrito;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.observacion = observacion;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
