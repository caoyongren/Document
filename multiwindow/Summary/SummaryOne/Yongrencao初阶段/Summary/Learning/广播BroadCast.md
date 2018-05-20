###<center>发送广播
***
######&ensp;&ensp;简单接收：
**首先介绍：广播的注册分为：静态注册和动态注册。
静态注册：
例子:**

    <receiver
            android:name=".util.MySQLReceiver"
            android:enabled="true">
            <intent-filter>
                <action android:name="com.android.documentsui.SQLITE_CHANGE" />
                <action android:name="com.android.action.PACKAGE_SEND"/>
            </intent-filter>
    </receiver>
**动态注册：**

    IntentFilter filter = new IntentFilter();
    filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
    filter.addAction(ACTION_DEMO);
    filter.addAction("com.android.documentsui.util.startmenudialog");
    filter.addAction("com.android.systemui.activitykeyview");
    context.registerReceiverAsUser(mBroadcastReceiver, UserHandle.ALL,       filter,null, null);
**发送广播：**
######例如：
    public void sendBroadcastMethod() {
        Intent intent = new Intent();
        intent.putExtra("keyAddInfo",mActivity.mPkgName);
        intent.setAction("com.android.action.PACKAGE_SEND");
        mContext.sendBroadcast(intent);
    }
**接收广播**
######例如：
    if (intent.getAction().equals("com.android.action.PACKAGE_SEND")) {
           //执行操作
        }
***