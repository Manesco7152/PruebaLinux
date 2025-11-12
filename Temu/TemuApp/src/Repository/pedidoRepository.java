package Repository;

import Config.Conn;
import Model.pedido;
import Model.detallepedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pedidoRepository {

    public void crearPedido(pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedidos (id_usuario, fecha_pedido, estado, total, id_direccion_envio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, pedido.getIdUsuario());
            pstmt.setString(2, String.valueOf(pedido.getFechaPedido()));
            pstmt.setString(3, pedido.getEstado());
            pstmt.setDouble(4, pedido.getTotalAsDouble());
            pstmt.setInt(5, pedido.getIdDireccionEnvio());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                pedido.setIdPedido(generatedKeys.getInt(1));
            }
        }
    }

    public pedido obtenerPedidoPorId(int id) throws SQLException {
        String sql = "SELECT id_pedido, id_usuario, fecha_pedido, estado, total, id_direccion_envio FROM pedidos WHERE id_pedido = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new pedido(rs.getInt("id_pedido"), rs.getInt("id_usuario"), rs.getString("fecha_pedido"), rs.getString("estado"), rs.getString("total"), (Integer) rs.getInt("id_direccion_envio"), null);
            }
            return null;
        }
    }

    public List<pedido> obtenerTodosLosPedidos() throws SQLException {
        String sql = "SELECT id_pedido, id_usuario, fecha_pedido, estado, total, id_direccion_envio FROM pedidos";
        List<pedido> pedidos = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(new pedido(rs.getInt("id_pedido"), rs.getInt("id_usuario"), rs.getString("fecha_pedido"), rs.getString("estado"), rs.getString("total"), (Integer) rs.getInt("id_direccion_envio"), null));
            }
            return pedidos;
        }
    }

    public void actualizarPedido(pedido pedido) throws SQLException {
        String sql = "UPDATE pedidos SET id_usuario = ?, fecha_pedido = ?, estado = ?, total = ?, id_direccion_envio = ? WHERE id_pedido = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getIdUsuario());
            pstmt.setString(2, String.valueOf(pedido.getFechaPedido()));
            pstmt.setString(3, pedido.getEstado());
            pstmt.setDouble(4, pedido.getTotalAsDouble());
            pstmt.setInt(5, pedido.getIdDireccionEnvio());
            pstmt.setInt(6, pedido.getIdPedido());
            pstmt.executeUpdate();
        }
    }

    public void eliminarPedido(int id) throws SQLException {
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Métodos para Detalles de Pedido
    public void crearDetallePedido(detallepedido detallePedido) throws SQLException {
        String sql = "INSERT INTO detalles_pedido (id_pedido, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detallePedido.getIdPedido());
            pstmt.setInt(2, detallePedido.getIdProducto());
            pstmt.setInt(3, detallePedido.getCantidad());
            pstmt.setInt(4, detallePedido.getPrecioUnitario());
            pstmt.setInt(5, detallePedido.getSubtotal());
            pstmt.executeUpdate();
        }
    }

    public detallepedido obtenerDetallePedidoPorId(int id) throws SQLException {
        String sql = "SELECT id_detalle, id_pedido, id_producto, cantidad, precio_unitario, subtotal FROM detalles_pedido WHERE id_detalle = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new detallepedido(rs.getInt("id_detalle"), rs.getInt("id_pedido"), rs.getInt("id_producto"),
                        rs.getInt("cantidad"), rs.getInt("precio_unitario"), rs.getInt("subtotal"));
            }
            return null;
        }
    }

    public List<detallepedido> obtenerDetallesPedidoPorIdPedido(int idPedido) throws SQLException {
        String sql = "SELECT id_detalle, id_pedido, id_producto, cantidad, precio_unitario, subtotal FROM detalles_pedido WHERE id_pedido = ?";
        List<detallepedido> detalles = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                detalles.add(new detallepedido(rs.getInt("id_detalle"), rs.getInt("id_pedido"), rs.getInt("id_producto"),
                        rs.getInt("cantidad"), rs.getInt("precio_unitario"), rs.getInt("subtotal")));
            }
            return detalles;
        }
    }

    public void actualizarDetallePedido(detallepedido detallePedido) throws SQLException {
        String sql = "UPDATE detalles_pedido SET id_pedido = ?, id_producto = ?, cantidad = ?, precio_unitario = ?, subtotal = ? WHERE id_detalle = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detallePedido.getIdPedido());
            pstmt.setInt(2, detallePedido.getIdProducto());
            pstmt.setInt(3, detallePedido.getCantidad());
            pstmt.setInt(4, detallePedido.getPrecioUnitario());
            pstmt.setInt(5, detallePedido.getSubtotal());
            pstmt.setInt(6, detallePedido.getIdDetalle());
            pstmt.executeUpdate();
        }
    }

    public void eliminarDetallePedido(int id) throws SQLException {
        String sql = "DELETE FROM detalles_pedido WHERE id_detalle = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}