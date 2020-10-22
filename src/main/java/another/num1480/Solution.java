package another.num1480;

public class Solution {

    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1;i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }

    public int[] anotherSolution(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

}
