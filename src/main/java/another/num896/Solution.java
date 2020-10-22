package another.num896;

/**
 * @author FANG
 */
public class Solution {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len == 0) {
            //当A = {}时
            return false;
        }

        if (len == 1) {
            return true;
        }

        if (A[0] <= A[len - 1]) {
            return increase(A);
        } else {
            return decrease(A);
        }
    }

    public boolean increase(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1]) {
                return false;
            }
        }
        return true;
    }

    public boolean decrease(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                return false;
            }
        }
        return true;
    }
}
