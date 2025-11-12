package Repository;

import Model.categorias;
import Config.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class categoriasRepository {
    Scanner op = new Scanner(System.in);
    categorias c = new categorias();
    Conn con = new Conn();

    public void agregarCategoria(categorias c) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.categorias (nombre_categoria, descripcion) VALUES (?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, c.getNombre_categoria());
            ps.setString(2, c.getDescripcion());
            ps.executeUpdate();
            System.out.println("Categoria agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar categoria");
            e.printStackTrace();
        }

    }

    public void listarCategorias() {
        String sql = "SELECT * FROM temu.categorias";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("Lista de Categorías:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_categoria") + " - " + rs.getString("nombre_categoria") + ": "
                        + rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar categorías");
            e.printStackTrace();
        }
    }

    public void actualizarCategoria(categorias c) {
        String sql = "UPDATE temu.categorias SET nombre_categoria = ?, descripcion = ? WHERE id_categoria = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre_categoria());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getId_categoria());
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Categoría actualizada con éxito");
            } else {
                System.out.println("⚠ No se encontró ninguna categoría con ese ID");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar categoría");
            e.printStackTrace();
        }
    }

    public void eliminarCategoria(categorias c) {
        String sql = "DELETE FROM temu.categorias WHERE id_categoria = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, c.getId_categoria());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Categoria eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun categoria con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar categoria");
            e.printStackTrace();
        }
    }
}
