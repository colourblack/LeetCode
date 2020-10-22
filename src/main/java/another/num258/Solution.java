package another.num258;

public class Solution {
    public int addDigits(int num) {
        int result = 0;
        int i;
        while (true) {
            i = num % 10;
            result = i + result;
            num = num / 10;
            if (num == 0) {
                if (result > 9) {
                    num = result;
                    result = 0;
                } else {
                    return result;
                }
            }
        }
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
