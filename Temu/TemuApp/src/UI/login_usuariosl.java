package UI;

import Controller.usuarioslController;


import java.util.Scanner;

public class login_usuariosl{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        usuarioslController controller = new usuarioslController();
System.out.println(" --- Inicio de Sesión ---");
        System.out.println("1.INICIAR SESIÓN");
        System.out.println("2. REGISTRARSE");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
            controller.autenticar(null, null)
            break;
    }
}
}
