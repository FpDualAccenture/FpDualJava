package org.example.anotaciones;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        print(5);
        print("Hola");
        print(58.69);
        print(true);

        System.out.println(sum(5,5));
        System.out.println(sum(5,5.10));

        NumeroNatural<Integer> numeroNaturalInteger = new NumeroNatural<>(5);
        NumeroNatural<Double> numeroNaturalDouble = new NumeroNatural<>(5.5);
        NumeroNatural<Byte> numeroNaturalByte = new NumeroNatural<>(Byte.valueOf("1"));
        NumeroNatural<Byte> numeroNaturalByte2 = new NumeroNatural<>(Byte.valueOf("3"));
        NumeroNatural<Short> numeroNaturalShort = new NumeroNatural<>(Short.valueOf("2"));

        List<NumeroNatural<? extends Number>> listaNumeroNatural = new ArrayList<>();
        listaNumeroNatural.add(numeroNaturalInteger);
        listaNumeroNatural.add(numeroNaturalDouble);
        listaNumeroNatural.add(numeroNaturalByte);
        listaNumeroNatural.add(numeroNaturalByte2);
        listaNumeroNatural.add(numeroNaturalShort);

        listaNumeroNatural.forEach(System.out::println);

    }

    public static <E> void print(E dato){
        System.out.println("===== Generido del tipo: "+ dato.getClass()+" y tiene como valor: "+dato);
    }

    public static <E extends Number, U extends Number> Integer sum(E valor1, U valor2){
        return  getRealValue(valor1).intValue()+getRealValue(valor2).intValue();
    }

    private static <E extends Number> Number getRealValue(E valor){
        if(valor instanceof Double){
            return valor.doubleValue();
        } else if(valor instanceof Integer){
            return valor.intValue();
        }else if(valor instanceof Float){
            return valor.floatValue();
        } else if(valor instanceof Long){
            return valor.longValue();
        } else if(valor instanceof Short){
            return valor.shortValue();
        } else {
            return valor.byteValue();
        }
    }

}
