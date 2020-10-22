package another.num200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int numIslands(char[][] grid) {
        int islandNum = 0;
        if (grid == null ||grid.length == 0) {
            return islandNum;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    islandNum++;
                    grid[row][col] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(row * n + col);
                    while (!neighbors.isEmpty()) {
                        //不需要用LinkedList的poll()方法，因为队列不会为空
                        int index = neighbors.remove();
                        int r = index / n;
                        int c = index % n;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            neighbors.add((r - 1) * n + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < m && grid[r + 1][c] == '1') {
                            neighbors.add((r + 1) * n + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            neighbors.add(r * n + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < n && grid[r][c + 1] == '1') {
                            neighbors.add(r * n + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return islandNum;
    }
}
