package org.design_pattern.observer;

/**
 * 使用者1
 *
 *
 * @Author: HaoBin
 * @Date 2018/2/2 23:39
 */
public class Observer1 implements Observer{

    private Subject subject;

    public Observer1(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update(String msg) {
        System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
