package design.pattern.template;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/19/21 5:26 PM
 */
public class TemplateTest {

    public static void main(String[] args) {
        MessageHandler httpHandler = new HttpMessageHandler();
        MessageHandler websocketHandler = new WebsocketMessageHandler();

        httpHandler.doSendMessage("这是http内容");
        websocketHandler.doSendMessage("这是websocket内容");
    }

}
