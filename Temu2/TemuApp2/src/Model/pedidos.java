
package Model;

import java.sql.Timestamp;

public class pedidos {
    int id_pedido;
    int id_usuario;
    Timestamp fecha_pedido;
    String estado;
    double total;
    int id_direccion_envio;

    public pedidos() {}

    public pedidos(int id_pedido, int id_usuario, Timestamp fecha_pedido, String estado, double total, int id_direccion_envio) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.fecha_pedido = fecha_pedido;
        this.estado = estado;
        this.total = total;
        this.id_direccion_envio = id_direccion_envio;
    }
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Timestamp getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Timestamp fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_direccion_envio() {
        return id_direccion_envio;
    }

    public void setId_direccion_envio(int id_direccion_envio) {
        this.id_direccion_envio = id_direccion_envio;
    }

    @Override
    public String toString() {
        return "pedidos [id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", fecha_pedido=" + fecha_pedido
                + ", estado=" + estado + ", total=" + total + ", id_direccion_envio=" + id_direccion_envio + "]";
    }
    
}
