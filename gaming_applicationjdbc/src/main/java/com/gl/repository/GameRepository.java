package com.gl.repository;

import com.gl.entity.Game;

import java.sql.SQLException;
import java.util.List;

public interface GameRepository {

    public void insertGame(Game game) throws SQLException;

    public void updateGame(String gameId,Game game) throws SQLException;

    public List<Game> getAllGame() throws SQLException;

    public void deleteGame(String gameId) throws SQLException;

}
