package Service;

import Model.carritocompras;
import Repository.carritocomprasRepository;
import java.util.Scanner;

public class carritocomprasService {
    Scanner op = new Scanner(System.in);
    carritocompras c = new carritocompras();
    carritocomprasRepository cr = new carritocomprasRepository();

    public void agregarCarritoCompras() {
        System.out.print("Ingresa tu id usuario: ");
        c.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu id producto: ");
        c.setId_producto(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu cantidad: ");
        c.setCantidad(op.nextInt());
        cr.agregarCarritoCompras(c);
    }

    public void listarCarritoCompras() {
        cr.ListarCarritoCompras();
    }

    public void actualizarCarritoCompra() {
        carritocompras c = new carritocompras();
        System.out.print("Ingresa el ID de la carrito de compras a actualizar: ");
        c.setId_carrito(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id usuario: ");
        c.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.println("nuevo id producto: ");
        c.setId_producto(op.nextInt());
        op.nextLine();
        System.out.println("nuevo cantidad: ");
        c.setCantidad(op.nextInt());
        cr.actualizarCarritoCompra(c);
    }

    public void eliminarCarritoCompra() {
        carritocompras c = new carritocompras();
        System.out.print("Ingresa el ID de la carrito de compras a eliminar: ");
        c.setId_carrito(op.nextInt());
        op.nextLine();
        cr.eliminarCarritoCompra(c);
    }

}
