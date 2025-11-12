package Repository;

import Model.productos;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productosRepository {
    Scanner op = new Scanner(System.in);
    productos p = new productos();
    Conn con = new Conn();

    public void agregarProducto(productos p) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.productos (id_vendedor, nombre_producto, descripcion_corta, precio, stock, codigo_producto) VALUES (?,?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, p.getId_vendedor());
            ps.setString(2, p.getNombre_producto());
            ps.setString(3, p.getDescripcion_corta());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getCodigo_producto());
            ps.executeUpdate();
            System.out.println("Producto agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar producto");
            e.printStackTrace();
        }
    }

    public List<productos> ListarProductos() {
        List<productos> productos = new ArrayList<>();
        String sql = "SELECT p.id_producto, v.nombre_tienda, p.nombre_producto, " +
                "p.descripcion_corta, p.precio, p.stock, p.codigo_producto " +
                "FROM temu.productos p " +
                "INNER JOIN temu.vendedores v ON p.id_vendedor = v.id_vendedor";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Productos:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_producto") + " - " +
                                rs.getString("nombre_tienda") + " - " +
                                rs.getString("nombre_producto") + " - " +
                                rs.getString("descripcion_corta") + " - " +
                                rs.getDouble("precio") + " - " +
                                rs.getInt("stock") + " - " +
                                rs.getString("codigo_producto"));
            }
            return productos;
        } catch (Exception e) {
            System.out.println("Error al listar productos");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarProducto(productos p) {
        String sql = "UPDATE temu.productos SET id_vendedor = ?, nombre_producto = ?, descripcion_corta = ?, precio = ?, stock = ?, codigo_producto = ? WHERE id_producto = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_vendedor());
            ps.setString(2, p.getNombre_producto());
            ps.setString(3, p.getDescripcion_corta());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getCodigo_producto());
            ps.setInt(7, p.getId_producto());
            ps.executeUpdate();
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Producto actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun producto con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar producto");
            e.printStackTrace();
        }
    }

    public void eliminarProducto(productos p) {
        String sql = "DELETE FROM temu.productos WHERE id_producto = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getId_producto());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Producto eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun producto con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar productos");
        }
    }

}
