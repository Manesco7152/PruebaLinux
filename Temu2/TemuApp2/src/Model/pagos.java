package Model;

import java.sql.Timestamp;

public class pagos {
    int id_pago;
    int id_pedido;
    int id_metodo_pago;
    Timestamp fecha_pago;
    double monto;

    public pagos() {}

    public pagos(int id_pago, int id_pedido, int id_metodo_pago, Timestamp fecha_pago, double monto) {
        this.id_pago = id_pago;
        this.id_pedido = id_pedido;
        this.id_metodo_pago = id_metodo_pago;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }
    public int getId_pago() {
        return id_pago;
    }
    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public Timestamp getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Timestamp fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "pagos [id_pago=" + id_pago + ", id_pedido=" + id_pedido + ", id_metodo_pago=" + id_metodo_pago
                + ", fecha_pago=" + fecha_pago + ", monto=" + monto + "]";
    }
    
}
