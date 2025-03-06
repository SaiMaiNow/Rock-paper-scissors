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

        this.ui.addPropertyChangeListener("playerMove", evt -> {
            Move playerMove = (Move) evt.getNewValue();
            handleGameTurn(playerMove);
        });
    }

    public void start() {
        ui.setGameStats(stats);
        ui.setVisible(true);
    }

    private void handleGameTurn(Move playerMove) {
        Move computerMove = computer.makeMove(player.getHistory());
        player.recordMove(playerMove);
        
        GameResult result = determineWinner(playerMove, computerMove);
        stats.recordResult(result);
        
        ui.displayResult(playerMove, computerMove, result);
    }

    private GameResult determineWinner(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            return GameResult.DRAW;
        }
        return playerMove.beats(computerMove) ? GameResult.WIN : GameResult.LOSE;
    }
} 