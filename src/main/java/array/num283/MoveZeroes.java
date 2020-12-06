package array.num283;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明：
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 */
public class MoveZeroes {

    /**
     * 根据题意，只需数组按顺序存放非零数字
     * 当所有非零数字存放完毕以后只需要补充 0 即可
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (;index < nums.length;index++) {
            nums[index] = 0;
        }
    }


    /**
     * 第二种解法（较为通用的解法）
     * 将数组看成两个序列，其中左序列为排序完成，右序列为还未处理
     * 对应left，right两个指针
     * left指针左边均为非零数。
     * right指针左边直到左指针处均为零。
     */
    public void moveZeroesNext(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
