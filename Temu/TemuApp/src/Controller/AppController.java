package Controller;

import java.util.List;

import Model.producto;
import Model.reseñaproducto;
import Model.usuario;
import Service.productoService;
import Service.reseñaService;
import Model.carritocompra;
import Model.detallepedido;
import Model.pedido;
import Service.CompraService;
import Model.pago;
import Service.pedidoService;

public class AppController {
    private final Service.usuarioService usuarioService;
    private productoService productoService;
    private pedidoService pedidoService;

    public AppController() {
        this.usuarioService = new Service.usuarioService();
        this.productoService = new productoService();
        this.pedidoService = new pedidoService();   
        this.compraService = new CompraService();
        this.resenaService = new reseñaService();

        this.pagoService = new CompraService();
    }

    // Métodos para Usuarios
    public void crearUsuario(String nombre, String apellido, String email, String contrasena, String telefono,
            String fechaRegistro) {
        usuario usuario = new Model.usuario(0, nombre, apellido, email, contrasena, telefono, fechaRegistro);
        usuarioService.crearUsuario(usuario);
    }

    public usuario obtenerUsuarioPorId(int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    public void listarUsuarios() {
        usuarioService.obtenerTodosLosUsuarios().forEach(usuario -> System.out.println(
                "ID: " + usuario.getIdUsuario() + ", Nombre: " + usuario.getNombre() + " " + usuario.getApellido()));
    }

    // Métodos para Productos (delegar al ProductoService)
    public void crearProducto(int idCategoria, String nombre, String descripcion, String precio, int stock, String fechaAlta) {
        producto producto = new Model.producto(0, idCategoria, nombre, descripcion, precio, stock, fechaAlta);
        productoService.crearProducto(producto);
    }

    public Model.producto obtenerProductoPorId(int id) {
        return null; // Llamar al ProductoService
    }

    public List<Model.producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    public void actualizarProducto(Model.producto producto) { // <--- Añade este método
        // Delega la llamada a tu productoService
        productoService.actualizarProducto(producto);
        System.out.println("Producto actualizado exitosamente."); // O maneja la confirmación de otra manera
    }

    public void eliminarProducto(int id) { // <--- Add this method
        // Delegate the call to your productoService
        productoService.eliminarProducto(id);
        System.out.println("Producto eliminado exitosamente."); // Or handle confirmation differently
    }

    // Métodos para Pedidos (delegar al PedidoService)

    public void crearPedido(int idUsuario, String fechaPedido, String estado, String total,
            List<detallepedido> detallesPedido, Integer idDireccionEnvio) {
        this.pedidoService.crearPedido(idUsuario, fechaPedido, estado, total, detallesPedido, idDireccionEnvio);
    }

    public pedido obtenerPedidoPorId(int id) {
        return this.pedidoService.obtenerPedidoPorId(id);
    }

    public List<pedido> obtenerTodosLosPedidos() {
        return this.pedidoService.obtenerTodosLosPedidos();
    }

    public void actualizarPedido(Model.pedido pedido) {
        this.pedidoService.actualizarPedido(pedido);
    }

    public void eliminarPedido(int id) {
        this.pedidoService.eliminarPedido(id);
    }

    public List<detallepedido> obtenerDetallesPedidoPorIdPedido(int idPedido) {
        return this.pedidoService.obtenerDetallesPedidoPorIdPedido(idPedido);
    }

    // Métodos para Carrito de Compras (delegar al CompraService)
    private CompraService compraService = new CompraService(); // Asegúrate de instanciar el servicio

    public void agregarAlCarrito(int idUsuario, int idProducto, int cantidad, String fechaAgregado) {
        compraService.agregarAlCarrito(idUsuario, idProducto, cantidad, fechaAgregado);
    }

    public List<carritocompra> obtenerCarritoPorIdUsuario(int idUsuario) {
        return compraService.obtenerCarritoPorIdUsuario(idUsuario);
    }

    public void actualizarCantidadEnCarrito(int idUsuario, int idProducto, int cantidad) {
        compraService.actualizarCantidadEnCarrito(idUsuario, idProducto, cantidad);
    }

    public void eliminarDelCarrito(int idUsuario, int idProducto) {
        compraService.eliminarDelCarrito(idUsuario, idProducto);
    }

    public void eliminarCarrito(int idUsuario) {
        compraService.eliminarCarrito(idUsuario);
    }

    // Métodos para Reseñas (delegar al ResenaService)
    private reseñaService resenaService = new reseñaService(); // Asegúrate de instanciar el servicio

    public void crearResena(int idUsuario, int idProducto, int calificacion, String comentario, String fechaResena) {
        resenaService.crearResena(idUsuario, idProducto, calificacion, comentario, fechaResena);
    }

    public reseñaproducto obtenerResenaPorId(int id) {
        return resenaService.obtenerResenaPorId(id);
    }

    public List<reseñaproducto> obtenerResenasPorIdProducto(int idProducto) {
        return resenaService.obtenerResenasPorIdProducto(idProducto);
    }

    // Métodos para Pagos (delegar al PagoService)
    private CompraService pagoService = new CompraService(); // Asegúrate de instanciar el servicio, usa CompraService
                                                             // porque ahí se procesan los pagos

    public void procesarPago(int idPedido, int idMetodoPago, double monto, String transaccionId, String fechaPago) {
        pagoService.procesarPago(idPedido, idMetodoPago, monto, transaccionId, fechaPago);
    }

    public pago obtenerPagoPorId(int id) {
        return pagoService.obtenerPagoPorId(id);
    }

    public void actualizarResena(Model.reseñaproducto resena) { // <--- Add this method
        // Delegate the call to your resenaService
        resenaService.actualizarResena(resena);
        System.out.println("Reseña actualizada exitosamente."); // Confirmation
    }

    public void eliminarResena(int id) { // <--- Añade este método
        // Delega la llamada a tu resenaService
        resenaService.eliminarResena(id);
        System.out.println("Reseña eliminada exitosamente."); // Mensaje de confirmación
    }
}
