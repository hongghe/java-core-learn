package org.design_pattern.observer;

/**
 * 观察者接口
 *
 * @Author: HaoBin
 * @Date 2018/2/2 23:20
 */
public interface Observer {

    /**
     * 当主题被改变时，观察者会被调用此方法
     * @param msg
     */
    public void update(String msg);
}
