/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class PedidoInternacional extends Pedido {
    private String paisDestino;
    private double arancelAdicional;

    public PedidoInternacional(String id, String descripcion, double pesoKg,
                               double distanciaKm, String paisDestino) {
        super(id, descripcion, pesoKg, distanciaKm);
        this.paisDestino      = paisDestino;
        this.arancelAdicional = 0.15; // 15% arancel
    }

    @Override
    public double calcularCostoEnvio() {
        return super.calcularCostoEnvio() * (1 + arancelAdicional);
    }

    @Override
    public String getTipo() { return "Internacional → " + paisDestino; }
}
