## 五月份
***
### May - 01
  - repo 一套代码在SSD
  - 配置Android studio
  - 配置 fennec
  - 配置 ijkplayer
  - 看源码
  - 分析 Xposed


### May - 02
  - 调整好笔记本
  - 通知栏图标问题
  - 看书

### May - 03
  - 分析是否和隐藏API有关系？
  - 在使用隐藏api时，将进程杀死；
  - 数据库 继承 SQLiteOpenHelper;

### May - 04
  - 整理本地demo
  - 分析Xposed， 预防再出现问题。
  - frameworks层实现；
  - 码云： SmasterCao //密码: caoyongren00
  - 两个任务
  - 1.  切换dpi后 ，通知栏内已有通知不会随之变化
  - 2. [bug 2424] 120dpi时，PCMark的图标显示为3DMark

  - ubuntu 上给应用创建快捷方式
  - location：
    - 创建:/usr/share/applications/Studio.desktop
    ```
    [Desktop Entry]
Name = Studio
comment= android studio
Exec=/home/smaster/Sdisk/android-studio/bin/studio.sh
Icon=/home/smaster/Sdisk/android-studio/bin/studio.png
Terminal=false
Type=Application
    ```
    - 注意不能有空格，有空格图标不显示；
    - > 引用

### May - 05
  - 学车

### May - 06
  - 和表哥去奥林匹克北园

### May - 07
  - 通知栏分辨率调整好通知消息的问题；
  - pcmark-android-v2-0-3715.apk问题
  - iso解压安装系统；
    - 1、将win7 iso压缩包文件下载到C盘之外的分区，比如下载到F盘，右键使用WinRAR等工具解压到当前文件夹或指定文件夹，不能解压到C盘和桌面，否则无法安装；
    - 2、解压之后，我们打开安装目录，找到【安装系统.exe】程序；
    - 3、双击【安装系统.exe】打开这个安装界面，选择【还原系统】，映像文件路径选择win7.gho文件，勾选要安装的位置C盘，如果不是显示C盘，要根据卷标或容量来判断C盘，再勾选【执行完成后重启】，最后点击【执行】；
    - 4、弹出提示框，提示映像文件即将还原到分区C，点击确定继续；
    - 5、这时候电脑会重启，进入到这个界面，默认选择SysCeo Recovery项启动；

    - 3DMark和pcMark同属一家公司
      - 现象: 3DMark任何分辨率都正常；
      - pcMark则在 120时换用了，3DMark的logo;

    - 源码分析调试工具 --> 陈工
    - 文本编辑器--> 崩溃
    - adb push remote LOCAL //模拟器复制到本机
    - adb pull local remote //本机复制到模拟器

    - ./bin/wxdt  //启动微信小程序；

    ### May - 08
      - 通知栏问题解决
App() 必须在 app.js 中注册，且不能注册多个。
不要在定义于 App() 内的函数中调用 getApp() ，使用 this 就可以拿到 app 实例。
不要在 onLaunch 的时候调用 getCurrentPages()，此时 page 还没有生成。
通过 getApp() 获取实例之后，不要私自调用生命周期函数。

  - sudo ln -s /opt/node-v10.0.0-linux-x64/bin/wepy /usr/local/wepy //软连接

### May - 08
  - 使用“Ctrl+Shift+p”打开命令窗口，输入“Git:init”来初始化git化境

### May - 09
  - 练车

### May - 10
  - npm i
  - npm run dev
  - 1861 文件管理器多开时,打开其他应用，点击任务栏返回桌面按钮,不能完全回到桌面

### May - 11
  - 学车
  - 去首都师范

### May - 12
  - ctrl + alt + f //再浏览器中看效果
  - PhoneWindowManager.java
    - startHomeManager()
    - FLAG_ACTIVITY_MULTIPLE_TASK

### May - 13
  - 复选框列表
在列表符号后面加上[]或者[x]代表选中或者未选中情况;
  - [] 好


  表头1  | 表头2
  -| -------------
  Content Cell  | Content Cell
  Content Cell  | Content Cell

  | 表头1  | 表头2|
  | ------------- | ------------- |
  | Content Cell  | Content Cell  |
  | Content Cell  | Content Cell  |

  | 名字 | 描述          |
  | ------------- | ----------- |
  | Help      | Display the help window.|
  | Close     | Closes a window     |

  表格中也可以使用普通文本的删除线，斜体等效果

  | 名字 | 描述          |
  | ------------- | ----------- |
  | Help      | ~~Display the~~ help window.|
  | Close     | _Closes_ a window     |

  表格可以指定对齐方式

  | 左对齐 | 居中  | 右对齐 |
  | :------------ |:---------------:| -----:|
  | col 3 is      | some wordy text | $1600 |
  | col 2 is      | centered        |   $12 |
  git config --global http.proxy "localhost:1080"
  vim .gitconfig

  $ 是 document.getElementById() 的简写；
  1. 首先可以用来表示变量； var $s = ‘asdasd’
  2. $来表示一个查找对象的函数

### May - 14
  - 启动模式
    - FLAG_ACTIVITY_MULTIPLE_TASK
      - 这个标识用来创建一个新的task栈，并且在里面启动新的activity（所有情况，不管系统中存在不存在该activity实例），
        经常和FLAG_ACTIVITY_NEW_DOCUMENT或者FLAG_ACTIVITY_NEW_TASK一起使用。

  - 任务栏中的图标锁定
  - docker指令可以刷一波
   
   - 微信开发账号: 941636391@qq.com
     - 密码: caoyongren00
     -   双括号里面就是变量
     
   
  ***

### May - 15
  - 多开问题--> 从栈入手
  - 小程序demo完成；
sudo add-apt-repository ppa:ubuntu-desktop/ubuntu-make
sudo apt-get update
sudo apt-get install ubuntu-make
umake web visual-studio-code

卸载

umake web visual-studio-code --remove 
sudo apt-get remove ubuntu-make

>ext install

### May - 16
  - TaskManager bug 分析
  - home键返回launcher;
  - 8.1 配置
  
     - ssh oto@192.168.0.158
     - docker start -ai cyr-8.1
     - mkdir ~/bin
     - PATH=~/bin:$PATH
     - curl http://192.168.0.185/git-repo-downloads/repo > ~/bin/repo 
     - chmod a+x ~/bin/repo
     - repo init -u git://192.168.0.185/android-x86/manifest.git -b multiwindow-oreo 

  - npm install -g react-native-cli
  - react-native -v
  - react-native init AwesomeProject
  - react-native start
  - org.gradle.java.home=/usr/lib/jvm/java-8-openjdk-amd64
  - react-native run-android

### May - 17  
  - 尝试解决
  - git clone https://github.com/facebook/watchman.git
cd watchman
git checkout v4.5.0  # 这是本文发布时的最新版本，请自行选择更新的版本
./autogen.sh
./configure
make
sudo make install

===
I/Smaster-->( 2923): GET--> start -->
I/Smaster-->( 2923): java.lang.Exception
I/Smaster-->( 2923): 	at com.android.server.am.ActivityManagerService.getRecentTasks(ActivityManagerService.java:8321)
I/Smaster-->( 2923): 	at android.app.ActivityManagerNative.onTransact(ActivityManagerNative.java:634)
I/Smaster-->( 2923): 	at com.android.server.am.ActivityManagerService.onTransact(ActivityManagerService.java:2305)
I/Smaster-->( 2923): 	at android.os.Binder.execTransact(Binder.java:446)

### May - 18
  - ｇｉｔ技巧
  - ASS中的焦点分析；
  - I/Smaster -->( 2924): AMS ==>focusRecentStack
I/Smaster -->( 2924): java.lang.Exception
I/Smaster -->( 2924): 	(ActivityManagerService.java:19986)
I/Smaster -->( 2924): 	(ActivityStackSupervisor.java:1853)
I/Smaster -->( 2924): 	(ActivityStackSupervisor.java:1825)
I/Smaster -->( 2924): 	at com.android.server.am.ActivityStack.moveTaskToFrontLocked(ActivityStack.java:3501)
I/Smaster -->( 2924): 	(ActivityStackSupervisor.java:2851)
I/Smaster -->( 2924): 	(ActivityManagerService.java:8741)
I/Smaster -->( 2924): 	(ActivityManagerService.java:8715)
I/Smaster -->( 2924): 	(ActivityManagerService.java:2510)：

