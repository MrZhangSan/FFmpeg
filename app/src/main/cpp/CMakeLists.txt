# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("ffmpeg")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

set(DISTRIBUTION_DIR ${CMAKE_SOURCE_DIR}/../jniLibs/)


# 编解码(最重要的库)
add_library(
        avcodec
        SHARED
        IMPORTED
)

#指定编码库的位置
set_target_properties(
        avcodec
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libavcodec-56.so
)

#设备信息
add_library(
        avdevice
        SHARED
        IMPORTED
)

#指定设备信息的位置
set_target_properties(
        avdevice
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libavdevice-56.so
)

#滤镜特效处理库
add_library(
        avfilter
        SHARED
        IMPORTED
)

#指定滤镜库位置
set_target_properties(
        avfilter
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libavfilter-5.so
)

#封装格式处理库
add_library(
        avformat
        SHARED
        IMPORTED
)

#指定格式库路径
set_target_properties(
        avformat
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libavformat-56.so
)

#工具库(大部分库都需要这个库的支持)
add_library(
        avutil
        SHARED
        IMPORTED
)

#指定工具库路径
set_target_properties(
        avutil
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libavutil-54.so
)

#后期处理
add_library(
        postproc
        SHARED
        IMPORTED
)

#指定后期处理库路径
set_target_properties(
        postproc
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libpostproc-53.so
)

#数据格式转换库
add_library(
        swresample
        SHARED
        IMPORTED
)

#指定库位置
set_target_properties(
        swresample
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libswresample-1.so
)

#视频像素数据格式转换
add_library(
        swscale
        SHARED
        IMPORTED
)
#视频像素格式转换库位置
set_target_properties(
        swscale
        PROPERTIES IMPORTED_LOCATION
        ${DISTRIBUTION_DIR}/${ANDROID_ABI}/libswscale-3.so
)


find_library(
        android-lib
        android
)

find_library(
        log-lib
        log
)

find_library(
        jnigraphics-lib
        jnigraphics
)

# 将预构建库与本地库相连
target_link_libraries(
        ffmpeg-video
        avcodec
        avdevice
        avfilter
        avformat
        avutil
        postproc
        swresample
        swscale
        ${android-lib}
        ${jnigraphics-lib}
        ${log-lib}
)