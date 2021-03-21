package array.num73;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Fang
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 例如：
 *     0, 1, 2, 0          0, 0, 0, 0
 *     1, 3, 4, 5    ->    0, 3, 4, 0
 *     4, 1, 4, 7          0, 1, 4, 0
 *
 *
 * 提示：
 *     m == matrix.length
 *     n == matrix[0].length
 *     1 <= m, n <= 200
 *     -231 <= matrix[i][j] <= 231 - 1
 *
 */
public class SetZeroesTest {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    if (row[i] != 1) {
                        row[i] = 1;
                    }

                    if (col[j] != 1) {
                        col[j] = 1;
                    }
                }
            }
        }

        setZero(matrix ,row, col);
    }


    public void setZero(int[][] matrix, int[] row, int[] col) {

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < col.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < col.length; j++) {
            if (col[j] == 1) {
                for (int i = 0; i < row.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    @Test
    public void setZeroTest() {
        int[][] matrix = {{1,1,1},{1, 0, 1},{1, 1, 1}};
        SetZeroesTest setZeroesTest = new SetZeroesTest();
        setZeroesTest.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
