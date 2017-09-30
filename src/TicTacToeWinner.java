import java.util.Scanner;

public class TicTacToeWinner {

    public enum PLAYER {
        PLAYER1("X"), PLAYER2("O"), EMPTY("E");

        private String player;

        PLAYER(String s) {
            this.player = s;
        }

        public String getPlayer() {
            return player;
        }

    }

    public static void main(String ...args) {
        System.out.println("Enter the grid size of the Tic-Tac-Toe board");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PLAYER[][] board = new PLAYER[n][n];
        System.out.println("Enter the grid with values X for Player X, O for Player O and E for empty cells separated by whitespace");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String player = scanner.next();
                switch (player) {
                    case "X":
                        board[i][j] = PLAYER.PLAYER1;
                        break;
                    case "O":
                        board[i][j] = PLAYER.PLAYER2;
                        break;
                    case "E":
                        board[i][j] = PLAYER.EMPTY;
                        break;
                    default:
                        System.out.println("Invalid Grid!");
                }


            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j=0; j<n; j++) {
//                System.out.println("board = " + i + " " + j + " " + board[i][j]);
//            }
//        }
        PLAYER winner = checkWinner(board, n);
        if(winner != null) {
            System.out.println("The Winner is " + winner.getPlayer());
        } else {
            System.out.println("This game has no winner");
        }

    }

    public static PLAYER checkWinner(PLAYER[][] board, int n) {
        if(n < 3) {
            return null;
        }
        boolean won;
        for(int i=0; i<n; i++) {
            won = true;
            for (int j=1; j<n; j++) {
                if(board[i][j] != board[i][j-1]) {
                    won = false;
                    break;
                }
            }

            if(won) {
                return board[i][0];
            }
        }

        for(int i=0; i<n; i++) {
            won = true;
            for(int j=1; j<n; j++) {
                if(board[j][i] != board[j-1][i]) {
                    won = false;
                    break;
                }
            }

            if(won) {
                return board[0][i];
            }
        }

        won = true;
        for(int i=1; i<n; i++) {
            if(board[i][i] != board[i-1][i-1]) {
                won = false;
                break;
            }
        }
        if(won) {
            return board[0][0];
        }

        won = true;
        for(int i=1; i<n; i++) {
            if(board[n-i][i-1] != board[n-i-1][i]) {
                won = false;
                break;
            }
        }
        if(won) {
            return board[n-1][0];
        }
        return null;
    }

}
