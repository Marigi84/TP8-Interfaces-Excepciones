/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8.pkginterface.exception;

public class TarjetaCredito implements PagoConDescuento {
    private static final double DESCUENTO_TARJETA = 0.10; // 10%
    private int cuotas;

    public TarjetaCredito(int cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public double aplicarDescuento(double monto) {
        if (cuotas == 1) {
            System.out.println("Pago en 1 cuota: se aplica un descuento del 10%.");
            return monto * (1 - DESCUENTO_TARJETA);
        } else {
            System.out.println("Pago en " + cuotas + " cuotas: sin descuento.");
            return monto;
        }
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta procesado por $" + monto);
    }
}