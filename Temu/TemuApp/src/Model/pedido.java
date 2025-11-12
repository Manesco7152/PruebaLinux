package Model;

import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int idPedido;
    private int idUsuario;
    private String fechaPedido;
    private String estado;
    private String total;
    private int idDireccionEnvio;
    private List<detallepedido> detalles;

    public pedido() {
    }

    public pedido(int idPedido, int idUsuario, String fechaPedido, String estado, String total, int idDireccionEnvio,
            List<detallepedido> detalles) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
        this.idDireccionEnvio = idDireccionEnvio;
        this.detalles = new ArrayList<>(); 
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotalAsDouble() {
        try {
            return Double.parseDouble(this.total);
        } catch (NumberFormatException e) {
            System.err.println("Advertencia: El total del pedido '" + this.total
                    + "' no es un número válido. Retornando 0.0. " + e.getMessage());
            // You might want to log this error, or throw a custom exception
            return 0.0; // Or handle as appropriate
        }
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getIdDireccionEnvio() {
        return idDireccionEnvio;
    }

    public void setIdDireccionEnvio(int idDireccionEnvio) {
        this.idDireccionEnvio = idDireccionEnvio;
    }

    public List<detallepedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detallepedido> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "pedido [idPedido=" + idPedido + ", idUsuario=" + idUsuario + ", fechaPedido=" + fechaPedido
                + ", estado=" + estado + ", total=" + total + ", idDireccionEnvio=" + idDireccionEnvio + ", detalles="
                + detalles + "]";
    }

}
