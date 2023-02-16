package com.gl.callable;

import com.gl.entity.Game;
import com.gl.repository.GameRepositoryImpl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class callable {
    public static void main(String[] args) {
        GameRepositoryImpl gameRepository=new GameRepositoryImpl();
        Scanner scanner=new Scanner(System.in);

        try {
            while (true){
                int i=0;
                System.out.println("\nIf you want to perform some" + "\n1-> InsertGame" + "\n 2-> Update"
                        + "\n3->delete" + "\n4-> display" + "\n9->For Exit");
                int number = scanner.nextInt();
                if (number==1)
                {
                    System.out.println("Enter the Game id = ");
                    String game_id = scanner.next();
                    System.out.println("Enter the Game Name = ");
                    String game_name = scanner.next();
                    System.out.println("Enter the Number OF Players = ");
                    String no_of_players = scanner.next();
                    Game game = new Game(game_id, game_name, no_of_players);
                    gameRepository.insertGame(game);
                    System.out.println("Game added successfully");
                }else if(number==2){
                    System.out.println("Enter the Gane Id you want to update = ");
                    String game_id = scanner.next();
                    System.out.println("Enter the Game Name = ");
                    String game_name = scanner.next();
                    System.out.println("Enter the Number OF Players = ");
                    String no_of_players = scanner.next();
                    Game game = new Game(game_id, game_name, no_of_players);
                    gameRepository.updateGame(game.getGame_id(), game);
                    System.out.println("GameUpdated successfully");
                }else if(number==3){
                    System.out.println("Enter the Game Id you want to = ");
                    String gameId = scanner.next();
                    gameRepository.deleteGame(gameId);
                    System.out.println("Deleted successfully");
                }else if (number==4){
                    System.out.println(gameRepository.getAllGame());
                }else {
                    i=9;
                }
                if (i==9){
                    System.out.println("SuccessFully Exited ");
                    break;
                }

            }
        }catch (InputMismatchException | SQLException e){
            System.out.println(e);
        }

    }
}

