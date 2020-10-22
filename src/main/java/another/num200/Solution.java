package another.num200;

public class Solution {

    private void dps(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return ;
        }

        grid[r][c] = '0';
        dps(grid, r - 1, c);
        dps(grid, r, c -1);
        dps(grid, r + 1, c);
        dps(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        int islandNum = 0;

        if (grid == null || grid.length == 0) {
            return islandNum;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    islandNum++;
                    dps(grid, r, c);
                }
            }
        }
        return islandNum;
    }
}
