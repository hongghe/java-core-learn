package org.design_pattern.singleton;

/** 双重检验锁模式
 *
 * 如果有多个线程进入new Instance操作，就会进入同步块内，就不会产生多个实例
 *
 * 但是还是存在一定缺陷：
 * instance = new Instance()这个操作在JVM中，不是一个原子操作，大概分为：
 * 1. 分配instance内存
 * 2. 调用Instance的构造函数来初始化成员变量
 * 3. 将instance对象指向分配的空间(到这步，instance就为非null了)
 *
 * 在JVM的即时编译器中存在指令重排序优化，执行中2.3步的顺序是不能保证的，有可能是1-2-3
 * 也可能是 1-3-2，如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
 * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后就会报错
 *
 *
 * 解决方法：将 instance用volatile修饰，如：private volatitle static DoubleCheckSington instance
 *
 * @Author: HaoBin
 * @Date 2018/1/31 18:32
 */
public class DoubleCheckSington {

    private static DoubleCheckSington instance;

    private DoubleCheckSington() {}

    public static DoubleCheckSington getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSington.class) {
                if (instance == null) {
                    instance = new DoubleCheckSington();
                }
            }
        }
        return instance;
    }
}
