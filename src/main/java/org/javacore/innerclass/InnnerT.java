package org.javacore.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 内部类的使用
 */
public class InnnerT {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10000, true);
        clock.start();

        // 点击弹出框退出
        JOptionPane.showMessageDialog(null, "退出?");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int internal, boolean beep) {
        this.interval = internal;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        javax.swing.Timer t = new javax.swing.Timer(interval, listener);
        t.start();
    }

    // 内部类可以使用外围类的变量
    public class TimePrinter implements ActionListener {

        // 用外围类的beep来控制
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("the time is " + new Date());
            if(beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
