package org.example.anotaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Creacion(version = "1.0", date = "03/05/2022")
public class Jugador {

    private String nombre;
    private int puntuacion;
    private Date ultimaFechaJugado;

}
