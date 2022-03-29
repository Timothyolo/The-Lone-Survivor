package Java;

import Java.GameFiles.GameEngine;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        GameEngine game = new GameEngine();

        //Loop to run game
        while(true) {
            System.out.println("Welcome to Lone Survivor, a text-based adventure game! ");
            System.out.println("Are you ready to play? (Y/N)"); //main - if Y, starting game, if N, re-loops to beginning
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("Y")) {
                game.startGame();
            }
            else if (line.equalsIgnoreCase("N")) {
                break;
            }
            else{
                System.out.println("Invalid Input!");
            }
        }


    }
}
