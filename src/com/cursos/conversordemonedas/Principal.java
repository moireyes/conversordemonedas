package com.cursos.conversordemonedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("*****SISTEMA CONVERSOR DE MONEDAS******");
        System.out.println("Bienvenido al Conversor de Monedas");
        boolean salida = false;
        while (!salida) {
            System.out.println("1. Dólar >>>>>>>>>>>> Peso Argentino");
            System.out.println("2. Peso Argentino >>>>>>>>>>>> Dólar");
            System.out.println("3. Dólar >>>>>>>>>>>> Real Brasileño");
            System.out.println("4. Real Brasileño >>>>>>>>>>>> Dólar");
            System.out.println("5. Dólar >>>>>>>>>>>> Peso Colombiano");
            System.out.println("6. Peso Colombiano >>>>>>>>>>>> Dólar");
            System.out.println("7. Salir");
            System.out.println("Elija una opción");
            Scanner leer = new Scanner(System.in);
            int opcion = leer.nextInt();

            //Condiciones de selección
            if (opcion == 1) {
                System.out.println("Dólar >>>>>> Peso Argentino");
            } else if (opcion == 2) {
                System.out.println("Peso Argentino >>>>>> Dólar");
            } else if (opcion == 3) {
                System.out.println("Dólar >>>>>> Real Brasileño");
            } else if (opcion == 4) {
                System.out.println("Real Brasileño >>>>>> Dólar");
            } else if (opcion == 5) {
                System.out.println("Dólar >>>>>> Peso Colombiano");
            } else if (opcion == 6) {
                System.out.println("Peso Colombiano >>>>>> Dólar");
            } else if (opcion == 7) {
                salida = true;
                System.out.println("Regresa pronto");
            } else {
                System.out.println("Opción no Valida");
            }
        }
    }
}
