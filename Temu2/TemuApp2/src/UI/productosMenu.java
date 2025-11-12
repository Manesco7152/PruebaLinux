
package UI;

import Controller.productosController;
import java.util.Scanner;

public class productosMenu {
    Scanner op = new Scanner(System.in);
    productosController pc = new productosController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu productos------");
                System.out.println("1. Agregar producto");
                System.out.println("2. Obtener todos los productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        pc.agregarProducto();
                        break;
                    case 2:
                        pc.listarProductos();
                        break;
                    case 3:
                        pc.actualizarProducto();
                        break;
                    case 4:
                        pc.eliminarProducto();
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
