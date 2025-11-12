package Service;

import Model.inventario;
import Repository.inventarioRepository;
import java.util.Scanner;

public class inventarioService {
    Scanner op = new Scanner(System.in);
    inventario i = new inventario();
    inventarioRepository ir = new inventarioRepository();
    public void agregarInventario() {
        System.out.print("Ingresa tu id producto: ");
        i.setId_producto(op.nextInt());
        System.out.print("Ingresa tu id proveedor: ");
        i.setId_proveedor(op.nextInt());
        System.out.print("Ingresa tu cantidad: ");
        i.setCantidad(op.nextInt());
        ir.agregarInventario(i);
    }
    public void listarInventarios() {
        ir.ListarInventarios();
    }
    public void actualizarInventario() {
        inventario i = new inventario();
        System.out.print("Ingresa el ID de la inventario a actualizar: ");
        i.setId_inventario(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id producto: ");
        i.setId_producto(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id proveedor: ");
        i.setId_proveedor(op.nextInt());
        op.nextLine();
        System.out.print("nuevo cantidad: ");
        i.setCantidad(op.nextInt());
        ir.actualizarInventario(i);
    }
    public void eliminarInventario() {
        inventario i = new inventario();
        System.out.print("Ingresa el ID de la inventario a eliminar: ");
        i.setId_inventario(op.nextInt());
        op.nextLine();
        ir.eliminarInventario(i);
    }
}
