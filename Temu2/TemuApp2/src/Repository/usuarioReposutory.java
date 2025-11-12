package Repository;

import Model.usuario;

import java.util.Scanner;
import Config.Conn;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioReposutory {
    Scanner op = new Scanner(System.in);
    usuario u = new usuario();
    Conn con = new Conn();

    public void agregarUsuario(String nombre, String pass, String correo_electronico, String rol) {
        String sql = "INSERT INTO temu.usuario (nombre_usuario, contraseña, correo_electronico, fecha_registro, ultimo_acceso, rol) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = con.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ps.setString(3, correo_electronico);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.setString(6, rol);
            ps.executeUpdate();
            System.out.println("Usuario agregado con exito");
        } catch (Exception e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public usuario loginUsuario(String nombre, String pass) {
        usuario encontrado = null;
        String sql = "SELECT * FROM temu.usuario WHERE nombre_usuario = ? AND contraseña = ?";
    
        try (Connection cn = con.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
    
            ps.setString(1, nombre);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    encontrado = new usuario();
                    encontrado.setNombre_usuario(rs.getString("nombre_usuario"));
                    encontrado.setCorreo_electronico(rs.getString("correo_electronico"));
                    encontrado.setRol(rs.getString("rol"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al loguear usuario");
            e.printStackTrace();
        }
        return encontrado;
    }
}
