package Repository;

import Model.proveedores;
import Config.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class proveedoresRepository {
    Scanner op = new Scanner(System.in);
    proveedores p = new proveedores();
    Conn con = new Conn();

    public void agregarProveedor(proveedores p) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.proveedores (nombre, telefono, correo) VALUES (?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getCorreo());
            ps.executeUpdate();
            System.out.println("Proveedor agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar proveedor");
            e.printStackTrace();
        }
    }

    public List<proveedores> ListarProveedores() {
        List<proveedores> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM temu.proveedores";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Proveedores:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_proveedor") + " - " + rs.getString("nombre") + " - " + rs.getString("telefono") + " - "
                        + rs.getString("correo"));
            }
            return proveedores;
        } catch (Exception e) {
            System.out.println("Error al listar proveedores");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarProveedor(proveedores p) {
        String sql = "UPDATE temu.proveedores SET nombre = ?, telefono = ?, correo = ? WHERE id_proveedor = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getCorreo());
            ps.setInt(4, p.getId_proveedor());
            ps.executeUpdate();
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Proveedor actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun proveedor con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar proveedor");
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(proveedores p) {
        String sql = "DELETE FROM temu.proveedores WHERE id_proveedor = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_proveedor());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Proveedor eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun proveedor con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar proveedor");
            e.printStackTrace();
        }
    }
    
}
