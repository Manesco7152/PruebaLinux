package Service;

import Model.direcciones;
import Repository.direccionesRepository;
import java.util.Scanner;

public class direccionesService {
    Scanner op = new Scanner(System.in);
    direcciones d = new direcciones();
    direccionesRepository dr = new direccionesRepository();

    public void agregarDireccion() {
        System.out.print("Ingresa tu id usuario: ");
        d.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("Ingresa tu calle: ");
        d.setCalle(op.nextLine());
        System.out.print("Ingresa tu numero exterior: ");
        d.setNumero_exterior(op.nextLine());
        System.out.print("Ingresa tu numero interior: ");
        d.setNumero_interior(op.nextLine());
        System.out.print("Ingresa tu colonia: ");
        d.setColonia(op.nextLine());
        System.out.print("Ingresa tu codigo postal: ");
        d.setCodigo_postal(op.nextLine());
        System.out.print("Ingresa tu ciudad: ");
        d.setCiudad(op.nextLine());
        System.out.print("Ingresa tu estado: ");
        d.setEstado(op.nextLine());
        System.out.print("Ingresa tu pais: ");
        d.setPais(op.nextLine());
        dr.agregarDireccion(d);
    }
    public void listarDirecciones() {
        dr.ListarDirecciones();
    }
    public void actualizarDireccion() {
        direcciones d = new direcciones();
        System.out.print("Ingresa el ID de la direccion a actualizar: ");
        d.setId_direccion(op.nextInt());
        op.nextLine();
        System.out.print("nuevo id usuario: ");
        d.setId_usuario(op.nextInt());
        op.nextLine();
        System.out.print("nuevo calle: ");
        d.setCalle(op.nextLine());
        System.out.print("nuevo numero exterior: ");
        d.setNumero_exterior(op.nextLine());
        System.out.print("nuevo numero interior: ");
        d.setNumero_interior(op.nextLine());
        System.out.print("nuevo colonia: ");
        d.setColonia(op.nextLine());
        System.out.print("nuevo codigo postal: ");
        d.setCodigo_postal(op.nextLine());
        System.out.print("nuevo ciudad: ");
        d.setCiudad(op.nextLine());
        System.out.print("nuevo estado: ");
        d.setEstado(op.nextLine());
        System.out.print("nuevo pais: ");
        d.setPais(op.nextLine());
        dr.actualizarDireccion(d);
    }
    public void eliminarDireccion() {
        direcciones d = new direcciones();
        System.out.print("Ingresa el ID de la direccion a eliminar: ");
        d.setId_direccion(op.nextInt());
        op.nextLine();
        dr.eliminarDireccion(d);
    }
    
}
