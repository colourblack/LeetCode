package design.pattern.strategy.case2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 4/7/21 5:25 PM
 */
public class DispatcherHandler{

    private final Map<String, Handler> collection;

    DispatcherHandler () {
        collection = new HashMap<>();
        collection.put("/v1/login", new LoginController());
        collection.put("/v1/display", new DisplayController());
    }


    public void dispatch(Request request) {
        collection.get(request.getUrl()).doHandle(request.getCommand());
    }

}
