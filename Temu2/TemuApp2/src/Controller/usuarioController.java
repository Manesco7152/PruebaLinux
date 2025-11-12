package Controller;

import Service.usuarioService;
import Model.usuario;
import Repository.usuarioReposutory;

public class usuarioController {
    usuarioService uc = new usuarioService();
    usuarioReposutory ur = new usuarioReposutory();

    public void agregarUsuario() {
        uc.agregarUsuario();
    }

    public usuario iniciarSesion() {
        return uc.iniciarSesion();
    }
}