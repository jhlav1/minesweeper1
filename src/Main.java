import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);

            // Create the demo mined field

            System.out.println("******* Minesweeper *******");
            System.out.println("The  available positions in the game");
            System.out.println();
            String[][] board = {{"     ", " 1 ", " 2 ", " 3 "},
                    {"row 1", " 0 ", " 0 ", " 0 "},
                    {"row 2", " 0 ", " 0 ", " 0 "},
                    {"row 3", " 0 ", " 0 ", " 0 "}};

            System.out.println("      columns");

            System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] );

            System.out.println(board[1][0] + "|" + board[1][1] + " " + board[1][2] + " " + board[1][3]);

            System.out.println(board[2][0] + "|" + board[2][1] + " " + board[2][2] + " " + board[2][3]);

            System.out.println(board[3][0] + "|" + board[3][1] + " " + board[3][2] + " " + board[3][3]);


            // End demo mined field

// create a 3 x 3 field with 9 hidden spaces and 5 mines randomised distributed
            int rows = 3;
            int columns = 3;
            int mines = 4;

            System.out.println();
            System.out.println("* ================= *");
            System.out.println("A new field is created, there are 4 MINES ready to explode!");
            System.out.println("the mines are represented by the number 9 while 0 refers to 'hidden' spaces");
            System.out.println();

            // Creates the game
            MinesweeperGame game = new MinesweeperGame(rows, columns, mines); // Creates the game
            System.out.println();
            System.out.println("Let's get started!");

            // Plays the game
            while (true) {
                System.out.println();
                System.out.println("Please select a row (1 to 3): ");
                int inputRow = sc.nextInt() - 1;
                System.out.println("Please select a column (1 to 3): ");
                int inputColumn = sc.nextInt() - 1;

                // User input to select square ==> Row - Column
                int y = game.playerInteract(inputRow, inputColumn);

                // The game continues if the game has not been completed.
                if (y == 0) {
                    System.out.println();
                    System.out.println("Here is the board for reference. Please think carefully you next move.");
                    System.out.println();
                    game.getVisibleBoard();
                }
                // The game is finished if the user input don't hit a mine.
                if (y == 1) {
                    System.out.println();
                    System.out.println("You win! Congratulations");
                    System.out.println();
                    game.getBoard();
                    break;
                }
                // The ame is over if the user input hits a mine
                if (y == 2) {
                    System.out.println();
                    System.out.println("You hit a mine!");
                    System.out.println("Check the field and the placed mines(9)");
                    //System.out.println("");
                    game.getBoard();
                    break;
                }

            }
            System.out.println("Game Over");
            System.out.println("======================");
            System.out.println();

        }

    }
}