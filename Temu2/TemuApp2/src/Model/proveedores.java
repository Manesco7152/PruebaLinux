package Model;

public class proveedores {
    int id_proveedor;
    String nombre;
    String telefono;
    String correo;
    
    public proveedores() {}

    public proveedores(int id_proveedor, String nombre, String telefono, String correo) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "proveedores [id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", telefono=" + telefono
                + ", correo=" + correo + "]";
    }
    
}
