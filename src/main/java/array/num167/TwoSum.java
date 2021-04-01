package array.num167;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * 给定一个已按照升序排列的整数数组numbers，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers的下标从 1开始计数，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 * @author Fangjunjin
 * @since 2021/4/1
 */
public class TwoSum {

    /**
     * 使用双指针解决问题
     * @param numbers 给定数组numbers
     * @param target  给定的目标数target
     * @return [index1, index2] 数组下标从1开始计数
     */
    public int[] twoPoint(int[]numbers, int target) {
        // 左指针
        int start = 0;
        // 右指针
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                break;
            }
            // 因为数组numbers已经升序排序， 因此只有当numbers[end] < target 才需要考虑求和情况
            if (numbers[end] <= target) {
                if (numbers[start] < target - numbers[end]) {
                    start++;
                } else {
                    end--;
                }
            } else {
                end--;
            }
        }
        return new int[] {start + 1, end + 1};
    }


    /**
     * 使用二分查找解决问题
     * 遍历每个 nums[i]，在剩余数组中查找 target-nums[i] 的值，时间复杂度为 O(n log n)。
     * @param numbers 给定数组numbers
     * @param target  给定的目标数target
     * @return [index1, index2] 数组下标从1开始计数
     */
    public int[]  binarySearch(int[]numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] nums = {5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(binarySearch(nums, target)));

    }

}
