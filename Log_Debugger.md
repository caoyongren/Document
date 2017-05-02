### 常规启动模拟器取log

***

  - 启动模拟器（我用的qume）

  - adb kill-server //用于杀死其他进程。

  - adb logcat > debug.log  //建一个日志文件

  - 然后另起一个终端：
    
    tail -f debug.log

  - 这样你操作模拟器，就可以在debug.log中看到日志信息。

***

### 远程取log

  - adb connect ip  //测试机的ip

  - adb logcat > debug.log

  - 另起一个终端 ： adb logcat | grep "DEBUG++" //引号中为检索的关键字

***

### 常用打log的方式：

  - Log.d(TAG,Log.getStackTraceString(new Throwable()));  //打印堆栈

***

### 测试apk 常用的 adb 指令

  - killall -9 adb  //杀死正在链接的adb

  - adb connect ip //要装的机器的ip

  - adb install ./..path../××.apk  //

***

[adb指令大全](!http://blog.csdn.net/janronehoo/article/details/6863772/%29)

***

#### 后期添加 c++  c 的取log测试的 技巧。
