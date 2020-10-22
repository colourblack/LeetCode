package another.num415;

/**
 * 字符类型转整型
 * char c = 2;
 * int i = c - '0';
 * System.out.println((int)c); -->  输出 50
 * System.out.println(i);   --> 输出 2
 * @author FANG
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int index = 0;
        while (i >= 0 || j >=0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0': 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0': 0;
            int temp = n1 + n2 + index;
            index = temp / 10;
            result.append(temp % 10);
            i--;
            j--;
        }
        if (index == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
