package Repository;

import Model.pagos;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class pagosRepository {
    Scanner op = new Scanner(System.in);
    pagos p = new pagos();
    Conn con = new Conn();

    public void agregarPago(pagos p) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.pagos (id_pedido, id_metodo_pago, fecha_pago, monto) VALUES (?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, p.getId_pedido());
            ps.setInt(2, p.getId_metodo_pago());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setDouble(4, p.getMonto());
            ps.executeUpdate();
            System.out.println("Pago agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar pago");
            e.printStackTrace();
        }
    }

    public List<pagos> ListarPagos() {
        List<pagos> pagos = new ArrayList<>();
        String sql = "SELECT p.id_pago, p.id_pedido, p.id_metodo_pago, m.nombre AS metodo_pago_nombre, " +
        "p.fecha_pago, p.monto " +
        "FROM temu.pagos p " +
        "LEFT JOIN temu.pedidos pe ON p.id_pedido = pe.id_pedido " +
        "INNER JOIN temu.metodos_pago m ON p.id_metodo_pago = m.id_metodo_pago";
   try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Pagos:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_pago") + " - " +
                    rs.getInt("id_pedido") + " - " +
                    rs.getString("metodo_pago_nombre") + " - " +   // ← aquí está el dato que quieres ver
                    rs.getTimestamp("fecha_pago") + " - " +
                    rs.getDouble("monto")
                );
            }
            return pagos;
        } catch (Exception e) {
            System.out.println("Error al listar pagos");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarPago(pagos p) {
        String sql = "UPDATE temu.pagos SET id_pedido = ?, id_metodo_pago = ?, fecha_pago = ?, monto = ? WHERE id_pago = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_pedido());
            ps.setInt(2, p.getId_metodo_pago());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setDouble(4, p.getMonto());
            ps.setInt(5, p.getId_pago());
            ps.executeUpdate();
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Pago actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun pago con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar pago");
            e.printStackTrace();
        }
    }

    public void eliminarPago(pagos p) {
        String sql = "DELETE FROM temu.pagos WHERE id_pago = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_pago());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Pago eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun pago con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar pago");
        }
    }
}
