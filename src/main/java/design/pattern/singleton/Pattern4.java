package design.pattern.singleton;

/**
 * 单例模式: 懒汉式(同步锁)
 * @author Fang
 */
public class Pattern4 {

    /**
     * 构造器私有化,
     * 在需要时才创建该类的实例, 达到Lazy Loading的效果.
     * 同时增加了synchronized, 保证了多线程下的线程安全.
     *
     * 优点：这种写法起到了Lazy Loading的效果，也保证了多线程下的使用安全.
     * 缺点：如果在多线程下, 无论该类是否已经完成实例化, 每一次获取该类实例都会将方法getInstance()加锁
     *      这样降低了代码的执行效率
     */

    private static Pattern4 PATTERN_4;

    private Pattern4() {

    }

    public synchronized static Pattern4 getInstance(){
        if (PATTERN_4 == null) {
            PATTERN_4 = new Pattern4();
        }
        return PATTERN_4;
    }

    public void print() {
        System.out.println("这是懒汉式~(同步锁)");
    }


}
