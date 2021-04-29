package com.byk.ffmpeg;

public class VideoUtils {
    static {
        System.loadLibrary("libavcodec");
        System.loadLibrary("libavdevice");
        System.loadLibrary("libavfilter");
        System.loadLibrary("libavformat");
        System.loadLibrary("libavutil");
        System.loadLibrary("libswresample");
        System.loadLibrary("libswscale");

        //测试测试
    }
    public native static void decode(String input,String output);
}
