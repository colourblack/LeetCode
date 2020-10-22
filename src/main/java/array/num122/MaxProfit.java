package array.num122;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int maxProfit = 0;
        int i = 1;
        while (i < len) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
            i++;
        }
        return maxProfit;
    }

}
