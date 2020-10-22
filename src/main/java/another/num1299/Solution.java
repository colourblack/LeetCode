package another.num1299;

public class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int rigthMax = arr[len -1];
        arr[len -1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = rigthMax;
            if (rigthMax < temp) {
                rigthMax = temp;
            }
        }
        return arr;
    }
}
