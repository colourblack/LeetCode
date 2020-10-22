package another.num989;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 在java中，整型int的最大值是 2 的 31 次方 - 1 = 2147483648 - 1 = 2147483647
     * 当数组的值为[9,9,9,9,9,9,9,9,9,9]时，将会越界。
     * 所以该解法只适合在int类型最大值以内的数值
     * @param A
     * @param K
     * @return
     */
    public static List<Integer> addToArrayForm1(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int ten = 1;
        int a = 0;
        int sum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            a = a + A[i] * ten;
            ten = ten * 10;
        }
        sum = a + K;
        while (sum > 0) {
            res.add(sum % 10);
            sum = sum / 10;
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }
        return result;
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> listForK = new ArrayList<>();
        int temp = K;
        while (temp > 0){
            listForK.add(temp % 10);
            temp = temp /10;
        }
        int i = A.length - 1;
        int j = 0;
        int index = 0;
        while (i >= 0 || j < listForK.size()) {
            int n1 = i >= 0 ? A[i] : 0;
            int n2 = j < listForK.size() ? listForK.get(j) : 0;
            int sum = n1 + n2 + index;
            res.add(sum % 10);
            index = sum / 10;
            i--;
            j++;
        }
        if (index == 1) {
            res.add(index);
        }
        for (int m = res.size() - 1; m >= 0; m--) {
            result.add(res.get(m));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {2,1,5};
        int k = 806;
        List<Integer> result = addToArrayForm(A, k);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
