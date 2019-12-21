#include "jni.h"
#include "com_pa_restc_util_JniUtil.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_pa_restc_util_JniUtil_sayHelloWorld(JNIEnv *env,jobject obj){
    printf("Hello World!\n");
}