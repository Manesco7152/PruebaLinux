package Model;

public class productos {
    int id_producto;
    int id_vendedor;
    String nombre_producto;
    String descripcion_corta;
    Double precio;
    int stock;
    String codigo_producto;

    public productos() {
    }

    public productos(int id_producto, int id_vendedor, String nombre_producto, String descripcion_corta, Double precio, int stock, String codigo_producto) {
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.nombre_producto = nombre_producto;
        this.descripcion_corta = descripcion_corta;
        this.precio = precio;
        this.stock = stock;
        this.codigo_producto = codigo_producto;
    }
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    @Override
    public String toString() {
        return "productos [id producto=" + id_producto + ", id vendedor=" + id_vendedor + ", nombre_producto="
                + nombre_producto + ", descripcion_corta=" + descripcion_corta + ", precio=" + precio + ", stock="
                + stock + ", codigo_producto=" + codigo_producto + "]";
    }

}
