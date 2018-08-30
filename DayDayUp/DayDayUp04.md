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

===================================
2018
### February - 26
  - TaskManager
  - TextEditor
    - 修改: 使用OtoFM
    - 增加: 右键弹出dialog执行复制/粘贴
    - 弹出的dialog带有阴影
    - 去掉边界线

### February - 27
  - TextEditor
    - 调研EditorText中文字选中　弹出右键菜单，复制 粘贴
    - 新的版本
    - bug: 显式启动到FM, 默认打开失效。
      - 猜测打开文件之后的刷新；

### February - 28
  - 实现TextEditor的文档
  - 分析选中右键弹出dialog的复制粘贴
  - FM分析回退功能；  

### March - 01
  - 将TextEditor的实现文档完成
    - 编辑栏的增加和关闭

### March - 02
  - 优化TextEditor
  - 分析选中区域在什么位置
    - (function() { }).call();
    - 自执行！
  -  在google中进行div的调试
    - 1. 点击左上角的手机icon
    - 2. 点击右侧的div，在左侧就显示块区域
    - 3. 小的项目，在左侧点击，在右侧也会显示code区域；
  - http://www.xuechebu.com
  - caoyongren00 18210026210
  - 学习证: L6703643

### March - 03
  - 去表哥家.
  - 找韦新杰
  - 区链块

### March - 04
  - 做科目习题
  - 打扫卫生
  - 实现第一个小程序

### March - 05
  -  恭喜您注册成功!登录用户名为: 372924199110193912
  - http://bj.122.gov.cn
  - caoyongen00
  - 1. 右键弹出dialog
  - 2. 系统级文件选择框;
    - android:sharedUserId="org.mozilla.fennec_root.sharedID"

任务:
  - 文本编辑器鼠标左键拖动选中文本，右键拷贝粘贴撤销重做等功能需要实现
  - 实现调用文件对话框，/data目录，显示详细视图
  - 突破口
    - 选中后顶部出现的菜单；


### March - 06
  - 分析选中后　弹出的复制　粘贴　怎么出现的
  - http://ieeexplore.ieee.org.sci-hub.io/document/8297302/
  - http://ieeexplore.ieee.org.sci-hub.io/document/8297302/

  - http://ieeexplore.ieee.org/document/8297302/  --> 你的地址
  - http://ieeexplore.ieee.org.sci-hub.la/document/8297302  --> 修改一下
    - 如果la不好使, 换
    - hk
    - tw
    - tv
  - ActionBar的使用；
  - js和java之间的相互调用
    - 例如:
    1. Java调用js代码
        String call = "javascript:sumToJava(1,2)";
        webView.loadUrl(call);
    2. js函数处理, 并将结果通过调用java方法返回
        function sumToJava(number1, number2){
           window.control.onSumResult(number1 + number2)
        }
    3. Java在回调方法中获取js函数返回值
        @JavascriptInterface
        public void onSumResult(int result) {
            Log.i(LOGTAG, "onSumResult result=" + result);
        }

    - js中调用java
      - window.control.onSumResult(number1 + number2)
---------------
    - 安装Qmmp音乐播放器
      - sudo add-apt-repository ppa:forkotov02/ppa
      - sudo apt-get update
      - sudo apt-get install qmmp
      - sudo apt-get install qmmp-plugin-pack
      - 卸载:
        - sudo apt-get install ppa-purge
        - sudo ppa-purge ppa:forkotov02/ppa
    - 安装主题
　　　　  - http://blog.csdn.net/anooyman/article/details/51068140
      - Plank  //icon居中
      - Unity Tweek tool　//主题管理
  - 整理博客

### March - 07
  - 将dialog的菜单部分实现
  - MaterialDialog实现

### March - 08
  - 学习js基础知识；
  - 区块链
    - 现金交易
    - 转账 -- 中心
    - 广播　--> 节点（区中心）
  - 特点:
    - 去中心化
    - 不可串改
    - 开放性
    - 可匿名
  - 拖拽选中
    - 分析按住shift键如何实现的；
  - richeditor-android
    - java /js　调用方式

### March - 09
  - js中实现拖拽，
  - js中具有构造器；
  - 电影奇迹男孩

### March - 10
  - 陪小烨看大数据
  - 刷题

### March - 11
  - 刷科目一习题
  - 自律

### March - 12
  - 仔细分析js那里的实现
    - 找到问题所在;
  - shift + f10 运行app
  - git stash -k -u  //zan cun
  - git pop  //hui fu

  - TaskManager
    - 1. 需求:
      - 解除关联启动
      - 例如:
        - 在启动word时，会将word / ppt 的进程启动.
        - 人工在ppt进行休眠后，启动word　不再启动ppt的进程。
          - 待测: 在word中启动ppt是否可以?
            - openthos上不受影响;
    - 2. 以实现案例
        - 冰箱
        - 问题: StartupMenu中icon消失；

        - 华为手机中存在取消关联启动
          - 取消后，不存在问题
          - 例如： 华为手机取消关联后，天猫支付不受影响，可以启动支付宝；
    - 3. 实现方案
      - 冰箱的实现方式:
        - 针对关联的接受对象进行手动处理；

5、以下是从别的地方摘抄的一段话，关于“应用自动启动”和“关联启动”：
安卓每个程序（软件）都可以设置监听广播，广播的来源有两大类：
一类是常见的的系统广播如：开机广播、解锁屏广播、电量变化广播、网络状态广播等等，
格式举例：（开机广播），手机上所有的安卓程序（软件）开发时都可以设置监听这些广播，当然监听有些系统广播需要在程序里声明权限。
接收系统广播唤醒软件，一般称之为软件自启动。
另一类是软件（程序）自定义的广播，这些广播可以在程序运行的任何过程发出，
比如：该程序启动时发出，联网时发出，等等。所有知道该广播的软件（程序）都可以接受。接收广播主要用于唤醒软件（软件关联启动）。
一般来说，软件（程序）自定义的广播属于商业机密，比如说阿里给支付宝定义了广播A，给淘宝定义了广播B，
同一家的软件支付宝就能通过淘宝发出的广播B启动，淘宝亦然。微信和QQ的也是这样。
假如有一天，用户只装了支付宝和微信，那么支付宝和微信如何关联启动？
阿里对腾讯说，我把支付宝发出的广播告诉你，你把微信发出的广播告诉我。
腾讯说，好。于是你会发现支付宝唤醒了微信，微信唤醒了支付宝.

### March - 13
  - 科目一考试
  - siri的八大使用
    - 设置提醒
    - 时间助手 例如: 帮你设置闹钟
    - 识别音乐
    - 计算器
    - 出行好帮手
    - 手机开关设置
    - 如何快速启动

### March - 14
  - TextEditor的拖拽选中放弃;
  - 右键弹出dialog;
  - 卸载GIMP
  - sudoapt-get install ppa-purge
  - sudo ppa-purge ppa:otto-kesselgulasch/gimp

  - 安装atom当做记事本使用
  - 增加一个浏览器sudo apt-get install midori
  - ctrl + shift + m进行md的预览

  ### March - 15
    - 实现dialog 和定位；
    - siri：
      - 和天气组合:
        Siri“今天天气怎么样?
    - 手机始终是登录账户状态。
    - 在设置中，隐私里面，定位服务打开。
    - icloud定位开启
    　（查找我的iphone）
    - 维基百科
    - 写富文本编辑器的论文；

### March - 16
  - 接口文件选择器
    - 1. 实现打开 保存　另存为；
    - 2. 升级问题；

### March - 17
  - 科目二 练习
  - 下雪了；

### March - 18
  - Atom的快捷键
    - ctrl + T　文件搜索
　　- java　Over
  - 关联启动
    - 刘总想要实现的是: 华为设置中的效果
　　　　- 推测是广播进行实现的；
　　
### March - 19
  - TextEditor在google浏览器中使用shift可以拖拽选中；
  - 从shift快捷键入手；
  -  new SelectDrawableEventHandler(this, mouseHandler);
  - 实现拖拽，从它开始；

### March - 20
  ```
  mouseHandler.selectByLines = this.extendSelectionBy.bind(mouseHandler, "getLineRange");
  mouseHandler.selectByWords = this.extendSelectionBy.bind(mouseHandler, "getWordRange");
  new SelectDrawableEventHandler(this, mouseHandler);  //Smaster 注释掉　拖拽失败
  ```
**java８中 lambda表达式**
  - “lambda表达式”是一段可以传递的代码，因为他可以被执行一次或多次。我们先回顾一下之前在Java中一直使用的相似的代码块。

```
new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.println("Without Lambda Expression");
            }}).start();
```
```
new Thread(() -> {
            for (int i = 0; i < 100; i++)
                System.out.println("Lambda Expression");
        }).start();
```
```
class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
Arrays.sort(strings, new LengthComparator());
```
```
Comparator<String> c = (s1, s2) -> Integer.compare(s1.length(), s2.length());
```
**解释**
  - 在Java中传递代码并不是很容易，不可能将代码块到处传递。你不得不构建一个类的对象，由他的某个方法来包含所需的代码。而lambda表达式实际上就是代码块的传递的实现。其语法结构如下：

(parameters) -> expression 或者 (parameters) -> {statements;}

括号里的参数可以省略其类型，编译器会根据上下文来推导参数的类型，你也可以显式地指定参数类型，如果没有参数，括号内可以为空。方法体，如果有多行功能语句用大括号括起来，如果只有一行功能语句则可以省略大括号；
代替了匿名内部类。
***
com.microsoft.office.Notification.ACTION_APP_FIRST_LAUNCH
com.microsoft.office.outlook.action.TIME_CHANGED
com.microsoft.office.outlook.action.AGENDA_APPWIDGET_UPDATE
com.microsoft.office.outlook.action.TIME_CHANGED
***
ctrl + alt + 上/下/左/右键

***
### March - 21
  - 分析广播怎么启动的关联应用的进程；
  - ubuntu添加开机启动应用
    - start Application 中添加
  - 打开github项目: 配置--> 以前的配置；
  - 为了保证杀进程之后依然收到推送，国内第三方推送 sdk 基本都弄了一个联合唤醒的机制，只要使用了同一家的 sdk ，启动其中一个 app 的时候就会唤醒其它所有集成了该家 sdk 的 app 的推送进程，以保证所有 app 推送的送达率。

### March - 22
  - 装系统- 并准备一套装机后处理文档

### March - 23
  - docker : sudo apt-get install libelf-dev
  - TaskManager
    - office 套件不是通过广播实现关联启动；
    - 华为的关联启动禁止后 虽然提示禁止后有异常， 但不影响使用
      - 故不用区分应该 禁止和不能禁止的关联
    - 测试是不是通过service来实现；
  - 学习Binder的实现逻辑；

### March - 24
  - 练车 上车定点
  - 献血

### March - 25
  - 打扫卫生
  - 掘金技术交流会
    - 组件化开发
      - 看ppt

### March - 26
  - Binder监听
  - Error:Execution failed for task ':app:validateSigningRelease'.
> Keystore file /home/smaster/keystore/key.jks not found for signing config 'externalOverride'.
  - 解决: File -> Invalidate Caches & Restart...

  - 任务不能完成移交给别人，首先你要把 需求 给别人讲明白；
  - 做事情首先要把需求 特别是 自己的不熟悉的领域 ， 把需求搞清楚；

### March - 27
 - 试试ctrl-z，然后用fg %1来回复运行
 - 失去焦点
 -   menuDialog.getWindow().setFlags(
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    menuDialog.setCancelable(true);

    -
    /*PopupMenu popupMenu = new PopupMenu(getContext(), v);
      MenuInflater inflater = popupMenu.getMenuInflater();
      inflater.inflate(R.menu.browser_menu, popupMenu.getMenu());
      popupMenu.show();*/

### March - 28
  - 1. 菜单问题，菜单配色取消，菜单失去焦点消失过慢，鼠标悬浮划过其他顶级菜单项时，菜单应随之移动变化
  - 2.取消“主题”功能. √
  - 3.文件标签栏(tab)偏小，开新tab的“+“是全局的靠最右排列，而不是每个tab都有 √
  - 4.使用鼠标左键按下并移动选中的模式，而不是触屏长按选中模式.
  - 5.邮件菜单太窄，请参考windows左右留白.
  - 6.默认不要显示回车换行等不可见符号（现在空文档中显示一个字符，连续按下回车会显示更多）

### March - 29
  - 1  Open termial and su to root
  - 2  unzip xposed_x86_64-by_David_chan_2017-12-18.zip
  - 3  cd xposed_x86_64-by_David_chan_2017-12-18
  - 4  ./install_xposed.sh
  - 5  cd .. && rm -rf xposed_x86_64-by_David_chan_2017-12-18 && reboot -f
After reboot you can install the XposedInstaller_3.1.4.apk

  - To navigate to the implementation(s) of an abstract method, position the caret at its usage or its name in the declaration and press Ctrl+Alt+B.

  - Ctrl+W (extend selection) in the editor selects the word at the caret and then selects expanding areas of the source code. For example, it may select a method name, then the expression that calls this method, then the whole statement, then the containing block, etc. You can also select the word at the caret and the expanding areas of the source code by double-clicking the target areas in the editor.

  - ctrl + shift + space //建议

  - ubuntu ssh 链接
  - windows中PuTTY进行链接；
  - ubuntu 利用adb 链接 openthos
  - 然后 scp下载ubuntu上的数据；

  - SystemHook.java //方法重点测试分析；

### March - 30
  - com.microsoft.tokenshare.TokenSharingService
  - ForceStopGB分析
    - 项目中利用Xposed的地方可以重用，独立出来；
    - 可以从外部入手；
  - /gradlew :app:clean :app:build

### March - 31
  - 加班: 分析ForeGB

### April - 01
  - 倒车入库

### April - 02
  - 获取唤醒的log;
  - 格式 例如:
    - OneNote --> 唤醒  office 拦截；

### April - 03
  - /home/smaster/.mozbuild/android-sdk-linux
  - /home/smaster/.mozbuild/android-ndk-r15c
  - addStatusBarWindow();//获取status bar 的高度
  - 19828e2e319dc9d7f1c5380e55d46a007ae36a19
  - jar是java字节码文件（class文件）的归档文件，其不包含android中的资源文件等信息；
  - aar是android中特有的归档文件，既包含字节码文件也包含androi
  d的资源文件等；

  - Quick start
       首先编译出android, 然后执行：

make otapackage

    即可获得：out/target/product/{product_name}/ {product_name}-ota-eng.{uid}.zip

    将该文件改名为update.zip放到T卡根目录, 即可开始recovery模式下的 OTA 升级。

  - xposed for openthos 1.0 链接：https://pan.baidu.com/s/1dFHCHsX 密码：fayg

### April - 04
  - 注册时，在打开的License Activation窗口中选择“License server”，在输入框输入下面的网址：
  - http://idea.codebeta.cn （新，感谢Rachelsalaheiyo提供）
  - http://idea.imsxm.com/
  - 点击：Activate即可。

### April - 05
  - 学左边倒库
  - 熬夜分析 TaskManager 获取log;

### April - 06
  - 宅在家
  - 找老三 吃大虾；

### April - 07
  - 学车侧方入库
  - 去北邮
  - 决定让老爸学驾证

### April - 08
  - LOCAL_SDK_VERSION := current //源码编译去掉: 然后访问 隐藏api
  - 配置jar包
    - LOCAL_STATIC_JAVA_LIBRARIES += xposed
    - LOCAL_STATIC_JAVA_LIBRARIES += libsuperuser
    - LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := xposed:lib/XposedBridgeApi.jar \
                                        libsuperuser:libs/libsuperuser.jar

### April - 09
  - 服务器中的项目运行成功；
    - 但是广播接收失败；

### April - 10
  - 分析广播为什么接收不到
  - 实现阻止功能；
  - scp smaster@192.168.0.107:/home/smaster/Downloads/xposed.zip .
  - view弹出位置: 相对差值
  - 当package发生改变，xposed_init没有变
  - 但是如果没有再次编译，则仍然没有用
  - 在服务器上注意这个问题；


### April - 11
  - 删除data下面的system/  可以进行系统重置；

### April - 12
  - 将apk放到系统 尝试；
  - 在google中的拖拽選中，是浏览器的功能；


### April - 13
  - getShiftKey
  - 可以将鼠标双击选中优化
  - 可以从交互的方法触发；
  - 可以写一段js代码

  - Updating c391611..3c5e1df
    error: The following untracked working tree files would be overwritten by merge:
        readme.md
    Please move or remove them before you can merge.
    错误解释: 服务器代码有文件readme.md  但是本地重名 且不属于服务器

### April - 14
  - TaskManager: xposed_x86_64 部分分析

### April - 15
  - linux 版本的wps添加 fonts.
  - 1、权限设置，执行命令如下

     #cd /usr/share/fonts/

     #chmod 755 wps_symbol_fonts

     #cd /usr/share/fonts/wps_symbol_fonts

     #chmod 644 *

2、生成缓存配置信息，进入字体目录  
     #cd /usr/share/fonts/wps_symbol_fonts
     #mkfontdir
     #mkfontscale
     #fc-cache

### April - 16
  - 获取内存信息；

### April - 17
> ls -alt # 按修改时间排序
> ls --sort=time -la # 等价于> ls -alt
> ls -alc # 按创建时间排序
> ls -alu # 按访问时间排序

##### 以上均可使用-r实现逆序排序
> ls -alrt # 按修改时间排序
> ls --sort=time -lra # 等价于> ls -alrt
> ls -alrc # 按创建时间排序
> ls -alru # 按访问时间排序


### April - 18
  - 科目二 失败


### April - 19
  - 整理OtoTaskManager 和 OtoTextEditor.
  - 分析阻止启动的原理；
  - vim studio64.vmoptions //提高studio内存
  - 导入系统源代码
    - mmm development/tools/idegen/
    - development/tools/idegen/idegen.sh
    - 导入根目录的android.ipr.
    - 移除本地jar然后添加系统源码的。

cd /root/zxz/usermultiwin/kernel/
git branch
git remote -v
git fetch x86
git branch -a
git checkout remotes/x86/openthos-4.15
cd /root/zxz/usermultiwin

替换当前文件中所有 old 为 new
:%s/old/new/g

要将目录 dir 下面所有文件中的 old 都修改成new:
sed -i "s/old/new/g" `grep 'old' -rl dir`  

sudo apt-get install libssl-dev libelf-dev

eog studio.png


### April - 20

  - U盘挂载问题：
  - 安装exfat-fuse:
  - sudo apt-get install exfat-fuse
  - sudo apt install kazam //屏幕录制
  - String.format("/proc/%d/stat", pid)

  - dumpsys
  adb shell dumpsys activity
  adb shell dumpsys cpuinfo
  adb shell dumpsys battery

  dumpsys meminfo pkg:
    - 获取pkg的内存信息；

    adb shell                         //进入手机shell
    dumpsys | grep "DUMP OF SERVICE"  //列举当前手机所有支持的dumpsys命令

    dumpsys package  <package_name>   //查看指定包名的信息
   dumpsys activity <package_name>  //查看指定包名的activity信息

   dumpsys alarm      //查看Alarm信息
   dumpsys audio      //查看声音信息
   dumpsys battery    //查看电池信息
   dumpsys cpuinfo //查看CPU信息
   dumpsys meminfo  <package_name>//查看指定包名的内存信息
   dumpsys netstats//查看网络统计信息
   dumpsys diskstats   //查看空间free状态
   dumpsys jobscheduler   //查看任务计划
   dumpsys power//查看功耗信息
   dumpsys wifi//查看wifi信息

   libs/binder/ProcessState.cpp
   cmds/dumpsys

   native的使用

### April - 21
  - 目录结构:
    1. imgages
    2. pages
      - 所有页面
      - index.js --> 当前页面逻辑
      - index.wxml --> 页面
      - index.wxss --> 修饰样式、
      - index.json配置文件

  - utls --> 工具类

  - app.js整个逻辑
  - app.json配置文件
  - app.wxss

### April - 22
  - 内存在 15上的问题
  - xposed 问题

  2)查看环境变量修改成功与否
   echo $JAVA_HMOE
   echo $CLASSPATH
  - adb uninstall com.example.developerhaoz.sleephelper
    - 后面是包名


### April - 23
  - 整理OtoTaskManager中ActivityManager获取不到getProcessMemory的原因是，和用于获取隐藏类的jar包中的
    ActivityManager发生冲突；
  - ForceStopGB的作者提供的 补丁有效
    - 分析补丁怎么使用？

  - 确保自己的docker 可以正常使用；

  - 视频处理: sudo apt install kdenlive

  问题解决方向:
    1. patch
    2. 将apk
    3. 系统

### April - 24
  -  dpkg -l | grep "virtualBox"
  - du -sh .[^.]*  //隐藏文件
  - user版
    - stop adbd
    - start adbd

### April - 25
  - Xposed_installer.将apk
  - 移植成功

### April - 26
  - 移植Xposed installer 到OtoTaskManager.
  - 2395 任务管理器CPU主频显示固定值2.8GHz，修改为实时变化的.
  - 2394 任务管理器CPU占用显示始终为0
  - 在 kernal升级后，TaskManager中内存显示为0.0
  - 切断关联启动功能-----------------------------------目前还在内核4.9上进行开发
  - LocalPrintService.java //--128

  - Osmoniter获取cpu信息；  
  - 刷新: 注意小的for循环就会出现NNR

### Apri - 27
2.mmm 命令
该命令是 envsetup.sh 中注册的函数,用于在源码根目录编译指定模块,参数为模块的相对
路径。只能在第一次编译后使用。比如要编译 Phone 部分源码,需要在终端中执行以下命令 :
allong@android:~/android/jellybean$mmm packages/apps/phone
3.mm 命令
该命令也是 envsetup.sh 中注册的函数,用于在模块根目录编译这个模块。只能在第一次
编译后使用。例如要编译 Phone 部分源码,需要在终端中执行以下命令 :
allong@android:~/android/jellybean$cd packages/apps/phone
allong@android:~/android/jellybean/packages/apps/phone$mm

- hls

### April - 28
- strncmp(str1, str2, 3)用于比较str1和str2的前三个字符是否相同。
- 5月11号 考试
- 5月5号 --> 练车 钱已交；
- char* 代表 字符指针类型，当其指向一个字符串的第一个元素时，它就可以代表这个字
- 函数名: atoi 功 能: 把字符串转换成长整型数 ；

- echo $[3678/1024] //计算器
1、临时设置：vim打开文档-->命令行形式输入set hlsearch。
缺点：关闭文档后，下次打开，又需要重新设置一遍。

2、永久设置（推荐）：在~/.vimrc中配制
vim ~/.vimrc
在文件中加上set hlsearch

### April - 29
  - update-alternatives --config java
  - 陪潘月新转一圈；

### April - 30
  - 装系统

### May - 01
  - repo 一套代码在SSD
  - 配置Android studio
  - 配置 fennec
  - 配置 ijkplayer
  - 看源码
  - 分析 Xposed

### May
  - 为活着找个理由
    - 只为更好的活着；
