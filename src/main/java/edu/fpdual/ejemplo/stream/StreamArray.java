package edu.fpdual.ejemplo.stream;

import edu.fpdual.ejemplo.Persona;
import edu.fpdual.ejemplo.Sexo;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArray {

    public static void main(String[] args) {

        Persona[] personas = new Persona[3];

        personas[0] = Persona.builder().nombre("Alejandro").sexo(Sexo.MASCULINO).edad(20).direccion("Periana").build();
        personas[1] = Persona.builder().nombre("Natalia").sexo(Sexo.FEMENINO).edad(45).direccion("Cártama").build();
        personas[2] = Persona.builder().nombre("Veronica").sexo(Sexo.FEMENINO).edad(18).direccion("Málaga").build();

        Stream.of(personas).filter(persona -> Sexo.FEMENINO.equals(persona.getSexo())).forEach(System.out::println);

//        Predicate<Persona> predicate = per -> Sexo.FEMENINO.equals(per.getSexo());
//        Consumer<Persona> stringConsumer = System.out::println;
//
//        for (Persona persona : personas) {
//            if (predicate.test(persona)) {
//                stringConsumer.accept(persona);
//            }
//        }
    }

}
