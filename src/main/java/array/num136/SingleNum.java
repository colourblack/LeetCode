package array.num136;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 常见思路： 使用集合Set对数据进行存储
 *  遍历整个数组，若对于nums[i]数组中没有存放，放入集合Set
 *  若nums[i]存在该数组，则删除集合Set中的对应的值
 *  如此最后一定只剩下唯一的数
 *
 * 最佳方案： 利用位运算-->异或运算 // 二进制中，两者相等则为0,不等则为1
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a;
 * 任何数和其自身做异或运算，结果是 0，即 a ^ a = 0;
 * 异或运算满足交换律和结合律;
 *
 */
@Slf4j(topic = "SingleNum")
public class SingleNum {

    public int singleNumber(int[] nums) {

        int single = 0;
        for(int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    @Test
    void test() {
        int[] nums = {4,2,1,2,4};
        log.info(new SingleNum().singleNumber(nums) + "");
    }

}
