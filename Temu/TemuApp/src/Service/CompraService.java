package Service;

import Model.carritocompra;
import Model.pago;
import Repository.carritocompraRepository;

import java.sql.SQLException;
import java.util.List;

public class CompraService {
    private final carritocompraRepository carritoCompraRepository;
    private final Repository.pagoRepository pagoRepository;

    public CompraService() {
        this.carritoCompraRepository = new carritocompraRepository();
        this.pagoRepository = new Repository.pagoRepository();
    } 

    // Métodos para Carrito de Compras
    public void agregarAlCarrito(int idUsuario, int idProducto, int cantidad, String fechaAgregado) {
        if (idUsuario <= 0 || idProducto <= 0 || cantidad <= 0) {
            System.err.println("Error: Datos de carrito no válidos.");
            return;
        }
        try {
            carritocompra existente = carritoCompraRepository.obtenerCarritoPorIdUsuarioYProducto(idUsuario, idProducto);
            if (existente != null) {
                int nuevaCantidad = existente.getCantidad() + cantidad;
                carritoCompraRepository.actualizarCantidadEnCarrito(idUsuario, idProducto, nuevaCantidad);
                System.out.println("Cantidad actualizada en el carrito.");
            } else {
                carritocompra carrito = new carritocompra(0, idUsuario, idProducto, cantidad, fechaAgregado);
                carritoCompraRepository.agregarAlCarrito(carrito);
                System.out.println("Producto agregado al carrito.");
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar al carrito: " + e.getMessage());
        }
    }

    public List<carritocompra> obtenerCarritoPorIdUsuario(int idUsuario) {
         if (idUsuario <= 0) {
            System.err.println("Error: ID de usuario no válido.");
            return null;
        }
        try {
            return carritoCompraRepository.obtenerCarritoPorIdUsuario(idUsuario);
        } catch (SQLException e) {
            System.err.println("Error al obtener el carrito: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCantidadEnCarrito(int idUsuario, int idProducto, int cantidad) {
        if (idUsuario <= 0 || idProducto <= 0 || cantidad <= 0) {
            System.err.println("Error: Datos de carrito no válidos.");
            return;
        }
        try {
            carritoCompraRepository.actualizarCantidadEnCarrito(idUsuario, idProducto, cantidad);
            System.out.println("Cantidad en carrito actualizada.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar cantidad en carrito: " + e.getMessage());
        }
    }

    public void eliminarDelCarrito(int idUsuario, int idProducto) {
        if (idUsuario <= 0 || idProducto <= 0) {
            System.err.println("Error: Datos de carrito no válidos.");
            return;
        }
        try {
            carritoCompraRepository.eliminarDelCarrito(idUsuario, idProducto);
            System.out.println("Producto eliminado del carrito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar del carrito: " + e.getMessage());
        }
    }
    public void eliminarCarrito(int idUsuario) {
        if (idUsuario <= 0) {
            System.err.println("Error: Datos de carrito no válidos.");
            return;
        }
        try {
            carritoCompraRepository.eliminarCarrito(idUsuario);
            System.out.println("Carrito eliminado.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el carrito: " + e.getMessage());
        }
    }

    // Métodos para Pago
    public void procesarPago(int idPedido, int idMetodoPago, double monto, String transaccionId, String fechaPago) {
        if (idPedido <= 0 || idMetodoPago <= 0 || monto <= 0) {
            System.err.println("Error: Datos de pago no válidos.");
            return;
        }
        pago pago = new pago(0, idPedido, idMetodoPago, fechaPago, monto, transaccionId);
        try {
            pagoRepository.crearPago(pago);
            System.out.println("Pago procesado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al procesar el pago: " + e.getMessage());
        }
    }

     public pago obtenerPagoPorId(int id) {
        if (id <= 0) {
            System.err.println("Error: ID de pago no válido.");
            return null;
        }
        try {
            return pagoRepository.obtenerPagoPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener el pago: " + e.getMessage());
            return null;
        }
    }
}
