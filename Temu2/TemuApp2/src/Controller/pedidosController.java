package Controller;

import Service.pedidosService;
import Repository.pedidosRepository;

public class pedidosController {
    pedidosService ps = new pedidosService();
    pedidosRepository pr = new pedidosRepository();
    public void agregarPedido() {
        ps.agregarPedido();
    }
    public void listarPedidos() {
        ps.listarPedidos();
    }
    public void actualizarPedido() {
        ps.actualizarPedido();
    }
    public void eliminarPedido() {
        ps.eliminarPedido();
    }
}
