import java.util.Scanner;
import java.text.DecimalFormat;
public class Taxi {
    int pasajeros,kilometros,recorrido,pasajes,tpasajes;
    double consumo_estandar,consumo;
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.###");

    public Taxi(int pasajeros, int kilometros,double consumo_estandar,int recorrido,double consumo,int pasajes,int tpasajes){
        this.pasajeros = pasajeros;
        this.kilometros= kilometros;
        this.consumo_estandar= consumo_estandar;
        this.recorrido=recorrido;
        this.consumo = consumo;
        this.pasajes= pasajes;
        this.tpasajes= tpasajes;

        pasajeros=0;
        kilometros=0;
        consumo_estandar=0.02;
        recorrido=45;
        consumo=0;
        pasajes=25000;
        tpasajes =0;
    }
    public void rangoPasajeros(){
        System.out.println("cuantos pasajeros van a ir en taxi?");
        pasajeros= sc.nextInt();
        if ((pasajeros > 4)||(pasajeros<1)){
            do {
                System.out.print("cantidad de pasajeros no disponible, intentalo nuevamente: ");
                pasajeros = sc.nextInt();
            } while (!(pasajeros >= 1 && pasajeros <= 4));
            
        }
    }
    public int calcularPasajes(){
        tpasajes = pasajeros*pasajes;
        System.out.println("el valor total de los pasajes es de:"+ tpasajes);
        return tpasajes;
    }
    public double inicializarConsumo(){
     consumo   = recorrido*consumo_estandar;
     System.out.println(" el consumo estandar del vehículo es de: "+ consumo);
     return consumo;

    }
    public double agregarconsumoPasajeros(){

        double extra_pasajero,extra;
        extra_pasajero = 0.02;
        extra= consumo*(pasajeros * extra_pasajero);
        consumo += extra;
        System.out.println("el consumo extra por los pasajeros es de " + df.format(extra) + " el consumo total sin cambios es de "+ df.format(consumo));
        return consumo;
    }
/*el siguiente metodo calcula el consumo añadido por los cambios,este va en el main, puesto que es un metod que lo requieren todos los vehículos 
    este metodo recibe el siguiente atributo: consumo(el total del consumo estandar mas el consumo adicional por pasajero),
    public double agregarconsumoCambios(){
        double kilometro_inicio,kilometro_final,consumo_extra,pconsumo,extra;
        int cambio,kilometro;
        kilometro = kilometro_final;
        
        System.out.println("en que kilómetro se hizo el cambio?: ");
        kilometro_inicio = sc.nextDouble();
        System.out.println("hasta que kilómetro se hizo el cambio?: ");
        kilometro_final = sc.nextDouble();
        System.out.println("que cambio se realizo?");
        cambio = sc.nextInt();
                
         if ((cambio > 3)||(cambio<1)){
            do {
                System.out.print("el cambio ingresado no exite en el sistema, intentalo nuevamente");
                cambio = sc.nextInt();
            } while (!(cambio >= 1 && cambio <= 3));
        }
    
        consumo_extra= kilometro_final-kilometro_inicio;
        pconsumo = 0;
        switch (cambio) {
            case 1:
            pconsumo= 3;
                break;
        
            case 2:
            pconsumo= 2;    
                break;
            case 3:
            pconsumo= 1;
                break;
        }
        extra = consumo*((consumo_extra*pconsumo)/100);
        consumo += consumo+ extra; 
        return consumo;      
    }
   
    public int calcularGalonesConsumidos(){
        int galones;
        galones= (int) Math.ceil(consumo);
        return galones;
    }
    public int calcularCostoGalones(){
        int costo_galon,galones;
        galones = calcularGalonesConsumidos();
        costo_galon =  galones*16000;
        return costo_galon;
    }
    public double calcularRentabilidad(){
        double rentabilidad;
        int ingreso,gasto;
        ingreso=calcularPasajes();
        gasto=calcularCostoGalones();
 
        rentabilidad= ingreso-gasto;
        return gasto;
    }
    */
}
