package Repository;

import Config.Conn;
import Model.pago;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pagoRepository {

    public void crearPago(pago pago) throws SQLException {
        String sql = "INSERT INTO pagos (id_pedido, id_metodo_pago, fecha_pago, monto, transaccion_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pago.getIdPedido());
            pstmt.setInt(2, pago.getIdMetodoPago());
            pstmt.setString(3, String.valueOf(pago.getFechaPago()));
            pstmt.setDouble(4, pago.getMonto());
            pstmt.setString(5, pago.getTransaccionId());
            pstmt.executeUpdate();
        }
    }

    public pago obtenerPagoPorId(int id) throws SQLException {
        String sql = "SELECT id_pago, id_pedido, id_metodo_pago, fecha_pago, monto, transaccion_id FROM pagos WHERE id_pago = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new pago(rs.getInt("id_pago"), rs.getInt("id_pedido"), rs.getInt("id_metodo_pago"), rs.getString("fecha_pago"), rs.getDouble("monto"), rs.getString("transaccion_id"));
            }
            return null;
        }
    }

    public List<pago> obtenerTodosLosPagos() throws SQLException {
        String sql = "SELECT id_pago, id_pedido, id_metodo_pago, fecha_pago, monto, transaccion_id FROM pagos";
        List<pago> pagos = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                pagos.add(new pago(rs.getInt("id_pago"), rs.getInt("id_pedido"), rs.getInt("id_metodo_pago"), rs.getString("fecha_pago"), rs.getDouble("monto"), rs.getString("transaccion_id")));
            }
            return pagos;
        }
    }

    public void actualizarPago(pago pago) throws SQLException {
        String sql = "UPDATE pagos SET id_pedido = ?, id_metodo_pago = ?, fecha_pago = ?, monto = ?, transaccion_id = ? WHERE id_pago = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pago.getIdPedido());
            pstmt.setInt(2, pago.getIdMetodoPago());
            pstmt.setString(3, String.valueOf(pago.getFechaPago()));
            pstmt.setDouble(4, pago.getMonto());
            pstmt.setString(5, pago.getTransaccionId());
            pstmt.setInt(6, pago.getIdPago());
            pstmt.executeUpdate();
        }
    }

    public void eliminarPago(int id) throws SQLException {
        String sql = "DELETE FROM pagos WHERE id_pago = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}