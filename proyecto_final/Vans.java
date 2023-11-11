package proyecto_final;
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
        public double agregarConsumoCambios(){
     double pcambios =0,consumo_kilometro,consumo_cambio;
     
        switch (cambios) {
            case 1:
            pcambios= 0.03;
            break;
            case 2:
            pcambios = 0.02;
            break;
            case 3: 
            pcambios =0.01;
            break;
            default:
            System.out.println("Opción no válida.");
            break;
    }
        
            consumo_kilometro= kilometros*consumo_estandar;
            consumo_cambio = consumo_kilometro*pcambios;
            consumo+= consumo_cambio; 

           
        return consumo;
    }


    public double getConsumo() {
        return consumo;
    }
}
