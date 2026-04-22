/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class EnvioProgramado implements EstrategiaEnvio {
    private String fechaEntrega;

    public EnvioProgramado(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double base = 5000 + (pesoKg * 800) + (distanciaKm * 80);
        double descuento = ConfiguracionSistema.getInstancia().getDescuento();
        double impuesto  = ConfiguracionSistema.getInstancia().getImpuesto();
        return base * (1 - descuento) * (1 + impuesto);
    }
    @Override
    public String getNombre() { return "Programado para: " + fechaEntrega; }
}
