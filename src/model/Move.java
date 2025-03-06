package model;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public boolean beats(Move other) {
        return (this == ROCK && other == SCISSORS) ||
               (this == PAPER && other == ROCK) ||
               (this == SCISSORS && other == PAPER);
    }

    public static Move fromChoice(int choice) {
        switch (choice) {
            case 1: return ROCK;
            case 2: return PAPER;
            case 3: return SCISSORS;
            default: return null;
        }
    }
} 