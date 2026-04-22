/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
abstract class DecoradorNotificacion implements Notificacion {
    protected Notificacion notificacionWrapped;

    public DecoradorNotificacion(Notificacion notificacion) {
        this.notificacionWrapped = notificacion;
    }

    @Override
    public void enviar(String mensaje) {
        notificacionWrapped.enviar(mensaje);
    }
} 