package design.pattern.observer.impl;

import design.pattern.observer.Event;
import design.pattern.observer.Observer;
import design.pattern.observer.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 下午5:35
 */
public class WeatherCenter implements Subject<Observer, Event> {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherCenter.class);

    private final List<Observer> observers;

    public WeatherCenter() {
        observers = new ArrayList<>();
        LOGGER.info("气象站开始工作了.");
    }

    @Override
    public Observer registerObserver(Observer observer) {
        observers.add(observer);;
        return observer;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers(Event e) {
        for (Observer observer : observers) {
            observer.update(e);
        }
    }

    public void getNewWeatherData(int i) {
        if (observers.size() == 0) {
            LOGGER.error("没有人想要知道气象站的信息.");
        }
        WeatherData weatherData = new WeatherData();
        weatherData.setMessage(i);
        this.notifyObservers(weatherData);
    }
}
