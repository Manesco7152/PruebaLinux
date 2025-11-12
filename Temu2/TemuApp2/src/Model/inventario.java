package Model;

import java.sql.Timestamp;

public class inventario {
    int id_inventario;
    int id_producto;
    int id_proveedor;
    int cantidad;
    Timestamp fecha_entrada;

    public inventario() {}

    public inventario(int id_inventario, int id_producto, int id_proveedor, int cantidad, Timestamp fecha_entrada) {
        this.id_inventario = id_inventario;
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.cantidad = cantidad;
        this.fecha_entrada = fecha_entrada;
    }
    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Timestamp fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    @Override
    public String toString() {
        return "inventario [id cartito=" + id_inventario + ", id_producto=" + id_producto + ", id_proveedor="
                + id_proveedor + ", cantidad=" + cantidad + ", fecha_entrada=" + fecha_entrada + "]";
    }
    
}
