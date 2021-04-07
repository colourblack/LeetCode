package design.pattern.strategy.case2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:24 PM
 */
@Slf4j
public class DisplayController implements Handler {

    @Override
    public void doHandle(String command) {
        log.info("DisplayController 执行展示任务: {}", command);
    }
}
