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

        int i = left;
        int j = right;
        int key = nums[right];

        while (i < j) {
            while (i < j && nums[i] <= key) {
                i++;
            }

            while (i < j && nums[j] >= key) {
                j--;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[right] = nums[i];
        nums[i] = key;

        quickSort(nums, left , i - 1);
        quickSort(nums, i + 1, right);
    }

    @Test
    public void quickSortTest() {
        int[] nums = {4,1,9,3,7,2,5,0,6,8};
        quickSort(nums, 0, nums.length - 1);
        LOGGER.info(Arrays.toString(nums));
    }




}
