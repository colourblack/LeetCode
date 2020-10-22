package dynamic;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int[] array = {4, 1, 1, 9, 1};
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int value = optValue(i, array);
            System.out.println("i: " + i + ", " + "value: " + value);
        }
    }

    private static int optValue(int index, int[] array) {
        if (index == 0) {
            return array[0];
        }
        if (index == 1) {
            return Math.max(array[0], array[1]);
        }
        int valueChoose = 0;
        int valueNotChoose = 0;
        valueChoose = array[index] + optValue(index - 2, array);
        valueNotChoose = optValue(index - 1, array);
        return Math.max(valueChoose, valueNotChoose);
    }

}
