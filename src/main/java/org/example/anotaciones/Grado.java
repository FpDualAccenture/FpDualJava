package org.example.anotaciones;

import lombok.Getter;

@Getter
public enum Grado {

	FORMACION_BASICA(2, "Basico"),
	GRADO_MEDIO(2, "Medio"),
	GRADO_SUPERIOR(2, "Superior"),
	BACHILLERATO(2, "Bachiller"),
	UNIVERSITARIO(4),
	MASTER(2),
	DOCTOR("PhD");

	private Integer tiempoEstudio;
	private String titulo;

	private Grado(String titulo) {
		this.titulo = titulo;
	}
	
	private Grado(Integer tiempoEstudio) {
		this.tiempoEstudio = tiempoEstudio;
	}
	
	private Grado(Integer tiempoEstudio, String titulo) {
		this.tiempoEstudio = tiempoEstudio;
		this.titulo = titulo;
	}
	
}
