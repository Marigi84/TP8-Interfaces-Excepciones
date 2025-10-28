/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8.excepcion;

/**
 * Excepción personalizada que se lanza cuando una edad no es válida.
 * Se considera inválida si es menor a 0 o mayor a 120.
 */
public class EdadInvalidaException extends Exception {

    // Constructor que recibe un mensaje descriptivo
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
