package org.design_pattern.proxy;

/**
 * 静态代理模式：
 * 给某个对象提供一个代理对象，并由代理对象控制对于原对象的访问，即客户端不直接操作原对象，而是通过
 * 代理对象间接的操控原对象，这样可以在代理方法的前后执行一些操作
 */

public class ProxyDemo {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }
}

interface Subject{
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("request");
    }
}

class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("Prepare");
        subject.request();
        System.out.println("postProcess");
    }
}


