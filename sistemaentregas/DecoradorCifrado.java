/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 *
 * @author Estudiantes
 */
class DecoradorCifrado extends DecoradorNotificacion {
    public DecoradorCifrado(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public void enviar(String mensaje) {
        String mensajeCifrado = cifrar(mensaje);
        System.out.println("    [CIFRADO] Mensaje cifrado: " + mensajeCifrado);
        super.enviar(mensaje);
    }

    private String cifrar(String texto) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            sb.append((char)(c + 3));
        }
        return sb.toString().substring(0, Math.min(20, sb.length())) + "...";
    }
}