import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String playerHand;
        String newRound;

        do {
            do {
                System.out.printf("%nChoose between '" + ConsoleColors.YELLOW + "Scissor" + ConsoleColors.RESET + "', '" +
                        ConsoleColors.YELLOW + "Rock" + ConsoleColors.RESET + "' and '" +
                        ConsoleColors.YELLOW + "Paper" + ConsoleColors.RESET + "'.%n");

                playerHand = scanner.nextLine().toLowerCase();
                playerHand = playerHand.substring(0, 1).toUpperCase() + playerHand.substring(1);

            } while ((!playerHand.equals("Scissor")
                    && !playerHand.equals("Rock")
                    && !playerHand.equals("Paper")));

            String enemyHand = enemyTurn();
            String winner = checkWinner(playerHand, enemyHand);

            System.out.printf("%nYou've chosen " + ConsoleColors.YELLOW + "%s " + ConsoleColors.RESET +
                            "and the computer has chosen " + ConsoleColors.YELLOW + "%s" + ConsoleColors.RESET + ".%n"
                    , playerHand, enemyHand);

            switch (winner) {
                case "Player" -> System.out.println("You won!");
                case "Computer" -> System.out.println("The computer won!");
                default -> System.out.println("It's a draw!");
            }

            do {
                System.out.printf("%nDo you want to play another round?%n");
                newRound = scanner.nextLine();

            } while (!newRound.equalsIgnoreCase("no") && !newRound.equalsIgnoreCase("yes"));

        } while (newRound.equalsIgnoreCase("yes"));

    }

    static String enemyTurn() {
        int random = new Random().nextInt(1, 4);
        return switch (random) {
            case 1 -> "Scissor";
            case 2 -> "Rock";
            default -> "Paper";
        };

    }

    static String checkWinner(String playerHand, String enemyHand) {

        if (playerHand.equals(enemyHand)) {
            return "Draw";
        } else if ((playerHand.equals("Rock") && enemyHand.equals("Scissor"))
                || (playerHand.equals("Scissor") && enemyHand.equals("Paper"))
                || (playerHand.equals("Paper") && enemyHand.equals("Rock"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }

}