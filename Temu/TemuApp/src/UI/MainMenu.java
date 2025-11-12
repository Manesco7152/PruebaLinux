package UI;

import Controller.AppController;
import Model.producto;
import Model.pedido;
import Model.detallepedido;
import Model.carritocompra;
import Model.reseñaproducto;
import Model.pago;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MainMenu {

    private static AppController appController;
    private static Scanner scanner;

    public static void main(String[] args) {
        appController = new AppController();
        scanner = new Scanner(System.in);
        mostrarMenuPrincipal();
    }
    
    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Productos");
            System.out.println("2. Pedidos");
            System.out.println("3. Carrito de Compras");
            System.out.println("4. Reseñas de Productos");
            System.out.println("5. Pagos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

            switch (opcion) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuPedidos();
                    break;
                case 3:
                    menuCarritoCompras();
                    break;
                case 4:
                    menuResenasProductos();
                    break;
                case 5:
                    menuPagos();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void menuProductos() {
        while (true) {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Crear Producto");
            System.out.println("2. Obtener Producto por ID");
            System.out.println("3. Obtener Todos los Productos");
            System.out.println("4. Actualizar Producto");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    obtenerProductoPorId();
                    break;
                case 3:
                    obtenerTodosLosProductos();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void menuPedidos() {
        while (true) {
            System.out.println("\n--- Menú de Pedidos ---");
            System.out.println("1. Crear Pedido");
            System.out.println("2. Obtener Pedido por ID");
            System.out.println("3. Obtener Todos los Pedidos");
            System.out.println("4. Actualizar Pedido");
            System.out.println("5. Eliminar Pedido");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    crearPedido();
                    break;
                case 2:
                    obtenerPedidoPorId();
                    break;
                case 3:
                    obtenerTodosLosPedidos();
                    break;
                case 4:
                    actualizarPedido();
                    break;
                case 5:
                    eliminarPedido();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void menuCarritoCompras() {
        while (true) {
            System.out.println("\n--- Menú de Carrito de Compras ---");
            System.out.println("1. Agregar al Carrito");
            System.out.println("2. Obtener Carrito por Usuario");
            System.out.println("3. Actualizar Cantidad en Carrito");
            System.out.println("4. Eliminar del Carrito");
            System.out.println("5. Eliminar Carrito");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarAlCarrito();
                    break;
                case 2:
                    obtenerCarritoPorUsuario();
                    break;
                case 3:
                    actualizarCantidadEnCarrito();
                    break;
                case 4:
                    eliminarDelCarrito();
                    break;
                case 5:
                    eliminarCarrito();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void menuResenasProductos() {
        while (true) {
            System.out.println("\n--- Menú de Reseñas de Productos ---");
            System.out.println("1. Crear Reseña");
            System.out.println("2. Obtener Reseña por ID");
            System.out.println("3. Obtener Reseñas por Producto");
            System.out.println("4. Actualizar Reseña");
            System.out.println("5. Eliminar Reseña");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    crearResena();
                    break;
                case 2:
                    obtenerResenaPorId();
                    break;
                case 3:
                    obtenerResenasPorProducto();
                    break;
                case 4:
                    actualizarResena();
                    break;
                case 5:
                    eliminarResena();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void menuPagos() {
        while (true) {
            System.out.println("\n--- Menú de Pagos ---");
            System.out.println("1. Procesar Pago");
            System.out.println("2. Obtener Pago por ID");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    procesarPago();
                    break;
                case 2:
                    obtenerPagoPorId();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void crearProducto() {
        System.out.print("Ingrese el ID de la categoría del producto: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        String precio = scanner.nextLine();
        // No need for scanner.nextLine() here, as precio = scanner.nextLine() already
        // consumed it.
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la fecha de alta del producto: ");
        String fechaAlta = scanner.nextLine();
        // No need for scanner.nextLine() here.

        // Call appController.crearProducto with individual parameters
        appController.crearProducto(idCategoria, nombre, descripcion, precio, stock, fechaAlta);
        System.out.println("Producto creado exitosamente.");
    }

    private static void obtenerProductoPorId() {
        System.out.print("Ingrese el ID del producto a obtener: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        producto producto = appController.obtenerProductoPorId(id);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre() + ", " + producto.getDescripcion() + ", "
                    + producto.getPrecio());
        } else {
            System.out.println("No se encontró ningún producto con el ID proporcionado.");
        }
    }

    private static void obtenerTodosLosProductos() {
        List<producto> productos = appController.obtenerTodosLosProductos();
        if (productos != null && !productos.isEmpty()) {
            System.out.println("\n--- Lista de Productos ---");
            for (producto producto : productos) {
                System.out.println("ID: " + producto.getIdProducto() + ", Nombre: " + producto.getNombre()
                        + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio());
            }
        } else if (productos != null) {
            System.out.println("No hay productos disponibles.");
        }
    }

    private static void actualizarProducto() {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        producto productoExistente = appController.obtenerProductoPorId(id);
        if (productoExistente != null) {
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del producto: ");
            String nuevaDescripcion = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del producto: ");
            String nuevoPrecio = scanner.nextLine();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese el nuevo ID de la categoría del producto: ");
            int nuevoIdCategoria = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese el nuevo stock del producto: ");
            int nuevoStock = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese la nueva fecha de alta del producto: ");
            String nuevaFechaAlta = scanner.nextLine();

            producto productoActualizado = new producto(id, nuevoIdCategoria, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevoStock, nuevaFechaAlta);
            appController.actualizarProducto(productoActualizado);
        } else {
            System.out.println("No se encontró ningún producto con el ID proporcionado.");
        }
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.eliminarProducto(id);
    }

    // Métodos para Pedidos
    private static void crearPedido() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la fecha del pedido: ");
        String fechaPedido = scanner.nextLine();
        System.out.print("Ingrese el estado del pedido: ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el total del pedido: ");
        String total = scanner.nextLine();
        scanner.nextLine(); // Consumir la nueva línea

        List<detallepedido> detallesPedido = new ArrayList<>();
        while (true) {
            System.out.print("Ingrese el ID del producto para el detalle del pedido (o 0 para terminar): ");
            int idProducto = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (idProducto == 0) {
                break;
            }
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese el precio unitario: ");
            int precioUnitario = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            int subtotal = cantidad * precioUnitario;
            detallesPedido.add(new detallepedido(0, 0, idProducto, cantidad, precioUnitario, subtotal)); 
        System.out.print("Ingrese el ID de la dirección de envío (o 0 para null): ");
        Integer idDireccionEnvio = scanner.nextInt();
        scanner.nextLine();

        appController.crearPedido(idUsuario, fechaPedido, estado, total, detallesPedido, idDireccionEnvio);
        }
    }

    private static void obtenerPedidoPorId() {
        System.out.print("Ingrese el ID del pedido a obtener: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        pedido pedido = appController.obtenerPedidoPorId(id);
        if (pedido != null) {
            System.out.println("Pedido encontrado: ID: " + pedido.getIdPedido() + ", Usuario: " + pedido.getIdUsuario()
                    + ", Fecha: " + pedido.getFechaPedido() + ", Estado: " + pedido.getEstado() + ", Total: "
                    + pedido.getTotalAsDouble() + ", Direccion de Envio: " + pedido.getIdDireccionEnvio());
            List<detallepedido> detalles = appController.obtenerDetallesPedidoPorIdPedido(id);
            if (detalles != null && !detalles.isEmpty()) {
                System.out.println("\n--- Detalles del Pedido ---");
                for (detallepedido detalle : detalles) {
                    System.out.println("ID Detalle: " + detalle.getIdDetalle() + ", Producto: "
                            + detalle.getIdProducto() + ", Cantidad: " + detalle.getCantidad() + ", Precio Unitario: "
                            + detalle.getPrecioUnitario() + ", Subtotal: " + detalle.getSubtotal());
                }
            } else if (detalles != null) {
                System.out.println("No hay detalles para este pedido.");
            }
        } else {
            System.out.println("No se encontró ningún pedido con el ID proporcionado.");
        }
    }

    private static void obtenerTodosLosPedidos() {
        List<pedido> pedidos = appController.obtenerTodosLosPedidos();
        if (pedidos != null && !pedidos.isEmpty()) {
            System.out.println("\n--- Lista de Pedidos ---");
            for (pedido pedido : pedidos) {
                System.out.println("ID: " + pedido.getIdPedido() + ", Usuario: " + pedido.getIdUsuario() + ", Fecha: "
                        + pedido.getFechaPedido() + ", Estado: " + pedido.getEstado() + ", Total: "
                        + pedido.getTotalAsDouble() + ", Direccion de Envio: " + pedido.getIdDireccionEnvio());
            }
        } else if (pedidos != null) {
            System.out.println("No hay pedidos disponibles.");
        }
    }

    private static void actualizarPedido() {
        System.out.print("Ingrese el ID del pedido a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        pedido pedidoExistente = appController.obtenerPedidoPorId(id);
        if (pedidoExistente != null) {
            System.out.print("Ingrese el nuevo ID del usuario: ");
            int nuevoIdUsuario = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("Ingrese el nuevo estado del pedido: ");
            String nuevoEstado = scanner.nextLine();

            System.out.print("Ingrese el nuevo total del pedido: ");
            String nuevoTotal = scanner.nextLine(); // No extra nextLine() here

            System.out.print("Ingrese el nuevo ID de la dirección de envío (o 0 para null): ");
            Integer nuevoIdDireccionEnvio = scanner.nextInt(); // Integer can accept null if input is "null" or similar
                                                               // logic
            scanner.nextLine(); // Consume the newline

            // Ensure pedidoExistente.getFechaPedido() returns a String,
            // or convert it here if it returns a Date/Object.
            String fechaPedidoStr = String.valueOf(pedidoExistente.getFechaPedido());

            // Assuming your pedido constructor expects a String for total, and a
            // List<detallepedido> as last arg (can be null)
            pedido pedidoActualizado = new pedido(
                    id,
                    nuevoIdUsuario,
                    fechaPedidoStr, // Use the string representation
                    nuevoEstado,
                    nuevoTotal, // Use the String for total
                    nuevoIdDireccionEnvio,
                    null // <--- ADD THIS if your constructor has List<detallepedido> as last arg
            );

            appController.actualizarPedido(pedidoActualizado);
            System.out.println("Pedido actualizado exitosamente.");
        } else {
            System.out.println("No se encontró ningún pedido con el ID proporcionado.");
        }
    }

    private static void eliminarPedido() {
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.eliminarPedido(id);
    }

    // Métodos para Carrito de Compras
    private static void agregarAlCarrito() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la fecha de agregado: ");
        String fechaAgregado = scanner.nextLine();
        appController.agregarAlCarrito(idUsuario, idProducto, cantidad, fechaAgregado);
    }

    private static void obtenerCarritoPorUsuario() {
        System.out.print("Ingrese el ID del usuario para obtener el carrito: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        List<carritocompra> carrito = appController.obtenerCarritoPorIdUsuario(idUsuario);
        if (carrito != null && !carrito.isEmpty()) {
            System.out.println("\n--- Carrito de Compras del Usuario " + idUsuario + " ---");
            for (carritocompra item : carrito) {
                System.out.println("ID Carrito: " + item.getIdCarrito() + ", Producto: " + item.getIdProducto()
                        + ", Cantidad: " + item.getCantidad() + ", Fecha Agregado: " + item.getFechaAgregado());
            }
        } else if (carrito != null) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("No se pudo obtener el carrito.");
        }
    }

    private static void actualizarCantidadEnCarrito() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID del producto en el carrito: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la nueva cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.actualizarCantidadEnCarrito(idUsuario, idProducto, cantidad);
    }

    private static void eliminarDelCarrito() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID del producto a eliminar del carrito: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.eliminarDelCarrito(idUsuario, idProducto);
    }

    private static void eliminarCarrito() {
        System.out.print("Ingrese el ID del usuario para eliminar el carrito: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.eliminarCarrito(idUsuario);
    }

    // Métodos para Reseñas de Productos
    private static void crearResena() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese la calificación (1-5): ");
        int calificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el comentario: ");
        String comentario = scanner.nextLine();
        System.out.print("Ingrese la fecha de reseña: ");
        String fechaResena = scanner.nextLine();
        appController.crearResena(idUsuario, idProducto, calificacion, comentario, fechaResena);
    }

    private static void obtenerResenaPorId() {
        System.out.print("Ingrese el ID de la reseña a obtener: ");
        int idResena = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        reseñaproducto resena = appController.obtenerResenaPorId(idResena);
        if (resena != null) {
            System.out.println("Reseña encontrada: ID: " + resena.getIdResena() + ", Usuario: " + resena.getIdUsuario()
                    + ", Producto: " + resena.getIdProducto() + ", Calificación: " + resena.getCalificacion()
                    + ", Comentario: " + resena.getComentario() + ", Fecha: " + resena.getFechaResena());
        } else {
            System.out.println("No se encontró ninguna reseña con el ID proporcionado.");
        }
    }

    private static void obtenerResenasPorProducto() {
        System.out.print("Ingrese el ID del producto para obtener sus reseñas: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        List<reseñaproducto> resenas = appController.obtenerResenasPorIdProducto(idProducto);
        if (resenas != null && !resenas.isEmpty()) {
            System.out.println("\n--- Reseñas del Producto " + idProducto + " ---");
            for (reseñaproducto resena : resenas) {
                System.out.println("ID: " + resena.getIdResena() + ", Usuario: " + resena.getIdUsuario()
                        + ", Calificación: " + resena.getCalificacion() + ", Comentario: " + resena.getComentario()
                        + ", Fecha: " + resena.getFechaResena());
            }
        } else if (resenas != null) {
            System.out.println("No hay reseñas para este producto.");
        }
    }

    private static void actualizarResena() {
        System.out.print("Ingrese el ID de la reseña a actualizar: ");
        int idResena = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        reseñaproducto resenaExistente = appController.obtenerResenaPorId(idResena);
        if (resenaExistente != null) {
            System.out.print("Ingrese el nuevo ID del usuario: ");
            int nuevoIdUsuario = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese el nuevo ID del producto: ");
            int nuevoIdProducto = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese la nueva calificación (1-5): ");
            String nuevaCalificacion = scanner.nextLine();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese el nuevo comentario: ");
            String nuevoComentario = scanner.nextLine();

            // Convert fechaResena to String if it's not already.
            // Assuming Model.reseñaproducto.getFechaResena() returns a String.
            // If it returns Date/Object, use String.valueOf() or SimpleDateFormat.
            String fechaResenaStr = resenaExistente.getFechaResena();

            reseñaproducto resenaActualizada = new reseñaproducto(
                    idResena,
                    nuevoIdUsuario,
                    nuevoIdProducto,
                    nuevaCalificacion,
                    nuevoComentario,
                    fechaResenaStr // Pass the String date
            );

            appController.actualizarResena(resenaActualizada); // This should now work
            // Confirmation message is already in AppController
        } else {
            System.out.println("No se encontró ninguna reseña con el ID proporcionado.");
        }
    }

    private static void eliminarResena() {
        System.out.print("Ingrese el ID de la reseña a eliminar: ");
        int idResena = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        appController.eliminarResena(idResena);
    }

    // Métodos para Pagos
    private static void procesarPago() {
        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID del método de pago: ");
        int idMetodoPago = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el monto del pago: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el ID de la transacción: ");
        String transaccionId = scanner.nextLine();
        System.out.print("Ingrese la fecha de pago: ");
        String fechaPago = scanner.nextLine();
        appController.procesarPago(idPedido, idMetodoPago, monto, transaccionId, fechaPago);
    }

    private static void obtenerPagoPorId() {
        System.out.print("Ingrese el ID del pago a obtener: ");
        int idPago = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        pago pago = appController.obtenerPagoPorId(idPago);
        if (pago != null) {
            System.out.println("Pago encontrado: ID: " + pago.getIdPago() + ", Pedido: " + pago.getIdPedido()
                    + ", Método de Pago: " + pago.getIdMetodoPago() + ", Fecha: " + pago.getFechaPago() + ", Monto: "
                    + pago.getMonto() + ", Transacción ID: " + pago.getTransaccionId());
        } else {
            System.out.println("No se encontró ningún pago con el ID proporcionado.");
        }
    }
}
