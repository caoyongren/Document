## Openthos 8.1 和 Openthos 5.1 SystemUI的设计界面基本相同

[Openthos8.1待解决问题](https://github.com/openthos/systemui-analysis/blob/master/LJH/Openthos8.1/Openthos%208.1%20%E6%9C%AA%E8%A7%A3%E5%86%B3%E9%97%AE%E9%A2%98.md)

### 不同点
 - Openthos 8.1的任务栏以及通知栏现在都是自定义的
 - Openthos 8.1的SystemUI先采用的是以Dialog形式弹出，5.1时使用的是windowManage窗口形式弹出
 - 设计结构上，Openthos 8.1的开始菜单与任务栏的联系更加紧密，去除了5.1时通过广播通信的操作
 - View的展示上，Openthos 8.1的任务栏上多使用的是自定义View，避免了给View设置固定大小，View的大小由任务栏的高度自适应
 
### 目录
  - 开始菜单：com.android.systemui.startupmenu
  - 开始菜单以及任务栏上dialog：com.android.systemui.dialog
  - 开始菜单与任务栏启动公共交互类：com.android.systemui.startupmenu.utils.AppOperateManager
  
### 开始菜单

#### 设计方式
  - 采用dialog中加载自定义View的方式
  - 开始菜单的主体部分是StartupMenuView(com.android.systemui.startupmenu.StartupMenuView),
     弹出方式是在StartupMenuDialog（com.android.systemui.dialog.StartupMenuDialog）,
     启动位置是在OpenthosStatusBarView（com.android.systemui.statusbar.phone.OpenthosStatusBarView）.
  -  数据信息存储数据库SqliteOperateHelper(com.android.systemui.startupmenu.SqliteOperateHelper),此类主要是创建数据库，以及一些增删改查的方法。还有就是查询系统安装应用数据。本类的查询采用单线程池的方式，避免出现数据库死锁的问题
  - 右键菜单以及任务栏弹出的右键菜单类MenuDialog(com.android.systemui.dialog.MenuDialog)
  
#### 监听处理（同时适配鼠标左右键以及不支持鼠标左右键的时候）（com.android.systemui.startupmenu.AppAdapter）
  ```
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (MotionEvent.ACTION_DOWN == event.getAction()) {
                mDownX = (int) event.getRawX();
                mDownY = (int) event.getRawY(); ／／记录点击位置，方便长按事件时使用
                switch (event.getButtonState()) {
                    case MotionEvent.BUTTON_PRIMARY:
                        ／／无论是否支持鼠标右键都会触发的操作，此处不进行逻辑操作，放到onclick事件中进行
                        break;
                    case MotionEvent.BUTTON_SECONDARY:
                        ......
                        return true; //return true后不会再执行onLongClick和onClick监听
                }
            } 
            return false;
        }

        @Override
        public void onClick(View v) {
            ／／点击操作
        }

        @Override
        public boolean onLongClick(View v) {
            .....
            return true;   //return true后不会再执行onClick监听
        }
  ```

### 任务栏

#### 应用图标显示
 - 自定义View TaskBarButtonView(com.android.systemui.statusbar.view.TaskBarButtonView)
 - 新创建图标时需要传入应用的packageName，应用的具体信息通过AppOperateManager的getAppInfo（String）来获取。
 - [应用最小化以及其它操作触发改变任务栏的原理（changeStatusBarIcon）](https://github.com/openthos/multiwin-analysis/blob/master/multiwindow/lh/%E4%BB%BB%E5%8A%A1%E6%A0%8F%E9%9C%80%E6%B1%82.md)
 - 通知任务栏图标刷新
 ```
    //(com.android.systemui.statusbar.phone.StatusBar)
    @Override
    public void changeStatusBarIcon(int taskId, ComponentName cmp, boolean keep) {
        ／／taskId 打开或者关闭应用的id
        ／／cmp 打开或者获得焦点的应用的ComponentName，关闭应用时返回为null
        ／／keep true 应用打开或者获得焦点。false 应用关闭
        android.util.Log.i("ljh", "taskId " + taskId + " keep " + keep + " cmp" + cmp);
        if (!keep || cmp == null) {
            iconClose(taskId);
            return;
        }
        bindIconToTaskId(taskId, cmp); //创建图标
    }
 ```
 - 其他操作
   - 绑定图标
   ```
   public void bindIconToTaskId(int taskId, ComponentName componentName) {
        if (!canAdd(componentName.getPackageName())) {
            return;
        }
        if (mPrevTaskId != -1) {
            for (TaskBarIcon buttonView : mShowIcons.values()) {
                if (mPrevTaskId == buttonView.getTaskId()) {
                    buttonView.setFocusInApplications(false);
                }
            }
        }

        String packageName = componentName.getPackageName();
        TaskBarIcon buttonView = mShowIcons.get(packageName);
        if (buttonView == null) {
            buttonView = new TaskBarIcon(mContext, packageName);
            mActivityLayout.addView(buttonView);
            mShowIcons.put(packageName, buttonView);
        }

        buttonView.setTaskId(taskId);
        buttonView.setFocusInApplications(true);
        mPrevTaskId = taskId;
    }
   ``` 
   - 关闭应用
   ```
   public void closeApp(String packageName) {
        try {
            TaskBarIcon buttonView = mShowIcons.get(packageName);
            if (buttonView != null) {
                ActivityManager.getService().removeTask(buttonView.getTaskId());
            }
        } catch (Exception e) {
        }
    }
    ```
    - 固定到任务栏
    ```
    public void addToTaskbar(String packageName) {
        TaskBarIcon buttonView = mShowIcons.get(packageName);
        if (buttonView == null) {
            buttonView = new TaskBarIcon(mContext, packageName);
            mActivityLayout.addView(buttonView);
            mShowIcons.put(packageName, buttonView);
        }
        buttonView.locked();
    }
    ```
    - 从任务栏移除
    ```
    public void removeFromTaskbar(String packageName) {
        TaskBarIcon buttonView = mShowIcons.get(packageName);
        if (buttonView != null) {
            if (!buttonView.isRun()) {
                mActivityLayout.removeView(buttonView);
                mShowIcons.remove(packageName);
            }
            buttonView.unlocked();
        }
    }
    ```
 
#### 右侧快捷方式
  - 主要触发类（com.android.systemui.statusbar.phone.OpenthosStatusBarView）,布局文件（res/layout/openthos_status_bar）
  - 输入法 （com.android.systemui.dialog.InputMethodDialog）
  - 电池（com.android.systemui.dialog.BatteryDialog）
  - 音量（com.android.systemui.dialog.VolumeDialog）
  - wifi（com.android.systemui.dialog.WifiDialog）
  - 日期（com.android.systemui.dialog.CalendarDialog）
  
  ***
  
        //自动监听输入法改变任务栏上的图标
        
        //注册监听设置中数据库输入法的改变
        mContext.getContentResolver().registerContentObserver(
                Settings.Secure.getUriFor(Settings.Secure.DEFAULT_INPUT_METHOD),
                false,
                mInputMethodSettingsObserver,
                UserHandle.USER_ALL);

        mContext.getContentResolver().registerContentObserver(
                Settings.Secure.getUriFor(Settings.Secure.SELECTED_INPUT_METHOD_SUBTYPE),
                false,
                mInputMethodSettingsObserver,
                UserHandle.USER_ALL);
                
        private final ContentObserver mInputMethodSettingsObserver = new ContentObserver(mHandler) {
            @Override
            public void onChange(boolean selfChange) {
                if (mOpenthosStatusBarView != null) {
                    mOpenthosStatusBarView.updateInputMethodIcon();
                }
            }
        };
    
    ／／更新图标变化
    public void updateInputMethodIcon() {
        List<InputMethodInfo> inputMethodList = mInputMethodManager.getInputMethodList();
        String currentInputMethodId = Settings.Secure.getString(
                getContext().getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
        for (InputMethodInfo im : inputMethodList) {
            if (im.getId().equals(currentInputMethodId)) {
                if (currentInputMethodId.equals(SYSTEM_INPUT_METHOD_ID)) {//os input
                    mInputView.setImageResource(R.drawable.statusbar_switch_input_method);
                    return;
                } // other input methods;
                mInputView.setImageDrawable(im.loadIcon(getContext().getPackageManager()));
            }
        }
    }
  ***
 #### 应用其它操作方法
   - com.android.systemui.startupmenu.utils.AppOperateManager
     - 打开应用（openApplication）
     - 以手机模式运行（runPhoneMode）
     - 以桌面模式运行（runDesktopMode）
     - 固定到任务栏（addToTaskBar）
     - 解除固定 (removeFromTaskbar)
   - com.android.systemui.statusbar.view.TaskBarIcon
     - 启动应用或者重新获得焦点
     ```
     private void startRun() {
        try {
            IActivityManager am = ActivityManager.getService();
            if (isRun()) {
                am.setFocusedTask(mTaskId);
            } else {
                mOperateManager.openApplication(getAppInfo().getComponentName());
            }
            setFocusInApplications(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     ```

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
