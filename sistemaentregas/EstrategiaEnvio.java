/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
interface EstrategiaEnvio {
    double calcularCosto(double pesoKg, double distanciaKm);
    String getNombre();
}