package another.num441;

public class Solution {
    public int arrangeCoins(int n) {
        int i=1;
        while (n>=i){
            //n小于该行应有的个数则停止
            n-=i;
            i++;
        }
        return i-1;
    }
//    根据数学公式，k(k+1) /2 = n，可以得到其正数解为：k = sqrt(2n+1/4) - 1/2。然后求整即可。
//    唯一的问题是，这里2n+1/4有可能会超出sqrt函数的参数范围。
//    于是，我们可以变换一下， k = sqrt(2) * sqrt(n+1/8) - 1/2，这样求平方根就不会超限了。
//    于是，我们就有了这么一行代码
//    public int arrangeCoins(int n) {
//        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
//    }
}
