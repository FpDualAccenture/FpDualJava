package edu.fpdual.ejemplo.functional;

import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Function<Integer, String> booleanFunction = value -> {
            return value%2==0? "Par" : "Impar";
        };

        while(true) {
            int i = sc.nextInt();
            if(i==0){
                System.exit(0);
            }
            System.out.println(booleanFunction.apply(i));
        }

    }

}
