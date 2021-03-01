package design.pattern.singleton;

/**
 * 懒汉式: 双重检测锁
 * 推荐使用!
 * @author Fang
 */
public class Pattern6 {

    /**
     * 构造器私有化,
     * 同时将实例变量加上关键字volatile, 避免编译器优化指令而造成线程不安全.
     * 在需要时才创建该类的实例, 达到Lazy Loading的效果.
     * 同时采用了双重检测锁, 保证了多线程下的线程安全的同时提高了运行效率
     *
     * 目前最为广泛的使用方式
     */

    private volatile static Pattern6 PATTERN_6;

    private Pattern6() {

    }

    public synchronized static Pattern6 getInstance(){
        if ((PATTERN_6 == null)) {
            synchronized (Pattern6.class){
                if (PATTERN_6 == null) {
                    PATTERN_6 = new Pattern6();
                }
            }
        }
        return PATTERN_6;
    }

    public void print() {
        System.out.println("这是懒汉式~(双重检测锁)");
    }

    /*
     * 为什么是双重校验锁实现单例模式呢？
     *
     * 第一次校验： 也就是第一个if（singleton==null），这个是为了代码提高代码执行效率，由于单例模式只要一次创建实例即可，
     * 所以当创建了一个实例之后，再次调用getInstance方法就不必要进入同步代码块，不用竞争锁。直接返回前面创建的实例即可。
     *
     * 第二次校验： 也就是第二个if（singleton==null），这个校验是防止二次创建实例，假如有一种情况，
     * 当singleton还未被创建时，线程t1调用getInstance方法，由于第一次判断singleton==null，
     * 此时线程t1准备继续执行，但是由于资源被线程t2抢占了，此时t2页调用getInstance方法。
     *
     * 同样的，由于singleton并没有实例化，t2同样可以通过第一个if，然后继续往下执行，
     * 同步代码块，第二个if也通过，然后t2线程创建了一个实例singleton。
     *
     * 此时t2线程完成任务，资源又回到t1线程，t1此时也进入同步代码块，如果没有这个第二个if，
     * 那么，t1就也会创建一个singleton实例，那么，就会出现创建多个实例的情况，但是加上第二个if，就可以完全避免这个多线程导致多次创建实例的问题。
     *
     * 所以说：两次校验都必不可少。
     *
     * 还有，这里的private static volatile Singleton singleton = null;中的volatile也必不可少，volatile关键字可以防止jvm指令重排优化，
     *
     * 因为 singleton = new Singleton() 这句话可以分为三步：
     *
     * 为 singleton 分配内存空间；
     * 初始化 singleton；
     * 将 singleton 指向分配的内存空间。
     * 但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。
     * 指令重排在单线程下不会出现问题，但是在多线程下会导致一个线程获得一个未初始化的实例。
     * 例如：线程T1执行了1和3，此时T2调用 getInstance() 后发现 singleton 不为空，因此返回 singleton， 但是此时的 singleton 还没有被初始化。
     *
     * 使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
     *
     * 这里还说一下volatile关键字的第二个作用，保证变量在多线程运行时的可见性：
     *
     * 在 JDK1.2 之前，Java的内存模型实现总是从主存（即共享内存）读取变量，是不需要进行特别的注意的。
     * 而在当前 的 Java 内存模型下，线程可以把变量保存本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。
     *
     * 这就 可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成数 据的不一致。
     *
     * 要解决这个问题，就需要把变量声明为 volatile，这就指示 JVM，这个变量是不稳定的，每次使用它都到主存中进行 读取。
     */
}
