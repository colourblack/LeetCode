package dynamic.programming;

/**
 * @author Fangjunjin
 * @since 2021/4/4
 */
public class FibonacciSequence {
    /**
     * 斐波那契数列的数学形式如下：
     *    使用以下递归的求解方式会造成大量的重复运算
     *    如果fib(5) = fib(4) + fib(3)
     *       fib(4) = fib(3) + fib(2)
     *       ...
     *   以上可以看出fib(3) fib(2) fib(1)都进行了重复的运算
     *   那么便可以使用一个dp table作为备忘录进行记录已经计算过的结果
     */
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public int fibDpTable(int n) {
        // 使用一维数组进行记录
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n - 1];
    }

    public int fibBetterTable(int n) {
        //其实斐波那契数列只与前两个值相关，因此只需要记录前两个值即可
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre1 = 1; // i - 2
        int pre2 = 1; // i - 1
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return sum;
    }



}
