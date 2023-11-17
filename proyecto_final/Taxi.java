package proyecto_final;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Taxi {
    int pasajeros,pasajes,tpasajes,recorrido,galones;
    double consumo,consumo_estandar,costo_galon;
  
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.###");

    public Taxi(int capacidad, int recorrido, double consumo_estandar, int pasajes) {
        this.pasajeros = capacidad;
        this.recorrido = recorrido;
        this.consumo_estandar = consumo_estandar;
        this.pasajes = pasajes;
        this.tpasajes = 0;
    }
    public void rangoPasajeros() {
        System.out.println("¿Cuántos pasajeros van desde la terminal?");
        pasajeros = sc.nextInt();
        if (pasajeros < 1|| pasajeros > 4) {
            do {
                System.out.print("Cantidad de pasajeros no disponible, inténtalo nuevamente: ");
                pasajeros = sc.nextInt();
            } while (!(pasajeros > 0 && pasajeros <5));
        }
    }
    public int calcularPasajes() {
        tpasajes = (pasajeros) * pasajes;
        return tpasajes;
    }
    public double inicializarConsumo() {
        consumo = recorrido * consumo_estandar;
        return consumo;
    }
    public double agregarconsumoPasajeros(){
        double extra_pasajero=0.02,extra;
        extra= consumo*(pasajeros * extra_pasajero);
        consumo += extra;
        return consumo;
    }
    public double agregarConsumoCambios() {
        int i=0,x=0,y=0,z=0;
        double c1,c2,c3,pc;

        while(i<1){
        System.out.println("durante cuantos kilometros estuvo en primera?");
        x = sc.nextInt();
         System.out.println("durante cuantos kilometros estuvo en segunda?");
        y = sc.nextInt();
         System.out.println("durante cuantos kilometros estuvo en tercera?");
        z = sc.nextInt();
        if(x+y+z > 45 || x < 0  || y<0 || z <0){
            System.out.println("has ingresado mal los kilometros,intentalo nuevamente");
        }
        else {
            i+=1;
        }
        }
        c1= consumo_estandar*x*0.03;
        c2= consumo_estandar*y*0.02;
        c3= consumo_estandar*z*0.01;
        pc=consumo*(c1+c2+c3);
        System.out.println("el consumo por cambios es "+ df.format(pc));
        consumo +=pc;
        return consumo;

    }
    public double getConsumo() {
        return consumo;
    }
   
    public double calcularCostoGalones(){
        costo_galon =  consumo*16000;
        System.out.println("el costo total de los galones requeridos es de $"+ df.format(costo_galon));
        return costo_galon;
    }
    public void calcularRentabilidad(){
        double rentabilidad;
        double ingreso,gasto;
        ingreso=tpasajes;
        gasto=costo_galon;
        rentabilidad= ingreso-gasto;
        System.out.println("la rentabilidad del viaje fue de $"+Math.round(rentabilidad));
       

    }
}
