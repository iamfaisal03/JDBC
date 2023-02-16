package com.gl.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gl.DBConnection.DBConnection;
import com.gl.callable.callable;
import com.gl.entity.Game;

class RepositoryTes {

	@Test
	public void insertGame() throws SQLException {
		Game game=new Game();

		GameRepositoryImpl gameRepositoryImpl=new GameRepositoryImpl();
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
}
