package Repository;

import Model.pedidos;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class pedidosRepository {
    Scanner op = new Scanner(System.in);
    pedidos p = new pedidos();
    Conn con = new Conn();

    public void agregarPedido(pedidos p) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.pedidos (id_usuario, fecha_pedido, estado, total, id_direccion_envio) VALUES (?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, p.getId_usuario());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setString(3, p.getEstado());
            ps.setDouble(4, p.getTotal());
            ps.setInt(5, p.getId_direccion_envio());
            ps.executeUpdate();
            System.out.println("Pedido agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar pedido");
            e.printStackTrace();
        }
    }

    public List<pedidos> ListarPedidos() {
        List<pedidos> pedidos = new ArrayList<>();
        String sql = "SELECT p.id_pedido, u.nombre_usuario AS nombre_usuario, p.fecha_pedido, " +
                "p.estado, p.total, d.calle, d.ciudad, d.codigo_postal " +
                "FROM temu.pedidos p " +
                "INNER JOIN temu.direcciones d ON p.id_direccion_envio = d.id_direccion " +
                "INNER JOIN temu.usuario u ON p.id_usuario = u.id_usuario";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Pedidos:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_pedido") + " - " +
                                rs.getString("nombre_usuario") + " - " +
                                rs.getTimestamp("fecha_pedido") + " - " +
                                rs.getString("estado") + " - " +
                                rs.getDouble("total") + " - " +
                                rs.getString("calle") + ", " +
                                rs.getString("ciudad") + " (" +
                                rs.getString("codigo_postal") + ")");
            }

            return pedidos;
        } catch (Exception e) {
            System.out.println("Error al listar pedidos");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarPedido(pedidos p) {
        String sql = "UPDATE temu.pedidos SET id_usuario = ?, fecha_pedido = ?, estado = ?, total = ?, id_direccion_envio = ? WHERE id_pedido = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_usuario());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setString(3, p.getEstado());
            ps.setDouble(4, p.getTotal());
            ps.setInt(5, p.getId_direccion_envio());
            ps.setInt(6, p.getId_pedido());
            ps.executeUpdate();
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Pedido actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun pedido con ese ID");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar pedido");
            e.printStackTrace();
        }
    }

    public void eliminarPedido(pedidos p) {
        String sql = "DELETE FROM temu.pedidos WHERE id_pedido = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_pedido());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Pedido eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun pedido con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar pedidos");
        }
    }
}
