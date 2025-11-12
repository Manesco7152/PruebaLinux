package Repository;

import Model.metodospago;
import Config.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class metodospagoRepository {
    Scanner op = new Scanner(System.in);
    metodospago m = new metodospago();
    Conn con = new Conn();

    public void agregarMetodoPago(metodospago m) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.metodos_pago (nombre, descripcion) VALUES (?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.executeUpdate();
            System.out.println("Metodo pago agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar metodo pago");
            e.printStackTrace();
        }
    }

    public void listarMetodosPago() {
        String sql = "SELECT * FROM temu.metodos_pago";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Metodos de Pago:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_metodo_pago") + " " + rs.getString("nombre") + " " + rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar metodos pago");
            e.printStackTrace();
        }
    }

    public void actualizarMetodoPago(metodospago m) {
        String sql = "UPDATE temu.metodos_pago SET nombre = ?, descripcion = ? WHERE id_metodo_pago = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.setInt(3, m.getId_metodo_pago());
            ps.executeUpdate();
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Metodo pago actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun metodo de pago con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar metodo pago");
            e.printStackTrace();
        }
    }

    public void eliminarMetodoPago(metodospago m) {
        String sql = "DELETE FROM temu.metodos_pago WHERE id_metodo_pago = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, m.getId_metodo_pago());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Metodo pago eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun metodo de pago con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar metodo de pago");
        }
    }
}
