package design.pattern.observer.impl;

import design.pattern.observer.Event;
import design.pattern.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 下午5:53
 */
public class DashBoard implements Observer {

    private final static Logger LOGGER = LoggerFactory.getLogger(DashBoard.class);

    @Override
    public void update(Event e) {
        LOGGER.info(e.getMessage());
    }
}
