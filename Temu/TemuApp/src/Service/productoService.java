package Service;

import Model.categoria;
import Model.producto;

import java.sql.SQLException;
import java.util.List;


public class productoService {
    private final Repository.productoRepository productoRepository;

    public productoService() {
        this.productoRepository = new Repository.productoRepository();
    }

    public void crearProducto(producto producto) {
        try {
            productoRepository.crearProducto(producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public producto obtenerProductoPorId(int id) {
        try {
            return productoRepository.obtenerProductoPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Model.producto> obtenerTodosLosProductos() {
        try {
            return productoRepository.obtenerTodosLosProductos();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarProducto(producto producto) {
        try {
            productoRepository.actualizarProducto(producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int id) {
        try {
            productoRepository.eliminarProducto(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para Categorías e Inventario (podrías tener servicios separados)
    public void crearCategoria(categoria categoria) throws SQLException {
        productoRepository.crearCategoria(categoria);
    }
}
