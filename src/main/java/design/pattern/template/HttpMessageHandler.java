package design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 5:22 PM
 */
@Slf4j
public class HttpMessageHandler extends AbstractMessageHandler{
    @Override
    public void preSend() {
        log.info("容器为Http协议做一系列准备");
    }

    @Override
    public void afterSend() {
        log.info("容器准备销毁Http相关内容");
    }
}
