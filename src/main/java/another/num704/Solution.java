package another.num704;


public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid ;
        while (left <= right) {
            mid = (right + left) / 2 ;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left ++;
            } else {
                right --;
            }
        }
        return -1;
    }

}
