package array.num189;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class MoveRight {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            k = k % len;
        }
        if (len < 1) {

        } else {
            for (int j = 0; j < k; j++) {
                int lastIndex = nums[len - 1];
                int temp;
                int nextValue = nums[0];
                for (int i = 1; i < len; i++) {
                    temp = nums[i];
                    nums[i] = nextValue;
                    nextValue = temp;
                }
                nums[0] = lastIndex;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
