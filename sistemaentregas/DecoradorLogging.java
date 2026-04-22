/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class DecoradorLogging extends DecoradorNotificacion {
    public DecoradorLogging(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("    [LOG] Registrando notificacion en bitacora...");
        super.enviar(mensaje);
        System.out.println("    [LOG] Registro completado ");
    }
}