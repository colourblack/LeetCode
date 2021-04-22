package design.pattern.facade;


/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/22/21 10:55 AM
 */
public class System implements SystemHandler {

    private final Computer computer;
    private final Monitor monitor;

    public System() {
        computer= new Computer();
        monitor = new Monitor(computer);
    }

    @Override
    public void open() {
        computer.open();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.open();
    }
}
