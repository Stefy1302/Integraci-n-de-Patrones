/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class DecoradorReintento extends DecoradorNotificacion {
    private int maxIntentos;

    public DecoradorReintento(Notificacion notificacion, int maxIntentos) {
        super(notificacion);
        this.maxIntentos = maxIntentos;
    }

    @Override
    public void enviar(String mensaje) {
        for (int i = 1; i <= maxIntentos; i++) {
            try {
                System.out.printf("    [REINTENTO] Intento %d de %d...%n", i, maxIntentos);
                notificacionWrapped.enviar(mensaje);
                System.out.println("    [REINTENTO] Envio exitoso ");
                return;
            } catch (Exception e) {
                System.out.println("    [REINTENTO] Fallo intento " + i);
            }
        }
        System.out.println("    [REINTENTO] Todos los intentos fallaron.");
    }
}