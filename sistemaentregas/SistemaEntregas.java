/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaentregas;

/**
 * 
 * @author Estudiantes
 */
public class SistemaEntregas {

    public static void main(String[] args) {

        separador("SISTEMA DE ENTREGAS A DOMICILIO");

        // 1. SINGLETON – Configuración Global
        separador("1. SINGLETON – Configuración Global");
        ConfiguracionSistema config = ConfiguracionSistema.getInstancia();
        System.out.println(config);
        System.out.println("¿Misma instancia? " +
            (config == ConfiguracionSistema.getInstancia())); 


        // 2. FACTORY – Creación de Pedidos
        separador("2. FACTORY – Creación de Pedidos");

        Pedido pedidoNal  = FabricaPedidos.crearPedido("NACIONAL", "P-001",
                                "Laptop + accesorios", 2.5, 300, "Medellin");
        Pedido pedidoIntl = FabricaPedidos.crearPedido("INTERNACIONAL", "P-002",
                                "Libros tecnicos", 1.0, 2800, "Mexico");
                                
        System.out.println("Pedidos creados via fabrica:");
        System.out.println("  • " + pedidoNal.getTipo()  + " | ID: " + pedidoNal.id);
        System.out.println("  • " + pedidoIntl.getTipo() + " | ID: " + pedidoIntl.id);


        // 3. STRATEGY – Estrategias de Envío
        separador("3. STRATEGY – Estrategias de Envio");

        pedidoNal.setEstrategiaEnvio(new EnvioEstandar());
        System.out.println("Pedido Nacional con Envio Estandar:");
        System.out.printf("  Costo: %s %.2f%n",
            config.getMoneda(), pedidoNal.calcularCostoEnvio());

        pedidoNal.setEstrategiaEnvio(new EnvioExpress());
        System.out.println("Pedido Nacional con Envio Express (cambio dinamico):");
        System.out.printf("  Costo: %s %.2f%n",
            config.getMoneda(), pedidoNal.calcularCostoEnvio());

        pedidoIntl.setEstrategiaEnvio(new EnvioProgramado("2026-04-22"));
        System.out.println("Pedido Internacional con Envio Programado:");
        System.out.printf("  Costo (+ arancel 15%%): %s %.2f%n",
            config.getMoneda(), pedidoIntl.calcularCostoEnvio());


        // 4. OBSERVER – Suscripción a Cambios de Estado
        separador("4. OBSERVER – Suscripción a Cambios de Estado");

        ObservadorPedido cliente  = new NotificadorCliente("Ana Garcia", "ana@email.com");
        ObservadorPedido logistic = new NotificadorLogistica();

        pedidoNal.suscribir(cliente);
        pedidoNal.suscribir(logistic);
        pedidoIntl.suscribir(cliente);
        pedidoIntl.suscribir(logistic);

        System.out.println("Observadores registrados en P-001:");
        System.out.println("  • " + cliente.getNombre());
        System.out.println("  • " + logistic.getNombre());


        // 5. DECORATOR – Extensión de Notificaciones
        separador("5. DECORATOR – Extensión de Notificaciones");

        // Combinación: Cifrado -> Logging -> Base
        Notificacion notifNal = new DecoradorCifrado(
                                    new DecoradorLogging(
                                        new NotificacionBase()));
        pedidoNal.setNotificacion(notifNal);
        System.out.println("P-001 usara: Cifrado + Logging + Base");

        // Combinación: Reintentos -> Logging -> Base
        Notificacion notifIntl = new DecoradorReintento(
                                    new DecoradorLogging(
                                        new NotificacionBase()), 3);
        pedidoIntl.setNotificacion(notifIntl);
        System.out.println("P-002 usara: Reintentos(3) + Logging + Base");


        // 6. FLUJO COMPLETO – Ciclo de vida
        separador("6. FLUJO COMPLETO – Ciclo de vida de pedidos");

        System.out.println("\n=== Ejecutando cambios en P-001 ===");
        pedidoNal.cambiarEstado("EN_PREPARACION");
        pedidoNal.cambiarEstado("ENVIADO");
        pedidoNal.cambiarEstado("ENTREGADO");

        System.out.println("\n=== Ejecutando cambios en P-002 ===");
        pedidoIntl.cambiarEstado("EN_PREPARACION");
        pedidoIntl.cambiarEstado("EN_ADUANA");
        pedidoIntl.cambiarEstado("ENVIADO");
        pedidoIntl.cambiarEstado("ENTREGADO");


        // 7. RESUMEN FINAL
        separador("7. RESUMEN FINAL DE PEDIDOS");
        System.out.println(pedidoNal);
        System.out.println();
        System.out.println(pedidoIntl);
    }

    /**
     * Imprime un separador visual limpio en la terminal.
     */
    private static void separador(String titulo) {
        System.out.println("--------------------------------------------------");
        // CORRECCIÓN: Se agrega 's' después del ancho (-40) para indicar String
        // El '%n' genera un salto de línea limpio
        System.out.printf("  %-40s%n", titulo); 
        System.out.println("--------------------------------------------------");
    }
}