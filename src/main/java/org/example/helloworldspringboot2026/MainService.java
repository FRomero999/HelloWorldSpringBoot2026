package org.example.helloworldspringboot2026;

import org.springframework.stereotype.Service;

@Service
class MainService {

    private GameRepository gameRepository;

    public MainService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void saveGame(Game newGame) {
        //Game g = new Game();
        //g.setTitle(newGame.getTitle().trim());
        //g.setPlatform(newGame.getPlatform().trim());
        newGame.setDescription("No hay descripcion");
        newGame.setYear(2026);
        gameRepository.save(newGame);
    }

}
