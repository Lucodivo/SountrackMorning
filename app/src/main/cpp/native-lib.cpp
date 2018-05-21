#include <jni.h>
#include <string>


std::string helloWorld() {
    std::string hello = "HelloWorld() in C++! ";
    return hello;
}

extern "C" JNIEXPORT jstring
JNICALL
Java_com_inasweaterpoorlyknit_soundtrackmorning_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = helloWorld();
    return env->NewStringUTF(helloWorld().c_str());
}

extern "C" JNIEXPORT jdouble
JNICALL
Java_com_inasweaterpoorlyknit_soundtrackmorning_MainActivity_doubleFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    double someDouble = 3.1415;
    return someDouble;
}