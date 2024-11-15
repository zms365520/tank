package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: zms
 * @Date: 2024/11/15 - 11 - 15 - 16:48
 * @Description: com.aks.tank
 * @version: 1.0
 */
public class T {
    public static void main(String[] args) {
        Frame f=new Frame();//Frame：窗口类
        f.setSize(800,600);//设置大小
        f.setResizable(false);//窗口不可改变大小
        f.setTitle("Tank War another");
        f.setVisible(true);

        //f的window监听器，监听者windowClosing这件事，当点击❌时，系统退出
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //f.show();
    }
}
