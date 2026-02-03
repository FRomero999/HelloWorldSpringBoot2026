package org.example.helloworldspringboot2026;

import org.springframework.hateoas.server.core.AbstractEntityLinks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
class WebController {

    private GameRepository gameRepository;
    private MainService mainService;

    WebController(
            GameRepository gameRepository,
            MainService mainService) {
        this.gameRepository = gameRepository;
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("platforms",gameRepository.getPlatforms());
        /* Edita juego y guarda */
        // model.addAttribute("juego", gameRepository.findAll().get(0));
        /* Crea uno nuevo */
        model.addAttribute("juego", new Game());
        return "index";
    }

    /* Endpoint que recibe los datos del formulario */
    @PostMapping("/")
//    public String crear(Model model, @RequestParam String title, @RequestParam String platform) {
    public String crear(Model model, @ModelAttribute Game newGame) {
        //System.out.println(title);
        //System.out.println(platform);
        System.out.println(newGame);
        mainService.saveGame(newGame);
        return "redirect:/";
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
