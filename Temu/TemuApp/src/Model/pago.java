package Model;

public class pago {
    private int idPago;
    private int idPedido;
    private int idMetodoPago;
    private String fechaPago;
    private double monto;
    private String transaccionId;

    public pago(){}

    public pago(int idPago, int idPedido, int idMetodoPago, String fechaPago, double monto, String transaccionId) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.idMetodoPago = idMetodoPago;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.transaccionId = transaccionId;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    @Override
    public String toString() {
        return "pago [idPago=" + idPago + ", idPedido=" + idPedido + ", idMetodoPago=" + idMetodoPago + ", fechaPago="
                + fechaPago + ", monto=" + monto + ", transaccionId=" + transaccionId + "]";
    }
}
