package UI;

import Controller.vendedoresController;
import java.util.Scanner;

public class vendedoresMenu {
    Scanner op = new Scanner(System.in);
    vendedoresController vc = new vendedoresController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu vendedores------");
                System.out.println("1. Agregar vendedor");
                System.out.println("2. obtener todos los vendedores");
                System.out.println("3. Actualizar vendedor");
                System.out.println("4. Eliminar vendedor");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        vc.agregarVendedor();
                        break;
                    case 2:
                        vc.listarVendedores();
                        break;
                    case 3:
                        vc.actualizarVendedor();
                        break;
                    case 4:
                        vc.eliminarVendedor();
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
