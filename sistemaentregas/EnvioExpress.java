/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class EnvioExpress implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double pesoKg, double distanciaKm) {
        double base = 8000 + (pesoKg * 1200) + (distanciaKm * 120);
        double impuesto = ConfiguracionSistema.getInstancia().getImpuesto();
        return base * (1 + impuesto);
    }
    @Override
    public String getNombre() { return "Express (1-2 dias)"; }
}