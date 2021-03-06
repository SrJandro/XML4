import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String nombrePr;
    int stock;
    int precio;

    public void Tienda() {
        solicitarNombrePro();
        solicitarStockPro();
        solicitarPrecioPro();
    }
    public void solicitarNombrePro(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("------Producte--------");
        System.out.println("Introdueix el nom del producte: ");
        nombrePr = teclado.nextLine();
    }

    public static int solicitarProductos() {
        int numeroPro;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Quants productes desitja?");

        numeroPro = teclado.nextInt();
        return numeroPro;
    }

    public void solicitarStockPro(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introdueix el stock de: " + devolverNombre() + " : ");
        stock = teclado.nextInt();
    }

    public void solicitarPrecioPro(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el precio de: " + devolverNombre() + " : ");
        precio = teclado.nextInt();
    }

    public String devolverNombre(){
        return nombrePr;
    }
    public int devolverPrecio(){
        return precio;
    }
    public int devolverStok(){
        return stock;
    }
    public void modificarStock(int sto){
        stock = stock -sto;
        System.out.println("Venta realizada.");
    }
    public boolean quedaStock(int sto){

        if (stock >= sto) {

            return true;

        } else {

            System.err.println("Error. Quedan " + stock + " unidades");

            return false;
        }
    }
    public static void menuEntrada (ArrayList <Tienda> productos) {
        int opcion;

        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("+++ Supermecado \" 2A \" +++++");
            System.out.println("");
            System.out.println("Pulse 1 para mostrar el ticket");
            System.out.println("Pulse 2 para acceder al Menu de productos");
            System.out.println("Pulse 3 para salir ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: {
                    menuProductos(productos);
                    break;
                }
                case 2: {
                    menuVentas(productos);
                    break;
                }
                case 3: {
                    System.out.println("Gracias, vuelva pronto");
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }

        } while (opcion != 3);


    }

    public static void menuProductos(ArrayList<Tienda> productos) {
        String respuesta = "no";
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("- Menu Productos -");

            productos.add(new Tienda());

            System.out.println("??Desea algun Otro Producto?");
            respuesta = teclado.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));

    }

    public static void menuVentas(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int unidades=0;
        String respuesta;
        double factura = 0;
        do {
            System.out.println("--Menu de venta de productos--");
            System.out.println("");

            for (int i = 0; i < productos.size(); i++) {
                System.out.println("Puse " + i + " Para comprar " + productos.get(i).devolverNombre() + " cuyo precio es de " + productos.get(i).devolverPrecio() + " y el stock es de " + productos.get(i).devolverStok() + " unidades");
            }

            opcion = teclado.nextInt();

            System.out.println("Ha elegido comprar " + productos.get(opcion).devolverNombre());

            for (int i = opcion; i < productos.size(); i++) {

                unidades = unidades(productos);

                if (productos.get(i).quedaStock(unidades) == true) {
                    productos.get(i).modificarStock(unidades);
                    unidades = unidades * productos.get(i).devolverPrecio();
                }
                break;
            }

            factura = factura + unidades;

            System.out.println("??Desea comprar otro producto?(si/no)");
            respuesta = teclado.next();

        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println("El total de su compra es: " + factura + "???????");

    }

    public static int unidades(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int unidades;

        System.out.println("??Cuantas unidades quieres?");
        unidades = teclado.nextInt();

        return unidades;
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Tienda> productos = new ArrayList<>();

        menuEntrada(productos);

    }

}