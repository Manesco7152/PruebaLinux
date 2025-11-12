
package Service;

import Model.vendedores;
import Repository.vendedoresRepository;

import java.util.Scanner;

public class vendedoresSevice {
    Scanner op = new Scanner(System.in);
    vendedores v = new vendedores();
    vendedoresRepository vr = new vendedoresRepository();

    public void agregarVendedor() {
        System.out.print("Ingresa tu id usuario: ");
        v.setId_usuario(op.nextInt());
        System.out.print("Ingresa tu nombre tienda: ");
        v.setNombre_tienda(op.nextLine());
        System.out.print("Ingresa tu descripcion: ");
        v.setDescripcion(op.nextLine());
        System.out.print("Ingresa tu url logo: ");
        v.setUrl_logo(op.nextLine());
        vr.agregarVendedor(v);
    }

    public void listarVendedores() {
        vr.ListarVendedores();
    }

    public void actualizarVendedor() {
        vendedores v = new vendedores();
        System.out.print("Ingresa el ID de la vendedor a actualizar: ");
        v.setId_vendedor(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id usuario: ");
        v.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("nuevo nombre tienda: ");
        v.setNombre_tienda(op.nextLine());
        System.out.print("nuevo descripcion: ");
        v.setDescripcion(op.nextLine());
        System.out.print("nuevo url logo: ");
        v.setUrl_logo(op.nextLine());
        vr.actualizarVendedor(v);
    }

    public void eliminarVendedor() {
        vendedores v = new vendedores();
        System.out.print("Ingresa el ID de la vendedor a eliminar: ");
        v.setId_vendedor(op.nextInt());
        vr.eliminarVendedor(v);
    }
}