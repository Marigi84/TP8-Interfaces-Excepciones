/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp8.excepcion;

import java.io.*;
import java.util.Scanner;

/**
 * =============================================================
 *  Trabajo Pr�ctico 8 � Parte 2: Manejo de Excepciones en Java
 * =============================================================
 * 
 * Este programa re�ne los 5 ejercicios solicitados sobre excepciones.
 * Cada ejercicio est� implementado como un m�todo independiente.
 * 
 * Contenido:
 *  1. Divisi�n segura (ArithmeticException)
 *  2. Conversi�n de cadena a n�mero (NumberFormatException)
 *  3. Lectura de archivo (FileNotFoundException)
 *  4. Excepci�n personalizada (EdadInvalidaException)
 *  5. Uso de try-with-resources con BufferedReader (IOException)
 */

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        // Men� principal para seleccionar qu� ejercicio ejecutar
        do {
            System.out.println("\n===== TP8 - PARTE 2: EXCEPCIONES =====");
            System.out.println("1. Divisi�n segura");
            System.out.println("2. Conversi�n de cadena a n�mero");
            System.out.println("3. Lectura de archivo");
            System.out.println("4. Excepci�n personalizada (EdadInvalidaException)");
            System.out.println("5. Try-with-resources con BufferedReader");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opci�n: ");
            opcion = Integer.parseInt(sc.nextLine());

            // Ejecuta el m�todo correspondiente seg�n la opci�n elegida
            switch (opcion) {
                case 1 -> divisionSegura();
                case 2 -> conversionCadenaNumero();
                case 3 -> lecturaArchivo();
                case 4 -> excepcionPersonalizada();
                case 5 -> lecturaTryWithResources();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opci�n no v�lida.");
            }

        } while (opcion != 0);
    }

    // =============================================================
    // EJERCICIO 1 - Divisi�n segura
    // =============================================================
    public static void divisionSegura() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Ingrese numerador: ");
            int numerador = Integer.parseInt(sc.nextLine().trim()); // Conversi�n de texto a n�mero entero

            System.out.print("Ingrese denominador: ");
            int denominador = Integer.parseInt(sc.nextLine().trim());

            // Esta l�nea puede lanzar ArithmeticException si el denominador es 0
            int resultado = numerador / denominador;

            System.out.println("Resultado: " + numerador + " / " + denominador 
                    + " = " + resultado);

        } catch (ArithmeticException e) {
            // Se ejecuta si ocurre una divisi�n por cero
            System.out.println("?? Error: No se puede dividir por cero.");
        } catch (NumberFormatException e) {
            // Se ejecuta si el usuario escribe texto en lugar de n�meros
            System.out.println("?? Error: Debe ingresar n�meros enteros v�lidos.");
        } finally {
            // Bloque que siempre se ejecuta, ocurra o no una excepci�n
            System.out.println("Ejecuci�n finalizada.\n");
        }
    }

    // =============================================================
    // EJERCICIO 2 - Conversi�n de cadena a n�mero
    // =============================================================
    public static void conversionCadenaNumero() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese un n�mero entero: ");
            String texto = sc.nextLine().trim(); // Lee el texto ingresado por el usuario

            // Intenta convertir el texto a un n�mero entero
            int numero = Integer.parseInt(texto);

            System.out.println("? El n�mero ingresado es: " + numero);

        } catch (NumberFormatException e) {
            // Se ejecuta si el texto no es num�rico
            System.out.println("?? Error: El valor ingresado no es un n�mero v�lido.");
        }

        System.out.println("Programa finalizado.\n");
    }

    // =============================================================
    // EJERCICIO 3 - Lectura de archivo
    // =============================================================
    public static void lecturaArchivo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine().trim();

        try {
            File archivo = new File(nombreArchivo);        // Crea un objeto File que representa el archivo
            Scanner lector = new Scanner(archivo);         // Intenta abrir el archivo para lectura

            System.out.println("\n? Contenido del archivo:");
            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());     // Muestra l�nea por l�nea el contenido
            }

            lector.close();                                // Cierra el archivo

        } catch (FileNotFoundException e) {
            // Se ejecuta si el archivo no existe o no se puede abrir
            System.out.println("?? Error: El archivo '" + nombreArchivo 
                    + "' no existe o no se puede abrir.");
        }

        System.out.println("Lectura finalizada.\n");
    }

    // =============================================================
    // EJERCICIO 4 - Excepci�n personalizada: EdadInvalidaException
    // =============================================================
     public static void excepcionPersonalizada() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n=== EJERCICIO 4: Excepci�n personalizada ===");

    try {
        // 1?? Se solicita la edad al usuario
        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(sc.nextLine().trim());

        // 2?? Se valida la edad mediante un m�todo que puede lanzar la excepci�n
        validarEdad(edad);

        // 3?? Si no se lanz� excepci�n, la edad es v�lida
        System.out.println("? Edad v�lida: " + edad + " a�os.");

    } 
    // Captura de la excepci�n personalizada (definida por nosotros)
    catch (EdadInvalidaException e) {
        System.out.println("?? Error: " + e.getMessage());
    } 
    // Captura de error por ingreso de texto en lugar de n�mero
    catch (NumberFormatException e) {
        System.out.println("?? Error: debe ingresar un n�mero entero.");
    }

    System.out.println("Lectura finalizada.\n");
}

/**
 * M�todo que valida una edad.
 * Si no cumple las condiciones, lanza una EdadInvalidaException.
 * 
 * @param edad valor ingresado por el usuario
 * @throws EdadInvalidaException si la edad es negativa o superior a 120
 */
public static void validarEdad(int edad) throws EdadInvalidaException {
    if (edad < 0) {
        // Se lanza la excepci�n con un mensaje personalizado
        throw new EdadInvalidaException("La edad no puede ser negativa.");
    }
    if (edad > 120) {
        // Se lanza la excepci�n con otro mensaje personalizado
        throw new EdadInvalidaException("La edad no puede superar los 120 a�os.");
    }
}
    // =============================================================
    // EJERCICIO 5 - Try-with-resources con BufferedReader
    // =============================================================
   // Lectura de archivo con try-with-resources
// ------------------------------------------
public static void lecturaTryWithResources() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n=== EJERCICIO 5: Try-with-resources ===");

    // Se pide al usuario el nombre del archivo
    System.out.print("Ingrese el nombre del archivo a leer: ");
    String nombreArchivo = sc.nextLine().trim();

    // El bloque try-with-resources garantiza el cierre autom�tico del BufferedReader
    try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {

        System.out.println("\n? Contenido del archivo:");
        System.out.println("-------------------------");

        // Se lee l�nea por l�nea hasta que readLine() devuelve null
        String linea;
        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
        }

        System.out.println("\nLectura finalizada correctamente.");

    } catch (IOException e) {
        // Se captura cualquier error de entrada/salida:
        // - archivo inexistente
        // - permisos insuficientes
        // - error al leer
        System.out.println("?? Error al leer el archivo: " + e.getMessage());
    }
}
}

    

