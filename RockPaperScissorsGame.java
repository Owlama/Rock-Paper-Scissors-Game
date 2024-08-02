import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Game extends JFrame {
    protected int userScore;
    protected int computerScore;

    public Game() {
        userScore = 0;
        computerScore = 0;
    }

    protected void updateScores(int user, int computer) {
        userScore += user;
        computerScore += computer;
    }

    protected void writeResultToFile(String result) {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write(result + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage());
        }
    }

    // Method with polymorphism
    public void displayResult(String result) {
        JOptionPane.showMessageDialog(this, result);
    }

    // Overloaded method with polymorphism
    public void displayResult(String result, String score) {
        JOptionPane.showMessageDialog(this, result + "\nScore: " + score);
    }
}

public class RockPaperScissorsGame extends Game {
    public RockPaperScissorsGame() {
        super();
        setTitle("Rock, Paper, Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        rockButton.addActionListener(e -> playGame("Rock"));
        paperButton.addActionListener(e -> playGame("Paper"));
        scissorsButton.addActionListener(e -> playGame("Scissors"));

        setLayout(new FlowLayout());
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
    }

    private void playGame(String userChoice) {
        try {
            String[] choices = {"Rock", "Paper", "Scissors"};
            String computerChoice = choices[new Random().nextInt(choices.length)];
            String result;

            if (userChoice.equals(computerChoice)) {
                result = "Oh No It's A Tie!";
                updateScores(0, 0);
            } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                    (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                    (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                result = "Awww You Win!";
                updateScores(1, 0);
            } else {
                result = "Haha Computer Wins!";
                updateScores(0, 1);
            }

            // Using polymorphic method
            displayResult("Computer chose " + computerChoice + "\n" + result);

            // Using overloaded polymorphic method
            displayResult("User Score: " + userScore + "\nCompu ter Score: " + computerScore, "Final Score");

            writeResultToFile(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsGame().setVisible(true));
    }
}