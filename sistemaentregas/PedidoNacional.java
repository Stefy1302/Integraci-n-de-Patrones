/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class PedidoNacional extends Pedido {
    private String ciudadDestino;

    public PedidoNacional(String id, String descripcion, double pesoKg,
                          double distanciaKm, String ciudadDestino) {
        super(id, descripcion, pesoKg, distanciaKm);
        this.ciudadDestino = ciudadDestino;
    }

    @Override
    public String getTipo() { return "Nacional → " + ciudadDestino; }
}
