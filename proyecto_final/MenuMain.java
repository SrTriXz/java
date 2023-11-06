package proyecto_final;
import proyecto_final.Vans;
import proyecto_final.Microbus;
import proyecto_final.Taxi;
import java.util.Scanner;
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
                } while (pasajerosRecogidosVan < 0 || pasajerosRecogidosVan > 10);
                van.rangoPasajeros(pasajerosRecogidosVan);
                van.calcularPasajes();
                van.inicializarConsumo();
                if (trayecto == 1) {
                    van.agregarConsumoPasajeros();
                }
                System.out.println("Gasto total de gasolina: " + van.getConsumo());
                break;

            case 2:
                Microbus microbus = new Microbus(15, 45, 0.033, 12000);
                int pasajerosRecogidosMicrobus;
                do {
                    System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                    pasajerosRecogidosMicrobus = sc.nextInt();
                } while (pasajerosRecogidosMicrobus < 0 || pasajerosRecogidosMicrobus > 15);
                microbus.rangoPasajeros(pasajerosRecogidosMicrobus);
                microbus.calcularPasajes();
                microbus.inicializarConsumo();
                if (trayecto == 1) {
                    microbus.agregarConsumoPasajeros();
                }
                System.out.println("Gasto total de gasolina: " + microbus.getConsumo());
                break;

            case 3:
                Taxi taxi = new Taxi(4, 45, 0.02, 25000);
                int pasajerosRecogidosTaxi;
                do {
                    System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                    pasajerosRecogidosTaxi = sc.nextInt();
                } while (pasajerosRecogidosTaxi < 0 || pasajerosRecogidosTaxi > 4);
                taxi.rangoPasajeros(pasajerosRecogidosTaxi);
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
