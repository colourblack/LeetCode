package another.num279;

import java.util.*;

public class Solution {

    private List<Integer> result = new ArrayList<>();
    private int minSize = 1000;
    private boolean isSuccess = false;

    public int numSquares(int n) {
        // todo
        int index = 0;
        int maxNum = 0;
        while (true) {
            if (index * index < n) {
                index = index + 1;
            } else {
                break;
            }
        }
        if (index == 0) {
            return 0;
        } else {
            maxNum = index - 1;
        }
        System.out.println(index);
        findMin(n, maxNum, maxNum);
        if (isSuccess) {
            return minSize;
        } else {
            return 0;
        }
    }

    private void findMin(int n, int x, int maxNum) {
        if (x < 0 || maxNum < 0) {
            return;
        }
        if (!isSuccess) {
            // 进行递归
            int temp = n - (x * x);
            if (temp == (x * x)) {
                result.add(x);
                result.add(x);
                isSuccess = true;
                if (minSize > result.size()) {
                     minSize = result.size();
                }
            }
            if (temp == 0) {
                result.add(x);
                isSuccess = true;
                if (minSize > result.size()) {
                    minSize = result.size();
                }
            }
            if (temp > (x * x)) {
                result.add(x);
                findMin(temp, x, maxNum);
            } else {
                if (temp > 0) {
                    result.add(x);
                    findMin(temp, x - 1, maxNum);
                } else {
                    while (true) {
                        x = x - 1;
                        if (x == 0) {
                            break;
                        }
                        temp = n - (x * x);
                        if (temp == 0) {
                            isSuccess = true;
                            result.add(x);
                            break;
                        }
                        if (temp > 0) {
                            result.add(x);
                            findMin(temp, x - 1,  maxNum);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        System.out.println(solution.numSquares(n));
    }

}
