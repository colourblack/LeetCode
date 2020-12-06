package array.num350;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 可以不考虑输出结果的顺序。
 */
public class Intersect {

    /**
     * 思路：
     * 1、将两个数组进行排序
     * 2、采用双指针的方式，两个数组均从零开始，进行遍历
     *      i  ）两个下标对应的数组的值相等，说明该值符合要求，进行记录
     *      ii ）若两值不相等，又因为数组已经排序完成，则将值小的数组下标进行移动，
     *         而值大的下标保持不变，用于下轮循环判断
     *      iii）若有任意一个下标到达数组末尾，循环结束。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }
        return res;
    }


}
