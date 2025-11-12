package UI;

import Controller.carritocomprasController;
import java.util.Scanner;

public class carritocomprasMenu {
    Scanner op = new Scanner(System.in);
    carritocomprasController cc = new carritocomprasController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu carrito compras------");
                System.out.println("1. Agregar carrito compras");
                System.out.println("2. Obtener todos los carrito compras");
                System.out.println("3. Actualizar carrito compra");
                System.out.println("4. Eliminar carrito compra");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        cc.agregarCarritoCompras();
                        break;
                    case 2:
                        cc.listarCarritoCompras();
                        break;
                    case 3:
                        cc.actualizarCarritoCompra();
                        break;
                    case 4:
                        cc.eliminarCarritoCompra();
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
