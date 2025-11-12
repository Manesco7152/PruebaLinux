package Controller;

import Service.categoriasService;
import Repository.categoriasRepository;

public class categoriasController {
    categoriasService cs = new categoriasService();
    categoriasRepository cr = new categoriasRepository();
    public void agregarCategoria() {
        cs.agregarCategoria();
    }
    public void listarCategorias() {
        cs.listarCategorias();
    }
    public void actualizarCategoria() {
        cs.actualizarCategoria();
    }
    public void eliminarCategoria() {
        cs.eliminarCategoria();
    }
}
