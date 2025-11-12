package Controller;

import Service.vendedoresSevice;
import Repository.vendedoresRepository;

public class vendedoresController {
    vendedoresSevice vs = new vendedoresSevice();
    vendedoresRepository vr = new vendedoresRepository();
    public void agregarVendedor() {
        vs.agregarVendedor();
    }
    public void listarVendedores() {
        vs.listarVendedores();
    }
    public void actualizarVendedor() {
        vs.actualizarVendedor();
    }
    public void eliminarVendedor() {
        vs.eliminarVendedor();
    }
    
}
