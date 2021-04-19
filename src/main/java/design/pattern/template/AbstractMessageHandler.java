package design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 5:20 PM
 */
@Slf4j
public abstract class AbstractMessageHandler implements MessageHandler{
    @Override
    public final void doSendMessage(String message) {
        preSend();
        log.info("发送消息: {}", message);
        afterSend();
    }

    public abstract void preSend();

    public abstract void afterSend();

}
