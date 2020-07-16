package com.cxs;

import com.newpack.IHashMap;
import com.newpack.MyHashMap;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: mogochen
 * @Date: 2020/7/9 13:49
 */
public class Test1 {
    public static long beginTime;
    public static int count = 0;

    public static String t(int n) {
        String i = String.valueOf(n % 10);
        if (n / 10 == 0)
            return i;
        return t(n / 10) + "," + i;
    }

    public static void xuanzesort(int[] arry) {
        if (arry.length < 2)
            return;
        int temp;
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[i] > arry[j]) {
                    temp = arry[i];
                    arry[i] = arry[j];
                    arry[j] = temp;
                }
            }
        }
    }

    public static void maopao(int[] arry) {
        int temp;
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = 0; j < arry.length - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }
        }
    }

    public static void printArry(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + "\t");
        }
    }

    public static char[] getzifushuzu() {
        char[] arry = new char[62];
        int i = 0;
        int a;
        for (a = 48; a <= 57 && i < 10; a++) {
            arry[i] = (char) a;
            i++;
        }
        for (a = 65; a <= 90 && i < 36; a++) {
            arry[i] = (char) a;
            i++;
        }
        for (a = 97; a <= 122 && i < 62; a++) {
            arry[i] = (char) a;
            i++;
        }
        return arry;
    }

    public static char[] getRandomCharArry(char[] chars, int length) {
        int charsLength = chars.length;
        if (length < 1 || charsLength < 1)
            return new char[0];
        char[] randomChars = new char[length];
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * charsLength);
            randomChars[i] = chars[index];
        }
        return randomChars;
    }

    public static void stringSort(String[] strs) {
        int length = strs.length;
        if (length < 1)
            return;
        String temp;
        for (int j = 0; j < length - 1; j++) {
            for (int i = 0; i < length - 1 - j; i++) {
                if (null == strs[i] || strs[i].length() == 0) {
                    continue;
                }
                if (null == strs[i + 1] || strs[i + 1].length() == 0) {
                    temp = strs[i];
                    strs[i] = strs[i + 1];
                    strs[i + 1] = temp;
                    continue;
                }
                char headchar1 = strs[i].charAt(0);
                char headchar2 = strs[i + 1].charAt(0);
                if (Character.isLetter(headchar1) && Character.isUpperCase(headchar1)) {
                    headchar1 = Character.toLowerCase(headchar1);
                }
                if (Character.isLetter(headchar2) && Character.isUpperCase(headchar2)) {
                    headchar2 = Character.toLowerCase(headchar2);
                }
                if (headchar1 > headchar2) {
                    temp = strs[i];
                    strs[i] = strs[i + 1];
                    strs[i + 1] = temp;
                }

            }
        }
    }

    public static void pojiemima(char[] password, char[] chars) {
        if (null == password || password.length < 1) {
            System.out.println("需要破解的密码为空 ！");
            return;
        }
        if (null == chars || chars.length < 1) {
            System.out.println("字典为空！");
            return;
        }
        int passLength = password.length;
        int charsLength = chars.length;
        char[] guess = new char[passLength];
        int count = 0;
        long beginTime = System.currentTimeMillis();
        long durTime = 0;
        a:
        for (int i = 0; i < charsLength; i++) {
            guess[0] = chars[i];
            for (int j = 0; j < charsLength; j++) {
                guess[1] = chars[j];
                for (int k = 0; k < charsLength; k++) {
                    count++;
                    guess[2] = chars[k];
                    //System.out.println("尝试第 " + count + "次:" + Arrays.toString(guess));
                    if (guess[0] == password[0] && guess[1] == password[1] && guess[2] == password[2]) {
                        durTime = (System.currentTimeMillis() - beginTime) / 1000;
                        System.out.println("用时" + durTime + "s," + count + "次" + "解密成功：" + Arrays.toString(guess));
                        System.out.println("密码：" + Arrays.toString(password));
                        break a;
                    }
                }
            }
        }
    }

    public static void pojiemima2(char[] password, char[] chars, int i, int j, int k) {
        if (null == password || password.length < 1) {
            System.out.println("需要破解的密码为空 ！");
            return;
        }
        if (null == chars || chars.length < 1) {
            System.out.println("字典为空！");
            return;
        }
        int passLength = password.length;
        char[] guess = new char[passLength];
        guess[0] = chars[i];
        guess[1] = chars[j];
        guess[2] = chars[k];
        if (guess[0] == password[0] && guess[1] == password[1] && guess[2] == password[2]) {
            long durTime = (System.currentTimeMillis() - beginTime) / 1000;
            System.out.println("用时" + durTime + "s," + count + "次" + "解密成功：" + Arrays.toString(guess));
            System.out.println("密码：" + Arrays.toString(password));
            return;
        }
        if (k == 61) {
            if (j == 61) {
                if (i == 61) {
                    System.out.println("没找到");
                } else {
                    i++;
                    j = 0;
                    k = 0;
                }
            } else {
                j++;
                k = 0;
            }
        } else {
            k++;
        }
        count++;
        pojiemima2(password, chars, i, j, k);
        return;
    }

    public static int hashcode(String str) {
        if (str.length() == 0)
            return 0;
        char[] charArry = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArry.length; i++) {
            sum = sum + charArry[i];
        }
        return (23 * sum > 1999) ? (23 * sum % 2000) : (23 * sum);
    }

    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        // int[] arry = new int[]{1, 3, 4, 5, 3, 1};
        // for (int i = 0; i < arry.length; i++) {
        //     list.add(arry[i]);
        // }
        // System.out.println(list.contains(6));
        // list.add(6);
        // list.add(0, 7);
        // System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(list.indexOf(6));
        // System.out.println(list.set(0, 9));
        // System.out.println(Arrays.toString(list.toArray()));
        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }
        //Set<Integer> set = new HashSet<>();
        //for (int i = 0; i < arry.length; i++) {
        //    set.add(arry[i]);
        //}
        //Iterator iterator = set.iterator();
        //while (iterator.hasNext()) {
        //    System.out.println(iterator.next());
        //}
        Map<String, String> map = new HashMap<>();
        //map.put("adc", "射手");
        //map.put("ap", "法师");
        //map.put("tank", "坦克");
        Set<String> keyset = map.keySet();
        //Map<String, String> map2 = new HashMap<>();
        //for (String s : keyset) {
        //    map2.put(map.get(s), s);
        //    System.out.println(s+":"+map.get(s));
        //}
        //Set<String> set2 = map2.keySet();
        //for (String s : set2) {
        //    System.out.println(s+":"+map2.get(s));
        //}

        //for (int k=0;k<100;k++){
        //    int length = (int) (Math.random() * 8 + 2);
        //    char[] strArry = new char[length];
        //    for (int i = 0; i < length; i++) {
        //        strArry[i] = (char) (Math.random() * 94 + 32);
        //    }
        //    String str = new String(strArry);
        //    System.out.println(str + ":" + hashcode(str));
        //}

        IHashMap iHashMap = new MyHashMap();
        iHashMap.put("001","kkk");
        iHashMap.put("002","sdfsdf");
        iHashMap.put("003","fdsfd");
        System.out.println(iHashMap.get("001"));


    }
}