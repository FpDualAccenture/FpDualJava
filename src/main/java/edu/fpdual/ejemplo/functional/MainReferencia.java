package edu.fpdual.ejemplo.functional;

import java.util.ArrayList;
import java.util.List;

public class MainReferencia {

    public static void main(String[] args) {
        List<String> localidades = new ArrayList<>();

        localidades.add("Málaga");
        localidades.add("Cártama");
        localidades.add("Periana");

        localidades.forEach(System.out::println);
    }

}
