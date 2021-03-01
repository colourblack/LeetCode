package design.pattern.singleton;


/**
 * 单例模式: 懒汉式
 * @author Fang
 */
public class Pattern3 {
    /**
     * 构造器私有化,
     * 在需要时才创建该类的实例, 达到Lazy Loading的效果.
     *
     * 优点：这种写法起到了Lazy Loading的效果，但是只能在单线程下使用。
     * 缺点：如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
     *      另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
     */

    private static Pattern3 PATTERN_3;

    private Pattern3() {

    }

    public static Pattern3 getInstance(){
        if (PATTERN_3 == null) {
            PATTERN_3 = new Pattern3();
        }
        return PATTERN_3;
    }

    public void print() {
        System.out.println("这是懒汉式~(采用静态代码块创建)");
    }

}
