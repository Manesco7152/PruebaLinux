package Model;

import java.time.LocalDateTime;

public class inventario {
    private int idInventario;
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private LocalDateTime fechaEntrada;

    public inventario(){}

    public inventario(int idInventario, int idProducto, int idProveedor, int cantidad, LocalDateTime fechaEntrada) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public String toString() {
        return "inventario [idInventario=" + idInventario + ", idProducto=" + idProducto + ", idProveedor="
                + idProveedor + ", cantidad=" + cantidad + ", fechaEntrada=" + fechaEntrada + "]";
    }

    
}
