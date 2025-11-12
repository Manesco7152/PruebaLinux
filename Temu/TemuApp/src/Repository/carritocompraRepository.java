package Repository;

import Config.Conn;
import Model.carritocompra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class carritocompraRepository {

    public void agregarAlCarrito(carritocompra carrito) throws SQLException {
        String sql = "INSERT INTO carrito_compras (id_usuario, id_producto, cantidad, fecha_agregado) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carrito.getIdUsuario());
            pstmt.setInt(2, carrito.getIdProducto());
            pstmt.setInt(3, carrito.getCantidad());
            pstmt.setString(4, String.valueOf(carrito.getFechaAgregado()));
            pstmt.executeUpdate();
        }
    }

    public carritocompra obtenerCarritoPorId(int id) throws SQLException {
        String sql = "SELECT id_carrito, id_usuario, id_producto, cantidad, fecha_agregado FROM carrito_compras WHERE id_carrito = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new carritocompra(rs.getInt("id_carrito"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getInt("cantidad"), rs.getString("fecha_agregado"));
            }
            return null;
        }
    }

    public carritocompra obtenerCarritoPorIdUsuarioYProducto(int idUsuario, int idProducto) throws SQLException {
        String sql = "SELECT id_carrito, id_usuario, id_producto, cantidad, fecha_agregado FROM carrito_compras WHERE id_usuario = ? AND id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new carritocompra(rs.getInt("id_carrito"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getInt("cantidad"), rs.getString("fecha_agregado"));
            }
            return null;
        }
    }

    public List<carritocompra> obtenerCarritoPorIdUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT id_carrito, id_usuario, id_producto, cantidad, fecha_agregado FROM carrito_compras WHERE id_usuario = ?";
        List<carritocompra> carritos = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                carritos.add(new carritocompra(rs.getInt("id_carrito"), rs.getInt("id_usuario"), rs.getInt("id_producto"),
                        rs.getInt("cantidad"), rs.getString("fecha_agregado")));
            }
            return carritos;
        }
    }

    public void actualizarCantidadEnCarrito(int idUsuario, int idProducto, int cantidad) throws SQLException {
        String sql = "UPDATE carrito_compras SET cantidad = ? WHERE id_usuario = ? AND id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cantidad);
            pstmt.setInt(2, idUsuario);
            pstmt.setInt(3, idProducto);
            pstmt.executeUpdate();
        }
    }

    public void eliminarDelCarrito(int idUsuario, int idProducto) throws SQLException {
        String sql = "DELETE FROM carrito_compras WHERE id_usuario = ? AND id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idProducto);
            pstmt.executeUpdate();
        }
    }

    public void eliminarCarrito(int idUsuario) throws SQLException {
        String sql = "DELETE FROM carrito_compras WHERE id_usuario = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();
        }
    }
}
