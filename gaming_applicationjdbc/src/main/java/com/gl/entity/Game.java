package com.gl.entity;



public class Game {

    private String game_id;
    private String game_name;
    private String no_of_players;

    public Game() {
    }

    public Game(String game_id, String game_name, String no_of_players) {
        this.game_id = game_id;
        this.game_name = game_name;
        this.no_of_players = no_of_players;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getNo_of_players() {
        return no_of_players;
    }

    public void setNo_of_players(String no_of_players) {
        this.no_of_players = no_of_players;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id='" + game_id + '\'' +
                ", game_name='" + game_name + '\'' +
                ", no_of_players='" + no_of_players + '\'' +
                '}';
    }
}

