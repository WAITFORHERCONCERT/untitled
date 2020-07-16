package com.newpack;

import java.util.Stack;

/**
 * @Author: mogochen
 * @Date: 2020/7/14 19:08
 */
public class Threadtest {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Thread c1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (stack) {
                        if (stack.empty()) {
                            try {
                                stack.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        char c = stack.pop();
                        System.out.println(Thread.currentThread().getName() + "弹出字符：" + c + "  count：" + stack.size());
                        stack.notifyAll();
                    }
                }
            }
        };
        Thread p1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (stack) {
                        if (stack.size() >= 200) {
                            try {
                                stack.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        char c = (char) (Math.random() * 25 + 65);
                        System.out.println(Thread.currentThread().getName() + "压入字符：" + c + "  count：" + stack.size());
                        stack.push(c);
                        stack.notifyAll();
                    }
                }
            }
        };
        Thread c2 = new Thread(c1);
        Thread c3 = new Thread(c1);
        Thread p2 = new Thread(p1);
        c1.setName("c1");
        c2.setName("c2");
        c3.setName("c3");
        p1.setName("p1");
        p2.setName("p2");
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();


    }
}
