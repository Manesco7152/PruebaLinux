package Controller;

import Service.carritocomprasService;
import Repository.carritocomprasRepository;

public class carritocomprasController {
    carritocomprasService cs = new carritocomprasService();
    carritocomprasRepository cr = new carritocomprasRepository();

    public void agregarCarritoCompras() {
        cs.agregarCarritoCompras();
    }

    public void listarCarritoCompras() {
        cs.listarCarritoCompras();
    }
    public void actualizarCarritoCompra() {
        cs.actualizarCarritoCompra();
    }
    public void eliminarCarritoCompra() {
        cs.eliminarCarritoCompra();
    }
}
