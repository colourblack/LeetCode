package array.num118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class YangHuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre;
        int index;
        for (int i = 1; i <= numRows ; i++) {
            result.add(new ArrayList<>(i));
            index = 0;
            while (index < i) {
                if (index == 0 || index == (i - 1) ) {
                    result.get(i - 1).add(1);
                } else {
                    // tips: 使用临时变量存储前一行的地址，避免cpu频繁寻址获取前一行的地址
                    // 临时变量让用时100%而不使用则只有65%！！！
                    pre = result.get(i - 2);
                    result.get(i - 1).add(pre.get(index) + pre.get(index - 1));
                }
                index++;
            }
        }
        return result;
    }
}
