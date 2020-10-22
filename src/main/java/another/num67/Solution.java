package another.num67;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int index = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(i) - '0' : 0;
            int temp = x + y + index;
            if (temp >= 2) {
                index = 1;
                temp = temp - 2;
            } else {
                index = 0;
            }
            stringBuilder.append(temp);
            i--;
            j--;
        }
        if (index == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
