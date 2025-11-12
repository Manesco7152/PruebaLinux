package Controller;

import Service.direccionesService;
import Repository.direccionesRepository;

public class direccionesController {
    direccionesService ds = new direccionesService();
    direccionesRepository dr = new direccionesRepository();
    public void agregarDireccion() {
        ds.agregarDireccion();
    }
    public void listarDirecciones() {
        ds.listarDirecciones();
    }
    public void actualizarDireccion() {
        ds.actualizarDireccion();
    }
    public void eliminarDireccion() {
        ds.eliminarDireccion();
    }
 
}
