/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class NotificadorCliente implements ObservadorPedido {
    private String nombreCliente;
    private String email;

    public NotificadorCliente(String nombre, String email) {
        this.nombreCliente = nombre;
        this.email = email;
    }

    @Override
    public void actualizar(String idPedido, String estadoAnterior, String nuevoEstado) {
        System.out.printf(
            "  [CLIENTE] %s (%s) → Pedido %s cambio: %s → %s%n",
            nombreCliente, email, idPedido, estadoAnterior, nuevoEstado
        );
    }
    @Override
    public String getNombre() { return "Cliente: " + nombreCliente; }
}