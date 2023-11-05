import java.util.Scanner;
public class MenuMain {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        Taxi t = new Taxi(0, 0, 0.02, 45, 0,25000,0);
        int opcion;
        do{

            System.out.println("Seleccione el tipo de vehiculo: ");
            System.out.println("1. taxi (capacidad 4 pasajeros)");
            System.out.println("2. van(capacidad 10 pasajeros)");
            System.out.println("3. MicroBus (capacidad 15 pasajeros)");
            System.out.println("0. Salir del menu");
            opcion = sc.nextInt();



            switch (opcion) {
                case 1:
                t.rangoPasajeros();      
                default:
                    break;
                case 2:
            }

            

        
        
        
            }while(opcion != 0); {
        }
        
        
        
 

    /* 
    
    
    */

        
    }
    
}
