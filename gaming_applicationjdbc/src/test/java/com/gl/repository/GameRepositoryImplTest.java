package com.gl.repository;

import com.gl.entity.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryImplTest {

    @Test
    void insertGame() {
        Game game=new Game();
        game.setGame_id(game.getGame_id());
        game.setGame_name(game.getGame_name());
        game.setNo_of_players(game.getNo_of_players());

        Game game1=new Game();
        game1.getGame_id("1");
        game1.getGame_name("pubg");




    }

    @Test
    void updateGame() {
    }

    @Test
    void getAllGame() {
    }

    @Test
    void deleteGame() {
    }
}