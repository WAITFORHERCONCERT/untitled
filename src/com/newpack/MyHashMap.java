package com.newpack;

import com.cxs.Test1;

import javax.swing.*;
import java.util.*;

/**
 * @Author: mogochen
 * @Date: 2020/7/14 16:03
 */
public class MyHashMap implements IHashMap {
    private Object[] objects;

    public MyHashMap() {
        objects = new Object[2000];
    }

    @Override
    public void put(String key, Object value) {
        int hashcode = Test1.hashcode(key);
        if (null == objects[hashcode]) {
            Map.Entry<String, Object> entry = new AbstractMap.SimpleEntry<String, Object>(key, value);
            List<Map.Entry<String, Object>> list = new LinkedList<>();
            list.add(entry);
            objects[hashcode] = list;
        } else {
            List<Map.Entry<String, Object>> list = (LinkedList<Map.Entry<String, Object>>) (objects[hashcode]);
            Map.Entry<String, Object> entry = new AbstractMap.SimpleEntry<String, Object>(key, value);
            list.add(entry);
        }
        ;
    }

    @Override
    public Object get(String key) {
        int hashcode = Test1.hashcode(key);
        if (null == objects[hashcode]) {
            return null;
        } else {
            List<Map.Entry<String, Object>> list = (LinkedList<Map.Entry<String, Object>>) (objects[hashcode]);
            Iterator<Map.Entry<String, Object>> iterator = list.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                String keystr = entry.getKey();
                if (key.equals(keystr)) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }
}
