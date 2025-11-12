package Service;

import Model.categorias;
import Repository.categoriasRepository;
import java.util.Scanner;

public class categoriasService {
    Scanner op = new Scanner(System.in);
    categorias c = new categorias();
    categoriasRepository cr = new categoriasRepository();

    public void agregarCategoria() {
        System.out.print("Ingresa tu categoria: ");
        c.setNombre_categoria(op.nextLine());
        System.out.print("Ingresa tu descripcion: ");

        c.setDescripcion(op.nextLine());
        cr.agregarCategoria(c);
    }

    public void listarCategorias() {
        cr.listarCategorias();
    }

    public void actualizarCategoria() {
        categorias c = new categorias();
        System.out.print("Ingresa el ID de la categoría a actualizar: ");
        c.setId_categoria(op.nextInt());
        op.nextLine();

        System.out.print("Nuevo nombre: ");
        c.setNombre_categoria(op.nextLine());

        System.out.print("Nueva descripción: ");
        c.setDescripcion(op.nextLine());

        cr.actualizarCategoria(c);
    }

    public void eliminarCategoria() {
        categorias c = new categorias();
        System.out.print("Ingresa el ID de la categoria a eliminar: ");
        c.setId_categoria(op.nextInt());
        op.nextLine();
        cr.eliminarCategoria(c);
    }

}
