package com.cursos.conversordemonedas;
import com.google.gson.Gson;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void menu() {
        System.out.println("1. Dólar >>>>>>>>>>>> Peso Argentino");
        System.out.println("2. Peso Argentino >>>>>>>>>>>> Dólar");
        System.out.println("3. Dólar >>>>>>>>>>>> Real Brasileño");
        System.out.println("4. Real Brasileño >>>>>>>>>>>> Dólar");
        System.out.println("5. Dólar >>>>>>>>>>>> Peso Colombiano");
        System.out.println("6. Peso Colombiano >>>>>>>>>>>> Dólar");
        System.out.println("7. Dólar >>>>>>>>>>>> Peso Chileno");
        System.out.println("8. Peso Chileno>>>>>>>>>>>> Dólar");
        System.out.println("9. Dólar >>>>>>>>>>>> Quetzal Guatemalteco");
        System.out.println("10. Quetzal Guatemalteco >>>>>>>>>>>> Dólar");
        System.out.println("0. Salir");
        System.out.println("Elija una opción");
    }

    public static void tasa(String origen, String destino, float monto) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/7befc56cf7899857f9cc715d/pair/" + origen+"/"+destino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        String json = response.body();
        Par par = gson.fromJson(json, Par.class);
        float convertir = par.conversion_rate();
        System.out.println("Tasa de Conversión: " + convertir);
        System.out.println(monto +" "+origen +" Equivale a "+convertir * monto + " " +destino);
        System.out.println("...................Presione Enter para continuar...................");
        Scanner leer2 = new Scanner(System.in);
        String espacio = leer2.nextLine();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("*****SISTEMA CONVERSOR DE MONEDAS******");
        System.out.println("Bienvenido al Conversor de Monedas");
        boolean salida = false;
        while (!salida) {
            menu();
            Scanner leer = new Scanner(System.in);
            int opcion = leer.nextInt();
            int monto = 0;
            if (opcion != 0) {
                System.out.println("Monto a Convertir");
                monto = leer.nextInt();
            }
            //Condiciones de selección
            if (opcion == 1) {
                System.out.println("Dólar >>>>>> Peso Argentino");
                tasa("USD","ARS", monto);
            } else if (opcion == 2) {
                System.out.println("Peso Argentino >>>>>> Dólar");
                tasa("ARS","USD", monto);
            } else if (opcion == 3) {
                System.out.println("Dólar >>>>>> Real Brasileño");
                tasa("USD","BRL", monto);
            } else if (opcion == 4) {
                System.out.println("Real Brasileño >>>>>> Dólar");
                tasa("BRL","USD", monto);
            } else if (opcion == 5) {
                System.out.println("Dólar >>>>>> Peso Colombiano");
                tasa("USD","COP", monto);
            } else if (opcion == 6) {
                System.out.println("Peso Colombiano >>>>>> Dólar");
                tasa("COP","USD", monto);
            } else if (opcion == 7) {
                System.out.println("Dólar >>>>>> Peso Chileno");
                tasa("USD","CLP", monto);
            } else if (opcion == 8) {
                System.out.println("Peso Chileno >>>>>> Dólar");
                tasa("CLP","USD", monto);
            } else if (opcion == 9) {
                System.out.println("Dólar >>>>>> Quetzal Guatemalteco");
                tasa("USD","GTQ", monto);
            } else if (opcion == 10) {
                System.out.println("Quetzal Guatemalteco >>>>>> Dólar");
                tasa("GTQ","USD", monto);
            } else if (opcion == 0) {
                salida = true;
                System.out.println("Regresa pronto");
            } else {
                System.out.println("Opción no Valida");
            }
        }
    }
}