package Model;

public class metodopago {
    private int idMetodoPago;
    private String nombre;
    private String descripcion;

    public metodopago(){}

    public metodopago(int idMetodoPago, String nombre, String descripcion) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "metodopago [idMetodoPago=" + idMetodoPago + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
}
