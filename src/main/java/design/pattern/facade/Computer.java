package design.pattern.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/22/21 10:43 AM
 */
@Slf4j
public class Computer implements SystemHandler{

    private boolean isActive = false;

    @Override
    public void open() {
        if (this.prepare()) {
            log.info("电脑正常开机");
        } else {
            log.error("电脑无法完成开机");
        }
    }

    public boolean prepare() {
        if (!isActive) {
            try {
                log.info("准备组装电脑...");
                Thread.sleep(1000);
                isActive = true;
            } catch (InterruptedException e) {
                log.error("被打断了. 无法正常完成电脑组装");
                return false;
            }
            return true;
        }
        return true;
    }
}
