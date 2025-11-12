package Model;


public class carritocompra {
    private int idCarrito;
    private int idUsuario;
    private int idProducto;
    private int cantidad;
    private String fechaAgregado;

    public carritocompra(){} 

    public carritocompra(int idCarrito, int idUsuario, int idProducto, int cantidad, String fechaAgregado) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fechaAgregado = fechaAgregado;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(String fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    @Override
    public String toString() {
        return "carritocompra [idCarrito=" +  idCarrito + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto
                + ", cantidad=" + cantidad + ", fechaAgregado=" + fechaAgregado + "]";
    }
}
