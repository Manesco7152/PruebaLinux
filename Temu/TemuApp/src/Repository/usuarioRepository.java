package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Config.Conn;
import Model.direccion;
import Model.usuario;

public class usuarioRepository {
    public void crearUsuario(usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, contrasena, telefono, fecha_registro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getContrasena());
            pstmt.setString(5, usuario.getTelefono());
            pstmt.executeUpdate();
        }
    }

    public usuario obtenerUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT id_usuario, nombre, apellido, email, telefono, fecha_registro FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("email"), "", rs.getString("telefono"), rs.getString("fecha_registro"));
            }
            return null;
        }
    }

    public void crearDireccion(direccion direccion) throws SQLException {
        String sql = "INSERT INTO direcciones (id_usuario, calle, numero_exterior, numero_interior, colonia, codigo_postal, ciudad, estado, pais) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, direccion.getIdUsuario());
            pstmt.setString(2, direccion.getCalle());
            pstmt.setInt(3, direccion.getNumeroExterior());
            pstmt.setInt(4, direccion.getNumeroInterior());
            pstmt.setString(5, direccion.getColonia());
            pstmt.setString(6, direccion.getCodigoPostal());
            pstmt.setString(7, direccion.getCiudad());
            pstmt.setString(8, direccion.getEstado());
            pstmt.setString(9, direccion.getPais());
            pstmt.executeUpdate();
        }
    }

    public direccion obtenerDireccionPorId(int id) throws SQLException {
        String sql = "SELECT id_direccion, id_usuario, calle, numero_exterior, numero_interior, colonia, codigo_postal, ciudad, estado, pais FROM direcciones WHERE id_direccion = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new direccion(rs.getInt("id_direccion"), rs.getInt("id_usuario"), rs.getString("calle"),
                        rs.getInt("numero_exterior"), rs.getInt("numero_interior"), rs.getString("colonia"),
                        rs.getString("codigo_postal"), rs.getString("ciudad"), rs.getString("estado"), rs.getString("pais"));
            }
            return null;
        }
    }

    public List<usuario> obtenerTodosLosUsuarios() {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosLosUsuarios'");
    }

    public void actualizarUsuario(usuario usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }

    public void eliminarUsuario(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
    }
}
