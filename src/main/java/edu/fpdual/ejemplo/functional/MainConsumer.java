package edu.fpdual.ejemplo.functional;

import java.util.Scanner;
import java.util.function.Consumer;

public class MainConsumer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Consumer<String> stringConsumer = texto -> {
            if(texto.length()>1){
                texto = texto.substring(0, 1).toUpperCase().concat(texto.substring(1).toLowerCase());
            }else{
                texto = texto.toUpperCase();
            }
            System.out.println(texto);
        };

        stringConsumer = stringConsumer.andThen(texto -> System.out.println(texto.toUpperCase()));

        while(true){

            String resultado = sc.nextLine();

            if("Exit".equals(resultado)){
                System.exit(0);
            }

            stringConsumer.accept(resultado);

        }

    }
}
