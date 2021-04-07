package design.pattern.observer;

/**
 * @author yf-Fangjunjin
 * @version 1.0
 * @since 2021/4/2 下午5:31
 */
public interface Subject<T extends Observer, E extends Event> {

    /**
     * 注册监听器
     */
    T registerObserver(T t);


    /**
     * 移除监听器
     */
    boolean removeObserver(Observer observer);

    /**
     * 提醒监听器
     */
    void notifyObservers(E e);
}
