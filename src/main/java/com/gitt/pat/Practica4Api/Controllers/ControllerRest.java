package com.gitt.pat.Practica4Api.Controllers;





import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController// un record es una nueva característica que proporciona una forma más sencilla de crear clases inmutables que están diseñadas para almacenar datos simples de manera eficiente
public class ControllerRest {
    private final Map<String, ModeloContador> contadores = new HashMap<>();

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    //public ModeloContador crea(@RequestBody ModeloContador contadorNuevo) {
    //    contadores.put(contadorNuevo.nombre(), contadorNuevo);
    //    return contadorNuevo;
    //}
    public ModeloContador crea(@Valid @RequestBody ModeloContador contadorNuevo) {
        contadores.put(contadorNuevo.nombre(), contadorNuevo);
        return contadorNuevo;
    }

    @GetMapping("/api/contadores/{nombre}")
    public ModeloContador contador(@PathVariable String nombre) {
        return contadores.get(nombre);
    }

    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
    public ModeloContador incrementa(@PathVariable String nombre,
                                     @PathVariable Integer incremento) {
        ModeloContador contadorActual = contadores.get(nombre);
        ModeloContador contadorIncrementado =
                new ModeloContador(nombre, contadorActual.valor() + incremento);
        contadores.put(nombre, contadorIncrementado);
        return contadorIncrementado;
    }

    @DeleteMapping("api/contadores/{nombre}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimina(@PathVariable String nombre) {contadores.remove(nombre);}

}

