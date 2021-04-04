package array.num20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * @author Fang
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        ArrayList<Character> valid = new ArrayList<>();
        valid.add('(');
        valid.add(')');
        valid.add('[');
        valid.add(']');
        valid.add('{');
        valid.add('}');
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        int flag = 0;
        int index;
        for (char c : arr) {
            flag ++;
            if (c == valid.get(1) || c == valid.get(3) || c == valid.get(5)) {
                index = valid.indexOf(c);
                if (stack.empty()) {
                    // 非法
                    result = false;
                    break;
                } else {
                    if (!stack.pop().equals(valid.get(index - 1))) {
                        // 非法
                        result = false;
                        break;
                    }
                }
            }
            if (c == valid.get(0) || c == valid.get(2) || c == valid.get(4)) {
                stack.push(c);
            }
        }

        if (!stack.isEmpty() || flag != len) {
            result = false;
        }
        return result;
    }

}
