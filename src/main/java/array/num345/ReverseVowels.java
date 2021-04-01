package array.num345;

import org.junit.jupiter.api.Test;

/**
 * @author Fangjunjin
 * @since 2021/4/1
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 查找符合条件的左指针
            while (left < right && isNotVowel(chars[left])) {
                left++;
            }
            // 查找符合条件的右指针
            while (left < right && isNotVowel(chars[right])) {
                right--;
            }
            // 进行交换
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            // 完成交换以后记得左右指针继续前进
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public boolean isNotVowel(char ch) {
        return ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }

    @Test
    public void test() {
        System.out.println(reverseVowels("hello"));
    }

}
