package array.num27;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
@Slf4j(topic = "RemoveDuplicates")
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int index = Integer.MIN_VALUE;
        int len = nums.length;
        while (i < len) {
            if (nums[i] > index) {
                index = nums[i];
                nums[j] = index;
                j++;
            }
            i++;
        }
        return j;
    }

    @Test
    public void test() {
        int[] arrays = {0, 0, 1, 2, 3, 4, 4};
        int len = removeDuplicates(arrays);
        for (int i = 0; i < len; i++) {
            log.info("result: {}", arrays[i]);
        }
    }

}
