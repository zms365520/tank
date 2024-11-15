package com.aks.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private static final int SPEED=10;
    Dir dir=Dir.DOWN;//默认坦克的方向：下
    int x=200,y=200;//放开的初始位置
    public TankFrame(){

        setSize(800,600);//设置大小
        setResizable(false);//窗口不可改变大小
        setTitle("Tank War another");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        //f的window监听器，监听者windowClosing这件事，当点击❌时，系统退出
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        //根据方向绘制坦克
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
    }

    //键盘的监听处理类
    class MyKeyListener extends KeyAdapter{
        //使用四个变量代表移动的方向，代替switch中的
        boolean bL=false;
        boolean bR=false;
        boolean bU=false;
        boolean bD=false;

        //键盘按键按下的时候触发该方法
        @Override
        public void keyPressed(KeyEvent e){
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                default:
                    break;
            }
            setMainTankDir();//设置坦克的方向
        }

        //键盘按键按下之后抬起（松开）的时候触发该方法
        @Override
        public void keyReleased(KeyEvent e){
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                default:
                    break;
            }
            setMainTankDir();//设置坦克的方向
        }

        private void setMainTankDir() {
            if(bL) dir=Dir.LEFT;
            if(bU) dir=Dir.UP;
            if(bR) dir=Dir.RIGHT;
            if(bD) dir=Dir.DOWN;
        }


    }
}
