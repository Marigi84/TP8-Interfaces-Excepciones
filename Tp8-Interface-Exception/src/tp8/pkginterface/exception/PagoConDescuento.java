/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp8.pkginterface.exception;

/**
 *
 * @author marin
 */
// Extiende Pago y agrega comportamiento adicional.
public interface PagoConDescuento extends Pago {
    double aplicarDescuento(double monto);
}
