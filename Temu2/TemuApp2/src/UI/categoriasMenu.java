package UI;

import Controller.categoriasController;
import java.util.Scanner;

public class categoriasMenu {
    Scanner op = new Scanner(System.in);
    categoriasController cc = new categoriasController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu categorias------");
                System.out.println("1. Agregar categoria");
                System.out.println("2. Obtener todas las categorias");
                System.out.println("3. Actualizar categoria");
                System.out.println("4. Eliminar categoria");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        cc.agregarCategoria();
                        break;
                    case 2:
                        cc.listarCategorias();
                        break;
                    case 3:
                        cc.actualizarCategoria();
                        break;
                    case 4:
                        cc.eliminarCategoria();
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
