package com.gitt.pat.Practica4Api.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorSSR {
    // Ruta para la página de precios
    @GetMapping("/precios.html")
    public String precios(Model model) {
        return "precios";  // nombre del archivo HTML
    }

    // Ruta para la página de contacto
    @GetMapping("/contacto.html")
    public String contacto(Model model) {
        return "contacto";  // nombre del archivo HTML
    }
    @GetMapping("/index.html")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/video.html")
    public String video(Model model) {
        return "video";
    }




}