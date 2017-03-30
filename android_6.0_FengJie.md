## Android 窗口管理服务WindowManagerService切换Activity窗口的过程分析
  - ActivityStack.startActivityLocked 方法进行切换操作，是否切换根据情况来定。

    if (!r.mLaunchTaskBehind && (taskForIdLocked(taskId) == null || newTask)) {// 最后的task 和 AMS 正在 进行任务。
          insertTaskAtTop(rTask);
          mWindowManager.moveTaskToTop(taskId);
    }
  - 在startActivityLocked的方法中 有较多的关于Activity栈的处理。

## AMS 调用架构
  - 代理模式
    - 代理类 和 被代理类共同实现一个类： IActivityManager.java 接口类
    - 代理类： ActivityManagerProxy 被代理类： ActivityManagerNative(操作)
    - Client : ActivityManager.java

  ![ams -](ams.png)