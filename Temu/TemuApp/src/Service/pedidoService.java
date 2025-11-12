package Service;

import Model.pedido;
import Model.detallepedido;
import Repository.pedidoRepository;

import java.sql.SQLException;
import java.util.List;

public class pedidoService {
    private pedidoRepository pedidoRepository;

    public pedidoService() {
        this.pedidoRepository = new pedidoRepository();
    }

    // Métodos para Pedido
    public void crearPedido(int idUsuario, String fechaPedido , String estado, String total, List<detallepedido> detallesPedido, int idDireccionEnvio) {
        // Validaciones
        if (idUsuario <= 0) {
            System.err.println("Error: ID de usuario no válido.");
            return;
        }
        if (detallesPedido == null || detallesPedido.isEmpty()) {
            System.err.println("Error: No hay detalles de pedido.");
            return;
        }

        pedido pedido = new pedido(0, idUsuario, fechaPedido, estado, String.valueOf(total), idDireccionEnvio, detallesPedido);
        try {
            pedidoRepository.crearPedido(pedido);

            // Crear los detalles del pedido asociados
            for (detallepedido detalle : detallesPedido) {
                detalle.setIdPedido(pedido.getIdPedido()); // Establecer el ID del pedido
                pedidoRepository.crearDetallePedido(detalle);
            }
            System.out.println("Pedido creado exitosamente con ID: " + pedido.getIdPedido());
        } catch (SQLException e) {
            System.err.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    private double calcularTotalPedido(List<detallepedido> detalles) {
        double total = 0;
        for (detallepedido detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    public pedido obtenerPedidoPorId(int id) {
        if (id <= 0) {
            System.err.println("Error: ID de pedido no válido.");
            return null;
        }
        try {
            pedido pedido = pedidoRepository.obtenerPedidoPorId(id);
            if (pedido != null) {
                List<detallepedido> detalles = pedidoRepository.obtenerDetallesPedidoPorIdPedido(id);
                pedido.setDetalles(detalles);
                double calculatedTotal = calcularTotalPedido(detalles);
                pedido.setTotal(String.valueOf(calculatedTotal));
            }
            return pedido;
        } catch (SQLException e) {
            System.err.println("Error al obtener el pedido: " + e.getMessage());
            return null;
        }
    }

    public List<pedido> obtenerTodosLosPedidos() {
        try {
            return pedidoRepository.obtenerTodosLosPedidos();
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los pedidos: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPedido(pedido pedido) {
        if (pedido == null || pedido.getIdPedido() <= 0) {
            System.err.println("Error: Pedido no válido para actualizar.");
            return;
        }
        try {
            pedidoRepository.actualizarPedido(pedido);
            System.out.println("Pedido actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
        }
    }

    public void eliminarPedido(int id) {
        if (id <= 0) {
            System.err.println("Error: ID de pedido no válido.");
            return;
        }
        try {
            pedidoRepository.eliminarPedido(id);
            System.out.println("Pedido eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el pedido: " + e.getMessage());
        }
    }

    // Métodos para DetallePedido (si los expones a la UI directamente desde aquí)
     public List<detallepedido> obtenerDetallesPedidoPorIdPedido(int idPedido) {
        if (idPedido <= 0) {
            System.err.println("Error: ID de pedido no válido.");
            return null;
        }
        try {
            return pedidoRepository.obtenerDetallesPedidoPorIdPedido(idPedido);
        } catch (SQLException e) {
            System.err.println("Error al obtener los detalles del pedido: " + e.getMessage());
            return null;
        }
    }
}