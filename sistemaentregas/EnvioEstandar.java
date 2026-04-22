/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class EnvioEstandar implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double base = 3000 + (pesoKg * 500) + (distanciaKm * 50);
        double impuesto = ConfiguracionSistema.getInstancia().getImpuesto();
        return base * (1 + impuesto);
    }
    @Override
    public String getNombre() { return "Estandar (3-5 días)"; }
}