package com.newpack;

import java.io.*;

/**
 * @Author: mogochen
 * @Date: 2020/7/15 13:44
 */
public class TestFileIO {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        char[] chars = {'怒'};
        System.out.println(chars.length);
        String s = "怒";
        byte[] bytes = s.getBytes("utf-8");
        for (int i=0;i<bytes.length;i++){
            System.out.println(bytes[i]);
        }

    }
}
