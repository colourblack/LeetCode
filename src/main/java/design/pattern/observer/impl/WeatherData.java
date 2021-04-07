package design.pattern.observer.impl;

import design.pattern.observer.Event;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 下午5:47
 */
public class WeatherData implements Event {

    private String message;

    public String setMessage(int i) {
        switch (i) {
            case 1:
                message = "阴天你好";
                break;
            case 2:
                message = "讨人厌的下雨天";
                break;
            default:
                message = "晴空万里";
        }
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
