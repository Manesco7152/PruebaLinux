package Model;

public class metodospago {
    int id_metodo_pago;
    String nombre;
    String descripcion;

    public metodospago() {}

    public metodospago(int id_metodo_pago, String nombre, String descripcion) {
        this.id_metodo_pago = id_metodo_pago;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
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
        return "metodospago [id_metodo_pago=" + id_metodo_pago + ", nombre=" + nombre + ", descripcion=" + descripcion
                + "]";
    }
    
}
