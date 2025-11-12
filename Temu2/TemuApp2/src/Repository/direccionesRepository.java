package Repository;

import Model.direcciones;
import Config.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class direccionesRepository {
    Scanner op = new Scanner(System.in);
    Conn con = new Conn();

    public void agregarDireccion(direcciones d) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.direcciones (id_usuario, calle, numero_exterior, numero_interior, colonia, codigo_postal, ciudad, estado, pais) VALUES (?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, d.getId_usuario());
            ps.setString(2, d.getCalle());
            ps.setString(3, d.getNumero_exterior());
            ps.setString(4, d.getNumero_interior());
            ps.setString(5, d.getColonia());
            ps.setString(6, d.getCodigo_postal());
            ps.setString(7, d.getCiudad());
            ps.setString(8, d.getEstado());
            ps.setString(9, d.getPais());
            ps.executeUpdate();
            System.out.println("Direccion agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar direccion");
            e.printStackTrace();
        }
    }

    public List<direcciones> ListarDirecciones() {
        List<direcciones> direcciones = new ArrayList<>();
        String sql = "\n" + //
                "SELECT d.id_direccion, u.nombre_usuario, d.calle, d.numero_exterior, d.numero_interior, d.colonia, d.codigo_postal, d.ciudad, d.estado, d.pais\n"
                + //
                "FROM temu.direcciones d\n" + //
                " LEFT join \n" + //
                " temu.usuario u\n" + //
                " on \n" + //
                " d.id_usuario = u.id_usuario\n" + //
                "";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Direcciones:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_direccion") + " - " +
                                rs.getString("nombre_usuario") + " - " +
                                rs.getString("calle") + " - " +
                                rs.getString("numero_exterior") + " - " +
                                rs.getString("numero_interior") + " - " +
                                rs.getString("colonia") + " - " +
                                rs.getString("codigo_postal") + " - " +
                                rs.getString("ciudad") + " - " +
                                rs.getString("estado") + " - " +
                                rs.getString("pais"));
            }
            return direcciones;
        } catch (Exception e) {
            System.out.println("Error al listar direcciones");
            e.printStackTrace();
        }
        return direcciones;
    }

    public void actualizarDireccion(direcciones d) {
        String sql = "UPDATE temu.direcciones SET id_usuario = ?, calle = ?, numero_exterior = ?, numero_interior = ?, colonia = ?, codigo_postal = ?, ciudad = ?, estado = ?, pais = ? WHERE id_direccion = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, d.getId_usuario());
            ps.setString(2, d.getCalle());
            ps.setString(3, d.getNumero_exterior());
            ps.setString(4, d.getNumero_interior());
            ps.setString(5, d.getColonia());
            ps.setString(6, d.getCodigo_postal());
            ps.setString(7, d.getCiudad());
            ps.setString(8, d.getEstado());
            ps.setString(9, d.getPais());
            ps.setInt(10, d.getId_direccion());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Direccion actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ninguna dirección con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar dirección");
        }
    }

    public void eliminarDireccion(direcciones d) {
        String sql = "DELETE FROM temu.direcciones WHERE id_direccion = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, d.getId_direccion());
            ps.executeUpdate();
            System.out.println("Direccion eliminado con exito");
        } catch (Exception e) {
            System.out.println("Error al eliminar direccion");
            e.printStackTrace();
        }

    }
}