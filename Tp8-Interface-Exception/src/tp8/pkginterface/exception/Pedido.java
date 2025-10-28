/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8.pkginterface.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marin
 */
public class Pedido implements Pagable {
    private List<Producto> productos = new ArrayList<>();
    private Cliente cliente;
    private PagoConDescuento metodoPago; // Usa la interfaz, no una clase concreta


    public Pedido(Cliente cliente, PagoConDescuento metodoPago) {
        this.cliente = cliente;
        this.metodoPago = metodoPago;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        cliente.notificar("Producto agregado: " + p);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public void pagar() {
        double total = calcularTotal();
        double conDescuento = metodoPago.aplicarDescuento(total);
        metodoPago.procesarPago(conDescuento);
    }
}