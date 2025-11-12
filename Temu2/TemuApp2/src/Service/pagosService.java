package Service;

import Model.pagos;
import Repository.pagosRepository;
import java.util.Scanner;

public class pagosService {
    Scanner op = new Scanner(System.in);
    pagos p = new pagos();
    pagosRepository pr = new pagosRepository();
    public void agregarPago() {
        System.out.print("Ingresa tu id pedido: ");
        p.setId_pedido(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu id metodo pago: ");
        p.setId_metodo_pago(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu monto: ");
        p.setMonto(op.nextDouble());
        pr.agregarPago(p);
    }
    public void listarPagos() {
        pr.ListarPagos();
    }
    public void actualizarPago() {
        pagos p = new pagos();
        System.out.print("Ingresa el ID de la pago a actualizar: ");
        p.setId_pago(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id pedido: ");
        p.setId_pedido(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id metodo pago: ");
        p.setId_metodo_pago(op.nextInt());
        op.nextLine();
        System.out.print("nuevo monto: ");
        p.setMonto(op.nextDouble());
        pr.actualizarPago(p);
    }
    public void eliminarPago() {
        pagos p = new pagos();
        System.out.print("Ingresa el ID de la pago a eliminar: ");
        p.setId_pago(op.nextInt());
        op.nextLine();
        pr.eliminarPago(p);
    }
}
