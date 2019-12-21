package com.pa.restc.util;

/**
 * <p>Description: </p>
 *
 * @author kuzank 2019/12/21
 */
public class JniUtilTest {

    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("JniUtil"); // 装入动态链接库,"HelloWorldImpl"是装入动态链接库的名称
    }

    public static void main(String[] args) {
        new JniUtil().sayHelloWorld();
    }

}
