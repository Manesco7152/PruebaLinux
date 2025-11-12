package Controller;

import Service.metodospagoService;
import Repository.metodospagoRepository;

public class metodospagoController {
    metodospagoService ms = new metodospagoService();
    metodospagoRepository mr = new metodospagoRepository();
    public void agregarMetodoPago() {
        ms.agregarMetodoPago();
    }
    public void listarMetodosPago() {
        ms.listarMetodosPago();
    }
    public void actualizarMetodoPago() {
        ms.actualizarMetodoPago();
    }
    public void eliminarMetodoPago() {
        ms.eliminarMetodoPago();
    }
}
