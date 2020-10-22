package another.num189;

public class Solution {

    public int[] rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int curIndex;
        int startIndex;
        int lastNum;
        int temp;
        int count = 0;
        for (int i = 0; count < len; i++) {
            startIndex = i;
            curIndex = startIndex;
            lastNum = nums[startIndex];
            while (true) {
                curIndex = curIndex + k;
                if (curIndex >= len) {
                    curIndex = curIndex - len;
                }
                temp = nums[curIndex];
                nums[curIndex] = lastNum;
                lastNum = temp;
                count++;
                if (curIndex == startIndex) {
                    break;
                }
            }
        }
        return nums;
    }

    public void result1(int[] nums, int k) {
        int len = nums.length;
        int pre;
        int temp;
        for (int i = 0; i < k; i++) {
            pre = nums[len - 1];
            for (int j = 0; j < len; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

}
