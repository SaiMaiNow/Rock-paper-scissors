package core;

import model.GameResult;
import model.Move;
import player.ComputerPlayer;
import player.Player;
import ui.GameUI;

public class RockPaperScissorsGame {
    private Player player;
    private ComputerPlayer computer;
    private GameStats stats;
    private GameUI ui;

    public RockPaperScissorsGame() {
        this.player = new Player();
        this.computer = new ComputerPlayer();
        this.stats = new GameStats();
        this.ui = new GameUI();
    }

    public void start() {
        while (true) {
            ui.displayStats(stats);
            ui.displayMenu();
            
            Move playerMove = player.makeMove(ui.getPlayerChoice());
            if (playerMove == null) continue;
            
            Move computerMove = computer.makeMove(player.getHistory());
            
            GameResult result = determineWinner(playerMove, computerMove);
            stats.recordResult(result);
            
            ui.displayResult(playerMove, computerMove, result);
        }
    }

    private GameResult determineWinner(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            return GameResult.DRAW;
        }
        return playerMove.beats(computerMove) ? GameResult.WIN : GameResult.LOSE;
    }
} 