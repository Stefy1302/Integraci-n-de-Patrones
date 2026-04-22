/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class FabricaPedidos {

    public static Pedido crearPedido(String tipo, String id, String descripcion,
                                     double pesoKg, double distanciaKm,
                                     String destino) {
        switch (tipo.toUpperCase()) {
            case "NACIONAL":
                return new PedidoNacional(id, descripcion, pesoKg, distanciaKm, destino);
            case "INTERNACIONAL":
                return new PedidoInternacional(id, descripcion, pesoKg, distanciaKm, destino);
            default:
                throw new IllegalArgumentException("Tipo de pedido desconocido: " + tipo);
        }
    }
}