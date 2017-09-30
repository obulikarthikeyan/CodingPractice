package arrays;

/**
 * Given a 2D grid of characters and a word, find all occurrences of given word in grid.
 * A word can be matched in all 8 directions at any point. Word is said be found in a direction if all characters match in this direction (not in zig-zag form).
 * The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.
 *
 * Example:
 * Input:  grid[][] = { "GEEKSFORGEEKS",
 *                      "GEEKSQUIZGEEK",
 *                      "IDEQAPRACTICE"};
 *
 * word = "GEEKS"
 *
 * Output:
 *
 * pattern found at 0, 0
 * pattern found at 0, 8
 * pattern found at 1, 0
 */

public class FindWordInMatrix8Directions {

    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean isWordFound(char[][] m, int row, int col, char[] word) {
        if(m[row][col] != word[0]) {
            return false;
        }

        int len = word.length;
        int rowSize = m.length;
        int columnSize = m[0].length;

        for(int dir = 0; dir < 8; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];
            String path = word[0] + "(" + row + "," + col + ")";

            for(k = 1; k < len; k++) {


                if(rd < 0 || rd >= rowSize || cd < 0 || cd >= columnSize) {
                    break;
                }

                if(m[rd][cd] != word[k]) {
                    break;
                }

                path += ", " + word[k] + "(" + rd + "," + cd + ")";

                rd += x[dir];
                cd += y[dir];
            }

            if(k == len) {
                System.out.println(path);
                return true;
            }
        }
        return false;
    }

    public static void findWord(String word, char[][] m) {
        if(word == null || word.isEmpty()) {
            return;
        }

        int rowSize = m.length;
        int columnSize = m[0].length;
        char[] w = word.toCharArray();

        for(int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++) {
                if(isWordFound(m, i, j, w)) {
                    System.out.println("word found at row = " + i + " col = " + j);
                }
            }
        }
    }

    public static void main(String ...args) {
        char[][] m ={"GEEKSFORGEEKS".toCharArray(), "GEEKSQUIZGEEK".toCharArray(), "IDEQAPRACTICE".toCharArray()};
        String word = "GEEKS";

        findWord(word, m);
    }
}
