package backtrack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/14/21 9:25 AM
 */
public class Info {
    /*
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */

    List<List<Integer>> result = new LinkedList<>();

    void permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    @Test
    public void permuteTest() {
        int[] nums = {1,2,3,4};
        permute(nums);
        System.out.println(result.toString());
    }

}
