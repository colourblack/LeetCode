package another.num844;

import java.util.Stack;

/**
 * @author FANG
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        return builder(S).equals(builder(T));
    }

    public String builder(String string) {
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if (c == '#') {
                if (stack.isEmpty()) {
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";

        Solution s = new Solution();
        System.out.println(s.backspaceCompare(S, T));
    }
}
