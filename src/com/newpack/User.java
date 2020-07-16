package com.newpack;

import javax.xml.namespace.QName;

/**
 * @Author: mogochen
 * @Date: 2020/7/12 19:58
 */
public class User {
    private String name;
    public String sex = "男";
    protected String num;
    public int hp;

    public static int testnum = 1;

    static {
        System.out.println("testnum的值是"+testnum);
    }

    public User(){
        System.out.println("user构造函数");
    }

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        notify();
    }

    public synchronized void recover() {
        if (hp == 1000) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        this.notify();
    }

    private String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    protected String getNum() {
        return num;
    }

    public int getAge() {
        return hp;
    }

    public void say() {
        System.out.println("user say");
    }

    public static void main(String[] args) {

    }
}
