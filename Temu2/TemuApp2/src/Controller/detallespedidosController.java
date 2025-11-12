package Controller;

import Service.detallespedidosService;
import Repository.detallespedidosRepository;

public class detallespedidosController {
    detallespedidosService ds = new detallespedidosService();
    detallespedidosRepository dr = new detallespedidosRepository();
    public void agregarDetallePedido() {
        ds.agregarDetallePedido();
    }
    public void listarDetallesPedidos() {
        ds.listarDetallesPedidos();
    }
    public void actualizarDetallePedido() {
        ds.actualizarDetallePedido();
    }
    public void eliminarDetallePedido() {
        ds.eliminarDetallePedido();
    }
}
