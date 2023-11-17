package proyecto_final;
import proyecto_final.Taxi;
import proyecto_final.Vans;
import proyecto_final.Microbus;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");

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
                Vans van = new Vans(10, 45, 0.03166666667, 15000,0);
                van.rangoPasajeros();
                van.calcularPasajes();
                van.inicializarConsumo();
                double estandar = van.inicializarConsumo();
                if (trayecto == 1) {
                    van.agregarConsumoPasajeros();
                    van.agregarConsumoCambios(); 
                }
                System.out.println("El valor total de los pasajes es de: " + van.tpasajes);
                System.out.println("El consumo estándar del vehículo es de: " + df.format(estandar)+ " galones");
                van.calcularCostoGalones();
                van.calcularRentabilidad();
                break;

            case 2:
                Microbus microbus = new Microbus(15, 45, 0.03, 12000);
                microbus.rangoPasajeros();
                microbus.calcularPasajes();
                microbus.inicializarConsumo();
                double estandarm = microbus.inicializarConsumo();
                if (trayecto == 1) {
                    microbus.agregarConsumoPasajeros();
                    microbus.agregarConsumoCambios(); 
                }
                System.out.println("El valor total de los pasajes es de: " + microbus.tpasajes);
                System.out.println("El consumo estándar del vehículo es de: " + df.format(estandarm)+ " galones");
                microbus.calcularCostoGalones();
                microbus.calcularRentabilidad();
                break;

            case 3:
                Taxi taxi = new Taxi(4, 45, 0.02177777778, 25000);
                taxi.rangoPasajeros();
                taxi.calcularPasajes();
                taxi.inicializarConsumo();
                double estandart = taxi.inicializarConsumo();
                if (trayecto == 1) {
                    taxi.agregarconsumoPasajeros();
                    taxi.agregarConsumoCambios(); 
                }
                System.out.println("El valor total de los pasajes es de: " + taxi.tpasajes);
                System.out.println("El consumo estándar del vehículo es de: " + df.format(estandart)+ " galones");
                taxi.calcularCostoGalones();
                taxi.calcularRentabilidad();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
