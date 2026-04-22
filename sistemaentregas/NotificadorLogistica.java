/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class NotificadorLogistica implements ObservadorPedido {
    @Override
    public void actualizar(String idPedido, String estadoAnterior, String nuevoEstado) {
        System.out.printf(
            "  [LOGISTICA] Pedido %s cambio de '%s' a '%s'. Actualizar rutas.%n",
            idPedido, estadoAnterior, nuevoEstado
        );
    }
    @Override
    public String getNombre() { return "Area de Logistica"; }
}