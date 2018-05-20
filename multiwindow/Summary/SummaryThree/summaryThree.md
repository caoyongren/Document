#### 1. 替换fennec的初始化文件压缩包
  - fennec_initdata.tar.bz2

***

#### 2.void popup shut down gui when wake up screen.
  - WindowManagerPolicy.java
  - PhoneWindowManager.java
  - PowerManagerService.java
    - WindowManagerPolicy.java接口中声明方法: setSleepingFlag(boolean status);
    - PhoneWindowManager extends WindowManagerPolicy.java
    - 在PowerManagerService中可以找到 WindowManagerPolicy的对象.
    - PowerManagerService的 wakeUpNoUpdateLocked(long eventTime, int uid) 方法中 case: WAKEFULNESS_ASLEEP
    - mPolicy.setSleepingFlag(true);

***

#### 3.根据包名进行过滤
  - ApplicationInfo.java

***

#### 4.Change the background notification icon alpha
  - PhoneStatusBar.java
  - mNotification.getBackground().setAlpha(BACKGROUND_ALPHA_HUNDRED); 

***

#### 5.Show two dialogs in status bar and when click status bar, dialog can not dissmiss.
  - ActivityKeyView.java
  - PhoneStatusBar.java
    - dismissDialog();
    - 获取; PhoneStatusBar的对象;
      - ActivityKeyView中
        public void setPhoneStatusBar(PhoneStatusBar phoneBar){
            mPhoneBar = phoneBar;
        }
    - View对象 -- > akv.setPhoneStatusBar(this);

***

#### 6. About remove stack . 关于应用关闭;
  - ActivityManagerService.java
  - 方法:closeActivity(int stackId, boolean individual, int activities) {}
  - 判断StartupMenu:   activityStack.isStartupMenuStack()
  - 移除屏幕外;

***

####
