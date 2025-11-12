package UI;

import Controller.detallespedidosController;
import java.util.Scanner;

public class detallespedidosMenu {
    Scanner op = new Scanner(System.in);
    detallespedidosController dc = new detallespedidosController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu detalles pedidos------");
                System.out.println("1. Agregar detalle pedido");
                System.out.println("2. Obtener todos los detalles pedidos");
                System.out.println("3. Actualizar detalle pedido");
                System.out.println("4. Eliminar detalle pedido");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        dc.agregarDetallePedido();
                        break;
                    case 2:
                        dc.listarDetallesPedidos();
                        break;
                    case 3:
                        dc.actualizarDetallePedido();
                        break;
                    case 4:
                        dc.eliminarDetallePedido();
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
