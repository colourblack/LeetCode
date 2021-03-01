package design.pattern.singleton;

/**
 * @author Fang
 */
public class Pattern5 {
    /**
     * 懒汉式, 表面上看线程安全, 其实并不安全!
     */

    private static Pattern5 PATTERN_5;

    private Pattern5() {

    }

    public  static Pattern5 getInstance(){

        if (PATTERN_5 == null) {
            /*
             * 虽然使用了 synchronized 关键字对创建实例的语句进行上锁,
             * 但是存在一种特殊情况, 当T1线程判断不存在该实例, 进入该if分支以后,
             * Cpu将资源切换给了T2, 此时T2同样也能进入if分支, 获取锁后创建实例, 释放锁
             * Cpu再切换到T1线程, 这时候的T1现在由于仍然在if分支内, 因此会再申请锁再创建实例
             * 故而存在这种特殊情况使得该类在内存中存在两个实例.
             */
            synchronized (Pattern5.class) {
                PATTERN_5 = new Pattern5();
            }
        }
        return PATTERN_5;
    }

    public void print() {
        System.out.println("这是懒汉式~(同步锁)");
    }
}
