package edu.ejemplo.javaweb.servlet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jose.m.prieto.villar
 *
 * Estructura de usuario del aplicativo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Contraseña del usuario
     */
    private String password;

}