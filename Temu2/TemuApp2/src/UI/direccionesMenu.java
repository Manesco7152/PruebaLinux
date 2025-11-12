package UI;

import Controller.direccionesController;
import java.util.Scanner;

public class direccionesMenu {
    Scanner op = new Scanner(System.in);
    direccionesController dc = new direccionesController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu direcciones------");
                System.out.println("1. Agregar direccion");
                System.out.println("2. Obtener todos las direcciones");
                System.out.println("3. Actualizar direccion");
                System.out.println("4. Eliminar direccion");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        dc.agregarDireccion();
                        break;
                    case 2:
                        dc.listarDirecciones();
                        break;
                    case 3:
                        dc.actualizarDireccion();
                        break;
                    case 4:
                        dc.eliminarDireccion();
                        break;
                    case 5:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar opcion");
                op.nextLine();
            }
        } while (opcion != 5);
    }
    
}
