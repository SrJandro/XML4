import java.util.Scanner;

//* Gestió de vendes ...*/

public class Main {
    public static void main(String[] args) {
        saludaMain();
        Segon.saluda();
    }



public static void saludaMain(){
    System.out.println("Hola desde Main!");
}


void menuPrincipal(){
    System.out.println("Gestió de supermercat");
    System.out.println("1. Gestió Estoc");
    System.out.println("2. Gestió Vendes");
    System.out.println("3. Sortir");

    Scanner sc = new Scanner(System.in);
    System.out.println("\nIntrodueix la opció (1-3): ");

    //TODO llegir entrada
    //TODO cridar opció escollida
}


static void leerEstoc(){

}
}
