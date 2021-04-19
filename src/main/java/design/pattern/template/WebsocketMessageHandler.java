package design.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 5:24 PM
 */
@Slf4j
public class WebsocketMessageHandler extends AbstractMessageHandler{
    @Override
    public void preSend() {
        log.info("容器为Websocket协议做一系列准备");
    }

    @Override
    public void afterSend() {
        log.info("容器准备销毁Websocket相关内容");
    }
}
