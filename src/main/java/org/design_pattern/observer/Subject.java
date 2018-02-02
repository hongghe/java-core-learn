package org.design_pattern.observer;

/**
 * 主题接口，观察者只要订阅主题就会收到通知
 * @Author: HaoBin
 * @Date 2018/2/2 23:19
 */
public interface Subject {

    /**
     * 注册一个观察者
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();
}
