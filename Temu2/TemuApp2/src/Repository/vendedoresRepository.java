package Repository;

import Model.vendedores;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class vendedoresRepository {
    Scanner op = new Scanner(System.in);
    vendedores v = new vendedores();
    Conn con = new Conn();

    public void agregarVendedor(vendedores v) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.vendedores (id_usuario, nombre_tienda, descripcion, url_logo, fecha_establecimiento) VALUES (?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, v.getId_usuario());
            ps.setString(2, v.getNombre_tienda());
            ps.setString(3, v.getDescripcion());
            ps.setString(4, v.getUrl_logo());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            System.out.println("Vendedor agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar vendedor");
            e.printStackTrace();
        }
    }

    public List<vendedores> ListarVendedores() {
        List<vendedores> vendedores = new ArrayList<>();
        String sql = "SELECT v.id_vendedor, u.nombre_usuario AS nombre_usuario, v.nombre_tienda, " +
                "v.descripcion, v.url_logo, v.fecha_establecimiento " +
                "FROM temu.vendedores v " +
                "INNER JOIN temu.usuario u ON v.id_usuario = u.id_usuario";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Vendedores:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_vendedor") + " - " +
                                rs.getString("nombre_usuario") + " - " +
                                rs.getString("nombre_tienda") + " - " +
                                rs.getString("descripcion") + " - " +
                                rs.getString("url_logo") + " - " +
                                rs.getTimestamp("fecha_establecimiento"));
            }
            return vendedores;
        } catch (Exception e) {
            System.out.println("Error al listar vendedores");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarVendedor(vendedores v) {
        String sql = "UPDATE temu.vendedores SET id_usuario = ?, nombre_tienda = ?, descripcion = ?, url_logo = ?, fecha_establecimiento = ? WHERE id_vendedor = ?";
        try (Connection cn = con.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, v.getId_usuario());
            ps.setString(2, v.getNombre_tienda());
            ps.setString(3, v.getDescripcion());
            ps.setString(4, v.getUrl_logo());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.setInt(6, v.getId_vendedor());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Vendedor actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun vendedor con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar vendedor");
            e.printStackTrace();
        }
    }

    public void eliminarVendedor(vendedores v) {
        String sql = "DELETE FROM temu.vendedores WHERE id_usuario = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, v.getId_usuario());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Vendedor eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun vendedor con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar vendedor");
            e.printStackTrace();
        }
    }
}
