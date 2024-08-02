Game Initialization

1. Initialize user score and computer score to 0.

Gameplay

1. User selects a choice (Rock, Paper, or Scissors) by clicking a button.
2. Computer generates a random choice (Rock, Paper, or Scissors).
3. Determine the winner based on the game's rules:
    - If user and computer choices are the same, it's a tie.
    - If user choice beats computer choice (Rock beats Scissors, Paper beats Rock, Scissors beats Paper), user wins.
    - Otherwise, computer wins.
4. Update scores accordingly:
    - If user wins, increment user score by 1.
    - If computer wins, increment computer score by 1.
    - If it's a tie, no score updates.
5. Display the result using polymorphic methods:
    - Display the computer's choice and the result (tie, user win, or computer win).
    - Display the final score using an overloaded polymorphic method.
6. Write the result to a file named "results.txt".

Error Handling

1. Catch any exceptions that occur during gameplay or file writing.
2. Display an error message using JOptionPane.

Main Method

1. Create a new instance of the RockPaperScissorsGame class.
2. Make the game window visible using SwingUtilities.invokeLater.
