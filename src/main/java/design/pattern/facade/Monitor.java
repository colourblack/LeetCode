package design.pattern.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/22/21 10:46 AM
 */
@Slf4j
public class Monitor implements SystemHandler {

    private final Computer computer;

    public Monitor(Computer computer) {
        this.computer = computer;
    }


    @Override
    public void open() {
        if (this.prepare()) {
            log.info("可以打开显示器了");
        } else {
            log.error("出现错误, 无法打开显示器");
        }
    }

    public boolean prepare() {
        if (this.computer.prepare()) {
            log.info("电脑组装好了, 现在可以装显示器了");
            return true;
        }
        else  {
            log.error("电脑还没装好, 没法装显示器");
            return false;
        }
    }
}
