package org.example.anotaciones;

import lombok.Data;
import lombok.NonNull;

import java.lang.annotation.Annotation;

@Data
@Creacion(version = "5.0", author = "Mariano")
public class Persona {

    @NonNull
    private String nombre;

    private int edad;

    private Grado nivelObtenido;

    @Creacion(version = "1.0", author = "Mariano", date = "30/04/2022")
    public String direccion;

    @Creacion(version = "0.1", author = "Mariano", date = "01/05/2022")
    public void imprimir(@Creacion(version = "6", author = "Veronica", date = "15/06/2022") final String delimitador)
            throws NoSuchFieldException, NoSuchMethodException {

        //Imprimimos datos del objeto
        System.out.println(nombre + delimitador + edad + delimitador + direccion);

        //Busamos e imprimimos datos de la anotacion del atributo direccion
        Creacion creacion = getClass().getField("direccion").getAnnotation(Creacion.class);
        System.out.println(creacion.author() + delimitador + creacion.date() + delimitador + creacion.version());

        //Buscamos e imprimimos datos de la anotacion del metodo imprimir
        creacion = getClass().getMethod("imprimir", String.class).getAnnotation(Creacion.class);
        System.out.println(creacion.author() + delimitador + creacion.date() + delimitador + creacion.version());

        // * Buscamos las anotaciones de los atributos del metodo imprimir y los imprimimos siempre y cuando sean
        // * anotaciones del tipo creacion
        Annotation[][] annotations = getClass().getMethod("imprimir", String.class).getParameterAnnotations();
        for(Annotation[] annotationArray : annotations){
            for(Annotation annotation : annotationArray){
                if(annotation instanceof Creacion){
                    creacion = (Creacion) annotation;
                    System.out.println(creacion.author() + delimitador + creacion.date() + delimitador + creacion.version());
                }
            }
        }
    }

}
