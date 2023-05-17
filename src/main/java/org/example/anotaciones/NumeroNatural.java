package org.example.anotaciones;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumeroNatural<E extends Number> {

    private E valor;
}
