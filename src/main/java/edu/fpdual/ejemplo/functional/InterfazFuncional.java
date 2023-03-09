package edu.fpdual.ejemplo.functional;

@FunctionalInterface
public interface InterfazFuncional<T, R> {

    R operar(T t);

}
