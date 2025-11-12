package Controller;

import Service.productosService;
import Repository.productosRepository;

public class productosController {
    productosService ps = new productosService();
    productosRepository pr = new productosRepository();
    public void agregarProducto() {
        ps.agregarProducto();
    }
    public void listarProductos() {
        ps.listarProductos();
    }
    public void actualizarProducto() {
        ps.actualizarProducto();
    }
    public void eliminarProducto() {
        ps.eliminarProducto();
    }
}
