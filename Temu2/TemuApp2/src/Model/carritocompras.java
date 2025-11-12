package Model;

import java.sql.Timestamp;

public class carritocompras {
    int id_carrito;
    int id_usuario;
    int id_producto;
    int cantidad;
    Timestamp fecha_agregado;

    public carritocompras() {}

    public carritocompras(int id_carrito, int id_usuario, int id_producto, int cantidad, Timestamp fecha_agregado) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.fecha_agregado = fecha_agregado;
    }
    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha_agregado() {
        return fecha_agregado;
    }

    public void setFecha_agregado(Timestamp fecha_agregado) {
        this.fecha_agregado = fecha_agregado;
    }

    @Override
    public String toString() {
        return "carritocompras [id_carrito=" + id_carrito + ", id_usuario=" + id_usuario + ", id_producto="
                + id_producto + ", cantidad=" + cantidad + ", fecha_agregado=" + fecha_agregado + "]";
    }
    
}
