package another.num1295;

public class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        int index = 0;
        for(int i : nums){
            while(i != 0){
                index ++;
                i = i /10;
            }
            if((index & 1) == 0){
                result += 1;
            }
            index = 0;
        }
        return result;
    }
}
