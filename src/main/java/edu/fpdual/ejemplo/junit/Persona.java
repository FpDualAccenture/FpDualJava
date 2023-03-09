package edu.fpdual.ejemplo.junit;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Persona {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private double edad;
    private List<Hobbies> hobbies;

    public void setNombre(String nombre){
        this.nombre = nombre.length() <= 1 ? nombre.toUpperCase() :
                nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

}
