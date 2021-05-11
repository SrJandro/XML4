public class Prueba {
    public static void main(String[] args) {

        // Creamos tienda, llenamos el almacen y mostramos el inventario:
        Tienda t = new Tienda();
        t.llenarAlmacen();
        t.mostrarInventario();

        // Saldo de la compra
        c.mostrarSaldo();

        // Obtenemos array de articulos en la tienda:
        Articulo[] articulos = t.obtenerArticulos();

        // Ejemplo de venta directa:
        t.vender(articulos[0], c);

        // Mostramos el estado del inventario, el saldo y el historial del
        // cliente despues de la compra (ticket):
        t.mostrarInventario();
        c.mostrarSaldo();
        c.mostrarHistorial();

        // Ejemplo de venta mediante el carrito:
        t.meterAlCarrito(articulos[1], c);
        t.meterAlCarrito(articulos[3], c);
        c.mostrarCarrito();
        t.venderCarrito(c);

        // Mostramos el estado del inventario, el saldo y el historial del
        // cliente despues de la compra:
        t.mostrarInventario();
        c.mostrarSaldo();
        c.mostrarHistorial();

        // Cosas erroneas:

        // 1. Intentamos meter al carrito un articulo que no esta en el inventario:
        t.meterAlCarrito(new Articulo(99, "ArticuloTrampa", 0), c);

        // 2. Intentamos comprar un articulo que no esta en el inventario:
        t.vender(new Articulo(99, "ArticuloTrampa", 0), c);

        // 3. Un cliente no registrado intenta comprar en la tienda:
        t.vender(articulos[0], new Cliente("ClienteNoRegistrado"));
    }
}