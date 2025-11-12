package Service;

import Model.detallespedidos;
import Repository.detallespedidosRepository;
import java.util.Scanner;

public class detallespedidosService {
    Scanner op = new Scanner(System.in);
    detallespedidos d = new detallespedidos();
    detallespedidosRepository dr = new detallespedidosRepository();
    public void agregarDetallePedido() {
        System.out.print("Ingresa tu id pedido: ");
        d.setId_pedido(op.nextInt());
        System.out.print("Ingresa tu id producto: ");
        d.setId_producto(op.nextInt());
        System.out.print("Ingresa tu cantidad: ");
        d.setCantidad(op.nextInt());
        System.out.print("Ingresa tu precio unitario: ");
        d.setPrecio_unitario(op.nextDouble());
        System.out.print("Ingresa tu subtotal: ");
        d.setSubtotal(op.nextDouble());
        dr.agregarDetallePedido(d);
    }
    public void listarDetallesPedidos() {
        dr.ListarDetallesPedidos();
    }
    public void actualizarDetallePedido() {
        detallespedidos d = new detallespedidos();
        System.out.print("Ingresa el ID del detalle pedido a actualizar: ");
        d.setId_detalle(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id pedido: ");
        d.setId_pedido(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id producto: ");
        d.setId_producto(op.nextInt());
        op.nextLine();
        System.out.print("nuevo cantidad: ");
        d.setCantidad(op.nextInt());
        op.nextLine();
        System.out.print("nuevo precio unitario: ");
        d.setPrecio_unitario(op.nextDouble());
        op.nextLine();
        System.out.print("nuevo subtotal: ");
        d.setSubtotal(op.nextDouble());
        dr.actualizarDetallePedido(d);
    }
    public void eliminarDetallePedido() {
        detallespedidos d = new detallespedidos();
        System.out.print("Ingresa el ID de la detalle pedido a eliminar: ");
        d.setId_detalle(op.nextInt());
        op.nextLine();
        dr.eliminarDetallePedido(d);
    }
}
