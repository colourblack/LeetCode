package array.num56;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Fangjunjin
 * @since 4/4/21
 */
@Slf4j
public class MergeArray {

    public int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        log.info("Num 56 intervals: {}", Arrays.deepToString(merge(intervals)));
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int j = intervals.length - 1; j >= 0; j--) {
            if (intervals[j][1] >= stack.peek()) {
                stack.pop();
            } else {
                stack.push(intervals[j][1]);
            }

            stack.push(intervals[j][0]);
        }

        int size = (stack.size() - 1) / 2;
        int[][] result = new int[size][2];
        int i = 0;
        while (i < size) {
            result[i][0] = stack.pop();
            result[i][1] = stack.pop();
            i ++;
        }
        return result;
    }



    public void quickSort (int[][] intervals, int left , int right) {
        if (left >= right) {
            return ;
        }

        int i = 0;
        int j = right;
        int[] key = intervals[right];

        while (i < j) {
            while (i < j && intervals[i][0] <= key[0]) {
                i++;
            }

            while (i < j && intervals[j][0] >= key[0]) {
                j--;
            }

            if (i < j) {
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }

        intervals[right] = intervals[i];
        intervals[i] = key;

        quickSort(intervals, left, i - 1);
        quickSort(intervals, i + 1, right);
    }

    @Test
    public void test() {
        int[][] intervals = {{1,3},{2, 6}, {8, 10},{15, 18}};
        log.info("Num 56 result: {}", Arrays.deepToString(merge(intervals)));

    }

}
