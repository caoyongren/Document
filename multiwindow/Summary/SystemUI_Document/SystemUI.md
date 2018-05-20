#### SystemUI中的关键类

  - 1. BaseStatusBar.java
    - 这是核心类, 是一个抽象类. 它的start()方法(继承自SystemUI), 
      在该方法中, 实现了状态栏启动的具体步骤.

  - 2. SystemUI.java
    - SystemUI被SystemUIService调用, SystemUIService继承Service,
      所以StatusBar也是一个Service.

  - 3. CommandQueue.Callbacks
    - BaseStatusBar实现CommandQueue.Callbacks接口
    - CommandQueue继承IStatusBar.Stub远程接口.
    - 内部接口 Callbacks.  (call back on the main thread)
    - IStatusBar.Stub 接口的方法通过 CommandQueue的Callbacks接口实现,
      所以BaseStatusBar又是IStatusBar.stub远程的实现类.

  - 4. 实现抽象类,BaseStatusBar.java的的两个子类.
    - 1. PhoneStatusBar.java
      - 
    - 2. TabletStatusBar.java

  - 5. 实现SystemUI的类
    - KeyguardViewMediator  RingtonePlayer   VolumeUI.
      SystemBars,  PowerUI  StorageNotification  Recents

***
  - 执行流程
    - 1. 屏幕顶端的状态栏.
    - 2. 底部的导航栏.
    - 3. 图片壁纸以及 RecentPanel(近期使用)
    - 4. SystemUI的范涛.
    - 5. SystemUI中有, TakeScreenshotService服务, 用于截屏.
    - 6. SystemUI提供PowerUI和RingtonePlayer两个服务. 后者则
         依托AutoService为其他应用程序提供播放铃声的功能.

***

### SystemUI 启动

  - SystemUIService是在SystemServer.java中被启动.
    mActivityManagerService.systemReady(new Runnable() { ~}
      startSystemUI(context);
  - SystemUIService的onCreate()调用SystemUIApplication的方法启动
    SystemUI相关组件, startServicesIfNeeded() , 启动各种Service,
    但是它们不是真正的Service, 是继承SystemUI.java这个抽象类, 复写
    start()方法.

  - UI组件的启动
    通过Handler发 mHandler.sendEmptyMessage消息, 分别调用
    了 StartService() 和 continueStartService()两个方法.
    然后, 通过回调 -- >  SystemBars的对象中;
    -- > 调到PhoneStatusBar的start()方法. 同时PhoneStatusBar在
    start()方法里面调用父类BaseStatusBar的start(); 
    NavigationBar 和 QuickSettiingPanel初始化后, 添加到UI中;

    SystemBars中关键代码:
      createStatusBarFromConfig() {
            ...
            mStatusBar = (BaseStatusBar) cls newInstance();
            ...
            mStatusBar.start();
      }
 
### NavigationBar 导航栏
  - PhoneStatusBar类 start()方法里面调用 addNavigationBar();
      -- > prepareNavigationBarView();  最后
      -- > WindowManager 调用 addView将 NavigationBarView添加到UI界面;
      - -> Back  Home  Recent.

      PhoneStatusBar类中 prepareNavigationBarView()


### StatusBar加图标AddIcons 

  - PhoneStatusBar继承BaseStatusBar, 实现了CommandQueue里的
    Callbacks接口, 管家方法 -- > addIcon()方法;

  - PhoneStatusBar的start()方法里面调用PhoneStatusBarPolicy的
    构造器.

  - StatusBarManager, StatusBarManagerService和CommandQueue的
    setIcon()方法.

  - CommandQueue对象回调PhoneStatusBar的AddIcon()方法;
    最后, 通过mStatusIconKeyguard.addView()方法, 将Icon显示
    到界面上.

  - 最后图标真的需要显示,StatusBarManager对象
    的setIcon()调用关系:
    
  - icon 排序
    - status_bar.xml
    - system_icon.xml
    - signal_cluster_view.xml


### QuickSettingPanel快捷开关

    - QSTileHost.java 
      - PhoneStatusBar中相关代码
        - //Set up the quick settings tile panel
        - mQSPanel.setHost(qsh);
        - mQSPanel.setTiles(qsh.getTiles());

        - mHeader.setQSPanel(mQSPanel);
        - qsh.setCallback(new QSTileHost.Callback(){})
        - 时序图.

### ScreenShot事件流程
  - interceptScreenshotChord() 在PhoneWindowManager.java中.
  - mHandler.postDelayed(mScreenshotRunnable, getScreenshotChordLongPressDelay());
  - 启动服务: TakeScreenshotService, GlobalScreenshot.java对象进行真正的截屏操作,
    mScreenshot.takeScreenshot(); 这也是多线程操作.
    - SurfaceControl -- > screenshot(){}


### App与SystemUI交互(通知消息)
  -App通过android.app.NotificationManager的Notify方法 调用NotificationManagerService的
   SystemService的enqueNotificationWithTag()方法,再进入到enqueueNotificationInternal()方法
  - 位置:
    - frameworks/base/core/java/android/app/NotificaitonManager.java
    - ...            /core/java/android/service/notification/NotificationListenerService.java
    - ...           /core/java/com/android/server/notification/NotificationManagerService.java
    - enqueueNotificationInternal()方法, -- > 限制只能提交 50个通知.
    - if (notification.icon != 0) -- > 判断icon是否为空, 若不为空 则有效.
    - 装完毕准备显示到状态栏, 之后就需要将相关的通知消息告诉所有监听者.
    - notifyPostedLocked()中调用到notifyPosted()方法;
    - ...  listener.onNotificationPosted(sbnHolder, rankUpdate);

    - app清除(Cancel)通知
      - 在NotificationManager之后, 经由NotificationManagerService处理和NotificationListenerService
        的子类, 最后的处理方法变成了onNotificationRemoved.

    -

  - NotificationListenerService在系统通知的消息传递过程中, 起到代理作用.
  - 继承NotificationListenerService的类作为client端.
  - 真正的server端则是NotificationManagerService, 负责整个Notification的控制
    和管理.  NotificationManagerService将处理之后的结果通过NotificationListenerService
    返回给client端, 最后各个client端(BaseStatusBar) 通过onNotificationPosted() 和 onNotificationRemoved()
    方法拿到系统通知状态的相关信息.
    
