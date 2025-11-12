package Controller;

import Service.proveedoresService;
import Repository.proveedoresRepository;

public class proveedoresController {
    proveedoresService ps = new proveedoresService();
    proveedoresRepository pr = new proveedoresRepository();
    public void agregarProveedor() {
        ps.agregarProveedor();
    }
    public void listarProveedores() {
        ps.listarProveedores();
    }
    public void actualizarProveedor() {
        ps.actualizarProveedor();
    }
    public void eliminarProveedor() {
        ps.eliminarProveedor();
    }
}
