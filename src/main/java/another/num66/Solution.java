package another.num66;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        } else {
            Stack<Integer> stack = new Stack<>();
            int temp = 1;
            int i = len - 1;
            for (int digit : digits) {
                stack.push(digit);
            }
            while (temp == 1) {
                temp = stack.pop() + temp;
                if (temp == 10) {
                    temp = 1;
                    digits[i] = 0;
                } else {
                    digits[i] = temp;
                }
                i--;
                if (i == -1) {
                    break;
                }
            }
            if (digits[0] == 0) {
                int[] newResult = new int[len + 1];
                newResult[0] = 1;
                for (i = 1; i < newResult.length; i++) {
                    newResult[i] = 0;
                }
                return newResult;
            } else {
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne(test)));
    }
}
