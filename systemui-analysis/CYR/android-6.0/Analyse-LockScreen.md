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




















