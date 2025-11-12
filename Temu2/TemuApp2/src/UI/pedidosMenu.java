package UI;

import Controller.pedidosController;
import java.util.Scanner;

public class pedidosMenu {
    Scanner op = new Scanner(System.in);
    pedidosController pc = new pedidosController();
    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu pedidos------");
                System.out.println("1. Agregar pedido");
                System.out.println("2. Obtener todos los pedidos");
                System.out.println("3. Actualizar pedido");
                System.out.println("4. Eliminar pedido");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        pc.agregarPedido();
                        break;
                    case 2:
                        pc.listarPedidos();
                        break;
                    case 3:
                        pc.actualizarPedido();
                        break;
                    case 4:
                        pc.eliminarPedido();
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
