package player;

import java.util.List;
import java.util.Random;

import model.Move;

public class ComputerPlayer {
    private static final double AI_PROBABILITY = 0.8;
    private Random random;

    public ComputerPlayer() {
        this.random = new Random();
    }

    public Move makeMove(List<Move> playerHistory) {
        if (random.nextDouble() < AI_PROBABILITY && !playerHistory.isEmpty()) {
            return makeSmartMove(playerHistory);
        }
        return makeRandomMove();
    }

    private Move makeSmartMove(List<Move> playerHistory) {
        Move lastPlayerMove = playerHistory.get(playerHistory.size() - 1);
        
        if (playerHistory.size() >= 2 && 
            lastPlayerMove == playerHistory.get(playerHistory.size() - 2)) {
            return getWinningMove(lastPlayerMove);
        }
        
        return getWinningMove(lastPlayerMove);
    }

    private Move makeRandomMove() {
        Move[] moves = Move.values();
        return moves[random.nextInt(moves.length)];
    }

    private Move getWinningMove(Move playerMove) {
        switch (playerMove) {
            case ROCK: return Move.PAPER;
            case PAPER: return Move.SCISSORS;
            case SCISSORS: return Move.ROCK;
            default: return makeRandomMove();
        }
    }
} 