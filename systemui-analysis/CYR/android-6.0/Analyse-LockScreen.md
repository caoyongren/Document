## 锁屏分析文档
***
#### 概述
  - 在SystemUI目录下，Android.mk可以看出来两个模块，SystemUI编译需要依赖Keyguard模块，修改Keyguard模块后，编译此模块不会产生相应的apk而是要在继续编译SystemUI模块的代码产生的SystemUI.apk放到手机里才会起作用，也就是说锁屏不会产生一个单独的apk文件，而是由SystemUI.apk包含了现有手机的锁屏模块。
