package proyecto_final;
import java.util.Scanner;
import proyecto_final.Vans;
import proyecto_final.Microbus;
import proyecto_final.Taxi;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Vans");
        System.out.println("2. Microbus");
        System.out.println("3. Taxi");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Vans van = new Vans(10, 45, 0.04, 15000);
                System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                int pasajerosRecogidosVan = sc.nextInt();
                van.rangoPasajeros(pasajerosRecogidosVan);
                van.calcularPasajes();
                van.inicializarConsumo();
                van.agregarConsumoPasajeros();
                System.out.println("Gasto total de gasolina: " + van.getConsumo());
                break;

            case 2:
                Microbus microbus = new Microbus(15, 45, 0.033, 12000);
                System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                int pasajerosRecogidosMicrobus = sc.nextInt();
                microbus.rangoPasajeros(pasajerosRecogidosMicrobus);
                microbus.calcularPasajes();
                microbus.inicializarConsumo();
                microbus.agregarConsumoPasajeros();
                System.out.println("Gasto total de gasolina: " + microbus.getConsumo());
                break;

            case 3:
                Taxi taxi = new Taxi(4, 45, 0.02, 25000);
                System.out.print("¿Cuántas personas recogió en todo el viaje? ");
                int pasajerosRecogidosTaxi = sc.nextInt();
                taxi.rangoPasajeros(pasajerosRecogidosTaxi);
                taxi.calcularPasajes();
                taxi.inicializarConsumo();
                taxi.agregarConsumoPasajeros();
                System.out.println("Gasto total de gasolina: " + taxi.getConsumo());
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
