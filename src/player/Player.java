package player;

import java.util.ArrayList;
import java.util.List;

import model.Move;

public class Player {
    private List<Move> moveHistory;
    private static final int HISTORY_SIZE = 5;

    public Player() {
        this.moveHistory = new ArrayList<>();
    }

    public Move makeMove(int choice) {
        Move move = Move.fromChoice(choice);
        if (move != null) {
            recordMove(move);
        }
        return move;
    }

    public void recordMove(Move move) {
        moveHistory.add(move);
        if (moveHistory.size() > HISTORY_SIZE) {
            moveHistory.remove(0);
        }
    }

    public List<Move> getHistory() {
        return new ArrayList<>(moveHistory);
    }
} 