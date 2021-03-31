package array.num80;

import org.junit.jupiter.api.Test;

/**
 * @author Fangjunjin
 * @since 2021/3/31
 */
public class RemoveDuplicates {
    /**
     *
     * 给你一个有序数组nums ，请你原地删除重复出现的元素，使每个元素最多出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 解题思路：
     *      1.使用两个指针：
     *      - 第一个指针负责完成遍历数组的任务  index
     *      - 第二个指针负责指向重写的下标     cursor
     *      2.需要使用一个键值对记录数组中每一个值出现的次数，由于数组是有序的，因此不需要使用map
     *        在这里，只需要使用value - count作为键值对即可。
     */

    public int solution(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // 新数组的指针
        int cursor = 0;
        // 原数组的指针
        int index = 0;

        /* value - count 键值对 */
        int value = Integer.MIN_VALUE;
        int count = 0;
        for (; index < nums.length; index++) {
            if (nums[index] > value || value == Integer.MIN_VALUE) {
                nums[cursor] = nums[index];
                // 重置value
                value = nums[cursor];
                // 重置value出现的次数
                count = 0;
                // 游标右移
                cursor++;
            } else {
                if (count < 1) {
                    nums[cursor] = nums[index];
                    count++;
                    cursor++;
                }
            }
        }
        return cursor;
    }
}
