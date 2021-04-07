package design.pattern.strategy.case2;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:21 PM
 */
public interface Handler {

    /**
     * 执行任务
     * @param command 任务指令
     */
    void doHandle(String command);

}
