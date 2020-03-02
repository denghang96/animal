package com.wangyaolang.animal.controller.common;

/**
 * 保存用户登录信息的工具类
 */
public final class TraceUtil {

    private TraceUtil(){}

    private static ThreadLocal<String> threadLocal
                = new ThreadLocal<>();//ThreadLocal会为每一个线程创建一个独立的副本

    public static void initThread(String userId){
        threadLocal.set(userId);
    }

    public static String getUserId(){
        return threadLocal.get();
    }


}
