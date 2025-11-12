package Model;

public class producto {
    private int idProducto;
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private String precio;
    private int stock;
    private String fechaAlta;

    public producto (){}

    public producto(int idProducto, int idCategoria, String nombre, String descripcion, String precio, int stock,String fechaAlta) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaAlta = fechaAlta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "producto [idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", nombre=" + nombre
                + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", fechaAlta="
                + fechaAlta + "]";
    }

    
}
