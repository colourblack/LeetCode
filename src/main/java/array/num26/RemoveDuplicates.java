package array.num26;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
@Slf4j(topic = "RemoveDuplicates")
public class RemoveDuplicates {

    /**
     * 使用两个指针，数组已经排序完成，
     * 左指针对应的序列认为符合条件
     * 右指针对应着数组的下表
     * 当右指针到达数组末端时，检查完成
     */
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
