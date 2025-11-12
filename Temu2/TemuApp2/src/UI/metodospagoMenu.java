package UI;

import Controller.metodospagoController;
import java.util.Scanner;

public class metodospagoMenu {
    Scanner op = new Scanner(System.in);
    metodospagoController mc = new metodospagoController();

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu metodos pago------");
                System.out.println("1. Agregar metodo pago");
                System.out.println("2. Obtener todos los metodos pago");
                System.out.println("3. Actualizar metodo pago");
                System.out.println("4. Eliminar metodo pago");
                System.out.println("5. Regresar");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        mc.agregarMetodoPago();
                        break;
                    case 2:
                        mc.listarMetodosPago();
                        break;
                    case 3:
                        mc.actualizarMetodoPago();
                        break;
                    case 4:
                        mc.eliminarMetodoPago();
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
