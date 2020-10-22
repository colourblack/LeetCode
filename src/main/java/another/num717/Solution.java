package another.num717;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean flag = true;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                i = i + 2;
                flag = false;
            } else {
                i++;
                flag = true;
            }
        }
        return flag;
    }
}
