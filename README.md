## linux 调用 C 方法
    
    1、Java 编写 native 方法
    2、将Java native类编译成 C 语言文件
    3、实现 C 文件中的方法
    4、编写 makefile，并执行 make 命令，则 src/main/java 目录生成 libJniUtil.jnilib 
    5、将 libJniUtil.jnilib 目录添加到 jvm 启动参数中

### 1、Java 编写 native 方法
```java
package com.pa.restc.util;
public class JniUtil {
    public native void sayHelloWorld();
}
```

### 2、将Java native类编译成 C 语言文件
``` shell script
# 打开 terminal，进入 Java native 类路径下，编译 Java 文件为 class
cd src/main/java
javac com/pa/restc/util/JniUtil.java
# 将 class 文件编译成 C 语言头文件
# 执行 javah 命令，在 src/main/java 目录生成 com_pa_restc_util_JniUtil.h
javah com.pa.restc.util.JniUtil
```

### 3、实现 C 文件中的方法
JniUtilImpl.c
```
#include "jni.h"
#include "com_pa_restc_util_JniUtil.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_pa_restc_util_JniUtil_sayHelloWorld(JNIEnv *env,jobject obj){
    printf("Hello World!\n");
}
```

### 4、编写 makefile，并执行 make 命令，则 src/main/java 目录生成 libJniUtil.jnilib 
```shell script
CC=gcc
CFLAGS=I.

libJniUtil.jnilib : JniUtilImpl.c
        $(CC) -fPIC -I/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/include/ -I/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/include/darwin/ -shared -o libJniUtil.jnilib JniUtilImpl.c
```

### 5、将 libJniUtil.jnilib 目录添加到 jvm 启动参数中
```shell script
-Djava.library.path="/Users/kuzan/Documents/auto-cloud/rest-c/src/main/java"
```

### 参考文献
* [使用JNI的总结](https://www.jianshu.com/p/fe42aa3150a0)
* [java 调用c语言程序](https://www.jianshu.com/p/632ab36fe8bb)