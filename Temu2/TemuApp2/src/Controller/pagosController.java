package Controller;

import Service.pagosService;
import Repository.pagosRepository;

public class pagosController {
    pagosService ps = new pagosService();
    pagosRepository pr = new pagosRepository();
    public void agregarPago() {
        ps.agregarPago();
    }
    public void listarPagos() {
        ps.listarPagos();
    }
    public void actualizarPago() {
        ps.actualizarPago();
    }
    public void eliminarPago() {
        ps.eliminarPago();
    }
}
