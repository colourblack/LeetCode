package design.pattern.facade;

import org.junit.jupiter.api.Test;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/22/21 11:00 AM
 */
public class FacadeTest {

    public static void main(String[] args) {
        SystemHandler system = new System();
        system.open();
    }

    @Test
    public void badTest() {
        /*
         * 以下的做法是非常不好的, 因为直接获取了两个子系统的具体对象,
         * 那么如果对子系统了解的话, 可以直接调用子系统的方法.因此不安全
         * 同时根据软件设计的原则, 将抽象的接口对外开发, 而内部的细节隐藏才是解藕的方式.
         */
        Computer computer = new Computer();
        Monitor monitor = new Monitor(computer);
        computer.open();
        monitor.open();
    }


}
