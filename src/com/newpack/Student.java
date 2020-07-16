package com.newpack;

/**
 * @Author: mogochen
 * @Date: 2020/7/12 20:03
 */
public class Student extends User {

    public static int testnum = 2;

    static {
        System.out.println("testnum的值是" + testnum);
    }

    public Student() {
        System.out.println("student构造函数");
    }

    public static void main(String[] args) {
        User u = new Student();
        u.say();
    }
}
