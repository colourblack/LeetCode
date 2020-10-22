package another.num605;

/**
 * @author FANG
 */
public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i -1] == 0)
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 0 ,0};
        int n = 1;
        System.out.println(canPlaceFlowers(a, n));
    }
}
