package Service;

import Model.metodospago;
import Repository.metodospagoRepository;
import java.util.Scanner;

public class metodospagoService {
    metodospago m = new metodospago();
    Scanner op = new Scanner(System.in);
    metodospagoRepository mr = new metodospagoRepository();
    public void agregarMetodoPago() {
        System.out.print("Ingresa tu nombre: ");
        m.setNombre(op.nextLine());
        System.out.print("Ingresa tu descripcion: ");
        m.setDescripcion(op.nextLine());
        mr.agregarMetodoPago(m);
    }
    public void listarMetodosPago() {
        mr.listarMetodosPago();
    }
    public void actualizarMetodoPago() {
        metodospago m = new metodospago();
        System.out.print("Ingresa el ID de la metodo de pago a actualizar: ");
        m.setId_metodo_pago(op.nextInt());
        op.nextLine();
        System.out.print("nuevo nombre: ");
        m.setNombre(op.nextLine());
        System.out.print("nuevo descripcion: ");
        m.setDescripcion(op.nextLine());
        mr.actualizarMetodoPago(m);
    }
    public void eliminarMetodoPago() {
        metodospago m = new metodospago();
        System.out.print("Ingresa el ID de la metodo de pago a eliminar: ");
        m.setId_metodo_pago(op.nextInt());
        op.nextLine();
        mr.eliminarMetodoPago(m);
    }
    
}
