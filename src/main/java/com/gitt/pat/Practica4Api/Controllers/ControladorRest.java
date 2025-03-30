package com.gitt.pat.Practica4Api.Controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ControladorRest {
    //En este hashmap guardo los usuarios con clave email
    private final Map<String, ModeloUsuario> usuarios= new HashMap<>();

    @PostMapping("/api/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloUsuario registro(@Valid @RequestBody ModeloUsuario modeloUsuario) {
        usuarios.put(modeloUsuario.email(), modeloUsuario);
        return modeloUsuario;
    }

    @GetMapping("/api/registro/{email}")
    public ModeloUsuario buscarPorEmail(@PathVariable String email) {
        return usuarios.get(email);
    }


}
