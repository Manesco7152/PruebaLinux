package Repository;

import Model.inventario;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class inventarioRepository {
    Scanner op = new Scanner(System.in);
    inventario i = new inventario();
    Conn con = new Conn();

    public void agregarInventario(inventario i) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.inventario (id_producto, id_proveedor, cantidad, fecha_entrada) VALUES (?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, i.getId_producto());
            ps.setInt(2, i.getId_proveedor());
            ps.setInt(3, i.getCantidad());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            System.out.println("Inventario agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar inventario");
            e.printStackTrace();
        }
    }

    public List<inventario> ListarInventarios() {
        List<inventario> inventarios = new ArrayList<>();
        String sql = "SELECT i.id_inventario, p.nombre_producto, pr.nombre AS nombre_proveedor, " +
                "i.cantidad, i.fecha_entrada " +
                "FROM temu.inventario i " +
                "INNER JOIN temu.productos p ON i.id_producto = p.id_producto " +
                "INNER JOIN temu.proveedores pr ON i.id_proveedor = pr.id_proveedor";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Inventarios:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_inventario") + " - " +
                                rs.getString("nombre_producto") + " - " +
                                rs.getString("nombre_proveedor") + " - " +
                                rs.getInt("cantidad") + " - " +
                                rs.getTimestamp("fecha_entrada"));
            }
            return inventarios;
        } catch (Exception e) {
            System.out.println("Error al listar inventarios");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarInventario(inventario i) {
        String sql = "UPDATE temu.inventario SET id_producto = ?, id_proveedor = ?, cantidad = ?, fecha_entrada = ? WHERE id_inventario = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, i.getId_producto());
            ps.setInt(2, i.getId_proveedor());
            ps.setInt(3, i.getCantidad());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setInt(5, i.getId_inventario());
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Inventario actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun inventario con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar inventario");
            e.printStackTrace();
        }
    }

    public void eliminarInventario(inventario i) {
        String sql = "DELETE FROM temu.inventario WHERE id_inventario = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, i.getId_inventario());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Inventario eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun inventario con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar inventario");
            e.printStackTrace();
        }
    }

}
