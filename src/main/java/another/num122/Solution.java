package another.num122;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    private static Map<Integer, Integer> bestBranch = new HashMap<>();

    public int maxProfit(int[] prices) {
        // todo
        return 0;
    }

    private static void getMaxProfit(int buyIndex, int curIndex, int[] prices, int profit) {
        // todo 判断是否在记忆map中
        int sell = 0;

        if (buyIndex != -1) { // 如果持有股票
            // 卖
            sell = prices[curIndex] - prices[buyIndex];
            if (sell > 0) {
                buyIndex = -1;
            }
            if (curIndex + 1 != prices.length && !bestBranch.containsKey(curIndex + 1)) {
                // 卖了以后
                getMaxProfit(-1, curIndex + 1, prices, profit + sell);
                // 不卖
                getMaxProfit(buyIndex, curIndex + 1, prices, profit);
            }

        } else {
            if (curIndex + 1 != prices.length && !bestBranch.containsKey(curIndex + 1)) {
                // 买
                getMaxProfit(curIndex, curIndex + 1, prices, profit);
                // 不买
                getMaxProfit(-1, curIndex + 1, prices, profit);
            }
        }

        if (bestBranch.containsKey(curIndex + 1)) {
            bestBranch.put(buyIndex, profit + sell + bestBranch.get(curIndex + 1));
        } else {
            bestBranch.put(buyIndex, profit + sell);
        }
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        getMaxProfit(-1, 0, prices, 0);
        System.out.println(bestBranch.toString());
    }

}
