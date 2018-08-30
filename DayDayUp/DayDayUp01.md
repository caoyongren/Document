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


### August -- 07

1.另外在桌面按下power按键呼出关机菜单，此时再次按下应取消关机菜单

## SystemUI 后期任务：
１．　任务栏显示／隐藏　和　滑动显示灵敏度　需要重新写．
２．　通知栏　闪屏／屏幕变暗／　进程在，无法清除
３．　ＰowerSourceActivity重新设计．
４．　StartupMenu的icon 拖动
５．　任务栏icon的拖动
=====================
### August -- 08
操作arm模拟器：
platform-tools: ./adb shell

pm list package    //显示所有应用包

pm disable com.otosoft.setupwizard

ps aux|grep emu　　　　　//显示进程．

./adb devicse

./adb logcat

setVolumeIco

==================
### August -- 09

快捷键：　调控亮度和鼠标事件的亮度调节的控制保持一致．　PhoneWindow.java
系统配置文件: core/res/res/values/config.xml

https://github.com/openthos/systemui-analysis/edit/master/%E5%8E%9F%E7%94%9Fandroid%20lollipop%E7%9A%84%E8%B7%A8%E5%B9%B3%E5%8F%B0%E5%BC%80%E5%8F%91%E9%85%8D%E7%BD%AE%E6%96%87%E6%A1%A3.md (日报)

     cat主要有三大功能：
1.一次显示整个文件。$ cat filename
2.从键盘创建一个文件。$ cat > filename 
只能创建新文件,不能编辑已有文件.
3.将几个文件合并为一个文件： $cat file1 file2 > file  （file1追加到file）

### August -- 10
arm 版问题－－　startupMenu不能点击

1. setOnGenericMotionListener 失效

2. setOnTouchListener 失效．

3. setOnClickListener可以使用．

4. 输入法　　电池　　wifi 音量都无法弹出ｄｉalog.



C02SQN2CGTFL



将一个文件夹中的所有文件写入一个　文件中．
1. ll  >> aa.txt
2. find ./path -name *.md >> aa.txt  (带路径)

68af96a95dd212fda563f46b3895c63ae1f367b2 --> 陈工的关于通知栏的补丁

PhoneStatusBarView.java -- > onTouchEvent -- > 通知栏在StatusBar中点击事件．


### August -- 11

配置Ｔomcat
pwd: /opt/apache-tomcat-8.0.45
sudo ./bin/shutdown.sh
http://localhost:8080/
sudo ./bin/startup.sh

配置：　Mysql + java web
vim etc/profile

WindowManagerService.java   ---> 进行鼠标对任务栏的显示/隐藏

ActivityManagerService.java --> closeActivity() 
处理StartupMenu的关闭．

在PhoneWindowManager里面实现对PowerSourceActivity的关闭
参考：ActivityManagerNative.getDefault().killStartupMenu();

sudo add-apt-repository ppa:rvm/smplayer
sudo apt-get update
sudo apt-get install smplayer
sudo apt-get remove smplayer

通知栏的点击缩小到Icon -- > checkValidEvent在PhoneStatusBarView.java

对比另外的分之和当前分之的区别：　git diff multiwindow  .

切换远程分支：git checkout  remotes/aosp/1.0-ana -b cg-mw
显示所有分支：　包括远程：　git branch -a

测试网速：speedtest-cli


### August--12
/root/MyEclipse

进入：　/root    /先设置密码：　su - passwd


### August -- 13
  - 清单

### August -- 14
  - 1. 启动流程
  - 2. 修改锁屏后的休眠时间
  - 3. arm版．
  - 4. top　　和　　free 指令． locate

  - PowerManagerService.java 存在　休眠和锁屏的时间设置．
  - ActivityStackSupervisor.java(ASS) --处理启动FLAG的处理
    - 还有一个　运行模式取系统配置的应用技能．
 　　　//resume recorded rect
         Rect rect = Settings.Global.getRect(
                           mService.mContext.getContentResolver(), pkgName, null);

         Settings.System.putLong(getContentResolver(),
                  android.provider.Settings.System.SCREEN_OFF_TIMEOUT,
                  mTimes[index]);

  - ScreenTimeoutSettings.java  >> 设置里面的休眠时间设置．
  - core/res/res/values/config.xml  >> config_minimumScreenOffTimeout

### August -- 15
  - 1. 锁屏后到休眠
   - 原系统设计：　在锁屏时　timeout = 0 , 只能走　资源获取值．
  - 2. MainActivity.java -- > OtoLauncher --> arm版的点击．
  - 3. 软连接：　ln -s 软连接　　目标文件　　（无ｓ是硬连接）

  - 4.adb logcat | grep --color=auto -i  myapp #设置匹配字符串颜色

### August -- 16
  - 1.锁屏后休眠
    - WMS中　通过PowerManagerInternal.java中setUserActivityTimeoutOverrideFromWindowManager(long timeoutMillis)
    - 传来一个参数　-1. 到　PowerManagerService中然后　　－－　＞　赋值　timeout = 0;
    - 整体逻辑：　
      - 1．　非锁屏状态：　到休眠的时间是　走设置（因为设置中时间比较大）
      - 2.   锁屏状态：　到休眠走　资源中的设置，　因为timeout = 0 ;
  - 在WindowState中进行真正赋值．０　　userActivityTimeout = in.readLong();

Set the time that lock screen to sleep, and the setting to be consistent.


  - arm　版让任务栏一直显示．
  - 锁屏休眠第一版是修改原有逻辑后的一个处理，　--> 写另一套逻辑进行获取(原有保持不变)．
  - 系统开发尽量保持原有源码的逻辑原则．

```简单来说触摸事件的分发会经过这么几个顺序，dispatchTouchEvent --> onInterceptTouchEvent --> onTouchEvent，
事件拦截就在onInterceptTouchEvent方法中进行，在该方法中返回true即代表拦截触摸事件。触摸事件的分发是一个典型的隧道事件，即从上到下的过程。
从视图树角度上来说，就是触摸事件会从父视图挨个传递到子视图。
比如一个LinearLayout中又一个TextView，当触摸这个TextView时触摸事件会先打到LinearLayout，然后再到达TextView。
如果LinearLayout将触摸事件拦截了，那么TextView就会收到一个CANCEL事件，其他触摸就收不到了。
但是触摸事件的处理过程是一个冒泡事件，还是以上面的TextView为例，正常情况下，事件从上到下分发到TextView上，
TextView则会对该事件进行处理，如果TextView处理了该事件，即TextView的dispatchTouchEvent返回了true, 那么该事件就被消费了。
但是如果TextView的dispatchTouchEvent返回的是false, 则代表这个事件没有被处理，此时该事件就会从下到上
（即从child 到 view group的过程）找parent view进行处理。如果parent view也没有处理，那么最终会交给Activity （如果是Activity窗口） 的onTouchEvent来处理.```

### August -- 17
  - git push devorg multiwindow:refs/heads/multiwindow
    - 注意事项：　devorg
      - 利用：　git remote -v
      - 出现　　　aosp	git://192.168.0.185/lollipop/platform/frameworks/base (push)
      - 所以不要写　devorg　写　aosp
    - 要有本地branch． --> multiwindow
    - refs/heads/multiwindow  -- > 远程分支；
    - 补丁当前目录提交．

  - 有时间浏览View中的所有事件．
    -  public boolean onLongClick(View v) ; View.OnLongClickListener
    - 你不是努力，只是看起来很努力而已
  
  - 解决两个问题：
    - 1. status bar 添加　long click
    - 2. input / wifi / charge 的任务栏的隐藏．

### August -- 18
  - 1. 通知栏：　清除所有--EmptyShadeView.java  btnClearAll
    - onChangeUserInfo -- > 置灰　（不可点击）
  - 2. 收到信息，任务栏变亮：BaseStatusBar.java　setNotificationIconHighlight()
    - PhoneStatusBar.java -- > 
  - 3.c6c87b2accbcea34957c72dd6868a611a3a92e08    94558fa7c6aad737ac1f8cf093868872fdb0057d
  - 4. 通知消息：　添加　删除item: BaseStatusBar.java -- > notificationItemDelete.setOnClickListener()
    - status_bar_notification_row.xml     removeNotification(String key, RankingMap ranking)

  - Monkey的使用：
    - adb shell monkey [options]
    - adb shell monkey -p your.package.name -v 500

  - 当activity新建fragment时，直接将需要的参数传递；
    - 需要无参数构造器和有参数构造器：
      - 有参数：　@SuppressLint({"NewApi", "ValidFragment"})

  - 1. work program 2. release program 3. online program. 4. testing 5. 接口文档

### August -- 19
  - git diff HEAD -M20命令可以设置similarity的值，根据similarity的值，显示出renamed或者new的信息。
  - 20030803

### August -- 20
  - 引入Module
    - compile project(path: ':library')
    -
  - build.gradle(app)
    - versionCode 4 versionName "2.0" 和推送版本有关．
　　
  - applicationId "com.chad.baserecyclerviewadapterhelper"

### August -- 21
  - 查看launcher的监听．
  - 1.5 cupcake 纸杯蛋糕
  - 1.6 donut 甜甜圈
  - 2.2 jelly bean 冻酸奶
  - 2.3 gingerbread 姜饼
  - 4.0 ice cream sandwich 冰淇淋
  - 4.1 jelly bean 果冻豆
  - 4.4 kitkat 奇巧巧克力
  - 5.0 lollipop 棒棒糖　２０
  - 6.0 marshmallow 棉花糖
  - 7.0 Nougat 牛轧糖
  - 8.0 Oreo 奥利奥

  - Picasso的图片缓存
  - retrofit + okhttp3.0的网络缓存．
  - shift + A　　在vim中移动光标到行结尾．

  - ./hierarchyviewer  视图树．
  - pm list packages
  - pm install/uninstal
  - 技能：　模仿源码写功能．

### August -- 22
  - app启动方式汇总:
    - 属性：
      - 1.Component/Action/Category/Data/Type/Extra/Flag/七个属性
      Component是用来指定启动目标组件的属性．
        ComponentName comp = new ComponentName(firstActivity.this,secondActivity.class);
        Intent intent = new Intent();
        Intent.setComponent(comp);
        startActivity(intent);
      当需要为Intent设定Component属性的时候，Intent已经为我们提供了一个简单的构造器;
        Intent intent = new Intent(firstActivity.this, secondActivity.class);
      Intent的Action与Category属性：
        1.隐式启动　（5.1后不建议使用）-- 需要配置；
        2.显示启动
          Intent intent = new Intent(Intent.ACTION_MAIN);  
          intent.addCategory(Intent.CATEGORY_LAUNCHER);              
          ComponentName cn = new ComponentName(packageName, className);              
          intent.setComponent(cn);  
          startActivity(intent);  
       Intent中的Data和Type属性
          ACTION_VIEW Android.intent.action.VIEW显示指定数据
          String data = http://3g.renren.com; 
          Uri uri =Uri.parse(data);
          Intent.setAction(Intent.ACTION_VIEW);
          Intent.setData(uri);
          startActivity(intent);
　　      Intent的Extra属性：
　　　　　　　　　　Intent属性通常用来用于在多个Activity之间进行数据交换，Intent的Extra属性值应该是一个Bundle对象
           putExtra(Bundledata)   getExtras()
           putXXX(Stringkey XXX data)   getXXX(String key)
           putSerializable(Stringkey, Serializable data) 对应的有
           getSerializable(Stringkey, Serializable data)

  - 微博问题
    - 1. StartupMenu中打开，　首次启动（清除所有数据后启动）　－－　＞　闪退；
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(pkgName, activityName));
         intent --> Intent { cmp=com.sina.weibo/.SplashActivity }
    - 2. 任务栏
      PackageManager manager = mContext.getPackageManager();
      Intent intent1 = manager.getLaunchIntentForPackage(appInfo.getPkgName());
       act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] 
       flg=0x10000000 pkg=com.sina.weibo cmp=com.sina.weibo/.SplashActivity }

    - 3 微博启动闪退关键原因和数据有关，在设置中将应用数据清空，然后启动就会闪退．
      - 改变启动方式可以解决问题，但是我认为并不是真正解决．

### August  -- 23
  -fragment之间进行数据交换使用EventBus
  - 长按监听OnLongClick；
     class LongPressRunnable implements Runnable {
         @Override
         public void run() {
             Toast.makeText(mContext, "Long click", Toast.LENGTH_LONG).show();
             showDialog(getDialogView(), locationX);
             mPressLong = true;
         }
     }
 
     private void setPressInfo() {
         mPressLong = false;
         mHandler.postDelayed(mLongPressRunnable, 500);
     }
 
     private void removeRunnable() {
         mHandler.removeCallbacks(mLongPressRunnable);
     }

### August -- 24
  - 在ActivityKeyView中　ACTION_UP事件不生效 和　onClick事件也不生效．

  - 5.1Openthos中任务栏处理需求：
    - 1. StartupMenu 输入法　电池　网络　音量　通知栏　日历
    - 2. lock的icon:
      - 应用已启动：右键弹出菜单Ａ． 且　长按弹出: Ａ
      - 应用没有启动：　右键弹出菜单Ｂ. 且　长按弹出：Ｂ
    - 3.空白区域：
      - 右键弹出菜单Ｃ. 且　长按弹出 Ｃ
    - 4.Dialog之间需要互斥，只存在一个Dialog.
  - 目前Openthos将事件触发分开处理，造成事件的冲突．ActivityKeyView处理　Ａ Ｂ　
    StatusBarActivity处理Icon的状态． PhoneStatusBar中处理Ｃ

  - 应该在ＰhoneStatusBar中实现全部：
    -  StartupMenu 输入法　电池　网络　音量　通知栏　日历  -- > OnClick
    - lock的ｉcon启动　-- > OnTouch ()在　Down事件中进行~
      - 通过逻辑判断控制是否实现长按事件的生效．
Android事件分发顺序：Activity（Window） -> ViewGroup -> View
对于ViewGroup: 也就是父View，如果在onTouchEvent中对于Down属性的事件的返回值：
true：该事件被消费，之后的move，up不经过它自身的intercept判断，直接进入它的onTouchEvent被处理。
false：没有消费down事件，之后的move，up需要经过自身的intercept，拦截。
false：不消费事件，事件也不继续往下传递 / 交由给父控件onTouchEvent（）处理

对于View: 也就是子View，如果在onTouchEvent中对于Down属性的事件的返回值：
true：该事件被消费，之后的Move，Up仍然要经过它的父View的intercept方法判断，如果被父View劫走，它将收到到一个Cancel事件。
false：只要没有消费该Down事件，之后的Move和Up就真的说再见了，直到下一个Down事件来临。
##
  - True if the listener has consumed the event, false otherwise.

### August -- 25
  - 底部任务栏，在右键的时候，　hover事件要消失．
  - 当你点击启动已锁定的应用时，hover事件~
  - 使用　Android Device Monitor
    - 1. tools/monitor   启动
    - 2. adb ip　　连接　（usb也可以）
    - 3. 点击需要查看的包
    - 4. 很慢，需要等待


### August -- 26
  - 

### August -- 27
  - 对资源文件进行分包：
    - 1.使用project 模式．
    - 2.修改build文件
      -     
      sourceSets{
        main{
            res.srcDirs = [
                    'src/main/res/layout/fragment',
                    'src/main/res/layout',
                    'src/main/res'
            ]
        }
    }
    - 3.进行分类

### August -- 28 （七夕）
  - HashTable,HashMap,LinkedHashMap,TreeMap
    - HashMap线程不安全．高性能，存放和查询都高效，　缺点：　存无序，　取无序
    - HashTable的key和value不能为null，HashMap可以为空．
    - LinkedHashMap继承HashMap, 高性能，　有序（链表）存放有序，　最近访问有序．
    - TreeMap 实现SortMap接口，　可以对元素进行排序． (内部实现：红黑树　平衡查找树Ｏ(log n))

  
（1）List、Map、Set实现类的源代码
（2）ReentrantLock、AQS的源代码
（3）AtomicInteger的实现原理，主要能说清楚CAS机制并且AtomicInteger是如何利用CAS机制实现的
（4）线程池的实现原理
（5）Object类中的方法以及每个方法的作用

  - ListView的源码设计实现．
    - 解决问题：　ListView上view显示错乱的问题．

  - Android Studio修改包名：
    - 去除左侧右上角的ｓetting图标点击开后的第二个选项购．
  - sudo apt-get --purge remove <programname>
  - dpkg -l    //查看所有软件．

  - 已经安装的软件：
    - 2. Smplayer   //视频软件/usr/bin/smplayer /usr/share/smplayer
    - SimpleScreenRecorder   //小视频录制．
    - android studio　　//home/matthew/android-studio/bin/studio.sh
    - vim git python nodejs gitbook gc
    - Mysql  启动： mysql -u root -p     //练习sql语句 //usr/bin/mysql /usr/lib/mysql
    - KolourPaint  //绘图软件
    - gparted  //磁盘管理工具
　　　 - cheese //调用摄像头
    - sl //跑蒸汽机

    - 3. sudo　apt-get clean
    - 4. sudo　apt-get autoremove  //清理
    - 5. sudo apt-get purge   //去除．
    - 6. sudo apt-get install deborphan -y  //删除孤立的包．
    - 7. du –h /var/cache/apt/archives
    - 8. sudo dpkg -i *.deb

### August -- 29
  - 9.dpkg --get-selections|grep linux   //查看所有内核；

  - 绝不能安装的软件：
    - 1.音乐播放器  2. Myeclipse 3. genomoy 模拟器　４．firefox 5. office 
  - 更新显卡驱动：
    - sudo add-apt-repository ppa:graphics-drivers/ppa
    - sudo apt-get install nvidia-361



    - 也可以手动去下载更新．
  - Android O的SystemUI的特点：
    - 1. 用户可以在对应用的通知权限的调整中手动启闭和通知栏可以根据通知类型分组通知．
    - 2. 画中画功能增强．
    - 3. PhoneStatusBar在8.0中不再存在．
  - 视图：
    - StatusBarWindowView.java  /
      - 任务栏　+ 通知栏
      - AlphaOptimizedLinearLayout  id/system_icon_area
        - wifi + 电池　+ 时间
        - LinearLayout id/system_icons
          - wifi ＋　电池
    - 

  - 命名：
    - 布局：　１．layout_  fragment_  item_  dialog_  开始 + 自定义name + (item dialog 依附的布局)；　　
              ２．include 的布局：　依附的布局name + 自定义name
              3.  控件命名：　例如：　tv_main_title   //控件名缩写+位置+用处　

### August -- 30
  - 打标签  git tag  1.0-r1
  - 附加标注　　git tag -a 1.0-r1 -m "0.1.2版本"
  - 切换标签  git checkout []
  - 删除标签  git tag -d v1.0-r1
  - 推送标签到服务器  git push origin 1.0-r1  / git push origin -tags
  - 查看标签　git tab -l
  - 删除远程仓库中生成的标签  git push origin --delete tag tagname

***
  - 设计模式　单例模式　和　策略模式
***
  - 重要指令
    - whereis    查找某应用的路径．
***
  - 继续补充８.0在SystemUI处的变化
    - 1. BaseStatusBar.java去除．
    - 2.新增StatusBar.java　(改写自BaseStatusBar.java)
    - 3. 长按可以出现: 关闭通知　更多设置　　完成

### August -- 31
    - 新增类：CollapsedStatusBarFragment.java
    - Axel是一个命令行下载工具，支持多来源、多线程
    - http://vdisk.weibo.com/s/dCDzeTPvS5Lin#_loginLayer_1504170235728

### September -- 01
  - 熟悉7.1的多窗口个实现．
  - 整理收藏的链接．
  - Read The Fucking Source Code
  - Application的作用：
    - 1. 数据共享
      - 使用Application对象在不同的Activity之间进行数据的传输．
        - 例如：　登录时,　在application中进行数据初始化，保存在一个变量中，这样其他页面就可以使用啦．
  - Android开发之Synchronized的用法
    - 1. 方法声明时使用
      -    public synchronized void synMethod() {}
      - 一次只能有一个线程进入该方法．
    - 2. 对某一代码块使用
      - public int synMethod() {
        synchronized(a1){
        }
      }
    - 3. 对某一个对象使用 4.对类使用（不常用）
    - 4. OnFocuChangeListener  -- > 焦点的变化．
    - 5.使用小米手机做测试机：
      - 在MIUI 开发者选项中关闭 MIUI优化，重启手机.

### September -- 02
  - 去表哥家和陪初中同学．
### September -- 03
  - 整理出一份java 笔记
  - 把CSDN整理好．
  - 查看自己的资源：(我的资源)
    - http://download.csdn.net/my
***

### September -- 04

  - ps指令
    - ps -A //显示所有程序
    - ps c //列出程序,显示指令名称．
    - ps u //以用户为主的格式来显示程序状况
    - ps -aux //具体格式显示

  - java 8新特性
    - Lambda表达式(闭包)和Functional接口
      - 特点：　1.逗号分隔的参数列表　2.->符号　　3.　函数体
      - 例如：　Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
      - Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
      - Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );
      - Lambda可能会返回一个值，返回值的类型也是由编译器推测出来的．
      - 若lambda的函数体只有一行的话，没有必要使用return
      - 例如：
        - Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        - Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
          int result = e1.compareTo( e2 );
          return result;
        } );
      -函数式接口：
        - 函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换为lambda表达式
        - 如有某个人在接口定义中增加了另一个方法，这时，这个接口就不再是函数式的了，并且编译过程也会失败.
        - 为了克服函数式接口的这种脆弱性并且能够明确声明接口作为函数式接口的意图，
        - Java 8增加了一种特殊的注解@FunctionalInterface（Java 8中所有类库的已有接口都添加了@FunctionalInterface注解.
        - 默认方法和静态方法不影响．
  - 接口的默认方法与静态方法
    - 与传统的接口又有些不一样，它允许在已有的接口中添加新方法，而同时又保持了与旧版本代码的兼容性。
    - 默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。
    - Java 8带来的另一个有趣的特性是接口可以声明（并且可以提供实现）静态方法.
      - 例如：
        - private interface DefaulableFactory {
              // Interfaces now allow static methods
              static Defaulable create( Supplier< Defaulable > supplier ) {
              return supplier.get();
            }
          }
      - 默认方法的实现是非常高效的，　并且通过字节码指令为方法调用提供支持．
      - Demo
  - 方法引用
    - 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。
    - 与lambda联合使用，方法引用可以使语言的构造更紧凑简洁．
    - 
    public static class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
         
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
         
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
         
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }
}

    - 第一种：　构造器引用  Class< T >::new
      final Car car = Car.create(Car::new);
      final List<Car> cars = Arrays.asList(car);
    - 第二种：静态方法引用  Class::static_method
      cars.forEach(Car::collide);//接受一个Car类型的参数
　　　　-　第三种方法　特定类的任意对象的方法引用  Class::method
      cars.forEach(Car::repair);
    - 第四种方法  instance::method
      final Car police = Car.create(Car::new);
      cars.forEach(police::follow);

  - 重复注解
    - demo
  - 更好的类型推测机制
    - 编译器可以推测出确定的参数类型，这样就能使代码更整洁.
    - demo
    package com.javacodegeeks.java8.type.inference;
 
public class Value< T > {
    public static< T > T defaultValue() { 
        return null; 
    }
     
    public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}
    //Value<String> 类型的用法
  package com.javacodegeeks.java8.type.inference;
 
public class TypeInference {
    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        value.getOrDefault( "22", Value.defaultValue() );
    }
}
　　　　//Value.defaultValue()的参数类型可以被推测出，所以就不必明确给出

  - 扩展注解的支持

  - java类库的新特性
    - Optinal
    Optional< String > fullName = Optional.ofNullable( null );
    System.out.println( "Full Name is set? " + fullName.isPresent() );        
    System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
    System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

  - Stream
    - 新增API　　把真正的函数编程风格引入到java中，　简化了集合框架的处理
    - demo


  - uiautomatorviewer
    - 1. ./uiautomatorviewer
    - 2. adb 连接．
    - 3. 右上角点击刷新


### Septemper -- 05

  - 任务栏的焦点问题
    - wm/DisplayContent.java
      - int stackIdFromPoint(int x, int y)
    - wm/StackTapPointerEventListener.java
      - MotionEvent.ACTION_DOWN
    - wm/WindowManagerService.java
      - case TAP_OUTSIDE_STACK

  - 自动化测试无法测试Status Bar, 存在任务栏获取不到焦点的问题，
  - 但是获取不到焦点的原因应该是没有识别Status Bar这部分View.

  - 配置Ｖim
    - sudo apt-get install silversearcher-ag  //ag "" 快速搜索
    - sudo apt-get install exuberant-ctags  //函数跳转
      - ctags -R
      - 快捷键：　ctrl + ]    ctrl + T 返回

  - 文档要求
    - 对比TaskBar 和　StartupMenu
      - 1. 实现的操作步骤.
      - 2. TaskBar的实现效果展示.
      - 3. TaskBar已经具备的功能．
      - 4. TaskBar相对StartupMenu缺失的功能．
      - 5. TaskBar实现基本逻辑．
      - 6. TaskBar增加相对StartupMenu缺失功能的实现及难易把握．
      - 7. TaskBar 源码移植到系统中的大概问题是否好解决．
　　　　　 - 8. 评价 TaskBar效果．

    - SystemUI --对比8.0
      - 1. SystemUi的整体结构(原生).
      - 2. Openthos的StatusBar上添加的功能．
      - 3. 8.0中的变化．
      - 4. 8.0中实现大概思路．

### Septemper -- 06
  - ubuntu磁盘管理工具　　Disks
  - Axure 的目的是通过某种“特别”的手段去快速创建带有交互效果的网页原型.
  - 任务栏无法自动化测试问题：
    - new ActivityStack
    - AcitivityStackSupervisor.java  
      - void setFocusedStack(ActivityRecord r, String reason) 
    - ActivityManagerService.java
      -  mStackSupervisor.setFocusedStack(r, reason + " setFocusedActivity");
      -  public void setFocusedStack(int stackId) 
    - IActivityManagerNative.java
      - setFocusedStack(stackId);
    - ActivityStackSupervisor.java
      - new ActivityStack();

    - 在通知栏打开后，任务栏可以获取到焦点．
      //HomeStack的判断
      void moveHomeStack(boolean toFront, String reason) {
          InputManager.getInstance().setPointerIcon(PointerIcon.STYLE_ARROW);
          mayAutoHideStatusBar();
  
          ArrayList<ActivityStack> stacks = mHomeStack.mStacks;
          final int topNdx = stacks.size() - 1;
          if (topNdx <= 0) {
              return;
          }
          ActivityStack topStack = stacks.get(topNdx);
          final boolean homeInFront = topStack == mHomeStack;
          if (homeInFront != toFront) {
              mLastFocusedStack = topStack;
              stacks.remove(mHomeStack);
              stacks.add(toFront ? topNdx : 0, mHomeStack);
              mFocusedStack = stacks.get(topNdx);//MASTERMAN
              if (DEBUG_STACK) Slog.d(TAG, "moveHomeTask: topStack old=" + topStack + " new="
                      + mFocusedStack);
          }
      }

### Septemper -- 07

  - 矢量图和位图的区别
    - 1. 矢量图是根据几何特性来绘制图形，是用线段和曲线描述图像，矢量可以是一个点或一条线，矢量图只能靠软件生成．
    - 2. 矢量图文件占用内在空间较小.
    - 3. 矢量图与分别率无关，可以将它缩放到任意大小和任意分辨率，不会影响清晰图．
    - 4. 位图色彩丰富．类型多．
    - 5. 矢量图可以自由转化为位图．
　　　　
  - jadx-gui反编译apk
    - 1. git clone https://github.com/skylot/jadx.git 
    - 2. cd jadx ; ./gradlew dist
    - 3. 把apk改成zip
    - 4. 解压zip
    - 5. 将class.dex文件放到jadx/build/jadx/目录下．
    - 6. cd build/jadx/
    - 7. ./bin/jadx-gui classes.dex

### Septemper -- 08
    - 写布局文档
　　　　- android studio 最喜欢的字体　Source code pro
    - 当给android studio添加翻译插件出现乱码问题，解决：跟换option UI字体name. NOTO SANS


### Septemper -- 09
   - 根据文档看代码写一份精简的讲解文档．
   - 鼓捣一个开源app．GoApp×
   - 鼓捣一下后台数据库．√
   - 学做饭　√
   - 正确理解：同步和异步
     -   同步就是 下一个线程需要上一个线程的数据  没有上一个线程下一个线程无法运行
     - 异步就是  两个线程可能有数据交换  但是各自独自运行  相互之间没有影响。
  - 将获取的数据存储到服务器中．？

### Septemper -- 10
  - 理解字节
  - 整理ch02 √

***


### Septemper -- 11
  - 顺一遍．
  - 分析并解决，将通知栏和任务栏的布局分离．
    - 通知栏的大小和任务栏的大小有关．


  - FinBugs-IDEA //查bug插件  

  - 当使用TaskBar进行SystemUi的开发预料出现的问题
    - 1. 如果使用TaskBar则， 将StatusBar进行缩短到右下角很小的区域．
      这样则出现通知栏的尺寸也发生改变，就是：通知栏是依附于SystemUI．
      解决该问题，则要重构SystemUI让通知栏和任务栏分离．
    - 2. 将右下角的任务区域调整和通知栏的尺寸一样，这样就可以不用分离通知栏．
      这样实施出现的问题则就是，在通知区域的尺寸内，不能进行lock　icon


### Septemper-- 12
  - SystemUI组的二周任务计划
    - TaskBar
      - 1. 解决TaskBar和Launcher不能同时显示．
      - 2. 调整TaskBar和原生的StartupMenu的界面一致．

    - SystemUI
      - 1.将SystemUI的status_bar位置移动．
      - 2. 通知栏的点击触发区域处理．
      - 3. 和TaskBar的锁定栏结合．
    packages/apps/Provision/src/com/android/provision/DefaultActivity.java

    core/java/com/android/internal/app/ResolverActivity.java
  - p　-- 第一章√

### Septemper -- 13
  - 解决TaskBar和launcher的共存问题．
  - gsettings set com.canonical.Unity.Launcher launcher-position Bottom //启动栏放到底部
  - gsettings set com.canonical.Unity.Launcher launcher-position Left //放到左侧
  - 雪儿
    - 菏泽市立医院
    - 心内介入
    - 弟弟在铁职
    - 周二夜班
    - 周一比较忙
  - kill surface --> 刷新
  - 反射
    - 
  - 1. TaskBar打开一个窗口出现一个背景launcher．
    - 1. 是7.0的窗口效果．√
    - 2. TaskBar设计的


import static android.app.ActivityManager.StackId.DOCKED_STACK_ID;
import static android.app.ActivityManager.StackId.FREEFORM_WORKSPACE_STACK_ID;
import static android.app.ActivityManager.StackId.FULLSCREEN_WORKSPACE_STACK_ID;
import static android.app.ActivityManager.StackId.HOME_STACK_ID;
import static android.app.ActivityManager.StackId.INVALID_STACK_ID;
import static android.app.ActivityManager.StackId.PINNED_STACK_ID;

***
### Septemper -- 14
  - 7.1将Stack -- > Task
  - 在每一个Stack中有多个Task.

  - Launcher －－　＞　stackId == 1
  - TaskBar －－＞

### Septemper -- 15
  - ActivityStack --> 栈．
  - ActivityStackSuper --> HomeStack
  - 在service中显示需要把dialog设置成一个系统的dialog，即全局性质的提示框.


### Septemper -- 16
  - 研究TaskBar和Launcher问题．
    - 将TaskBar移植到SystemUI
      - 0.　java文件/res文件/移动√
      - 1. 修改包名√
      - 2. 修改Android.mk　？
      - 3. 修改AndroidManifext.xml
      - 4. 编译报错修改．
  - 鼓捣一个app.
  - 整理一套工作开发使用教程：
    - 1. vim.√
    - 2. git.√
    - 3. ubuntu.√
    - 4. 配置开发编译环境．
    - 5. 聪的笔记 √

%s/farmerbb/android.systemui/g

android.systemui
  - vector
  - Android Methods Count //android studio插件 显示依赖数量．
  - Lifecycle Sorter //声明周期排序
  //可以根据Activity或者fragment的生命周期对其生命周期方法位置进行先后排序，快捷键Ctrl + alt + K

***
### Septemper -- 18

final Resources res = mContext.getResources();

res.getDimensionPixelSize(
                com.android.internal.R.dimen.status_bar_height);

***

### Septemper -- 19
  - 当google浏览器在有网络的情况下出现无法连接网络的问题．
    - 原因：使用lantern没有正常关闭
    - 解决： 启动lantern．
  - Ubuntu根目录下各个文件的功能介绍:
    - /bin/ :存储二进制可执行命令文件．
    - /sbin/ : 系统命令的存储位置.
    - /root/ : 超级用户.
    - /home/ : 普通用户的默认目录(用户名文件夹)
    - /mnt/ : 通常包括系统引导后被挂载的文件系统的挂载点．
    - /dev/ : 存储设备文件，包括计算机的所有外部设备，如硬盘、是、键盘、鼠标等.
    - /etc/ :   存放文件管理配置文件和目录.(主要的配置文件:例如：jdk配置)
    - /lib/ :  存储各种程序所需要的共享库文件.
    - /var/ : 用于存放很多不断变化的文件，例如日志文件.
    - /usr/ : 包括与系统用户直接有关的文件和目录.(放第三方软件)
    - /media/ :  存放Ubuntu系统自动挂载的设备文件.
    - /tmp/ : 这是一个虚拟目录，它是内存的映射，包括系统信息和进程信息.
    - /initrd/ : 用来加载启动时临时挂载的initrd.img映像文件，以及载入所要的设备模块目录.
    - /opt/ : 作为可选文件和程序的存放目录，否则将无法引导计算机进入操作系统.
    - /srv/ :   存储系统提供的服务数据.
    - /sys/ :  系统设备和文件层次结构，并向用户程序提供详细的内核数据信息.

  - vim 技巧更新
    - 可视化模式下对文本操作
      - 1.单词拷贝
        - v + w + y  //w表示单词，点击次数表示个数．
      - 2. 段落拷贝
        -　v + i + p
        - 应用：　v + i + p + y + j + j + p//复制整段然后粘贴在下面．
　     - 3. 选中大括号之间的所有内容：
        - vi + num + [ //num表示几层．
　　　　　　　　- vi + num + ( 
      - 4. 替换
        - :%s /foo/bar/g //文件所有内容
        - :s /foo/bar/g  //本行
      - 5.重做上一个动作
        - Ctrl + r

  - TaskBar在全屏时，被覆盖．
  - StatusBarIconController.java //7.1新增类对status_bar上的icon进行控制．
  - service上不能弹出普通dialog,但可以弹出Alert　dialog,且若出现变暗使用：
　　　　lp.dimAmount =0;

  - pm指令:
    - pm list packages -f //列出所有ａpk信息
  - ubuntu修改挂载的磁盘名称
    - 1. sudo fdisk -l
    - 2. sudo umount /dev/sdc1
    - 3. sudo ntfslabel /dev/sdc1 DISK  //最后的但是是　new name
    

***

### Septemper  -- 20
  - 查看CPU 信息
    - cat /proc/cpuinfo
  - 查看内存
    - free -m
  - htop
    - sudo apt-get install htop
  - FrameLayout布局是五大布局中消耗资源最少且最简单的．
  - clipToPadding属性
    -滑动的时候就忽视paddingTop./false
    - 若为true就保有
  - clipChildren属性
    - 意思是是否限制子视图在其范围内.
    - 作用: 当底部放置一个图片，希望高度不和root View一致．保有高出的部分．
  
  - layout/keyguard_status_view //最上面的日期　用户
  - system_icons.xml  //status_bar 和　ｎotification共用的图标．
  - android studio中进行选择构造器时，多选时按住shift键．


### Septemper -- 21
  - TaskBar启动应用只是发送: FREEFORM_WORKSPACE_STACK_ID = 2. 在ＡcitivityManager中有定义，
  启动应用的应用进入free form栈(多窗口栈)，　由于Launcher在Ｈome栈，不在同一个栈，故将Ｌauncher覆盖．
  至于TaskBar则只是设置：WindowManager.LayoutParams.TYPE_PHONE（该窗口通常置于所有应用之上, 但在状态栏下）
 对Launcher问题没有影响．  在arm版recent窗口下呈现的则和这个情况一样．　 

### Septemper -- 22
  - 任务总结：
    - 分析完成launcher问题
    - SystemUI
      - 通知栏事件响应区域控制．
      - 去除navigationBar
      - 将status bar位置控制在右下角

    -   

### Septemper -- 23
  - DDR4 2133频率的内存.
   - http://tieba.baidu.com/p/4469570411
   - http://tieba.baidu.com/p/3463329838
   - http://www.iqiyi.com/w_19rvivvd95.html

### Septemper - 24
  - vim的高级使用
    - set ai //设置自动缩进．
    - /usr/share/vim/vim74
  - java７高级

### Septemer --25
  - 反思： 在最初的SystemUI的设计应该多交流，避免设计出错，多做无用工作．
  - 设计分析
    - 对于使用Taskbar作为上层应用暴露的问题:
      - 1. multiwindow实现最小化．
      - 2. 打开应用获取已开应用的焦点．
    - 棘手问题产生的原因: 主要因为上层应用和系统交互问题．
    - 故计划：放到SystemUI中．
    - 对于Taskbar的使用，之前的方案是在Taskbar上改造出StartupMenu, 重新分析：
      - 1. 将TaskBar代码逻辑复杂，不易改造维护，完全实现全部需求，会重新设计实现．
      - 2. TaskBar中带的任务栏并不能充当需求的任务栏．
    - 相反，如果根据TaskBar的代码来改造StartupMenu则易于实现：
      - 1. 改变打开应用的启动方式也能TaskBar中一样呈现多窗口．
      - 2. StartupMenu自己写易于维护和修改．
    - 故计划：不再继续改造TaskBar，而是使用借鉴TaskBar修改StartupMenu.
    - 对于使用StartupMenu后，对于任务栏的实现也有两套方案:
      1. 改造原有的StatusBar.
        - 缺点: StatusBar实现逻辑耦合性太强，后期维护麻烦．
        - 优点：5.1已经进行尝试，有经验可以参考．
      2. 根据原有StatusBar在NavigationBar上实现．
        - 缺点: 基本类似于自己从新实现，代码量大．
        - 优点: 便于后期维护，也利于以后迭代． 
    - 目前确定: 两种方案都可以满足需求．经讨论他们更趋向方案 - 2.
    综上计划:
      - 1. StartupMenu实现启动应用多窗口.
      - 2. 将StartupMenu的Activity变为Dialog或popupWindow.
      - 3. 将StartupMenu移植到SystemUI．
      - 4. 完成任务栏的初步布局．
      - 5. 实现在任务栏上启动StartupMenu. 


***

#### SystemUI的需求文档:
  - StartupMenu:
    - 1. 应用显示列表:
      - 1. 搜索
      - 2. 安装时间/使用频率/A-Z/ 排序
      - 3. 拖拽/分类(后期)
      - 4. 点击启动
      - 5. 右键菜单(长按)
        - 1. 锁定任务栏/解除锁定
        - 2. 打开/模式运行(手机/桌面)
        - 3. 卸载
    - 2. 常用列表
      - 1. 使用频率的自动排序
      - 2. 右键菜单和应用显示列表一样．
    - 3. Fm/Setting
    - 4. 关机界面
      - 1. 关机
      - 2. 重启
      - 3. 锁屏
      - 4. 休眠
    - 5.任务栏
      - 1. 显示已打开应用Icon/显示锁定的Icon
      - 2. 右键(长按)弹出菜单(icon):
        - 1. 锁定/解除锁定
        - 2. 打开/模式运行(手机/桌面)
      - 3. 点击运行(已经锁定Icon)
      - 4. 右键(长按)显示Dialog(非Icon区域)
        - 1. 任务栏显示
        - 2. 任务栏隐藏
      - 5. icon滚动效果(后期)
      - 6. 输入法
      - 7. 电池
      - 8. wifi
      - 9. 通知栏
        - 1. 显示通知信息
　　　　　　　　  - 1. 可关闭
        - 2. 显示打印信息
        - 3. 清除所有
        - 4. 通知管理
        - 5. 隔离
        - 6. 截屏
        - 7. 设置
        - 8. 投影
      - 10. 日历
      - 11. home键

*** 

  - 查找 dir 目录下所有包含 str 的文件
    - grep -lr 'str' dir
  - vim替换单个文件中所有字符串方法
    - :%s/old/new/g
  - 替换目录及子目录下所有文件中到某个字符串——sed结合grep
    - sed -i "s/old/new/g" `grep 'old' -rl dir`    

  - android:exported 属性
    - 如果不需要与其他应用程序进行数据共享，就应该在manifest文件中设置android:exported="false"。
    

### Septemper-26
  - 第一周任务安排

罗俊欢:
    - 1. StartupMenu实现多窗口/增添缺失的feature.
    - 2. StartupMenu移入SystemUI.
    - 3. StartupMenu和任务栏交互(数据库部分)

刘晓旭和曹永韧:
    - 4. 任务栏布局实现.
    - 5. StartupMenu在任务栏上完成启动．

罗浩 :
    - 6. 已打开的应用最小化和系统的交互(5完成前可先调研逻辑)．
　　　

  - 第二周任务安排
    - 1. 通知栏的启动
    - 2. 各种Dialog: 输入法/电量/网络/日历/Home.
    - 3. 任务栏显示/隐藏．/右键．
    - 4. 通知栏的重构(布局修改为openthos)


***

### Septemper - 27
  - ayout_gravity="end"
    - 从后面往前排列．
  - nav_bar_tuner_inflater.xml
    - navigation_bar_size
  - git 添加所有文件：
    - git add .
  - git 复原错误添加的文件
    - git reset HEAD^ fil

### Septemper - 28
  - Apple ID
    - matthewcaoyongren@163.com
    - Caoyongren00
    - 禹朴勇
    - 产品经理
    - 成武县
  - 将前面的几次提交做成一个补丁:
    - 1. git checkout -b dev
    - 2. git reset --hard commitId
    - 3. git merge master --squash
    - 4. commit / format-patch


09-28 08:58:47.532  3495  3495 I MasterMan: PanelBar:: onTouchEvent return mPanel  true
09-28 08:58:47.533  3495  3495 I MasterMan: PoneStatusBarView:: onTouchEvent + returnfalse
09-28 08:58:47.533  3495  3495 I MasterMan: PanelBar:: onTouchEvent return mPanel  false
09-28 08:58:47.533  3495  3495 I MasterMan: PanelView--> : onTouchvent
09-28 08:58:47.533  3495  3495 I MasterMan: PanelView--> : onTouchvent: return true

//正常: PanelBar --> onTouchEvent 此时mPanel == null故return true
--> 消费
PhoneStatusBarView --> onTouchEvent return false -- > PanelBar --> onTouchEvent --> mPanel != null
  -- > mPanel.onTouchEvent(event); ---> PanelView -- > expand

//解决:
1. 关键是mPanel的初始化，setPanel的调用．

2. 模仿PhoneStatusBarView，借助NavigationBarView.

================================================
### Septemper - 29
  - fn + 9　风扇全速．
  - 1. 通知栏应该从低层弹出．
  - 2. 序列化存储．
  - 月报:
  https://github.com/openthos/community-analysis/blob/master/weekly%20report/Mounth%20Report%20about%20SystemUI%20Group.md
  - 周报:
  https://github.com/openthos/community-analysis/blob/master/weekly%20report/Weekly_report_about_SystemUI.md
  - 数据的优化和通用．

=================================================
### October - 3
  - ipad出现烧焦的味道．
### October - 04
  - scroll六种方法√
  - Android绘图机巧
    - 屏幕参数
      - 屏幕大小: 指屏幕对角线的长度
      - 分辨率: 手机屏幕的像素点数． 720 * 1280
      - PPI: 每英寸的像素．  对角线/屏幕的大小．

## October 7
  - 1. 把一双帆布鞋和一条运动裤和一个长袖放家里．(春秋季节衣服)
  - 2. 回到北京把一些不怎么穿的衣服和棉袄邮回家.(家里总要放些自己的衣服)
  - 3. 坚持把每天的事记录下来, 工作/生活/想法/
  - 4. 大健康是一个方向.大健康　+ 大数据　+ 人工智能
  - 5. linux上安装matlab
  - 6. Android studio 进行编辑窗口分行:
    - Window --> Editor tabs --> 最后一个
  - 7. 八一路的菏泽老一中

## October 8
  - 菏泽老一中(八一路)　火车站做14路车.
  - 火车返京遇见周冬琴

## October 9
  - 收拾拍的
  - 看完人民的民义
  - 收拾要邮回家的衣服.

=============================================
song:
like: food: fentiao daxia zao wendemei daohuaxiang-meigui ganbianhuacai qingcai liangpi
buchi: yangrou
cloth: naibai 
changwei butaihao  bukeyi he liang shui 
yi yunche
jinshi 300du
fuqin dianhan

zhousan zhouwu you ke 
=============================================

==================================================================================================== end























