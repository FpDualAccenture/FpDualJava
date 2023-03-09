package edu.fpdual.ejemplo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Persona implements Comparable<Persona>{

    private String nombre;
    private int edad;
    private String direccion;
    private Sexo sexo;
    private List<Hobbies> hobbies;

    @Override
    public int compareTo(Persona o) {
        return 0;
    }
}
