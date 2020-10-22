package another.num48;
/*
    1,  2,  3,  4
    5,  6,  7,  8
    9, 10, 11, 12
    13, 14, 15 ,16

    swap 1 ： 1 和 4 交换  （原来1的位置现在变成了4， 4的位置为1）
    swap 2 ： 4 和 16 交换  （原来1的位置现在变成了16， 16的位置为4）
    swap 3 ： 16 和 13 交换  （原来1的位置现在变成了13， 13的位置为16）

 */
public class Solution {
    public static void rotate(int[][] matrix) {
        int len = matrix[0].length - 1;
        if (len < 1) {
            return ;
        }
        int temp = 0;
        for (int i = 0 ; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len - i - i; j++) {
                // swap 1
                temp = matrix[i + j][len - i];
                matrix[i + j][len - i] = matrix[i][i + j];
                matrix[i][i + j] = temp;
                // swap 2
                temp = matrix[len - i][len - i - j];
                matrix[len - i][len - i - j] = matrix[i][i + j];
                matrix[i][i + j] = temp;
                // swap 3
                temp = matrix[len - i - j][i];
                matrix[len - i - j][i] = matrix[i][i + j];
                matrix[i][i + j] = temp;
            }
        }
        for(int x = 0 ;x < len + 1; x++) {
            for(int y = 0; y < len + 1; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{1,2,3,},{4,5,6,},{7,8,9}};
        int len = matrix[0].length;
        for(int x = 0 ;x < len ; x++) {
            for(int y = 0; y < len ; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
        rotate(matrix);
    }
}
