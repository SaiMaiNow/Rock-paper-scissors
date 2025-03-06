package ui;
import java.util.Scanner;

import model.GameResult;
import model.Move;
import core.GameStats;

public class GameUI {
    private Scanner scanner;

    public GameUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("[1] Rock");
        System.out.println("[2] Paper");
        System.out.println("[3] Scissors");
    }

    public int getPlayerChoice() {
        int choice = scanner.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice");
            return -1;
        }
        return choice;
    }

    public void displayStats(GameStats stats) {
        System.out.println("Your win count: " + stats.getWinCount() + " wins");
        System.out.println("Your lose count: " + stats.getLoseCount() + " loses");
    }

    public void displayResult(Move playerMove, Move computerMove, GameResult result) {
        System.out.println("Your choice: " + playerMove);
        System.out.println("Computer choice: " + computerMove);
        System.out.println("Result: " + getResultMessage(result));
    }

    private String getResultMessage(GameResult result) {
        switch (result) {
            case WIN: return "You win!";
            case LOSE: return "You lose!";
            case DRAW: return "Draw!";
            default: return "";
        }
    }
} 