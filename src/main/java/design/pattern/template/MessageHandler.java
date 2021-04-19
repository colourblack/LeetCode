package design.pattern.template;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 5:19 PM
 */
public interface MessageHandler {

    /**
     * 推送消息
     * @param message 消息
     */
    void doSendMessage(String message);

}
