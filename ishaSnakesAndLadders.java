import java.util.Scanner;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the names of the two players:");
        String playerA = sc.next();
        String playerB = sc.next();
        int playerAPosition = 0;
        int playerBPosition = 0;
        int count = 0;

        while (playerAPosition < 30 && playerBPosition < 30) {
            int diceRoll = rollDice();
            System.out.println();

            // Player A's turn
            System.out.println(playerA + "'s turn:");
            playerAPosition = movePlayer(playerAPosition, diceRoll, playerA);
            System.out.println(playerA + " reaches cell " + playerAPosition);

            // Check if player A has won
            if (playerAPosition >= 30) {
                break;
            }

            // Player B's turn
            System.out.println(playerB + "'s turn:");
            diceRoll = rollDice();
            playerBPosition = movePlayer(playerBPosition, diceRoll, playerB);
            System.out.println(playerB + " reaches cell " + playerBPosition);

            count++;
        }

        System.out.println();
        System.out.println("Total number of dice throws made by each player is: " + count);

        if (playerAPosition >= 30 && playerBPosition >= 30) {
            System.out.println("It's a tie....");
        } else if (playerAPosition >= 30) {
            System.out.println(playerA + " is the winner...");
        } else {
            System.out.println(playerB + " is the winner...");
        }
    }

    private static int rollDice() {
        return 1 + (int) (Math.random() * (6 - 1 + 1));
    }

    private static int movePlayer(int currentPosition, int diceRoll, String playerName) {
        int newPosition = currentPosition + diceRoll;

        if (newPosition > 30) {
            newPosition = 30;
        }

        // Check for ladders
        switch (newPosition) {
            case 3:
                System.out.println(playerName + " reaches the base of a ladder ");
                newPosition = 22;
                System.out.println(playerName + " climbs up to position 22");
                break;
            case 5:
                System.out.println(playerName + " reaches the base of a ladder ");
                newPosition = 8;
                System.out.println(playerName + " climbs up to position 8");
                break;
            case 11:
                System.out.println(playerName + " reaches the base of a ladder ");
                newPosition = 26;
                System.out.println(playerName + " climbs up to position 26");
                break;
            case 20:
                System.out.println(playerName + " reaches the base of a ladder ");
                newPosition = 29;
                System.out.println(playerName + " climbs up to position 29");
                break;
            // Check for snakes
            case 17:
                System.out.println(playerName + " reaches the mouth of a snake ");
                newPosition = 4;
                System.out.println(playerName + " goes down to 4");
                break;
            case 19:
                System.out.println(playerName + " reaches the mouth of a snake ");
                newPosition = 7;
                System.out.println(playerName + " goes down to 7");
                break;
            case 21:
                System.out.println(playerName + " reaches the mouth of a snake ");
                newPosition = 9;
                System.out.println(playerName + " goes down to 9");
                break;
            case 27:
                System.out.println(playerName + " reaches the mouth of a snake ");
                newPosition = 1;
                System.out.println(playerName + " goes down to 1");
                break;
            default:
                break;
        }

        return newPosition;
    }
}