package edu.fpdual.ejemplo.functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        BiPredicate<String, Integer> stringPredicate = (t, g) -> (t.startsWith("A") || t.toLowerCase().startsWith("a")) && g>0;

        boolean validationReturn = stringPredicate.test("Veronica", 1);

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Alejandro", -1);

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Ismael", 5);

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Natalia", -8);

        System.out.println(validationReturn);

        validationReturn = stringPredicate.test("Antonio", 2);

        System.out.println(validationReturn);


    }
}
