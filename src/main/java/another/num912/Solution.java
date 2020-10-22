package another.num912;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result = mergeSort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            list.add(result[i]);
        }
        return list;
    }

    public int[] mergeSort(int[] array){
        if(array.length < 2){
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length){
                result[index] = right[j++];
            }
            else if (j >= right.length){
                result[index] = left[i++];
            }
            else if (left[i] > right[j]){
                result[index] = right[j++];
            }
            else{
                result[index] = left[i++];
            }
        }
        return result;
    }




    /**
     * 超出时间限制
     * @param nums
     * @return
     */
    public List<Integer> sortArrayFalse(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int temp;
        int i;
        int j;
        for(i = 0; i < len - 1; i++){
            for(j = i + 1; j < len; j++){
                if(nums[i] >= nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            list.add(nums[i]);
        }
        list.add(nums[i]);
        return list;
    }
}
