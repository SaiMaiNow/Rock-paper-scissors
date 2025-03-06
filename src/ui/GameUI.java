package ui;

import javax.swing.*;
import java.awt.*;
import model.Move;
import model.GameResult;
import core.GameStats;

public class GameUI extends JFrame {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel, statsLabel;
    private JPanel buttonPanel, infoPanel;
    private GameStats stats;

    public GameUI() {
        this.stats = new GameStats();
        setupUI();
    }

    private void setupUI() {
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));

        buttonPanel = new JPanel(new FlowLayout());
        infoPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        rockButton = createGameButton("Rock", "✊");
        paperButton = createGameButton("Paper", "✋");
        scissorsButton = createGameButton("Scissors", "✌️");

        resultLabel = new JLabel("Choose your move", SwingConstants.CENTER);
        statsLabel = new JLabel("Wins: 0 Losses: 0", SwingConstants.CENTER);
        
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        
        infoPanel.add(statsLabel);
        infoPanel.add(resultLabel);

        add(buttonPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private JButton createGameButton(String name, String emoji) {
        JButton button = new JButton(emoji);
        button.setFont(new Font("Dialog", Font.PLAIN, 24));
        button.setPreferredSize(new Dimension(80, 80));
        button.setActionCommand(name.toUpperCase());
        button.addActionListener(e -> handleMove(Move.valueOf(e.getActionCommand())));
        return button;
    }

    public void handleMove(Move playerMove) {
        firePropertyChange("playerMove", null, playerMove);
    }

    public void displayResult(Move playerMove, Move computerMove, GameResult result) {
        String resultText = String.format("You: %s vs CPU: %s - %s",
            getEmoji(playerMove), getEmoji(computerMove), getResultMessage(result));
        resultLabel.setText(resultText);
        updateStats();
    }

    private String getEmoji(Move move) {
        switch (move) {
            case ROCK: return "✊";
            case PAPER: return "✋";
            case SCISSORS: return "✌️";
            default: return "";
        }
    }

    private String getResultMessage(GameResult result) {
        switch (result) {
            case WIN: return "You Win! 🎉";
            case LOSE: return "You Lose 😢";
            case DRAW: return "Draw 🤝";
            default: return "";
        }
    }

    public void updateStats() {
        statsLabel.setText(String.format("Wins: %d Losses: %d", 
            stats.getWinCount(), stats.getLoseCount()));
    }

    public void setGameStats(GameStats stats) {
        this.stats = stats;
        updateStats();
    }
} 