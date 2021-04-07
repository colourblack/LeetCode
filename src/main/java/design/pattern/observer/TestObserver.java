package design.pattern.observer;

import design.pattern.observer.impl.DashBoard;
import design.pattern.observer.impl.WeatherCenter;
import design.pattern.observer.impl.WeatherData;


/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 下午5:58
 */
public class TestObserver {

    public static void main(String[] args) {
        DashBoard dashBoard = new DashBoard();
        WeatherCenter weatherCenter = new WeatherCenter();
        weatherCenter.registerObserver(dashBoard);
        weatherCenter.getNewWeatherData(1);
        weatherCenter.getNewWeatherData(2);
        weatherCenter.getNewWeatherData(3);
    }

}
