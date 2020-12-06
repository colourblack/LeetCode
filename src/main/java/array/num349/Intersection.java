package array.num349;

import java.util.*;
/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class Intersection {
    /**
     * 思路
     * 1、区分入参的两数组大小
     * 2、将小数组的值放入Set temp中
     * 3、判断大数组的值是否在小数组中，如果在，则说明该值为所求，即可放入Set result中
     * 4、将Set result转换成数组即可
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] a; // 小数组
        int[] b; // 大数组
        Set<Integer> result = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        } else {
            a = nums1;
            b = nums2;
        }
        for (int i : a) {
            temp.add(i);
        }
        for (int i : b) {
            if (temp.contains(i)) {
                result.add(i);
            }
        }
        int[] res = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            res[index] = iterator.next();
            index++;
        }
        return res;
    }
    // 其实对两个数组采用双指针的方式更加节省空间
}
