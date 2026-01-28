package org.example.helloworldspringboot2026;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class WebController {

    GameRepository gameRepository;
    public WebController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("games", gameRepository.findAll());
        System.out.println( gameRepository.getPlatforms() );
        return "index";
    }

    @GetMapping("/{nombre}")
    public String saludar(@PathVariable String nombre, Model model)
    {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", "anonimo");
        return "saludo";
    }

    @GetMapping("/juego/{id}")
    public String juego(@PathVariable Integer id, Model model)
    {
        if(gameRepository.findById(id).isPresent()) {
            model.addAttribute("game", gameRepository.findById(id).get());
            return "game";
        } else {
            model.addAttribute("error","No existe el juego "+id);
            return "error";
        }
    }


}
