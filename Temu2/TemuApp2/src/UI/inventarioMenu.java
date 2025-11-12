package UI;

import Controller.inventarioController;
import java.util.Scanner;

public class inventarioMenu {
    Scanner op = new Scanner(System.in);
    inventarioController ic = new inventarioController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu inventario------");
                System.out.println("1. Agregar inventario");
                System.out.println("2. Obtener todos los inventarios");
                System.out.println("3. Actualizar inventario");
                System.out.println("4. Eliminar inventario");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        ic.agregarInventario();
                        break;
                    case 2:
                        ic.listarInventarios();
                        break;
                    case 3:
                        ic.actualizarInventario();
                        break;
                    case 4:
                        ic.eliminarInventario();
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
