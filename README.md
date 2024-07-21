# Sistema de Banco por Consola

## Introducción

Este programa es un sistema de banco por consola que permite la gestión de cuentas bancarias de ahorro y corriente. Implementa los pilares de la programación orientada a objetos (POO) para organizar y manejar las cuentas de manera eficiente.

## Pilares de POO Utilizados

1. **Encapsulamiento:** 
   - Las clases `CuentaBancaria`, `CuentaAhorro` y `CuentaCorriente` utilizan atributos privados y métodos públicos para controlar el acceso y modificación de sus datos internos.

2. **Herencia:**
   - `CuentaAhorro` y `CuentaCorriente` heredan de la clase base `CuentaBancaria`, reutilizando código y manteniendo una estructura lógica.

3. **Polimorfismo:**
   - Las clases derivadas (`CuentaAhorro` y `CuentaCorriente`) implementan sus propios métodos específicos, como `mostrarDatos()`, permitiendo que una referencia de `CuentaBancaria` pueda utilizar métodos de sus subclases.

4. **Abstracción:**
   - La clase `CuentaBancaria` proporciona una abstracción general para cualquier tipo de cuenta bancaria, ocultando detalles específicos de implementación en las subclases.

## Funcionalidad

El programa ofrece las siguientes funcionalidades:

### Menú Principal

1. **Administrador Bancario**
   - **Meta-Información Banco Nexo:** Muestra el número total de cuentas registradas, incluyendo detalles de cuentas de ahorro y corrientes.
   - **Ver todas las Cuentas Bancarias:** Lista todas las cuentas registradas y muestra sus detalles.
   - **Crear Nueva Cuenta:** Permite crear una nueva cuenta de ahorro o corriente.
   - **Modificar Cuenta:** Permite modificar el titular o el saldo de una cuenta existente.
   - **Eliminar Cuenta:** Permite eliminar una cuenta existente.

2. **Usuario Bancario**
   - **Consultar Saldo:** Muestra el saldo actual de la cuenta.
   - **Depositar:** Permite realizar un depósito en la cuenta.
   - **Retirar:** Permite retirar fondos de la cuenta.

3. **Salir:** Finaliza el programa.

### Código del Programa

```java
package cuentabancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>(); 

        int userInput = 0;
        System.out.println("---BIENVENIDOS/a a la plataforma de acceso, <<BANCO NEXO>>");
```


## Vista 
![image](https://github.com/user-attachments/assets/801e2369-4723-4d06-8387-bc0abbc09530)
