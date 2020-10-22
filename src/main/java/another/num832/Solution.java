package another.num832;

import java.util.Stack;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = A;
        int len = A.length;
        Stack<Integer> temp = new Stack<>();
        int i;
        int j;
        for(i = 0; i < len; i++){
            for(j = 0; j < len; j++){
                temp.push(A[i][j]);
            }
            for(j = 0; j < len; j++){
                result[i][j] = temp.pop();
                if(result[i][j] == 0){
                    result[i][j] = 1;
                }else{
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        Solution solution = new Solution();

        int[][] a = {{1,1,0},{1,0,1},{0,0,0}};

        int[][] result = solution.flipAndInvertImage(a);
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


    }
}
