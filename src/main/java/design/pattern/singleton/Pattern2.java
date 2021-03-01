package design.pattern.singleton;

/**
 *
 * @author Fang
 */
public class Pattern2 {

    /**
     * 在类加载的时候就创建实例对象, 同时将构造器私有化
     * 避免对该类进行二次的实例化.
     * 提供一个公用的静态方法获取该实例对象
     *
     * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
     * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
     */

    private static final Pattern2 PATTERN_2;

    static {
        PATTERN_2 = new Pattern2();
    }


    private Pattern2(){

    }

    public static Pattern2 getInstance(){
        return PATTERN_2;
    }

    public void print() {
        System.out.println("这是饿汉式~(采用静态代码块创建)");
    }
}
