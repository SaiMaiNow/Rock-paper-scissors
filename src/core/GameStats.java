package core;
import java.util.ArrayList;
import java.util.List;

import model.GameResult;

public class GameStats {
    private List<GameResult> results;

    public GameStats() {
        this.results = new ArrayList<>();
    }

    public void recordResult(GameResult result) {
        results.add(result);
    }

    public long getWinCount() {
        return results.stream().filter(r -> r == GameResult.WIN).count();
    }

    public long getLoseCount() {
        return results.stream().filter(r -> r == GameResult.LOSE).count();
    }
} 