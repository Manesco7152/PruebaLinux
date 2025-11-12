package Service;

import Model.productos;
import Repository.productosRepository;
import java.util.Scanner;

public class productosService {
    productos p = new productos();
    Scanner op = new Scanner(System.in);
    productosRepository pr = new productosRepository();
    public void agregarProducto() {
        System.out.print("Ingresa tu id vendedor: ");
        p.setId_vendedor(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu nombre producto: ");
        p.setNombre_producto(op.nextLine());
        System.out.print("Ingresa tu descripcion corta: ");
        p.setDescripcion_corta(op.nextLine());
        System.out.print("Ingresa tu precio: ");
        p.setPrecio(op.nextDouble());
        op.nextLine();
        System.out.print("Ingresa tu stock: ");
        p.setStock(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu codigo producto: ");
        p.setCodigo_producto(op.nextLine());
        pr.agregarProducto(p);
    }
    public void listarProductos() {
        pr.ListarProductos();
    }
    public void actualizarProducto() {
        productos p = new productos();
        System.out.print("Ingresa el ID del producto a actualizar: ");
        p.setId_producto(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id vendedor: ");
        p.setId_vendedor(op.nextInt());
        op.nextLine();
        System.out.print("nuevo nombre producto: ");
        p.setNombre_producto(op.nextLine());
        System.out.print("nuevo descripcion corta: ");
        p.setDescripcion_corta(op.nextLine());
        System.out.print("nuevo precio: ");
        p.setPrecio(op.nextDouble());
        op.nextLine();
        System.out.print("nuevo stock: ");
        p.setStock(op.nextInt());
        op.nextLine();
        System.out.print("nuevo codigo producto: ");
        p.setCodigo_producto(op.nextLine());
        pr.actualizarProducto(p);
    }
    public void eliminarProducto() {
        productos p = new productos();
        System.out.print("Ingresa el ID de la producto a eliminar: ");
        p.setId_producto(op.nextInt());
        op.nextLine();
        pr.eliminarProducto(p);
    }
}
