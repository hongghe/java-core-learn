package org.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 3D服务号
 *
 * @Author: HaoBin
 * @Date 2018/2/2 23:29
 */
public class ObjectFor3D implements Subject{

    private List<Observer> observers = new ArrayList<>();

    /**
     * 通知消息
     */
    private String msg;

    /**
     * 添加观察者
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        int index = this.observers.indexOf(observer);
        if (index >= 0) {
            this.observers.remove(index);
        }
    }

    /**
     * 通知所有观察者
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    /**
     * 消息改变时通知所有观察者
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        this.notifyObservers();
    }
}
