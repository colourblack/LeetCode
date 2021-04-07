package design.pattern.strategy.case2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:22 PM
 */
@Slf4j
public class LoginController implements Handler{

    @Override
    public void doHandle(String command) {
        log.info("Admin controller 执行任务: {}", command);
    }

}
