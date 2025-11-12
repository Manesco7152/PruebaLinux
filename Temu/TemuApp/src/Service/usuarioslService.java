package Service;

import Model.usuariosl;
import Repository.usuarioslRepository;

public class usuarioslService {
    private usuarioslRepository repository = new usuarioslRepository();

    public usuariosl login(String nombreUsuario, String contraseña) {
        return repository.obtenerPorCredenciales(nombreUsuario, contraseña);
    }
    public void crearUsuario(usuariosl usuario) {
        repository.crearUsuario(usuario);
    }
    public void registrarse(usuariosl registro) {
        repository.registrarse(registro);
}
}