CC=gcc
CFLAGS=I.

libJniUtil.jnilib : JniUtilImpl.c
	$(CC) -fPIC -I/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/include/ -I/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/include/darwin/ -shared -o libJniUtil.jnilib JniUtilImpl.c
