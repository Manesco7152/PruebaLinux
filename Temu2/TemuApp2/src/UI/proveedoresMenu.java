package UI;

import Controller.proveedoresController;
import java.util.Scanner;

public class proveedoresMenu {
    Scanner op = new Scanner(System.in);
    proveedoresController pc = new proveedoresController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu proveedores------");
                System.out.println("1. Agregar proveedor");
                System.out.println("2. Obtener todos los proveedores");
                System.out.println("3. Actualizar proveedor");
                System.out.println("4. Eliminar proveedor");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        pc.agregarProveedor();
                        break;
                    case 2:
                        pc.listarProveedores();
                        break;
                    case 3:
                        pc.actualizarProveedor();
                        break;
                    case 4:
                        pc.eliminarProveedor();
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
