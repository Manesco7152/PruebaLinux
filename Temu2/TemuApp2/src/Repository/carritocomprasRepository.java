package Repository;

import Model.carritocompras;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class carritocomprasRepository {
    Scanner op = new Scanner(System.in);
    carritocompras c = new carritocompras();
    Conn con = new Conn();

    public void agregarCarritoCompras(carritocompras c) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.carrito_compras (id_usuario, id_producto, cantidad, fecha_agregado) VALUES (?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, c.getId_usuario());
            ps.setInt(2, c.getId_producto());
            ps.setInt(3, c.getCantidad());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            System.out.println("Carrito compras agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar carrito compras");
            e.printStackTrace();
        }
    }

    public List<carritocompras> ListarCarritoCompras() {
        List<carritocompras> carritocompras = new ArrayList<>();
        String sql = "SELECT c.id_carrito, u.nombre_usuario AS nombre_usuario, p.nombre_producto, c.cantidad, c.fecha_agregado " +
        "FROM temu.carrito_compras c " +
        "INNER JOIN temu.usuario u ON c.id_usuario = u.id_usuario " +
        "INNER JOIN temu.productos p ON c.id_producto = p.id_producto";
   try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            System.out.println("Lista de Carritos de Compras:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_carrito") + " - " +
                    rs.getString("nombre_usuario") + " - " + 
                    rs.getString("nombre_producto") + " - " + 
                    rs.getInt("cantidad") + " - " + 
                    rs.getTimestamp("fecha_agregado"));
            }
            return carritocompras;
        } catch (Exception e) {
            System.out.println("Error al listar carrito compras");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarCarritoCompra(carritocompras c) {
        try {
            con.getConnection();
            String sql = "UPDATE temu.carrito_compras SET id_usuario = ?, id_producto = ?, cantidad = ?, fecha_agregado = ? WHERE id_carrito = ?";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, c.getId_usuario());
            ps.setInt(2, c.getId_producto());
            ps.setInt(3, c.getCantidad());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setInt(5, c.getId_carrito());
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Carrito compras actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ninguna carrito compra con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar carrito compra");
            e.printStackTrace();
        }
    }

    public void eliminarCarritoCompra(carritocompras c) {
        String sql = "DELETE FROM temu.carrito_compras WHERE id_carrito = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, c.getId_carrito());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Carrito compras eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun carrito compra con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar carrito compra");
            e.printStackTrace();
        }
    }
}
