package Service;

import Model.usuario;
import Repository.usuarioReposutory;

import java.util.Scanner;

public class usuarioService {
    Scanner op = new Scanner(System.in);
    usuario u = new usuario();
    usuarioReposutory ur = new usuarioReposutory();

    public void agregarUsuario() {
        System.out.print("Ingresa tu nombre: ");
        u.setNombre_usuario(op.nextLine());
        System.out.print("Ingresa tu correo electronico: ");
        u.setCorreo_electronico(op.nextLine());
        System.out.print("Ingresa tu contraseña: ");
        u.setContraseña(op.nextLine());
        System.out.print("Ingresa el rol: ");
        u.setRol(op.nextLine());
        ur.agregarUsuario(u.getNombre_usuario(), u.getContraseña(), u.getCorreo_electronico(), u.getRol());
    }

    public usuario iniciarSesion() {
        System.out.print("Ingresa tu nombre: ");
        String nombre = op.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String pass = op.nextLine();
    
        return ur.loginUsuario(nombre, pass);   // null si no coincidió
    }

}
