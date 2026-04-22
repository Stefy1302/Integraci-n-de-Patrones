/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class NotificacionBase implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("    [Notificación] Enviando: " + mensaje);
    }
}
