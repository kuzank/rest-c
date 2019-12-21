package com.pa.restc;

import com.pa.restc.util.JniUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author kuzank 2019/12/21
 */
@RestController
public class JniControll {

    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("JniUtil"); // 装入动态链接库,"HelloWorldImpl"是装入动态链接库的名称
    }

    @GetMapping("test")
    public String test() {
        new JniUtil().sayHelloWorld();
        return "test";
    }

}
