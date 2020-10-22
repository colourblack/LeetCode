package another.num70;

/**
 * @author FANG
 * 仔细观察本题，会发现其结果是斐波那契数列
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
