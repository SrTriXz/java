import java.util.Scanner;
import java.text.DecimalFormat;



public class Vans {
    int pasajeros, recorrido, pasajes, tpasajes;
    double consumo_estandar, consumo;
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.###");

    public Vans(int capacidad, int recorrido, double consumo_estandar, int pasajes) {
        this.pasajeros = capacidad;
        this.recorrido = recorrido;
        this.consumo_estandar = consumo_estandar;
        this.pasajes = pasajes;
        this.tpasajes = 0;
        
    }

    public void rangoPasajeros(int pasajerosRecogidos) {
        if (pasajerosRecogidos < 1 || pasajerosRecogidos > pasajeros) {
            System.out.println("La cantidad de pasajeros recogidos no es válida.");
        } else {
            pasajeros = pasajerosRecogidos;
        }
    }

    public int calcularPasajes() {
        tpasajes = pasajeros * pasajes;
        System.out.println("El valor total de los pasajes es de: " + tpasajes);
        return tpasajes;
    }

    public double inicializarConsumo() {
        consumo = recorrido * consumo_estandar;
        System.out.println("El consumo estándar del vehículo es de: " + df.format(consumo));
        return consumo;
    }

    public double agregarConsumoPasajeros() {
        double extra_pasajero, extra;
        extra_pasajero = 0.03;
        extra = consumo * (pasajeros * extra_pasajero);
        consumo += extra;
        System.out.println("El consumo extra por los pasajeros es de " + df.format(extra) + ". El consumo total sin cambios es de " + df.format(consumo));
        return consumo;
    }

    public double getConsumo() {
        return consumo;
    }
}
