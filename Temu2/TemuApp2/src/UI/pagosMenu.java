package UI;

import Controller.pagosController;
import java.util.Scanner;

public class pagosMenu {

    Scanner op = new Scanner(System.in);
    pagosController pc = new pagosController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu pagos------");
                System.out.println("1. Agregar pago");
                System.out.println("2. Obtener todos los pagos");
                System.out.println("3. Actualizar pago");
                System.out.println("4. Eliminar pago");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        pc.agregarPago();
                        break;
                    case 2:
                        pc.listarPagos();
                        break;
                    case 3:
                        pc.actualizarPago();
                        break;
                    case 4:
                        pc.eliminarPago();
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
