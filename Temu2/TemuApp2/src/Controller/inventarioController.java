package Controller;

import Service.inventarioService;
import Repository.inventarioRepository;

public class inventarioController {
    inventarioService is = new inventarioService();
    inventarioRepository ir = new inventarioRepository();
    public void agregarInventario() {
        is.agregarInventario();
    }
    public void listarInventarios() {
        is.listarInventarios();
    }
    public void actualizarInventario() {
        is.actualizarInventario();
    }
    public void eliminarInventario() {
        is.eliminarInventario();
    }
}
