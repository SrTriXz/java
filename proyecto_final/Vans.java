package proyecto_final;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Vans {
    int pasajeros,i, recorrido, pasajes, tpasajes, cambios, kilometros = 0,galones;
    double consumo_estandar, consumo,costo_galon;
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.###");

    public Vans(int capacidad, int recorrido, double consumo_estandar, int pasajes, int cambios) {
        this.pasajeros = capacidad;
        this.recorrido = recorrido;
        this.consumo_estandar = consumo_estandar;
        this.pasajes = pasajes;
        this.tpasajes = 0;
        this.cambios = cambios;
    }

    public void rangoPasajeros() {
        System.out.println("¿Cuántos pasajeros van desde la terminal?");
        pasajeros = sc.nextInt();
        if (pasajeros < 0 || pasajeros > 10) {//restringe la cantidad de pasajeros en terminal
            do {
                System.out.print("Cantidad de pasajeros no disponible, inténtalo nuevamente: ");
                pasajeros = sc.nextInt();
            } while (!(pasajeros >= 0 && pasajeros <= 10));
        }
        System.out.println("cuantos pasajeros se montaron durante el recorrido?");
        i= sc.nextInt();
        //verificar que no se pase del limite
        if (pasajeros+i> 10){//si la suma de los pasajeros de terminal y los de camino suman mas de 10 entonces sobrepaso cupo
             do {
                System.out.print("la cantidad de pasajeros sobrepasó el límite de cupos del vehículo, inténtalo nuevamente: ");
                i = sc.nextInt();
            } while (!(pasajeros+i<=10));
            
        }

    }
    public int calcularPasajes() {
        tpasajes = (pasajeros+i) * pasajes;//calcula el precio total de los pasajes
        
        return tpasajes;
    }
    public double inicializarConsumo() {
        consumo = recorrido * consumo_estandar;
        return consumo;
    }
    public double agregarConsumoPasajeros() {
        double extra_pasajero = 0.03, extra,consumo_estandar_distancia;
        int camino=0,k,distancia;
        double tpasajero=0;
        //personas recogidas en el transcurso del camino
        extra= consumo * (pasajeros * extra_pasajero);
        consumo+=extra;
   
        while(camino<i){//camino es el acumculador
            System.out.println("en que kilometro se subió el pasajero " + (camino+1) +"?");
            k= sc.nextInt();
             if (k> 45){
             do {
                System.out.print("kilómetro fuera del límite, inténtalo nuevamente: ");
                k= sc.nextInt();
            } while (!(k<45));
        }
            distancia = 45-k;
            consumo_estandar_distancia= (distancia*consumo_estandar)*0.03;
            tpasajero+=consumo_estandar_distancia;
            camino++;
        }
        System.out.println("el consumo extra por los pasajeros de camino es de " +df.format(tpasajero));
        System.out.println("el total de pasajeros fueron "+ (pasajeros+i) );
        consumo += tpasajero;
        System.out.println("El consumo total sin cambios es de " + df.format(consumo)+" galones.");
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
