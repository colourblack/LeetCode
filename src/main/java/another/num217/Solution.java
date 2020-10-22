package another.num217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums.length == 0) {
            return false;
        }
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }


    public boolean anotherSolution(int[] nums) {
        for (int index = 1; index < nums.length; index++) {
            for (int i = 0; i < index; i++) {
                if (nums[index] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }


}
