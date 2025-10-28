/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8.pkginterface.exception;

public class PayPal implements PagoConDescuento {
    private static final double DESCUENTO_PAYPAL = 0.05; // 5%
    private int cuotas;

    public PayPal(int cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public double aplicarDescuento(double monto) {
        if (cuotas == 1) {
            System.out.println("Pago en 1 cuota: se aplica un descuento del 5%.");
            return monto * (1 - DESCUENTO_PAYPAL);
        } else {
            System.out.println("Pago en " + cuotas + " cuotas: sin descuento.");
            return monto;
        }
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal procesado por $" + monto);
    }
}