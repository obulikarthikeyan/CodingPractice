package leetcode;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * 1111
 * 1101
 * 1100
 * 0000
 *
 * Answer: 1
 *
 * Example 2
 * 1100
 * 1100
 * 0010
 * 0001
 *
 * Answer: 3
 */

public class NumerOfIslandsInMatrix {

    public static int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0) {
            return count;
        }

        int n = grid.length;
        int m = grid[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid,i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    public static void main(String ...args) {
        char[][] grid = {{'1', '1', '1', '1'}, {'1', '1', '0', '1'}, {'1', '1', '0', '0'}, {'0', '0', '0', '0'}};
        System.out.println("Output: " + numIslands(grid));
    }
}
