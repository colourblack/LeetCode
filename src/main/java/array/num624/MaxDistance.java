package array.num624;

import java.util.List;

/**
 * @author Fangjunjin
 * @since 4/5/21
 */
public class MaxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;

        int max;
        int min;
        int index= 0;
        for (List<Integer> l : arrays) {
            int childIndex = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (List<Integer> list : arrays) {
                if (childIndex == index) {
                    childIndex++;
                    continue;
                }
                int size = list.size();
                if (min >= list.get(0)) {
                    min = list.get(0);
                }

                if (max <= list.get(size - 1)) {
                    max = list.get(size - 1);
                }
                childIndex++;
            }
            result = Math.max(result, Math.abs(max - min));
            index ++;
        }
        return result;
    }
    

}
