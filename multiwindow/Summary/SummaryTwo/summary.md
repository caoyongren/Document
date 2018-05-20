#### 1.In the status bar to right-click show dialog, select to show or hide status bar.
  - 布局文件: right_button_menu_hide_show.xml
  - 主要代碼: PhoneStatusBar.java
    - 彈出: dialog  -- > showDialog(View view, int x, int y, int padding){}
    - hideText showText -- > sendBroadcast();
    - dissmissDialog() -- > 消失Dialog.
    - WindowManagerService.java
      - 收到: -- > 控制status_bar.
      - getRealScreenHeight() -- > get -- > status_bar height;

    - ActivityStackSupervisor.java
      - void setFocusedStack(ActivityRecord r, String reason)
      
***

#### 2.Adding header on microsoft office powerpoint to convenient to close or max or min powerpoint
  - 任何應用: 窗口都可在View中, 在View中獲取特殊處理;
  - PhoneWindow.java
    - HEAD的處理:
    - mDecorMW.mHeader.setVisibility(View.GONE);
    - mDecorMW.mHeader.setVisibility(View.VISIBLE);

***

#### 3.Get disk size same to file manager.
  - DeviceInfoSettings.java
    - getHardDiskMemory()
    - convertStorage(long size)

***

#### 4.Status bar disappear after lock or sleep screen.
  - PowerSourceActivity.java
    - sendBroadcast -- > hide status_bar.

***

#### 5.When shutdown and boot ,hide status bar.
  - SetupWizardActivity.java  -- > boot
  - FinishPagerActivity.java  -- > close
  - PowerSourceActivity.java
    - sendBroadcast()
  - PhoneWindowManager.java
    - 通過 控制 flag -- > 鼠標滑動 不會show.

***

#### 6.Lock screen function failure when the status bar is auto-hide.  AIDL
  - IStatusBar.aidl -- > void setStatusBarViewClicked();
  - IStatusBarService.aidl -- > void setStatusBarClicked();
  - CommandQueme.java -- > void setStatusBarViewClicked();
  - PhoneStatusBar.java -- > void setStatusBarViewClicked();

  - TvStatusBar.java -- > void setStatusBarViewClicked();
  - StatusBarManagerService.java -- > void setStatusBarClicked();

***

#### 7.Status bar can't remove apk icon when uninstall apk.
  - sendBroadcast()
  - removeLockedIcon(--);
  - removeLockedView(--);
  - removeApk(--);

***

#### 8.Display pc icon when ethernet state and display icon when have wifi or no wifi state. but when connect
or disconnect ethernet , icon can not change immediately.
  - WifiContentView.java
    - sendBroadcastWifiIcon(mBar);
    - STATUS_BAR_CHANGE_ICON
  - PhoneStausBar.java
    - change -- > icon.

***

#### 9.Calendar View.
  - CalendarDialog.java
    - mPopupwindowCalendarMonth.setText(---);
  - CalendarView.java
    - ROWS_TOTAL

***

#### 10.Modify notification layout to new api
  - 布局: status_bar_expanded.xml.

***

#### 11.use ContentProvider ; 
  - StatusBarContentProvider.java
  - StatusBarSqlDataBase.java

***

#### 12.The click-right dialog in the status bar, the current state of textView change to enabled.
  - hideText.setEnabled(false);
  - hideText.setTextColor(Color.parseColor(TEXT_COLOR_GRAY));

***

#### 13.Supporting change wifi icon when disconnect or connect ethnet.
  - PhoneStatusBar.java
    - isEthernet(ConnectivityManager cm)

***

#### 14.Support right click status bar to add choice 'phone mode '
  - ActivityKeyView.java

***

#### 15.Notification panel.
  - status_bar_no_notificatins.xml

#### 16.Notification  QSPanel.java

***

#### 17.Show tips on Status bar and tips in center.
  - 布局; status_bar_activity_hover_tips.xml
  - ActivityKeyView.java
    - PADDING_TIPS = 30;
  - lp.y = location[1] - dpy / 2 - view.getMeasuredHeight() + DIALOG_OFFSET_DIMENSIONS - padding;

***

#### 18.Isolation 隔離
  - IsolationModeTile.java
  - ProjectionTile.java

***

#### 19.when boot os, detection of ethernet then send broadcast.
  - WifiSettingsForSetupWizard.java
    - isEthernet(mCM)
      getActivity().sendBroadcast(intentEthnet);

***

#### 20.control open or close to Ethernet in Settings.
  - EthernetEnabler.java
  - Settings.Global.getInt(mContext.getContentResolver(), Settings.Global.ETHERNET_ON, 0);

  -
+        ConnectivityManager conManager = (ConnectivityManager)mContext.
+                                     getSystemService(Context.CONNECTIVITY_SERVICE);
+        if (isEthernet(conManager)) {
+            mSwitchBar.setChecked(true);
+        } else {
+            mSwitchBar.setChecked(false);
+        }

+    public static boolean isEthernet(ConnectivityManager cm) {
+        NetworkInfo networkINfo = cm.getActiveNetworkInfo();
+        if (networkINfo != null
+                && networkINfo.getRealType() == ConnectivityManager.TYPE_ETHERNET) {
+            return true;
+        }
+        return false;

***

#### 21.uninstall application.
  - UninstallAppProgress.java
  -. sendBroadUninstall()


#### 22.Update the top right corner of the window to 'max' 'close' 'min'
  - mw_decor.xml
  - mw_values.xml

***

