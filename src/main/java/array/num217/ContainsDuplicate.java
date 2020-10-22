package array.num217;

import java.util.Arrays;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        Arrays.sort(nums);
        int index = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == index) {
                return true;
            }
            index = nums[i];
        }
        return false;
    }

}
