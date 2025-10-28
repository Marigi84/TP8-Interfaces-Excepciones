# 🧩 TP8 – Interfaces y Excepciones en Java  

**Autora:** Marina Giselle Cordero  
**Carrera:** Tecnicatura Universitaria en Programación – UTN  
**Materia:** Programación II  
**Comisión:** 07  
**Año:** 2025  

---

## 📘 Descripción general
Este trabajo práctico integra dos ejes fundamentales de la programación orientada a objetos en Java:  
**Interfaces** y **Manejo de Excepciones**.  
Su desarrollo tiene como objetivo aplicar conceptos de **abstracción, polimorfismo y tratamiento de errores**, garantizando código más flexible, legible y seguro.

---

## 🔹 Parte 1 – Interfaces
Se implementó un modelo orientado a objetos que representa un sistema de pedidos con diferentes métodos de pago.

### 🧱 Clases e interfaces principales:
- **Producto** → Clase concreta que implementa la interfaz `Pagable`.
- **Cliente** → Clase que implementa la interfaz `Notificable`.
- **Pedido** → Clase que utiliza las interfaces `Pagable` y `PagoConDescuento` para calcular el total y aplicar descuentos.
- **Pago**, **PagoConDescuento** → Interfaces que definen el contrato para procesar pagos y aplicar descuentos.
- **TarjetaCredito** y **PayPal** → Clases que implementan las interfaces anteriores con comportamientos específicos.

### 🧩 Conceptos aplicados:
- Abstracción mediante interfaces.  
- Polimorfismo: distintos medios de pago implementan la misma interfaz.  
- Asociación y composición entre clases (`Pedido`–`Producto`–`Cliente`).  
- Uso de constantes estáticas (`DESCUENTO_TARJETA`, `DESCUENTO_PAYPAL`).  

### 📊 Diagrama UML:
Se diseñó un **diagrama de clases UML** que refleja las relaciones entre clases e interfaces:
- Asociación entre `Pedido` y `Cliente`.
- Composición entre `Pedido` y `Producto`.
- Implementación de interfaces por parte de `TarjetaCredito` y `PayPal`.

---

## 🔹 Parte 2 – Manejo de Excepciones
Incluye una serie de ejercicios para practicar el manejo de errores en Java mediante **try–catch**, **throws**, **excepciones personalizadas** y **try-with-resources**.

### 🧠 Ejercicios desarrollados:
1. **División segura**  
   - Captura `ArithmeticException` cuando el divisor es cero.  

2. **Conversión de cadena a número**  
   - Captura `NumberFormatException` si el texto ingresado no es un número válido.  

3. **Lectura de archivo**  
   - Maneja `FileNotFoundException` cuando el archivo no existe.  

4. **Excepción personalizada – `EdadInvalidaException`**  
   - Clase separada que hereda de `Exception`.  
   - Lanza una excepción si la edad es menor a 0 o mayor a 120.  

5. **Try-with-resources**  
   - Usa `BufferedReader` con cierre automático de recursos.  
   - Maneja `IOException` adecuadamente.

### 💬 Conclusión general:
El manejo de excepciones permite crear programas más **seguros y predecibles**, evitando fallos inesperados y ofreciendo mensajes claros al usuario.  
El uso de **excepciones personalizadas** mejora la legibilidad y el control del flujo, mientras que `try-with-resources` optimiza el manejo de archivos garantizando el cierre automático de recursos.

---

## ⚙️ Requisitos técnicos
- **JDK:** 24  
- **Entorno:** Apache NetBeans IDE  
- **Codificación recomendada:** UTF-8 o Windows-1252  
- **Estructura del proyecto:**
📍 *Repositorio creado con fines académicos y demostrativos.*
