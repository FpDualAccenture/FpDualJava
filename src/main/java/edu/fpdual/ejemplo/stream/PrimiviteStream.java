package edu.fpdual.ejemplo.stream;

import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimiviteStream {

    public static void main(String[] args) {

        int[] integers = new int[3];

        integers[0] = 20;
        integers[1] = 18;
        integers[2] = 45;

        System.out.println(IntStream.of(integers).count());

        System.out.println("-----------------------------------------------");

        IntStream.of(integers).filter(integer -> integer <= 30).sorted().forEach(System.out::println);
        System.out.println(IntStream.of(integers).anyMatch(integer -> integer <= 30));

        System.out.println("-----------------------------------------------");

        Function<Integer, Integer> function = data -> {return (data*-1);};

        IntStream.range(0, 12).map(function::apply).sorted().map(function::apply).forEach(System.out::println);

    }

}
