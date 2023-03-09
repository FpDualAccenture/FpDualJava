package edu.fpdual.ejemplo.functional;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainSupplier {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Supplier<String> stringSupplier = () -> {
            String texto = sc.nextLine();

            if(texto.length()>1){
                texto = texto.substring(0, 1).toUpperCase().concat(texto.substring(1).toLowerCase());
                texto = texto.substring(0, texto.length()-1).concat(texto.substring(texto.length()-1).toUpperCase());
            }else{
                texto = texto.toUpperCase();
            }

            return texto;
        };

        while(true){

            String resultado = stringSupplier.get();

            if("Exit".equals(resultado)){
                System.exit(0);
            }

            System.out.println(resultado);

        }

    }
}
