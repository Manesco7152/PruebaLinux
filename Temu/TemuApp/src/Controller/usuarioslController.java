package Controller;

import Model.usuariosl;
import Service.usuarioslService;

public class usuarioslController {
    private usuarioslService service = new usuarioslService();

    public boolean autenticar(String nombreUsuario, String contraseña) {
        usuariosl usuario = service.login(nombreUsuario, contraseña);
        if (usuario != null) {
            System.out.println("¡Bienvenido, " + usuario.getNombreUsuario() + "!");
            System.out.println("Correo: " + usuario.getCorreo());
            return true;
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
            return false;
        }
    }
    public void registrar(String nombreUsuario, String contraseña, String correo) {
        usuariosl registro = new usuariosl(0, nombreUsuario, contraseña, correo);
        service.crearUsuario(registro);
    }
}
