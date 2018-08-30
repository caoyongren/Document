### 一月：January 
### 二月：February
### 三月：March
### 四月：April
### 五月：May 
### 六月：June 
### 七月：July
### 八月：August 
### 九月：September 
### 十月：October 
### 十一月：November
### 十二月：December

====================
### December - 24
  - Tracer.trace
  - mSet.size的原因
 
### December - 25
3166         Cursor cursor = mdbStatusBar.rawQuery("select * from status_bar_tb", null);
3167         //test
3168         if (cursor != null) {
3169             while (cursor.moveToNext()) {
3170                 Log.i("MasterMan: -->", "removeApk:" + packageName );
3171             }
3172             cursor.close();
3173         }

Lock the taskbar, open the menu icon, click on the power to exit, the taskbar does not display.
frameworks:base: fixed two bugs:
  1. when lock status bar, open shutdown ui and click close to exit shutdown ui, then status bar not display.
  2. unlock a status bar icon, repeat, next to icon is also unlock along with. 

164 -        //clear All
165 -        int countNum = 0;
166 -        for (int i = 0; i < mStatusBarActivities.getChildCount(); i ++) {
167 -            ActivityKeyView kbv = getActivityKeyView(i);
168 -            if (!kbv.getStatusbarActivity().mApkRun) {
169 -                countNum++;
170 -            }
171 -        }
172 -        if (countNum >= mStatusBarActivities.getChildCount() && mSet.size() == 0) {
173 -            mStatusBarActivities.removeAllViews();
174 -        }

### December - 26
  - 1298 自动睡眠时，唤醒后直接进入桌面，没有要求输入密码.
  - 给刘总绿色守护的初步方案。

  - Notepad（原920 Editor）全面UI调整.
  - Notification Manager重写
  - 全局”Open With”优化，Core App为默认打开方式，并在自定义列表中排最前.

SystemUI组计划
  - 1962 解锁一个任务栏的图标，旁边图标也跟着一起解锁. 
  - 1298 自动睡眠时，唤醒后直接进入桌面，没有要求输入密码.
    - 对比立即锁定后，休眠需要输入锁屏的密码。
    - 先从settings入手，之后在从systemUI分析解决。
    - packages/SystemUI/src/com/android/systemui/keyguard/KeyguardViewMediator.java  + 682
  - TaskManager实现基本UI和确认实现休眠的方式并尝试实现。
  - 使用搬瓦工 需要安装插件。

6955         for (ActivityManager.RunningAppProcessInfo process : manager.getRunningAppProcesses()) {
6956             if(process.processName.equals(processApp)) {
6957                 return true;
6958             }
6959         }


### December - 27
  - 休眠后进行锁定要按照设置中的时间来设置。
  - LOCK_SCREEN_LOCK_AFTER_TIMEOUT
  - 当你开机: mDelayedShowingSequence --> 变为 1
  - 然后当send broadcast后，　又增加一　同样是在该方法中cancelDoKeyguardLaterLocked()
  - 故需要分析出在哪里调用的。


  - 思路:
    - 1. 启动系统: 执行onScreenTurnedOn ---> 调用: cancelDoKeyguardLaterLocked() 
    --> doKeyguardLaterLocked() 根据时间判断--> 发送广播---> 然后又调用一次onScreenTurnedOn 
    --> 接受广播:

    现在只需要第二次调用的地方就可以了。　PhoneWindowManager

### December - 28
  - 1. 去掉同步锁好使。
  - 2. 测试: 去掉广播什么情况？ ( shi jian bu qi zuo yong)
  - 3. 确定陈工的代码什么情况。(去掉meiyou ying xiang wen ti cun zai)
  - 4. bu qu diao tong bu suo , zhi qu diao if shi : shan chu xian xiu mian qian de jie mian.
  - 5. 在自动锁屏设置时间后，休眠后按照时间执行锁屏，出现闪屏现象, 　然后进入锁屏。
  - Settings中数据进行初始化
    packages/SettingsProvider/res/values/defaults.xml
    packages/SettingsProvider/src/com/android/providers/settings/DatabaseHelper.java

  LOCK_SCREEN_LOCK_AFTER_TIMEOUT
  frameworks: base: Set when auto sleep to lock screen default immediately.

### December - 29 
  - 确认通知栏的最终效果图\
    - 1. information item 背景色 保持一直
    - 2. 打印高度移动
    - 4. 快捷去掉留白
    - 5. 删除用删除图标
----------------------------------------------------------
　　- 岗位职责情况:
  - 主要负责SystemUI组对于openthos 5.1和oreo 8.0的工作：
    - 1. 一月/二月/三月/四月是在董鹏组进行Systemui的工作
      - 主要工作:
        　　1.status bar 的显示/隐藏的控制和多窗口相关的一些问题。
        　 2.有关wifi的 连接/断开的一些bug.
          3.实现任务栏上关于应用图标的状态的变换，固定/最小化/获得焦点/
          4.完成fennec的编译运行和解决fennec的一些问题。
          5.解决通知栏和日历的一些问题。
          6.完成锁屏和休眠的基本功能。
     
    - 2. 五月/六月/七月/八月是带领罗俊欢工程师负责SystemUI全部工作。
　　　　　　- 主要工作:
          1. 解决自动休眠的一些问题(屏幕变暗/唤醒弹出关机界面)
          2. 调研android 7.1的Systemui的实现。
          3. 解决关于点击win键弹出StartupMenu的一些bug.
          4. StartupMenu关于优化。
          5. 解决邮件客户端中刘总的一些需求。
          6. 调研和解决开源hotoManager应用的实现.
          7. 修改任务栏的音量的ui界面和代码优化。
          8. 设置锁屏进入休眠和设置中的时间保持一直。
          9. 调研在标准模拟器上, 长按并弹出菜单。

    - 3. 九月/十月/十一月/十二月 主要负责多窗口学习和Oreo8.1/7.1SystemUi的实现
      - 主要工作
          1. 分析TaskBar实现.
          2. 实现7.1SystemUI的重新定制.(Statusbar/notification/)
          3. 实现Oreo 8.0的SystemUI的重新定制(statusBar/notification)
          4. PhotoManger的一些bug解决.
          5. 调研和实现文本编辑器的运行.
          6. 解决5.1 SystemUI　遗留的bugs.
---------------------------------------------------------------------------

### December - 30 -- 周六 去首都师范周冬琴陪的和接待蒙恩

### December - 31 -- 加班，带蒙恩逛逛清华

### 2018 年 01月01日
  - 回家

### 2018年01月02日
  - 参加王富强的婚礼.

### January　-- 03
  - notification_guts.xml中设置字体颜色。

### January -- 04
  - 完成通知ui
    - 通过改变样式进行改变ui
    - TextAppearance.Material.Notification.Title
      - 通知消息的标题
    - secondary_text_material_light.xml
      - 内容
    - notification_public_default.xml
      - 默认设置
    - 90% E6

### January - 05
  - TaskManager 问题记录
  - TaskManager实现基本UI和确认实现休眠的方式后并尝试实现-----------------80%
  - 2072 自动化过程中，系统界面停止运行，必现，log见附件---------------------0%
  - （预计到2018.1.14）Notepad（原920 Editor）全面UI调整
  - （预计到2018.1.14）Start Menu优化
  - （预计到2018.1.14）Notification Manager重写
  - （预计到2018.1.14）全局”Open With”优化，Core App为默认打开方式，并在自定义列表中排最前.

### January - 06 
  - daishu start.
  - 下棋

### January - 07
  - 完成移植优化, 后续让罗把activity改为dialog.(14号之后)
  - 全局”Open With”优化，Core App为默认打开方式，并在自定义列表中排最前. 需要刘总--> 确认需求。
  - 四万/两年
  - http://www.bkzzy.com/news/1709/16816.shtml

### January - 08
  - Notification Manager 需要优化一版。
  - StartupMenu之后还需要做:
    - 1. 去掉广播
    - 2. activity --> dialog (困难在 点击home键启动需要aidl)
  - 晚上邮件和刘总确认：
    1. 920编辑器　ui调整是否满意
    2. 通知栏ui重写是否满意
    3. 全局”Open With”优化，Core App为默认打开方式. 实现
      1. 禁用　手机模式和桌面模式
      2. 打开的窗口始终是一种尺寸的默认。
  - print job layout 280dp
  - 

### January - 09
  - 1. 完成notification 的优化。
  - 2. TaskManager的需求确认。

  1.  图标暂时先用这个： http://www.iconarchive.com/show/simple-icons-by-kxmylo/utilities-system-monitor-icon.html (√)
  2.  系统应用应天然排除而不列出. √ (系统应用不处理)
  3.  UI打开时默认列出所有运行中的非系统应用，自动刷新（间隔1秒？）　(定时刷新√)
  4.  在每个应用后面提供一个关闭功能（比如一个X按钮），整体界面上提供一键清理的功能. (手动休眠: 单个结束进程　上面的休眠按钮变为全部结束进程　√)
  5.  窗口有足够的空间放置所有UI元素，不需要再来个菜单了.(√去掉最右侧的菜单)

  6.  每个应用给出占用资源简述：内容参考现有的“设置”-“应用”-“正在运行”.
  7.  在任务列表的上方（或者左右分栏方式的左侧），给出实时系统概述（每秒刷新？）： CPU占用，内存占用，电池情况（内容和形式参考“设置”-“电源管理”-“电量详细信息”）.
  8. 绿色守护的“唤醒追踪及切断”功能值得重点研究，否则流氓应用不停杀死/启动的话，只会增加系统消耗。
　 9. 任务管理器为ROOT权限并常驻内存，无需请求权限.(×)
  10.  应用排查顾问当然也就不需要了.(×)
 
  - ComponentName　
  //实例化一个ComponentName需要两个参数，第一个参数是要启动应用的包名称，这个包名称是指清单文件中列出的应用的包名称.

### January -10
  - 完成移植
  - 移动系统app，需要清除internal (out/ ..../app中)
  - <1257620787@qq.com>;
  - build/target/product/core.mk
  - git apply --whitespace=error + patch 可以找到patch中的空行。
  - startupMenu移植:
    - 1. res/文件移植--> 去掉重复
    - 2. src/移植--> 修改包名
    - 3. AndroidManifest/ 修改
    - 4. PhoneStatusBar 和　PhoneWindowManager修改
    - 5. core.mk中去掉 startupMenu 
    - 6. 去掉中间代码进行编译out/target/common/obj/APPS/SystemUI_intermediates
  - 碧玉养殖
  - 1. 不能光照
  - 2. 不能低温
  - 3. 可以多浇水。(三天浇一次水，一周彻底浇一次水)
    - 春秋是生长发育旺季，水量多些(每天)
  - 4. 碧玉的移植更加简单，只要有一片带有1厘米以上的茎的叶子，泡进水里也可以，插入土壤也可以，这样就可以重新移植一盆
  - 工作邮箱:
    - caoyongren@openthos.org /MasterMan00
  - m18410261910@163.com/ caoyongren00 /红旗邮件.
  - 以后用户名: Smaster  /sail

### January - 11
  - StartupMenu移植探索
  - 整理收藏
           mport android.view.KeyEvent;

　          NivagationOnKeyLinstener nivagationOnKeyLinstener = new NivagationOnKeyLinstener();
 　         mStartupMenu.setOnTouchListener(mEditTextTouchListener);
 　         mStartupMenu.setOnKeyListener(nivagationOnKeyLinstener);

    class NivagationOnKeyLinstener implements View.OnKeyListener {
 7         @Override
 766         public boolean onKey(View v, int keyCode, KeyEvent event) {
 767             switch (keyCode) {
 768                 case KeyEvent.KEYCODE_ENTER:
 769                 case KeyEvent.KEYCODE_NUMPAD_ENTER:
 770                     v.clearFocus();
 771                     String path = ((TextView) v).getText().toString();
 772                     for (int i = 0; i < path.length(); i++) {
 773                         if (path.charAt(i) != ' ') {
 774                             showSpaceFragment(path.substring(i, path.length()));
 775                             break;
 776                         }
 777                     }
 778                     return true;
 779                 case KeyEvent.KEYCODE_ESCAPE:
 780                     v.clearFocus();
 781                     return true;
 782             }
 783             return false;
 784         }
 785     }

  - onKeyEvent --> view的api

  - 亚马逊永久删除书籍
　　　　我的账户/管理我的内容和设备/我的内容/显示:个人文档/选中要删除的书目，永久删除。

### January - 12
  - PhoneStatusBarView中接收不到，　原因是　PhoneWindowManager可以进行拦截了onKeyEvent事件。
　　
  - repo sync --no-tags --no-clone-bundle --no-repo-verify
  
  - 对home键的监听和拦截；
  - OnKeyDown 方法被拦截；
  - 至于在PhoneWindowManager 怎么对OnKeyDown进行的拦截，不太清楚；？？？？
  - 通过PoneWindowManager 进行发送广播到 PhoneStatusBar可以实现弹出dialog.
  - 通过AIDL应该也可以实现。


### January - 13
  - 确定将来发展的方向；
  - android 本地编译配置 √
  - docker / repo / git 
  - frameworks 层的调用关系
  - app应用开发
  - 精通C++

### January - 14
  - 计划了一下
  - hollywood  ----> 显示黑客入侵的画面

### January - 15
  - 解决编辑器的crash 问题;
  - 2176 编辑器使用过程中，提示谷歌输入法停止运行，不易复现.
  - 2175 编辑器在快速输入时会出现漏字的问题，对比wps
  - 2177 编辑器菜单栏（文件、编辑、查找等）无法连续切换，在打开一个后，需点击文档空白处关闭，然后才能打开另外一个.

  6.  每个应用给出占用资源简述：内容参考现有的“设置”-“应用”-“正在运行”.
  7.  在任务列表的上方（或者左右分栏方式的左侧），给出实时系统概述（每秒刷新？）： CPU占用，内存占用，电池情况（内容和形式参考“设置”-“电源管理”-“电量详细信息”）.
  8. 绿色守护的“唤醒追踪及切断”功能值得重点研究，否则流氓应用不停杀死/启动的话，只会增加系统消耗。
  - 作为管理者，首先自己要把所有的事情想清楚　想明白；
  - 安装了软件: texmaker

### January - 16
  - 关于连续输入，　出现漏字问题；
    - 入手点: input.js  keyboard.js
  - 修改了需要编译
  - ubuntu上的终端游戏:http://www.freebuf.com/articles/others-articles/124743.html
  - 组合检索: grep libcutils -in `ls */Android.mk` //检索libcutils 在Android.mk中。
  - log:
    - signal 11 code 128 (SI_KERMEL), fault addr 0x0  //寻址错误
  - jni中有表格: java <--> c对应
  - system/core/libcutils
  - 搜狗拼音--
    Error:Execution failed for task ':app:ndkBuild'.
> A problem occurred starting process 'command '/home/matthew/Android/Sdk/ndk-bundle/ndk-build.cmd''
  - 解决:
    task ndkBuild(type: Exec) {
    def ndkDir = project.plugins.findPlugin('com.android.application').sdkHandler.getNdkFolder()
    commandLine "$ndkDir/ndk-build", '-C', 'src/main/jni',
            "NDK_OUT=$buildDir/intermediates/ndk/obj",
            "NDK_APP_DST_DIR=$buildDir/intermediates/ndk/libs/\$(TARGET_ARCH_ABI)"
    }
   - 是ndk-build 而不是ndk-build.cmd(这是windows)
  - ls -lrt //时间升序
  - ls -lt //时间降序

### January - 17
  - git branch -a //查看所有分支
  - git pull origin(远程仓库)　branch(远程分之)
  - vim .git/config //查看远程仓库origin
  
### January - 18
  - 任务管理器的新的需求.
    - 已经休眠的应用：　已经被休眠掉(不存在休眠列表)－－> 只显示休眠掉的(手动/自动)
    - 正在运行的应用必定出现在三个栏目之一。
    - 这是一个简单的应用程序显示在每个频率状态下的CPU花费的时间。
    - 这可能是一个有用的工具，在电池问题诊断或调整您的超频设置。
    - ubuntu clean deb
      sudo du -h /var/cache/apt/archives/
      sudo　apt-get autoremove
      sudo　apt-get autoclean
      sudo apt-get purge

  - BatteryManager.java
  - ActivityManager.java
  - 查看磁盘分区信息
    - fdisk /dev/sda
　　- 查找view /id
  - ./hierarchyviewer
  - 然后　adb 连接

### January - 19
  - 分析如何获取　cpu 电池信息。
  - 安装win10系统
    - 出现不能加载efi //解决: 将优盘启动项移动到第一位。
  - 点量分析
    - services/core/java/com/android/server/am/BatteryStatsService.java
    - PowerProfile.java

-------
packages/apps/Settings/src/com/android/settings/fuelgauge/PowerUsageSummary.java

packages/apps/Settings/src/com/android/settings/fuelgauge/PowerUsageDetail.java

packages/apps/Settings/src/com/android/settings/fuelgauge/BatterySipper.java

frameworks/base/core/java/android/os/BatteryStats.java

frameworks/base/core/java/com/android/internal/os/BatteryStatsImpl.java

frameworks/base/core/java/com/android/internal/os/ProcessStats.java

frameworks/base/core/java/com/android/internal/os/PowerProfile.java

frameworks/base/services/java/com/android/server/am/BatteryStatsService.java

processAppUsage(SparseArray<UserHandle> asUsers)

### January - 20
  - 去首都师范
  - 相约星期二看完

### January - 21
  - 系统盘
  - 打网球
  - 分析获取点量

### January -22
  - 获取电量信息。
  - 设置中内存获取涉及的类:
    - RunningProcessesView.java  //mSize
    - RunningState.java  //updateSize
    - ManagedServiceSettings.java  //vh.name.setText();

  - Error:Execution failed for task ':app:compileDebugNdk'.
> Error: Flag android.useDeprecatedNdk is no longer supported and will be removed in the next version of Android Studio.  Please switch to a supported build system.
  Consider using CMake or ndk-build integration. For more information, go to:
   https://d.android.com/r/studio-ui/add-native-code.html#ndkCompile
   To get started, you can use the sample ndk-build script the Android
   plugin generated for you at:
   /media/matthew/Android-studio-work/android-GT/app/build/intermediates/ndk/debug/Android.mk
  Alternatively, you can use the experimental plugin:
   https://developer.android.com/r/tools/experimental-plugin.html
  To continue using the deprecated NDK compile for another 60 days, set 
  android.deprecatedNdkCompileLease=1516588891456 in gradle.properties

  1.  界面需要整理一下，现在的tab太大，整体配色应改成浅色背景深色文字，tab栏有明确示意可以新建（均参考chrome）
  2.  菜单反应不太灵敏
  3.  限制只能横屏启动，默认尺寸屏幕2/3
  4.  窗口调整大小时，默认编辑边界（浅色竖线）应相应移动
  5.  鼠标左键拖动选中文本，右键拷贝粘贴撤销重做等功能需要实现
  6.  应用ID为 OTOTextEditor 中文 “文本编辑器” 英文 ”Text Editor”

  --
Error:Execution failed for task ':app:transformResourcesWithMergeJavaResForDebug'.
> More than one file was found with OS independent path 'res/drawable-hdpi/sym_keyboard_feedback_delete.png'
  - ctrl + alt + q
  - Smaster 0821Sqingqing

### January - 23
  - 获取cpu信息
  - 低版本android studio 打开高版本的android studio.
  - 18210026210@163.com　客户端密码0821Sqingqing
  - 复制电脑里的文件到设备
    - adb push ~/sr.mp4 /sdcard/
  - linux上进程管理的指令
    - ps
      - ps -a 列出所有运行中/激活进程
      - ps -ef | grep -列出需要进程
    - ps -aux -显示进程信息，包含user pid %cpu %mem
  - pstree
  - nice 可以根据优先级查看.
  - kill
  - w
  - who
  - jobs  后台进程
  - 地址运算符: & 给出变量的地址
    - 后跟一个变量名时，　＆给出变量的地址。
  - 地址运算符: * 给出存储在指针指向地址上的值。

### January - 24
  - 获取cpu信息
  - 理解反射原理
  - core/java/com/android/internal/os/BatteryStatsHelper.java
  在优化Android启动过程时，同事给出一种打印出调用栈的函数。分享一下

    java.util.Map<Thread, StackTraceElement[]> ts = Thread.getAllStackTraces();   
    StackTraceElement[] ste = ts.get(Thread.currentThread());   
    for (StackTraceElement s : ste) {   
        android.util.Slog.e("SS     ", s.toString()); //这个是android自带的，如果没有，用其他的打印函数一样   
    }

### January - 25
  - 编辑器
    - 6.  应用ID为 OTOTextEditor 中文 “文本编辑器” 英文 ”Text Editor”
    - 4.  窗口调整大小时，默认编辑边界（浅色竖线）应相应移动
    - 3.  限制只能横屏启动，默认尺寸屏幕2/3
    - 1.  界面需要整理一下，现在的tab太大，整体配色应改成浅色背景深色文字，tab栏有明确示意可以新建（均参考chrome）
  - 等TaskManager cpu信息添加上进行, 给刘总发邮件确认。
  - applicationId 改变－－> apk的包名改变
  - team@openthos.org
  - lf@openthos.org
  - yuchen@mail.tsinghua.edu.cn
  - PATCH
  - Daily Report 
  - bigandroid
  - 密码: openthos.
  - android-2.2_r1.2

### January -26
  - 阅读深入理解一

### January -27
  - Java的native函数和总结　举例: mediaScanner的JNI实现
    - 1. 加载对应的JNI库。
    - 2. 声明由关键字native修饰的函数。

  - 当java层调用native_init函数对应的JNI函数android_media_MediaScanner_native_init.
    - JNI层函数的名字android_media_MediaScanner_native_init.
  - 当Java层调用native_init函数时，它会从对应的JNI库中寻找
    Java_android_media_Media-Scanner_native_init 函数，如果没有，就会报错。
　　　　如果找到，则会为这个native_init和Java_android_media_Media_Scanner_native_linit
        建立一个关联关系，其实就是保存JNI函数的函数指针。以后调用native_init函数时，直接
　　　　　   使用这个函数指针就可以了
  - 深入理解init.c
    - ./system/core/init/init.c
  - init是一个进程，确切的说，它是Linux系统中用户空间的寄一个进程。
    - init负责创建系统中的几个关键进程，尤其是zygote, 
    - init提供了一个property service属性服务来管理它们。
  - zygnote分析
    - zygnote本身是一个Native的应用程序，　与驱动/内核等均无关系。
    - zygnote叫做: app_process这个名字在Android.mk文件中指定。
    - ps可以看到zygote
    - CallStaicVoidMethod最终将调用com.android.intenal.os.ZygoteInit的main函数
    - 进入java的世界
  - 大学同学聚会　粗粮人家　--东直门

### January - 28
  - 去表哥家

### January - 29
  - EditorText 问题解决
  - <module fileurl="file://$PROJECT_DIR$/TextEditor.iml" filepath="$PROJECT_DIR$/TextEditor.iml" />
  - <module fileurl="file://$PROJECT_DIR$/app/app.iml" filepath="$PROJECT_DIR$/app/app.iml" />
  - <module fileurl="file://$PROJECT_DIR$/common/common.iml" filepath="$PROJECT_DIR$/common/common.iml" />
  -  <module fileurl="file://$PROJECT_DIR$/file_explorer/file_explorer.iml" filepath="$PROJECT_DIR$/file_explorer/file_explorer.iml" />
  - <module fileurl="file://$PROJECT_DIR$/styles/styles.iml" filepath="$PROJECT_DIR$/styles/styles.iml" /> 
  - <module fileurl="file://$PROJECT_DIR$/tools/tools.iml" filepath="$PROJECT_DIR$/tools/tools.iml" />
  app/build.gradle
  build.gradle
  common/build.gradle
  common/src/main/res/drawable-v21/ic_close_btn.xml
  common/src/main/res/drawable/abc_ic_clear_material.xml
  file_explorer/build.gradle
  gradle/wrapper/gradle-wrapper.properties
  styles/build.gradle

  - 签名-密码
　　- 密码: openthos
  - 添加后， 第二个进行选择openthos_key

### January - 30
  - version code 
    - 版本号随日期改变，但是version code也需要变动。
  - 选择文本，右键弹出dialog
  - webStorm --> /usr/local/bin/webstorm

加入unsigned 关键字 表名不含负数。
比如 int  范围-32768~32767
而 unsigned int  范围 0~65535

extern : 类似import

### January - 31
  - 完成　EditorText和FM的交互
  - 默认字体调整为18
  - 打开/保存/另存为　实现 File Manager
    - 方案一: 将module中的file_explore进行改写；

### February - 01
  - 将系统安装到 移动硬盘
  - 无法将grub-amd64-signed软件包安装到/target/中.
    - 安装ubuntu系统有两种方式;
    - 选择非efi的方式。

  - android-2.2_r1.
  - 把一个工程项目以module的形式导入；

### February - 02
  - 将FM作为Module导入工程
    - 1. 修改app工程结构作为module的结构
    - 2. android studio中导入
    - 3. 修改build.gradle 
      - apply plugin: 'com.android.library'
    - 4. 修改module的sdk版本
    - 5. 修改代码
    - 6. 应用；

### February - 03
  - 和庞双 小烨　聚聚
  - 第一次去密室逃脱

### February - 04
  - 看: 归来仍是少年和洗衣服
  - 学小程序

### February - 05
  - 将FileManager 应用到TextEditor.
  - 1. ./gradlew -v 来查看项目所用的gradle版本
  - 2. ./gradlew clean 去除依赖的包
  - 3. ./gradlew build 编译生成apk
  - 4. ./gradlew assembleDebug 编译生成debug包
  - 5. ./gradow assembleRelease 编译并打开Release的包
    - 错误: 为什么出现Unsupported major.minor version 52.0？
    - 原因: gradlew使用的jdk版本和studio中的不一致
    - 解决: 在gradle.properties中添加
      - org.gradle.java.home=/Applications/Android Studio.app/Contents/jre/jdk/Contents/Home(studio中的)
  - 6. 同方年会

### February - 06
  - org.gradle.java.home=/home/matthew/android-studio/jre
  - 红酒: 179两瓶/72一瓶
  - 政治经济学的主要研究对象是国家或君主如何增进国家财富、保障国民生活等问题
    - https://www.zhihu.com/question/19668789

### Frebruary - 07
  - 分析FM的代码

### Frebruary - 08
  - 看java代码

### Frebruary - 09
  - 洗羽绒服
  - 收拾回家的东西

--------------------------------End
  
　
　　




























































