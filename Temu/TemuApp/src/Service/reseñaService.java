package Service;

import Model.reseñaproducto;
import Repository.reseñaproductoRepository;

import java.sql.SQLException;
import java.util.List;

public class reseñaService {
    private final reseñaproductoRepository resenaProductoRepository;
    private reseñaproducto resena;

    public reseñaService() {
        this.resenaProductoRepository = new reseñaproductoRepository();
    }

    public void crearResena(int idUsuario, int idProducto, int calificacion, String comentario, String fechaReseña) {
        if (idUsuario <= 0 || idProducto <= 0 || calificacion < 1 || calificacion > 5) {
            System.err.println("Error: Datos de reseña no válidos.");
            return;
        }
        resena = new reseñaproducto(0, idUsuario, idProducto, String.valueOf(calificacion), comentario, fechaReseña);
        try {
            resenaProductoRepository.crearResena(resena);
            System.out.println("Reseña creada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la reseña: " + e.getMessage());
        }
    }
    public reseñaproducto obtenerResenaPorId(int id) {
         if (id <= 0) {
            System.err.println("Error: ID de resena no válido.");
            return null;
        }
        try {
            return resenaProductoRepository.obtenerResenaPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener la resena: " + e.getMessage());
            return null;
        }
    }

    public List<reseñaproducto> obtenerResenasPorIdProducto(int idProducto) {
        if (idProducto <= 0) {
            System.err.println("Error: ID de producto no válido.");
            return null;
        }
        try {
            return resenaProductoRepository.obtenerResenasPorIdProducto(idProducto);
        } catch (SQLException e) {
            System.err.println("Error al obtener las reseñas: " + e.getMessage());
            return null;
        }
    }

    public void actualizarResena(reseñaproducto resena) { // <--- Add this method
        if (resena == null || resena.getIdResena() <= 0) {
            System.err.println("Error: Reseña no válida para actualizar.");
            return;
        }
        try {
            resenaProductoRepository.actualizarResena(resena);
        } catch (SQLException e) {
            System.err.println("Error al actualizar la reseña: " + e.getMessage());
            // Handle error
        }
    }
    public void eliminarResena(int id) { // <--- Este método es necesario
        if (id <= 0) {
            System.err.println("Error: ID de reseña no válido para eliminar.");
            return;
        }
        try {
            resenaProductoRepository.eliminarResena(id);
        } catch (SQLException e) {
            System.err.println("Error al eliminar la reseña: " + e.getMessage());
            // Maneja el error, quizás lanzando una excepción personalizada
        }
    }
}