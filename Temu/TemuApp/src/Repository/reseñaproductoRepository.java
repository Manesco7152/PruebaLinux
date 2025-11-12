package Repository;

import Config.Conn;
import Model.reseñaproducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class reseñaproductoRepository {

    public void crearResena(reseñaproducto resena) throws SQLException {
        String sql = "INSERT INTO resenas_productos (id_usuario, id_producto, calificacion, comentario, fecha_resena) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, resena.getIdUsuario());
            pstmt.setInt(2, resena.getIdProducto());
            pstmt.setString(3, resena.getCalificacion());
            pstmt.setString(4, resena.getComentario());
            pstmt.setString(5, String.valueOf(resena.getFechaResena()));
            pstmt.executeUpdate();
        }
    }

    public reseñaproducto obtenerResenaPorId(int id) throws SQLException {
        String sql = "SELECT id_resena, id_usuario, id_producto, calificacion, comentario, fecha_resena FROM resenas_productos WHERE id_resena = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new reseñaproducto(rs.getInt("id_resena"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getString("calificacion"), rs.getString("comentario"), rs.getString("fecha_resena"));
            }
            return null;
        }
    }

    public List<reseñaproducto> obtenerResenasPorIdProducto(int idProducto) throws SQLException {
        String sql = "SELECT id_resena, id_usuario, id_producto, calificacion, comentario, fecha_resena FROM resenas_productos WHERE id_producto = ?";
        List<reseñaproducto> resenas = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resenas.add(new reseñaproducto(rs.getInt("id_resena"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getString("calificacion"), rs.getString("comentario"), rs.getString("fecha_resena")));
            }
            return resenas;
        }
    }

    public List<reseñaproducto> obtenerTodasLasResenas() throws SQLException {
        String sql = "SELECT id_resena, id_usuario, id_producto, calificacion, comentario, fecha_resena FROM resenas_productos";
        List<reseñaproducto> resenas = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                resenas.add(new reseñaproducto(rs.getInt("id_resena"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getString("calificacion"), rs.getString("comentario"), rs.getString("fecha_resena")));
            }
            return resenas;
        }
    }

    public void actualizarResena(reseñaproducto resena) throws SQLException { // <--- Add this method
        String sql = "UPDATE reseñas_producto SET id_usuario = ?, id_producto = ?, calificacion = ?, comentario = ?, fecha_resena = ? WHERE id_resena = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, resena.getIdUsuario());
            pstmt.setInt(2, resena.getIdProducto());
            pstmt.setString(3, resena.getCalificacion());
            pstmt.setString(4, resena.getComentario());
            pstmt.setString(5, resena.getFechaResena()); // Make sure this returns String
            pstmt.setInt(6, resena.getIdResena());
            pstmt.executeUpdate();
        }
    }
    public void eliminarResena(int id) throws SQLException { // <--- Este método es necesario
        String sql = "DELETE FROM reseñas_producto WHERE id_resena = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
