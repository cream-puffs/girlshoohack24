import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    // Possible moves
    private static final String[] moves = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Select game mode:");
        System.out.println("1. Player vs AI");
        System.out.println("2. Player vs Player");
        int gameMode = scanner.nextInt();

        if (gameMode == 1) {
            playAgainstAI(scanner);
        } else if (gameMode == 2) {
            playAgainstPlayer(scanner);
        } else {
            System.out.println("Invalid mode selected.");
        }

        scanner.close();
    }

    // Play against AI
    private static void playAgainstAI(Scanner scanner) {
        Random random = new Random();
        System.out.println("Player vs AI mode selected.");

        while (true) {
            // Player move
            int playerMove = getPlayerMove(scanner);
            if (playerMove == -1) break; // Exit game

            // AI move
            int aiMove = random.nextInt(3);
            System.out.println("AI chose: " + moves[aiMove]);

            // Determine winner
            determineWinner(playerMove, aiMove);

            System.out.println(); // For spacing between rounds
        }
    }

    // Play with another player
    private static void playAgainstPlayer(Scanner scanner) {
        System.out.println("Player vs Player mode selected.");

        while (true) {
            // Player 1 move
            System.out.println("Player 1's turn:");
            int player1Move = getPlayerMove(scanner);
            if (player1Move == -1) break; // Exit game

            // Player 2 move
            System.out.println("Player 2's turn:");
            int player2Move = getPlayerMove(scanner);
            if (player2Move == -1) break; // Exit game

            // Determine winner
            determineWinner(player1Move, player2Move);

            System.out.println(); // For spacing between rounds
        }
    }

    // Get player's move
    private static int getPlayerMove(Scanner scanner) {
        System.out.println("Choose your move: (0: Rock, 1: Paper, 2: Scissors, -1 to Exit)");
        int move = scanner.nextInt();
        if (move == -1) {
            System.out.println("Exiting the game...");
            return -1;
        } else if (move >= 0 && move < 3) {
            System.out.println("You chose: " + moves[move]);
            return move;
        } else {
            System.out.println("Invalid move. Try again.");
            return getPlayerMove(scanner);
        }
    }

    // Determine winner between two moves
    private static void determineWinner(int move1, int move2) {
        if (move1 == move2) {
            System.out.println("It's a tie!");
        } else if ((move1 == 0 && move2 == 2) || // Rock beats Scissors
                (move1 == 1 && move2 == 0) || // Paper beats Rock
                (move1 == 2 && move2 == 1)) { // Scissors beats Paper
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 (or AI) wins!");
        }
    }
}

