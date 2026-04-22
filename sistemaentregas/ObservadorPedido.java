/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
interface ObservadorPedido {
    void actualizar(String idPedido, String estadoAnterior, String nuevoEstado);
    String getNombre();
}