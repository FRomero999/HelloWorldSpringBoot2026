package org.example.helloworldspringboot2026;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

class MainController {

    @Autowired
    private GameRepository gameRepository;

    /* end-point */
    @GetMapping("/")
    public List<String> index() {
        return List.of("Hello World Spring Boot 2026","DAM2");
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "Hello World Spring Boot 2026";
    }

    @GetMapping("/saludar/{nombre}/{apellido}")
    public String saludar(@PathVariable String nombre, @PathVariable String apellido) {
        return "Hello " + nombre + " " + apellido;
    }

    @GetMapping("/saludarJson")
    public String saludar2(@RequestBody Persona data) {
        System.out.println(data);
        return data.toString();
    }

    @GetMapping("/test3")
    public Boolean test3(@RequestBody Persona data) {
        if(data.getNombre().isEmpty() || data.getApellido().isEmpty()) {
            return  false;
        } else  {
            return true;
        }
    }

    @GetMapping("/saludar3/{idioma}")
    public String saludar3(@PathVariable String idioma, @RequestParam String nombre) {
        switch(idioma) {
            case "en": return  "Hello "+ nombre;
            case "es": return  "Hola "+ nombre;
            case "gitano": return  "Jelou "+ nombre;
            default: return "hi!";
        }
    }

    @GetMapping("/games")
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public Game findById(@PathVariable int id) {
        return gameRepository.findById(id).get();
    }

    @PostMapping("/games")
    public Game save(@RequestBody Game game) {
        return gameRepository.save(game);
    }



}
