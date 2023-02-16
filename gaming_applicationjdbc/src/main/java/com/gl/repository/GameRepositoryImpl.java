package com.gl.repository;

import com.gl.DBConnection.DBConnection;
import com.gl.entity.Game;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRepositoryImpl implements GameRepository{
    @Override
    public void insertGame(Game game) throws SQLException {
        Connection connection= DBConnection.getConnection();
        CallableStatement statement=null;
        try {
            statement=(CallableStatement) connection.prepareCall("{CALL add_Game(?,?,?)}");
            statement.setString(1,game.getGame_id());
            statement.setString(2,game.getGame_name());
            statement.setString(3,game.getNo_of_players());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }

    @Override
    public void updateGame(String gameId, Game game) throws SQLException {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        try {
            statement=(CallableStatement) connection.prepareCall("{CALL new_update_game(?,?,?)}");
            System.out.println(gameId);
            statement.setString(1,game.getGame_id());
            statement.setString(2,game.getGame_name());
            statement.setString(3,game.getNo_of_players());
            statement.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();
        }
    }

    @Override
    public List<Game> getAllGame() throws SQLException {
        Connection connection=DBConnection.getConnection();
        List<Game> list=new ArrayList<>();
        CallableStatement statement=(CallableStatement)  connection.prepareCall("{CALL get_all_games ()}");
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            Game game=new Game();
            game.setGame_id(resultSet.getString("game_id"));
            game.setGame_name(resultSet.getString("game_name"));
            game.setNo_of_players(resultSet.getString("no_of_players"));
            list.add(game);
        }
        return list;
    }

    @Override
    public void deleteGame(String gameId) throws SQLException {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        try {
            statement=(CallableStatement) connection.prepareCall("{CALL delete_game(?)}");
            statement.setString(1,gameId);
            statement.executeUpdate();
        }finally {
            connection.close();
        }
    }
}
