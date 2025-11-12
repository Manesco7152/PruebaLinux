package Repository;

import Config.Conn;
import Model.categoria;
import Model.producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productoRepository {

    // Método para crear un nuevo producto
    public void crearProducto(producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, id_categoria, stock, fecha_alta) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setString(3, producto.getPrecio());
            pstmt.setInt(4, producto.getIdCategoria());
            pstmt.setInt(5, producto.getStock());
            pstmt.setString(6, String.valueOf(producto.getFechaAlta()));
            pstmt.executeUpdate();
        }
    }

    // Método para obtener un producto por su ID
    public producto obtenerProductoPorId(int id) throws SQLException {
        String sql = "SELECT id_producto, nombre, descripcion, precio, id_categoria, stock, fecha_alta FROM productos WHERE id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new producto(
                        rs.getInt("id_producto"),
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("precio"),
                        rs.getInt("stock"),
                        rs.getString("fecha_alta")
                );
            }
            return null;
        }
    }

    // Método para obtener todos los productos
    public List<Model.producto> obtenerTodosLosProductos() throws SQLException {
        String sql = "SELECT id_producto, nombre, descripcion, precio, id_categoria, stock, fecha_alta FROM productos";
        List<producto> productos = new ArrayList<>();
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                productos.add(new producto(
                    rs.getInt("id_producto"),
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("precio"),
                    rs.getInt("stock"),
                    rs.getString("fecha_alta")
                ));
            }
            return productos;
        }
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, id_categoria = ?, stock = ?, fecha_alta = ? WHERE id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setString(3, producto.getPrecio());
            pstmt.setInt(4, producto.getIdCategoria());
            pstmt.setInt(5, producto.getIdProducto());
            pstmt.setInt(6, producto.getStock());
            pstmt.setString(7, String.valueOf(producto.getFechaAlta()));
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void crearCategoria(categoria categoria) {
        throw new UnsupportedOperationException("Unimplemented method 'crearCategoria'");
    }
}