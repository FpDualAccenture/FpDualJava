package edu.fpdual.ejemplo.functional;

public class MainMyFunctional {

    public static void main(String[] args) {

        Integer denominator = 2;

        InterfazFuncional<Integer, Double> operacion = value -> (double) (value / denominator);

        System.out.println(operacion.operar(4));
        System.out.println(operacion.operar(1452));

    }
}
