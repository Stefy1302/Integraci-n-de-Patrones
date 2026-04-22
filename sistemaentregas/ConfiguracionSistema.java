/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class ConfiguracionSistema {

    private static ConfiguracionSistema instancia;

    private double impuesto;
    private String moneda;
    private double descuento;

    private ConfiguracionSistema() {
        this.impuesto = 0.19;  
        this.moneda = "COP";
        this.descuento = 0.05;  
    }

    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public double getImpuesto()        { return impuesto; }
    public String getMoneda()          { return moneda; }
    public double getDescuento()       { return descuento; }
    public void setImpuesto(double v)  { this.impuesto = v; }
    public void setMoneda(String v)    { this.moneda = v; }
    public void setDescuento(double v) { this.descuento = v; }

    @Override
    public String toString() {
        return String.format(
            "[Config] Moneda: %s | Impuesto: %.0f%% | Descuento: %.0f%%",
            moneda, impuesto * 100, descuento * 100
        );
    }
}
