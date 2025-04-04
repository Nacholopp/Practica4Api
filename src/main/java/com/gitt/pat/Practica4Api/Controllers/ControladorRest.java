package com.gitt.pat.Practica4Api.Controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @DeleteMapping("/api/registro/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimina(@PathVariable String email) {usuarios.remove(email);}

    @PutMapping("/api/registro/{email}")
    public ModeloUsuario actualizarNombreUsuario(@PathVariable String email,
                                                 @RequestBody ModeloUsuario usuarioNuevo) {

        ModeloUsuario usuarioActual = usuarios.get(email);
        if (usuarioActual == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        // Creamos un nuevo objeto ModeloUsuario con el nombre actualizado
        ModeloUsuario usuarioActualizado = new ModeloUsuario(
                usuarioActual.email(),
                usuarioNuevo.nombre(),
                usuarioActual.pais(),
                usuarioActual.telefono()
        );


        usuarios.put(email, usuarioActualizado);


        return usuarioActualizado;
    }




}
