package Service;

import Model.direccion;
import Model.usuario;

import java.sql.SQLException;
import java.util.List;

public class usuarioService {
    private final Repository.usuarioRepository usuarioRepository;

    public usuarioService() {
        this.usuarioRepository = new Repository.usuarioRepository();
    }

    public void crearUsuario(usuario usuario) {
        try {
            usuarioRepository.crearUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción de forma adecuada
        }
    }

    public usuario obtenerUsuarioPorId(int id) {
        try {
            return usuarioRepository.obtenerUsuarioPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodosLosUsuarios();
    }

    public void actualizarUsuario(usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.eliminarUsuario(id);
    }

    // Métodos para Direcciones (podrías tener un DireccionService separado también)
    public void crearDireccion(direccion direccion) {
        try {
            usuarioRepository.crearDireccion(direccion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public direccion obtenerDireccionPorId(int id) {
        try {
            return usuarioRepository.obtenerDireccionPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
