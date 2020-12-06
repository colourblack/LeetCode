package array.num36;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个的3x3宫（一共9个宫格）只能出现一次。
 */
public class Sudoku {

    /**
     * 常规思路，暴力求解
     * 直接判断数字是否满足条件
     */
    public boolean isValidSudoku(char[][] board) {
        final int len = 9;
        char c;
        // 行集合
        ArrayList<Set<Character>> rowSet = new ArrayList<>(len);
        // 列集合
        ArrayList<Set<Character>> colSet = new ArrayList<>(len);
        // 3x3 宫格 集合
        ArrayList<ArrayList<Set<Character>>> coordinate = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            rowSet.add(null);
            colSet.add(null);
        }
        for (int i = 0; i < 3; i++) {
            coordinate.add(new ArrayList<>(3));
            for (int j = 0; j < 3; j++) {
                coordinate.get(i).add(new HashSet<>());
            }
        }
        for (int i = 0; i < len; i++) {
            if (rowSet.get(i) == null) {
                rowSet.set(i, new HashSet<>());
            }
            for (int j = 0; j < len; j++) {
                if (colSet.get(j) == null) {
                    colSet.set(j, new HashSet<>());
                }
                int m = i / 3;
                int n = j / 3;
                c = board[i][j];
                if (board[i][j] != '.' ) {
                    if (rowSet.get(i).contains(c)) {
                        return false;
                    }
                    rowSet.get(i).add(c);
                    if (colSet.get(j).contains(c)) {
                        return false;
                    }
                    colSet.get(j).add(c);
                    if (coordinate.get(m).get(n).contains(c)){
                        return false;
                    }
                    coordinate.get(m).get(n).add(c);
                }
            }
        }
        return true;
    }


    /**
     * 通过三个int数组来确认该值是否出现
     * tips：对任何char数字，可以与'0'相减获取对应的整型
     * 例如 int i = '7' - '0' ==> > i = 7
     * 唯一难点在于：如何用一个一维数组与9个3x3宫格一一对应(row (1~8), col(1~8))
     * 公式：boxed_index = (row / 3) * 3 + col / 3
     */
    public boolean isValidSudokuPlus(char[][] board) {
        final int len = 9;
        int val;
        int boxedIndex;
        int[][] rows = new int[len][len];
        int[][] cols = new int[len][len];
        int[][] boxed = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boxedIndex = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    // 字符类型的数字可以通过与零字符相减的到对应的整型
                    // 因为九宫格的数字范围是1-9，所以val - 1确保不会ArrayIndexOutOfBoundException
                    val = board[i][j] - '0' - 1;
                    rows[i][val]++;
                    cols[j][val]++;
                    boxed[boxedIndex][val]++;
                    if (rows[i][val] > 1 || cols[j][val] > 1 || boxed[boxedIndex][val] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
