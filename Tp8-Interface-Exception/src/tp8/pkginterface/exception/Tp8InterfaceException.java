/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp8.pkginterface.exception;

/**
 *
 * @author marin
 */
public class Tp8InterfaceException {

    public static void main(String[] args) {
        // --- CLIENTE PRINCIPAL ---
        Cliente cliente = new Cliente("Marina");

        // --- PEDIDO 1: Tarjeta de crédito en 3 cuotas (sin descuento) ---
        System.out.println("========== PEDIDO 1 ==========");
        PagoConDescuento pagoTarjeta = new TarjetaCredito(3);
        Pedido pedido1 = new Pedido(cliente, pagoTarjeta);

        pedido1.agregarProducto(new Producto("Libro", 5000));
        pedido1.agregarProducto(new Producto("Mouse", 3500));

        pedido1.pagar(); // Se espera sin descuento

        // --- PEDIDO 2: PayPal en 1 pago (con descuento) ---
        System.out.println("\n========== PEDIDO 2 ==========");
        PagoConDescuento pagoPayPal = new PayPal(1);
        Pedido pedido2 = new Pedido(cliente, pagoPayPal);

        pedido2.agregarProducto(new Producto("Auriculares", 6000));
        pedido2.agregarProducto(new Producto("Teclado", 4000));

        pedido2.pagar(); // Se espera con descuento
    }
}