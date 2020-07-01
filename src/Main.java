import java.util.Scanner;

/**
 Instructions
 - Upon completion the program should let two players play Tic Tac Toe
 - You can implement your own methods when you need to, or modify existing ones
 - The isGameWon() method has some bugs, you need to find the bugs and fix them
 - Implement the playing logic in the main function
 - Thinking of edge cases and handling them is a plus
 - executing input.nextLine(); in the main function will read input from the console
 */

public class Main {
    public static void main(String[] args) {
        final Scanner input;
        input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.printBoard();

        while(!game.isGameWon()  || !game.isBoardFull()) {
            final String line = input.nextLine();
            game.markCoordinates(line);
            game.printBoard();
        }

    }

}

class TicTacToe {
    private char board[][] = {{'N', 'N', 'N'}, {'N', 'N', 'N'}, {'N', 'N', 'N'}};
    private char currentPlayer = 'X';

    private boolean turn = true;

    public void printBoard() {
      final  StringBuffer sb = new StringBuffer();
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
             sb.append(" " + board[i][j]);
          }
          sb.append("\n");
      }
      System.out.println(sb);
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'N') {
                  isFull = false;

                }
              }
            }
        return isFull;
    }

    public boolean markCoordinates(String line) {
        // 1-1
        if (null != line || "".equals(line)) {
            String[] coordinates = line.split("-");
            int x = Integer.valueOf(coordinates[0]);
            int y = Integer.valueOf(coordinates[1]);
            if (board[x][y] != 'N') {
                return false;
            }
            if(turn) {
                System.out.println("X's turn");
                board[x][y] = 'X';
                turn =false;
            } else {
                System.out.println("Y's turn");
                board[x][y] = 'O';
                turn =true;
            }
            return true;
        }
        System.out.println("line empty");
        return false;
    }

    public boolean isGameWon() {
        boolean rowsWon, colsWon, diagWon;
        rowsWon = colsWon = diagWon = false;

        for (int i = 0; i < board.length; i++) {
            // check rows
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) rowsWon = true;
            // check cols
            if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) colsWon = true;
        }

        // check diag
        if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) diagWon = true;
        if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) diagWon = true;
        return rowsWon || colsWon || diagWon;
    }

}

