    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
abstract class Pedido {
    protected String id;
    protected String descripcion;
    protected double pesoKg;
    protected double distanciaKm;
    protected String estado;
    protected EstrategiaEnvio estrategiaEnvio;
    protected List<ObservadorPedido> observadores = new ArrayList<>();
    protected Notificacion notificacion;

    public Pedido(String id, String descripcion, double pesoKg, double distanciaKm) {
        this.id           = id;
        this.descripcion  = descripcion;
        this.pesoKg       = pesoKg;
        this.distanciaKm  = distanciaKm;
        this.estado       = "CREADO";
        this.notificacion = new NotificacionBase(); // Notificación por defecto
    }


    public void suscribir(ObservadorPedido obs)    { observadores.add(obs); }
    public void desuscribir(ObservadorPedido obs)  { observadores.remove(obs); }

    protected void notificarObservadores(String estadoAnterior) {
        System.out.println("\n ► Notificando a " + observadores.size() + " observador(es)...");
        for (ObservadorPedido obs : observadores) {
            obs.actualizar(id, estadoAnterior, estado);
        }
        notificacion.enviar("Pedido " + id + ": " + estadoAnterior + " → " + estado);
    }

    public void cambiarEstado(String nuevoEstado) {
        String anterior = this.estado;
        this.estado = nuevoEstado;
        System.out.printf("%n[PEDIDO %s] Estado cambiado: '%s' a '%s'%n", id, anterior, nuevoEstado);
        notificarObservadores(anterior);
    }

    // --- Strategy ---
    public void setEstrategiaEnvio(EstrategiaEnvio estrategia) {
        this.estrategiaEnvio = estrategia;
    }

    public double calcularCostoEnvio() {
        if (estrategiaEnvio == null) throw new IllegalStateException("Estrategia de envío no definida.");
        return estrategiaEnvio.calcularCosto(pesoKg, distanciaKm);
    }


    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        ConfiguracionSistema cfg = ConfiguracionSistema.getInstancia();
        return String.format(
            "-- Pedido [%s] (%s)%n" +
            "|  Descripcion : %s%n" +
            "|  Peso        : %.1f kg | Distancia: %.1f km%n" +
            "|  Estado      : %s%n" +
            "|  Estrategia  : %s%n" +
            "|  Costo envio : %s %.2f%n" +
            "----------------------------",
            id, getTipo(), descripcion, pesoKg, distanciaKm,
            estado,
            estrategiaEnvio != null ? estrategiaEnvio.getNombre() : "Sin definir",
            cfg.getMoneda(), estrategiaEnvio != null ? calcularCostoEnvio() : 0
        );
    }
}
