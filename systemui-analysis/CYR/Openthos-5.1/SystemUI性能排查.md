### SystemUI性能分析
***
**对于SystemUI占用过多资源，且一直不停刷新问题，针对性的排查：**

#### 1. status bar上input icon切换
```
1170             for (InputMethodInfo im : inputMethodList) { 
1171                 if (im.getId().equals(currentInputMethodId)) {
1172                     if (currentInputMethodId.equals(SYSTEM_INPUT_METHOD_ID)) {
1173                         mInputButton.setImageResource(
1174                                         R.drawable.statusbar_switch_input_method);
1175                     } else if (im.getId().equals(
1176                                ApplicationInfo.APPNAME_ANDROID_INPUTMETHOD_PINYIN)) {
1177                         mInputButton.setImageResource(
1178                                         R.drawable.statusbar_switch_input_method_pinyin);
1179                     } else {
1180                         Drawable inputMethodIcon = im.loadIcon(pm);
1181                         mInputButton.setImageDrawable(inputMethodIcon);
1182                     }
1183                 }
1184             }
//这个循环一直再运行
```

#### 2. 电池电量和wifi的变化
```
 949                 if (charging || pluggedIn || level == 0) {
 950                     mBatteryButton.setImageDrawable(mContext.getDrawable(
 951                             R.drawable.statusbar_battery));
 952                 } else if (level >= BATTERY_HIGH) {
 953                     mBatteryButton.setImageDrawable(mContext.getDrawable(
 954                             R.drawable.statusbar_battery_high));
 955                 } else if (level >= BATTERY_LOW && level <= BATTERY_HIGH) {
 956                     mBatteryButton.setImageDrawable(mContext.getDrawable(
 957                             R.drawable.ic_notice_battery_half));
 958                 } else {
 959                     mBatteryButton.setImageDrawable(mContext.getDrawable(
 960                             R.drawable.statusbar_battery_low));
 961                 }
//电量发生变化，这里就一直接收，然后 setImageDrawable
//wifi的情况其实也是一样
```

#### 3. 时间的变化
  - 一分钟有一次刷新，应该属于正常，如果有更好的思路就优化一版！
  
#### 另一个问题: 休眠
```
2960     private void waitForAWhile() {
2961         try {
2962             Thread.sleep(WAIT_INTERVAL);
2963         } catch (Exception e) {
2964             e.printStackTrace();
2965         }
2966     }
//在排查代码中，发现存在这个问题，有被调用，目前不知道原因，在调研；
```

***
*目前, 暂时调研排查这个几个地方，下一步进行针对问题处理！　
做过测试，将①注释掉，GPU检测状态基本不再有蓝色竖条的滚动，②③的影响GPU变化视觉上很小。
基本可以确定: ①是主要问题*



  
  
  
