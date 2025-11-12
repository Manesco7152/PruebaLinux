package UI;

import java.util.Scanner;
import Controller.usuarioController;
import Model.usuario;

public class MainMenu {
    Scanner op = new Scanner(System.in);

    public void MenuLoging() {
        int opcion = 0;
        do {
            try {
                System.out.println("Buenvenido a la aplicacion de Temu");
                System.out.println("-------login------");
                System.out.println("1. Agregar Usuario");
                System.out.println("2. Iniciar Sesion");
                System.out.println("3. Salir");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:usuarioController uc = new usuarioController();uc.agregarUsuario();break;
                    case 2: {
                        usuarioController uc1 = new usuarioController();
                        usuario logueado = uc1.iniciarSesion();

                        if (logueado != null) { // ← login correcto
                            System.out.println("\n¡Bienvenido, " + logueado.getNombre_usuario() + "!");
                            Menu(); // ← mismo objeto, mismo Scanner
                        } else {
                            System.out.println("Credenciales incorrectas.\n");
                        }
                    }
                    case 3:System.out.println("Saliendo de la aplicacion");break;
                    default:break;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar opcion");
                op.nextLine();
            }
        } while (opcion != 3);

    }

    public void Menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("-------Menu Principal------");
                System.out.println("1. Categorias");
                System.out.println("2. Productos");
                System.out.println("3. Pedidos");
                System.out.println("4. Detalles Pedidos");
                System.out.println("5. Proveedores");
                System.out.println("6. Vendedores");
                System.out.println("7. Metodos de Pago");
                System.out.println("8. Pagos");
                System.out.println("9. Carrito de Compras");
                System.out.println("10. Inventario");
                System.out.println("11. Direcciones");
                System.out.println("12. Salir");
                System.out.print("Opcion: ");
                opcion = op.nextInt();
                op.nextLine();
                switch (opcion) {
                    case 1:
                        categoriasMenu cm = new categoriasMenu();
                        cm.menu();
                        break;
                    case 2:
                        productosMenu pm = new productosMenu();
                        pm.menu();
                        break;
                    case 3:
                        pedidosMenu pe = new pedidosMenu();
                        pe.menu();
                        break;
                    case 4:
                        detallespedidosMenu dpm = new detallespedidosMenu();
                        dpm.menu();
                        break;
                    case 5:
                        proveedoresMenu pr = new proveedoresMenu();
                        pr.menu();
                        break;
                    case 6:
                        vendedoresMenu vm = new vendedoresMenu();
                        vm.menu();
                        break;
                    case 7:
                        metodospagoMenu mm = new metodospagoMenu();
                        mm.menu();
                        break;
                    case 8:
                        pagosMenu pa = new pagosMenu();
                        pa.menu();
                        break;
                    case 9:
                        carritocomprasMenu ca = new carritocomprasMenu();
                        ca.menu();
                        break;
                    case 10:
                        inventarioMenu im = new inventarioMenu();
                        im.menu();
                        break;
                    case 11:
                        direccionesMenu dm = new direccionesMenu();
                        dm.menu();
                        break;
                    case 12:
                        System.out.println("Saliendo de la aplicacion");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar opcion");
                op.nextLine();
            }
        } while (opcion != 12);
    }

}
