package org.example.anotaciones;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException{

        imprimirDatosAnotaciones();
        imprimitDatosPersona();


    }

    private static void imprimirDatosAnotaciones() {
        Jugador jugador = new Jugador();
        //Para obtener todas las anotaciones de una clase;
//        for(Annotation type : jugador.getClass().getAnnotations()){
//            System.out.println(type.toString());
//        }

        //Buscamos anotacion a nivel de clase
        Annotation annotation = jugador.getClass().getAnnotation(Creacion.class);
        System.out.println(annotation);

        //Buscamos las clases que tengan asociada una anotación x.
        Reflections ref = new Reflections("org.example.anotaciones");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Creacion.class)) {
            Creacion creacion = cl.getAnnotation(Creacion.class);
            System.out.printf("Found class: %s, with meta version: %s%n",
                    cl.getSimpleName(), creacion.version());
        }
    }

    private static void imprimitDatosPersona() throws NoSuchFieldException, NoSuchMethodException {
        Persona p = new Persona("Pablo");
        p.setEdad(18);
        p.setDireccion("Malaga");
        p.imprimir(" - ");
    }

}
