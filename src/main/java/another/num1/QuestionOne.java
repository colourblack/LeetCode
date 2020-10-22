package another.num1;


public class QuestionOne {
    public int[] twoSum(int[] nums, int target) {
        // 需要对数组先排序
        int[] result = new int[2];
        int index = 0;
        while (target >= nums[index]) {
            index++;
        }
        for (int i = index - 1; i > 0; i--) {
            int top = 0;
            while (target - nums[i] >= nums[top]) {
                if (i < top) {
                    break;
                }
                if (target - nums[i] == nums[top]) {
                    result[1] = i;
                    result[0] = top;
                    return result;
                }
                top++;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
