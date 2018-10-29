## SystemUI基础(aosp)
***
##### 该文档和其他文档有重复，属于整理的全部基础，便于宏观掌握
## 目录
  - 需求
    - 整体功能结构图	
      - 1. 通知栏
        - 1. wifi 飞行模式　手电筒　设置　..
      - 2. 状态栏
        - 时间　日历　信号 ..
    - 部分界面，功能描述
  - 代码结构
    - 源码结构和资源文件
      - com.android.systemui.statusbar
      - com.android.systemui.statusbar.phone
      - com.android.systemui.statusbar.policy
      - com.android.systemui.statusbar.stack
      - com.android.systemui.statusbar.tv
    - 通知栏，关键类和资源文件
      - SystemUI/src/com/android/systemui/statusbar/phone/PhoneStatusBar.java
      - base/packages/SystemUI/src/com/android/systemui/SystemUIService.java
      - frameworks/base/services/java/com/android/server/SystemServer.java

      - packages/SystemUI/src/com/android/systemui/statusbar/SystemBars.java
      - packages/SystemUI/src/com/android/systemui/statusbar/BaseStatusBar.java
      - packages/SystemUI/src/com/android/systemui/SystemUIApplication.java

      - base/packages/SystemUI/src/com/android/systemui/qs/QSPanel.java
      - src/com/android/systemui/statusbar/policy/BrightnessMirrorController.java
      - packages/SystemUI/src/com/android/systemui/recent/RecentsPanelView.java
      - SystemUI/src/com/android/systemui/statusbar/phone/NavigationBarView.java
      - packages/SystemUI/src/com/android/systemui/volume/VolumePanel.java

      - frameworks/base/packages/SystemUI/res/layout/super_status_bar.xml
      - frameworks/base/packages/SystemUI/res/layout/navigation_bar.xml
      - frameworks/base/packages/SystemUI/res/layout/system_icons.xml

      - frameworks/base/packages/SystemUI/res/layout/status_bar_expanded.xml
      - frameworks/base/packages/SystemUI/res/layout/status_bar_expanded_header.xml
      - frameworks/base/packages/SystemUI/res/layout/qs_panel.xml

    - SystemUI类图
      - ![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/systemui.png)
      - 状态的核心类是BaseStatusBar，这个类是一个抽象类。它的start()方法(继承自SystemUI)定义了状态栏启动时的具体步骤。
      - BaseStatusBar继承自SystemUI，SystemUI被SystemUIService调用，SystemUIService继承Service，所以StatuBar也是一个Service。
      - BaseStatusBar实现了CommandQueue.Callbacks接口，同时可以发现CommandQueue继承自IStatusBar.Stub远程接口，而IStatusBar.Stub接口的方法则通过CommandQueue的Callbacks接口实现，所以说BaseStatusBar又是IStatusBar.stub远程接口的实现类。　　
      - 我们说BaseStatusBar是抽象类，那么IStatusBar.stub接口中方法的实现该如何实现呢？很简单，我们可以通过StatuBar的两个子类：PhoneStatusBar和TabletStatusBar来实现。
      - 另外KeyguardViewMediator, RingtonePlayer, VolumeUI, SystemBars, PowerUI, StorageNotification, Recents 这几个UI组件也继承自 SystemUI
    - 执行流程
      - SystemUI是为用户提供系统级别的信息显示与交互的一套UI组件，因此它所实现的功能包罗万象:
      - 屏幕顶端的状态栏、
      - 底部的导航栏、
      - 图片壁纸以及RecentPanel（近期使用的APP列表）都属于SystemUI的范畴。
      - SystemUI中还有一个名为TakeScreenshotService的服务，用于在用户按下音量下键与电源键时进行截屏操作。
      - SystemUI还提供了PowerUI和RingtonePlayer两个服务。前者负责监控系统的剩余电量并在必要时为用户显示低电警告，后者则依托AudioService为向其他应用程序提供播放铃声的功能。
      - SystemUI大部分功能之间相互独立:
      - 比如RecentPanel、TakeScreenshotService等均是按需启动，并在完成其既定任务后退出，这与普通的Activity以及Service别无二致。
      - 比较特殊的是状态栏、导航栏等组件的启动方式。它们运行于一个称之为SystemUIService的一个Service之中。因此讨论状态栏与导航栏的启动过程其实就是SystemUIService的启动过程。
    - SystemUI启动
      - SystemUI常驻于系统，通过代码和结构分析，通过Service实现，关键Service：SystemUIService是在SystemServer.java中被启动的.
      - mActivityManagerService.systemReady(new Runnable() {...  startSystemUi(context)})
      - 然后，调用：mCallbacks.onNoService()；
      - 回到SystemBars 的对象中；这里调用关键方法：createStatusBarFromConfig()；
      - base/packages/SystemUI/res/values/config.xml
      - 这里面的取值：R.string.config_statusBarComponent实际就是PhoneStatusBar；
      - 这样就调到了PhoneStatusBar的start()方法。
      - 同时PhoneStatusBar在start()方法里面也调用了父类BaseStatusBar的start()；
      - 从这里一些列，将NavigationBar和QuickSettingPanel初始化好，添加到UI中。
      - SystemBar.java
        - createStatusBarFromConfig()
      - ![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/%E6%97%B6%E5%BA%8F%E5%9B%BE.png)
    - NavigationBar导航栏	
      - PhoneStatusBar类的start()方法里面调用 addNavigationBar() ; 
      - 流程如上图，第 9 步；然后此方法内调用 prepareNavigationBarView()；
      - 最后 WindowManager调addView将NavigationBarView添加到 UI 界面。
      - ![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/navigation.png)
  - RecentsActivity最近的APP	
    - 第三方APP访问Recent	
  - StatusBar加图标AddIcons	
    - Icons排列规则	
    - QuickSettingPanel快捷开关	
      - QSTitleHost.Java中定义快捷开关的各个标题createTiles()：代码如下
 ```
273     private QSTile<?> createTile(String tileSpec) {
274         if (tileSpec.equals("screenshot")) return new ScreenshotTile(this);
275         else if (tileSpec.equals("isolationmode")) return new IsolationModeTile(this);
276         else if (tileSpec.equals("projection")) return new ProjectionTile(this);
277         else if (tileSpec.equals("setting")) return new SettingTile(this);
278         else if (tileSpec.equals("wifi")) return new WifiTile(this);
279         else if (tileSpec.equals("bt")) return new BluetoothTile(this);
280         else if (tileSpec.equals("inversion")) return new ColorInversionTile(this);
281         else if (tileSpec.equals("cell")) return new CellularTile(this);
282         else if (tileSpec.equals("airplane")) return new AirplaneModeTile(this);
283         else if (tileSpec.equals("rotation")) return new RotationLockTile(this);
284         else if (tileSpec.equals("flashlight")) return new FlashlightTile(this);
285         else if (tileSpec.equals("location")) return new LocationTile(this);
286         else if (tileSpec.equals("cast")) return new CastTile(this);
287         else if (tileSpec.equals("hotspot")) return new HotspotTile(this);
288         else if (tileSpec.startsWith(IntentTile.PREFIX)) return IntentTile.create(this,tileSpec);
289         else throw new IllegalArgumentException("Bad tile spec: " + tileSpec);
290     }

 ```
  - 此方法在recreateTiles() 中调用，而recreateTiles() 又是在QSTitleHost的构造器中被调用，
QSTitleHost被构造好之后，为QSPanel对象配置QSTitleHost和标题；然后给顶部状态View设置QSPanel；
  - 最后为QSTitleHost设置CallBack回调方法。
```
1050         mQSPanel = (QSPanel) mStatusBarWindow.findViewById(R.id.quick_settings_panel);
1051         if (mQSPanel != null) {
1052             final QSTileHost qsh = new QSTileHost(mContext, this,
1053                     mBluetoothController, mLocationController, mRotationLockController,
1054                     mNetworkController, mZenModeController, mHotspotController,
1055                     mCastController, mFlashlightController,
1056                     mUserSwitcherController, mKeyguardMonitor,
1057                     mSecurityController, mScreenshotController, mSettingController);
1058             mQSPanel.setHost(qsh);
1059             mQSPanel.setTiles(qsh.getTiles());
1060             mBrightnessMirrorController = new BrightnessMirrorController(mStatusBarWindow);
1061             mQSPanel.setBrightnessMirror(mBrightnessMirrorController);
1062             qsh.setCallback(new QSTileHost.Callback() {
1063                 @Override
1064                 public void onTilesChanged() {
1065                     mQSPanel.setTiles(qsh.getTiles());
1066                 }
1067             });
1068         }

```
![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/qs.png)
  - ScreenShot事件流程
    - Android原生截屏是同时按下 电源键 和 音量减，开始截屏，
    - Android源码中对按键的捕获位于文件PhoneWindowManager.java (\frameworks\base\policy\src\com\android\internal\policy\impl) 中；我们可以在interceptKeyBeforeQueueing()中看到，按下截屏组合键之后，进入interceptScreenshotChord()方法
    - code
```
1243     private void interceptScreenshotChord() {
1244         if (mScreenshotChordEnabled
1245                 && mScreenshotChordVolumeDownKeyTriggered && mScreenshotChordPowerKeyTriggered
1246                 && !mScreenshotChordVolumeUpKeyTriggered) {
1247             final long now = SystemClock.uptimeMillis();
1248             if (now <= mScreenshotChordVolumeDownKeyTime + SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS
1249                     && now <= mScreenshotChordPowerKeyTime
1250                             + SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS) {
1251                 mScreenshotChordVolumeDownKeyConsumed = true;
1252                 cancelPendingPowerKeyAction();
1253 
1254                 mHandler.postDelayed(mScreenshotRunnable, getScreenshotChordLongPressDelay());
1255             }
1256         }
1257     }

```

![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/shortScreen.png)

  - APP与SystemUI交互	
    - APP通知到PhoneStatusBar	
      - App通过android.app.NotificationManager的Notify方法 调用NotificationManagerService的 SystemService的enqueNotificationWithTag()方法,再进入到enqueueNotificationInternal()方法
      - code
      - frameworks/base/core/java/android/app/NotificaitonManager.java
      - ...            /core/java/android/service/notification/NotificationListenerService.java
      - ...           /core/java/com/android/server/notification/NotificationManagerService.java
      - enqueueNotificationInternal()方法, -- > 限制只能提交 50个通知.
      - if (notification.icon != 0) -- > 判断icon是否为空, 若不为空 则有效.
      - 装完毕准备显示到状态栏, 之后就需要将相关的通知消息告诉所有监听者.
      - notifyPostedLocked()中调用到notifyPosted()方法;
      - ...  listener.onNotificationPosted(sbnHolder, rankUpdate);
    - APP清除(Cancel)通知	
      - 与"新增通知"类似的流程是"删除通知"，发起点在NotificationManager，之后经由NotificationManagerService处理和NotificationListenerService传递，最后到达各个继承自NotificationListenerService的子类中，只不过最后的处理方法变成了onNotificationRemoved
      - ![](https://github.com/openthos/systemui-analysis/blob/master/CYR/icon/cancelNotification.png)
      - 简单来看，NotificationListenerService在系统通知的消息传递过程中，起到了代理的作用。
      - 继承自NotificationListenerService的类作为client端，真正的server端则是NotificationManagerService，由它负责整个Notification的控制与管理。NotificationManagerService将处理之后的结果通过NotificationListenerService返回给client端，
      - 最终各个client端(BaseStatusBar)通过onNotificationPosted()和onNotificationRemoved()方法拿到系统通知状态变更的相关信息。
