package Repository;

import Model.detallespedidos;
import Config.Conn;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class detallespedidosRepository {
    Scanner op = new Scanner(System.in);
    detallespedidos d = new detallespedidos();
    Conn con = new Conn();

    public void agregarDetallePedido(detallespedidos d) {
        try {
            con.getConnection();
            String sql = "INSERT INTO temu.detalles_pedidos (id_pedido, id_producto, cantidad, precio_unitario, subtotal) VALUES (?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, d.getId_pedido());
            ps.setInt(2, d.getId_producto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecio_unitario());
            ps.setDouble(5, d.getSubtotal());
            ps.executeUpdate();
            System.out.println("Detalle pedido agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar detalle pedido");
            e.printStackTrace();
        }
    }

    public List<detallespedidos> ListarDetallesPedidos() {
        List<detallespedidos> detalles = new ArrayList<>();
        String sql = "SELECT d.id_detalle, p.id_pedido, d.id_producto, prod.nombre_producto, " +
                     "d.cantidad, d.precio_unitario, d.subtotal " +
                     "FROM temu.detalles_pedidos d " +
                     "INNER JOIN temu.pedidos p ON d.id_pedido = p.id_pedido " +
                     "INNER JOIN temu.productos prod ON d.id_producto = prod.id_producto";
        try (Connection cn = con.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            if (!rs.isBeforeFirst()) {
                System.out.println("⚠️ No se encontraron registros en la tabla detalles_pedidos.");
            }
            while (rs.next()) {
                System.out.println(
                    "Detalle #" + rs.getInt("id_detalle") +
                    " | Pedido #" + rs.getInt("id_pedido") +
                    " | Producto: " + rs.getString("nombre_producto") +
                    " | Cantidad: " + rs.getInt("cantidad") +
                    " | Precio: $" + rs.getDouble("precio_unitario") +
                    " | Subtotal: $" + rs.getDouble("subtotal")
                );
            }
    
            return detalles;
    
        } catch (Exception e) {
            System.out.println("Error al listar detalles pedidos");
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarDetallePedido(detallespedidos d) {
        String sql = "UPDATE temu.detalles_pedidos SET id_pedido = ?, id_producto = ?, cantidad = ?, precio_unitario = ?, subtotal = ? WHERE id_detalle = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, d.getId_pedido());
            ps.setInt(2, d.getId_producto());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecio_unitario());
            ps.setDouble(5, d.getSubtotal());
            ps.setInt(6, d.getId_detalle());
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Detalle pedido actualizado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun detalle pedido con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar detalle pedido");
            e.printStackTrace();
        }
    }

    public void eliminarDetallePedido(detallespedidos d) {
        String sql = "DELETE FROM temu.detalles_pedidos WHERE id_detalle = ?";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, d.getId_detalle());
            ps.executeUpdate();
            int resultado = ps.getUpdateCount();
            if (resultado > 0) {
                System.out.println("Detalle pedido eliminado con exito");
            } else {
                System.out.println("⚠ No se encontró ningun detalle pedido con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar detalle pedido");
            e.printStackTrace();
        }
    }

}
