package org.design_pattern.observer;

/**
 * 测试
 *
 * @Author: HaoBin
 * @Date 2018/2/2 23:46
 */
public class Test {

    public static void main(String[] args) {
        // 模拟3D服务号
        ObjectFor3D subjectFor3d = new ObjectFor3D();

        Observer observer1 = new Observer1(subjectFor3d);
        Observer observer2 = new Observer2(subjectFor3d);

        subjectFor3d.setMsg("中奖号码是：123");
    }
}
