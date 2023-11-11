package proyecto_final;
import java.util.Scanner;
import proyecto_final.Taxi;
import proyecto_final.Vans;
import proyecto_final.Microbus;
import java.text.DecimalFormat;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Vans");
        System.out.println("2. Microbus");
        System.out.println("3. Taxi");
        opcion = sc.nextInt();

        int trayecto;
        System.out.println("¿De Medellín a Rionegro o de Rionegro a Medellín?");
        System.out.println("1. Medellín a Rionegro");
        System.out.println("2. Rionegro a Medellín");
        trayecto = sc.nextInt();

        switch (opcion) {
            case 1:
                Vans van = new Vans(10, 45, 0.04, 15000);
                int pasajerosRecogidosVan;
                do {
                    System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                    pasajerosRecogidosVan = sc.nextInt();
                    if (pasajerosRecogidosVan < 1 || pasajerosRecogidosVan > 10) {
                        System.out.println("Cantidad de pasajeros no es válida");
                    }
                } while (pasajerosRecogidosVan < 0 || pasajerosRecogidosVan > 10);

                van.calcularPasajes();
                van.inicializarConsumo();
                if (trayecto == 1) {
                    van.agregarConsumoPasajeros();
                }
                System.out.println("Gasto total de gasolina: " + van.getConsumo());
                break;

            case 2:
                Microbus microbus = new Microbus(15, 45, 0.033, 12000);
                int kilometroMicrobus = 0;
                int pasajerosRecogidosMicrobus = 0;

                while (kilometroMicrobus <= 45 && pasajerosRecogidosMicrobus < 15) {
                    System.out.print("¿En qué kilómetro se encuentra? ");
                    kilometroMicrobus = sc.nextInt();

                    if (kilometroMicrobus > 45) {
                        System.out.println("Kilómetro no válido. Máximo permitido: 45");
                        continue;
                    }

                    System.out.print("¿Va a recoger pasajeros? (1: Sí, 2: No) ");
                    int recogerPasajeros = sc.nextInt();

                    if (recogerPasajeros == 1) {
                        System.out.print("¿Cuántos pasajeros va a recoger? ");
                        int pasajeros = sc.nextInt();

                        if (pasajeros > 0 && pasajerosRecogidosMicrobus + pasajeros <= 15) {
                            pasajerosRecogidosMicrobus += pasajeros;
                        } else {
                            System.out.println("Cantidad de pasajeros no válida. Capacidad máxima: 15");
                        }
                    }
                }

                microbus.calcularPasajes();
                microbus.inicializarConsumo();
                if (trayecto == 1) {
                    microbus.agregarConsumoPasajeros();
                }
                System.out.println("Gasto total de gasolina: " + microbus.getConsumo());
                break;

            case 3:
                Taxi taxi = new Taxi(4, 45, 0.02, 25000);
                int kilometroTaxi = 0;
                int pasajerosRecogidosTaxi = 0;

                while (kilometroTaxi <= 45 && pasajerosRecogidosTaxi < 4) {
                    System.out.print("¿En qué kilómetro se encuentra? ");
                    kilometroTaxi = sc.nextInt();

                    if (kilometroTaxi > 45) {
                        System.out.println("Kilómetro no válido. Máximo permitido: 45");
                        continue;
                    }

                    System.out.print("¿Va a recoger pasajeros? (1: Sí, 2: No) ");
                    int recogerPasajeros = sc.nextInt();

                    if (recogerPasajeros == 1) {
                        System.out.print("¿Cuántos pasajeros va a recoger? ");
                        int pasajeros = sc.nextInt();

                        if (pasajeros > 0 && pasajerosRecogidosTaxi + pasajeros <= 4) {
                            pasajerosRecogidosTaxi += pasajeros;
                        } else {
                            System.out.println("Cantidad de pasajeros no válida. Capacidad máxima: 4");
                        }
                    }
                }

                taxi.calcularPasajes();
                taxi.inicializarConsumo();
                if (trayecto == 1) {
                    taxi.agregarConsumoPasajeros();
                }
                System.out.println("Gasto total de gasolina: " + taxi.getConsumo());
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
