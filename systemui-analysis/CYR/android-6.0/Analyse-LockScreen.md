## 锁屏分析文档
***
#### 概述
  - 在SystemUI目录下，Android.mk可以看出来两个模块，SystemUI编译需要依赖Keyguard模块，修改Keyguard模块后，编译此模块不会产生相应的apk而是要在继续编译SystemUI模块的代码产生的SystemUI.apk放到手机里才会起作用，也就是说锁屏不会产生一个单独的apk文件，而是由SystemUI.apk包含了现有手机的锁屏模块.
  - 锁屏分两个部分: 锁屏界面为Keyguard 解锁界面: Bouncer.
#### 主要涉及的类
```
## SystemUI/部分
./src/com/android/systemui/keyguard/KeyguardService.java
./src/com/android/systemui/keyguard/KeyguardViewMediator.java
./src/com/android/systemui/statusbar/KeyguardIndicationController.java
./src/com/android/systemui/statusbar/phone/KeyguardBottomAreaView.java
./src/com/android/systemui/statusbar/phone/KeyguardClockPositionAlgorithm.java
./src/com/android/systemui/statusbar/phone/KeyguardBouncer.java
./src/com/android/systemui/statusbar/phone/KeyguardStatusBarView.java
./src/com/android/systemui/statusbar/phone/KeyguardPreviewContainer.java
./src/com/android/systemui/statusbar/phone/KeyguardAffordanceHelper.java
./src/com/android/systemui/statusbar/phone/KeyguardIndicationTextView.java
./src/com/android/systemui/statusbar/KeyguardAffordanceView.java
./src/com/android/systemui/statusbar/policy/KeyguardUserSwitcherScrim.java
./src/com/android/systemui/statusbar/policy/KeyguardMonitor.java
./src/com/android/systemui/statusbar/policy/KeyguardUserSwitcher.java
./res/drawable/keyguard_overflow_number_background.xml
./res/layout/keyguard_user_switcher_item.xml
./res/layout/keyguard_user_switcher.xml
./res/layout/keyguard_bottom_area.xml
./res/layout/keyguard_status_bar.xml
## server/部分
./core/java/com/android/server/policy/keyguard
./core/java/com/android/server/policy/keyguard/KeyguardServiceWrapper.java
./core/java/com/android/server/policy/keyguard/KeyguardStateMonitor.java
./core/java/com/android/server/policy/keyguard/KeyguardServiceDelegate.java
./core/java/com/android/server/wm/KeyguardDisableHandler.java
## Keyguard/部分
./src/com/android/keyguard/ObscureSpeechDelegate.java
./src/com/android/keyguard/SecurityMessageDisplay.java
./src/com/android/keyguard/KeyguardSecurityView.java
./src/com/android/keyguard/EmergencyCarrierArea.java
./src/com/android/keyguard/KeyguardSecurityContainer.java
./src/com/android/keyguard/KeyguardSecurityModel.java
./src/com/android/keyguard/NumPadKey.java
./src/com/android/keyguard/AlphaOptimizedImageButton.java
./src/com/android/keyguard/KeyguardMessageArea.java
./src/com/android/keyguard/KeyguardSecurityViewFlipper.java
./src/com/android/keyguard/KeyguardAbsKeyInputView.java
./src/com/android/keyguard/KeyguardPasswordView.java
./src/com/android/keyguard/KeyguardHostView.java
./src/com/android/keyguard/AlphaOptimizedRelativeLayout.java
./src/com/android/keyguard/KeyguardPatternView.java
./src/com/android/keyguard/AlphaOptimizedLinearLayout.java
./src/com/android/keyguard/KeyguardDisplayManager.java
./src/com/android/keyguard/CarrierText.java
./src/com/android/keyguard/LiftToActivateListener.java
./src/com/android/keyguard/KeyguardPINView.java
./src/com/android/keyguard/EmergencyButton.java
./src/com/android/keyguard/KeyguardStatusView.java
./src/com/android/keyguard/KeyguardPinBasedInputView.java
./src/com/android/keyguard/KeyguardSecurityCallback.java
./src/com/android/keyguard/ViewMediatorCallback.java
./src/com/android/keyguard/KeyguardSimPukView.java
./src/com/android/keyguard/KeyguardConstants.java
./src/com/android/keyguard/KeyguardSimPinView.java
./src/com/android/keyguard/PasswordTextView.java
./src/com/android/keyguard/KeyguardUpdateMonitor.java
./src/com/android/keyguard/KeyguardUpdateMonitorCallback.java
```
#### 主要类和布局解释
***
![锁屏界面](https://github.com/caoyongren/Document/blob/master/systemui-analysis/CYR/icon/lockscreen.png)
  - 针对keyguard_button_area三个按钮
  - packages/SystemUI/src/com/android/systemui/statusbar/phone/KeyguardBottomAreaView.java
```
    public void onClick(View v) {
        if (v == mCameraImageView) {
            launchCamera();//launch camera
        } else if (v == mLeftAffordanceView) {
            launchLeftAffordance();
        } if (v == mLockIcon) {
            if (!mAccessibilityController.isAccessibilityEnabled()) {
                handleTrustCircleClick();
            } else {
                mPhoneStatusBar.animateCollapsePanels(
                        CommandQueue.FLAG_EXCLUDE_NONE, true /* force */);
            }
        }
    }
```
  - PatternUnlockScreen.java类        图案开锁界面 
  - SimUnlockScreen.java 类           PIN开锁界面
  - PasswordUnlockScreen.java类       密码开锁界面
  - AccountUnlockScreen.java类        Google账户开锁界面
  -  KeyguardUpdateMonitor.java       ## 功能：该类的主要功能就是根据监视系统状态值的改变(例如：时间、SIM卡状态、电池电量;使用广播监听)，根据这种状态值的改变回调监听了该状态信息的对象实例.     它是来处理锁屏更新操作的类，KeyguardViewMediator.java等对于锁屏更新的额相关处理都是在这里面进行的操作。
  - KeyguardViewMediator.java         ## 该类是唯一实现了KeyguardUpdateMonitorCallback的类.该类的初始化是在PolicyWindowManager的构造函数中创建的.  此类是在SystemUI中做统一调度的，也就是像我们长熟悉的熄屏，亮屏，锁屏等的处理都是在这里面的做的，它是一个对Keyguard的调度者.
  - GlobalActions.java                #全局行为，这段代码就是处理锁屏界面长按Power键弹出的Dialog。关于静音模式/飞行模式和关机的。
  - IconUtilities.java                #图标工具，图片处理的工具类，提供了一个drawable转bitmap的方法，还有个绘制bitmap按下的方法.   
  - KeyguardHostView.java             #继承至FrameLayout，该ViewGroup作为顶层View，作为WindowManager的装饰对象添加至窗口。
  - KeyguardDisplayManager.java       #包装了WindowManager功能了，提供了添加、删除锁屏界面的功能。
  - StatusBarKeyguardViewManager      #Manages creating, showing, hiding and resetting the keyguard within the status bar.
  - KeyguardPatternView.java          #为LockView和UnLockView的载体，用来控制显示LockView还是UnLockView界面
  - KeyguardUpdateMonitorCallback.java ##作为更新之后的回调类，当我们跟新一些状态之后，还需要更新之后反馈一些状态时就会需要用到此类. KeyguardUpdateMonitorCallback.java当Keyguard和SystemUI中有需要回调的类，就需要先注册此Callback然后再有具体实现。
  - 
















