package design.pattern.singleton;

/**
 * 单例模式: 饿汉式
 * @author Fang
 */
public class Pattern1 {

    /**
     * 在类加载的时候就创建实例对象, 同时将构造器私有化
     * 避免对该类进行二次的实例化.
     * 提供一个公用的静态方法获取该实例对象
     *
     * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
     * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
     */

    private static final Pattern1 PATTERN_1 = new Pattern1();


    private Pattern1(){

    }

    public static Pattern1 getInstance(){
        return PATTERN_1;
    }

    public void print() {
        System.out.println("这是饿汉式~");
    }

}
