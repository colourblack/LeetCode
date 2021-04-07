package design.pattern.strategy.case2;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:30 PM
 */
public class Client {

    public static void main(String[] args) {
        DispatcherHandler dispatcherHandler = new DispatcherHandler();

        Request request = new Request();
        request.setUrl("/v1/login");
        request.setCommand("username=KongWu");

        dispatcherHandler.dispatch(request);
    }

}
