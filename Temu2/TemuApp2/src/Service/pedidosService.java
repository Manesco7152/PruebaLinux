package Service;

import Model.pedidos;
import Repository.pedidosRepository;
import java.util.Scanner;

public class pedidosService {
    Scanner op = new Scanner(System.in);
    pedidos p = new pedidos();
    pedidosRepository pr = new pedidosRepository();
    public void agregarPedido() {
        System.out.print("Ingresa tu id usuario: ");
        p.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu estado: ");
        p.setEstado(op.nextLine());
        System.out.print("Ingresa tu total: ");
        p.setTotal(op.nextDouble());
        System.out.print("Ingresa tu id direccion envio: ");
        p.setId_direccion_envio(op.nextInt());
        pr.agregarPedido(p);
    }
    public void listarPedidos() {
        pr.ListarPedidos();
    }
    public void actualizarPedido() {
        pedidos p = new pedidos();
        System.out.print("Ingresa el ID de la pedido a actualizar: ");
        p.setId_pedido(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id usuario: ");
        p.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("nuevo estado: ");
        p.setEstado(op.nextLine());
        System.out.print("nuevo total: ");
        p.setTotal(op.nextDouble());
        op.nextLine();
        System.out.print("nuevo id direccion envio: ");
        p.setId_direccion_envio(op.nextInt());
        pr.actualizarPedido(p);
    }
    public void eliminarPedido() {
        pedidos p = new pedidos();
        System.out.print("Ingresa el ID de la pedido a eliminar: ");
        p.setId_pedido(op.nextInt());
        pr.eliminarPedido(p);
    }
}
