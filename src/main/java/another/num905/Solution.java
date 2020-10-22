package another.num905;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((A[i]&1) == 1) {
                odd.add(A[i]);
            } else {
                even.add(A[i]);
            }
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < even.size()) {
                result[i] = even.get(i);
            } else {
                result[i] = odd.get(i - even.size());
            }
        }
        return result;
    }
}
