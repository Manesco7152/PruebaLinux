package Service;

import Model.proveedores;
import Repository.proveedoresRepository;
import java.util.Scanner;

public class proveedoresService {
    proveedores p = new proveedores();
    Scanner op = new Scanner(System.in);
    proveedoresRepository pr = new proveedoresRepository();

    public void agregarProveedor() {
        System.out.print("Ingresa tu nombre: ");
        p.setNombre(op.nextLine());
        System.out.print("Ingresa tu telefono: ");
        p.setTelefono(op.nextLine());
        System.out.print("Ingresa tu correo: ");
        p.setCorreo(op.nextLine());
        pr.agregarProveedor(p);
    }

    public void listarProveedores() {
        pr.ListarProveedores();
    }

    public void actualizarProveedor() {
        proveedores p = new proveedores();
        System.out.print("Ingresa el ID de la proveedor a actualizar: ");
        p.setId_proveedor(op.nextInt());
        op.nextLine();
        System.out.print("nuevo nombre: ");
        p.setNombre(op.nextLine());
        System.out.print("nuevo telefono: ");
        p.setTelefono(op.nextLine());
        System.out.print("nuevo correo: ");
        p.setCorreo(op.nextLine());
        pr.actualizarProveedor(p);
    }

    public void eliminarProveedor() {
        proveedores p = new proveedores();
        System.out.print("Ingresa el ID de la proveedor a eliminar: ");
        p.setId_proveedor(op.nextInt());
        pr.eliminarProveedor(p);
    }
}
