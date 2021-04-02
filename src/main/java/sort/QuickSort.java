package sort;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 快速排序
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 上午9:22
 */
public class QuickSort {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }

        int leftIndex = left;
        int rightIndex = right;
        int key = nums[right];

        while (left < right) {
            while (left < right && nums[left] <= key) {
                left++;
            }

            while (left < right && nums[right] >= key ) {
                right--;
            }

            if (left < right) {
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
        }

        nums[rightIndex] = nums[left];
        nums[left] = key;

        quickSort(nums, leftIndex, left - 1);
        quickSort(nums, left + 1, rightIndex);
    }

    @Test
    public void quickSortTest() {
        int[] nums = {4,1,9,3,7,2,5,0,6,8};
        quickSort(nums, 0, nums.length - 1);
        LOGGER.info(Arrays.toString(nums));
    }




}
