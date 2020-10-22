package another.num859;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public  boolean buddyStrings(String A, String B) {
        if (A.equals(null) || B.equals(null)) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        boolean isRepeated = false;
        int[] diff = new int[2];
        int index = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (index >= 2) {
                    return false;
                }
                diff[index] = i;
                index++;
            }
            if (isRepeated == false) {
                if (list.isEmpty()) {
                    list.add(A.charAt(i));
                } else {
                    if (list.contains(A.charAt(i))) {
                        isRepeated = true;
                    } else {
                        list.add(A.charAt(i));
                    }
                }
            }
        }

        if (index == 0) {
            return isRepeated;
        } else if (index == 1) {
            return false;
        } else {
            char[] charArray = A.toCharArray();
            char x = charArray[diff[0]];
            char y = charArray[diff[1]];
            charArray[diff[0]] = y;
            charArray[diff[1]] = x;

            if (B.equals(String.valueOf(charArray))) {
                return true;
            } else {
                return false;
            }
        }
    }
}
