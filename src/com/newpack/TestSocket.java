package com.newpack;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: mogochen
 * @Date: 2020/7/15 12:51
 */
public class TestSocket {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println(ip);
    }
}
