package com.gitt.pat.Practica4Api.Controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record ModeloUsuario(

        @Email(message = "el formato de email no es compatible")
        @NotBlank(message = "El email es obligatorio")
        String email,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String pais,

        @NotBlank(message = "El numero de Telefono es obligatorio")
        String telefono

)

{ }
