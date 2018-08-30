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

## 记录每天的事


### October - 10
  - Plan
    - 1. 通知栏布局
      - 可以在外布局中使用线性布局．
    - 2. 使用老毛桃实现win7 ＋　openthos双系统．
      - win-300G (其他盘随便搞)
    

### October - 11
  - 1. 通知栏布局置底问题．
  - 2. 去除原有status_bar
    - PhoneStatusBar mStatusBarView.setVisibility(View.GONE)
    - StatusBarWindowManager.java -- > barHeight = 0;
  - 3. android 8.0配置√
  - 4. 布局已经类似openthos.

  - ctrl + alt + A // git add

  - ctrl + K  //git commit

### October - 12
  - 1. 10 个Linux指令
    - 1. file logo.png //输出图像的尺寸
    - 2. tree //树形展示
      - tree -d//只显示目录的名字
    - 3. htop //进程资源查看
    - 4. sudo ssserver -p 8388 -k password -m rc4-md5 -d start
  - 合并代码
    - 冲突的文件可以修改补丁(冲突处手动应用补丁)
  - 启动8.0(本地)
    - 1. cd /out/product/target/emu_x86_64/
    - 2. system-qemu.img  build.prop 替换启动文件中的文件．
    - 3. 在启动文件中:emu_8.0    ./run_emulator.sh
  -指令对比:
    which       查看可执行文件的位置 
    whereis    　查看文件的位置 
    locate      配 合数据库查看文件位置 
    find        实际搜寻硬盘查询文件名称 
  - docker 中配置repo
    - which repo
      - /usr/bin/repo
  - alt + space　　//弹出窗口

  - 设置自动挂载
    - sudo vim /etc/fstab
    - 填写: 注意Linux类型是：　ext4

### October - 13
  - 1. 8.0的初步移植．
  - 2. java 8.0的新语法规则：
    - 1. :: 双冒号操作符
      - ①: 引用静态方法做参数// String::valueOf
      - ②: 引用非静态方法做参数// Object::toString
      - ③: 构造器//ArrayList::new
  - 3. 应用补丁:
    - 1. git apply //打上补丁但是并不进行commit
      - 出现冲突:
        - git apply --rej patch //将不冲突的进行应用，冲突的指明；
    - 2. git am patch　//应用补丁自动提交
      - 出现冲突:
        - 这时需要先进行: git apply --rej patch
        - 手动解决冲突后:
          - git am --resolved //直接按照原有的补丁描述进行提交．
            - 但是：原修改的文件还在．
           - 或者: git am --continue
***

### October - 14
  - 匠人时代
  - 双系统√
  - NavigationBarFrame.java 
  - 初始化镜像: 删除*.qcow2文件 和　替换 userdata-qemu.img

### October - 15
  - navigation_bar.xml --> NavigationBarFragment  主要的布局．
  - 制作了手写计划
  - 陆逊火烧联营．

### October - 16
  - 任务栏和通知栏实现．
　   - NavigationBarFragment -- > navigation_bar.xml
                                 -- > NavigationBarInflaterView.java
                                 //
  - 提交部分修改的代码:
    - git commit file1 file2.

### October -17
  - 实现通知栏
    - NavigationBarFrame  --　> navigation_bar_window
    - 可以将NavigationBarFragment中的navigation_bar_window　-- > navigation_bar_view.
    - shift + n  //上一个
    - NavigationBar中可以获取到StatusBar.
    

### October - 18
  - 袜子 + 春游垫子
  -     public void showCustomNotificationPanel() {
        Toast.makeText(mContext, "click-- > panel", Toast.LENGTH_LONG).show();
        Log.i("MasterMan---> statusBar:", "---------showCustomNotificationPanel: ");
    }
  - git am --abort //当git am 失败后执行.
  - git format-patch 应用
    - 1. 把某次的提交生成补丁:
      git format-patch -n + commitLastId 
      git format-patch commitLastId //将LastCommitId之前的所有提交一补丁输出．

### October -19
  - StatusBar 通过AIDL与AMS WMS进行交互.
  - statusBar 中要获取到OpenthosStatusBarView的实例．
  - 最佳方案:
    - 在StatusBar中通过windowManager.ad一个View进行替换navigationBarView.
  - 对于误操作：git reset --hard commitId
    - git reflog 看到提交记录
    - git reset --hard commitId

### October - 20
  - chmod -R 777 Oreo_one_version/
  - 北大翟尚请吃了饭．
  - make 编译不能正确编译xml文件．例如: @dimen/size. size 没有定义却不会报错．
 
### October - 21
  - 潘月新来北京学大数据．
  - 送走刘蕊．
  - 去大表哥家
  - 去老王宿舍看了看．

### October - 22
  - 未来人类安装内存条的教程．√
  - Oreo8.0 SystemUI分析的文档．
  - 本地搭建第一个Oreo8.0版本．√
  - 入门Kotlin．√
  - 双手握无限，刹那是永恒．



### October - 23
  - /home/matthew/.gradle/wrapper/dists    //gradle path
  - sudo apt-get remove --purge libreoffice*  //清理软件
  - sudo apt-get remove unity-webapps-common  //清理亚马逊．
  - 潘月新python --miqq．
  - win 没有播放视屏没有声音，更新驱动．

### October - 24
  - 1024
  - ubuntu输入出现两个输入框
    - ps -A | grep fctix
    - kill id　3
  - wget -qO- https://raw.github.com/ma6174/vim/master/setup.sh | sh //配置vim
  - mongodb 
    - mongod
    - mongo //进入
  - 爬虫
    - 请求网站提取数据的自动化程序．
    - 基本流程
      - 发送请求  request 
      - 获取响应内容　response
      - 解析内容  html
      - 保存数据
  - google 
    - f11 --> network --> all
    - post get 请求
  - 实例:
    - 1. reponse = requests.get('url')  //请求
    - 2. print(reponse.status_code)　　//状态码
    - 3. print(peponse.content)　//打印内容
    - 4. with open('/home/matthew/tmp/1.png', 'wb') as f:　　//f
    - 5. f.close()  //关闭

### 10 - 25
  - lock / sleep 
  - 通知栏的中文问题
  - python最具特色的就是使用缩进来表示代码块，不需要使用大括号({})。
  - Oreo: frameworks: base: add sleep feature to PowerSourceActivity.

### October - 26
  - vim + ctags + cscope + taglist
  - android studio 3.0新特性
    - 1. kotlin
    - 2. java 8
    - 3. Instant Apps支持
  2、分配一个常量数组，Kotlin调用的是intArrayOf方法，并不使用new关键字；
    推而广之，其它类型的数组也各有自己的数组类型，以及对应分配常量数组的方法，说明如下：
    长整型数组：数组类型为LongArray，分配方法为longArrayOf；
    浮点数组：数组类型为FloatArray，分配方法为floatArrayOf；
    双精度数组：数组类型为DoubleArray，分配方法为doubleArrayOf；
    布尔型数组：数组类型为BooleanArray，分配方法为booleanArrayOf；
    字符数组：数组类型为CharArray，分配方法为charArrayOf；
var long_array:LongArray = longArrayOf(1, 2, 3)
var float_array:FloatArray = floatArrayOf(1.0f, 2.0f, 3.0f)
var double_array:DoubleArray = doubleArrayOf(1.0, 2.0, 3.0)
var boolean_array:BooleanArray = booleanArrayOf(true, false, true)
var char_array:CharArray = charArrayOf('a', 'b', 'c')
  - Kotlin 实现　冒泡排序．

### October - 27
  - git log --author "CaoYongren"
  - 如果要查看 Git 仓库中，2008 年 10 月期间，Junio Hamano 提交的但未合并的测试脚本（位于项目的 t/ 目录下的文件），可以用下面的查询命令：
  -  git log --pretty="%h - %s" --author=gitster --since="2008-10-01" \
   --before="2008-11-01" --no-merges -- t/
  - 1. git log - n //指定最近n条提交
  - 2. git log --since=2,weeks //最近两周的提交


### October - 28
  - 爬长城
### October - 29
  - 找房子

### October - 30
  - 最小化分析
  - AIDL分析
  - 实现任务栏的显示/隐藏
    - 仿照: setStatusBarVisibility()实现．
  - 清理ubuntu的垃圾:
    - 1. sudo du -h /var/cache/apt/archives
      - 删除安装包
    - 2. sudo apt-get autoremove
    - 3. sudo apt-get autoclean
    - 4. sudo apt-get clean
    - 5. synaptic //在应用中找到可视化打开．
      - 应用前需要排序．
    - 现有vim配置文件中复制粘贴需要：　按住shift
  - 文档
    - 1. StartupMenu的实现
    - 2. StatusBar的实现
    - 3. 通知栏的实现

  - 问题:
    - 1. U.java做SystemUI的工具类，name --> UtilSystemUI.java
    - 2. BaseDialog.java 去除log．
    - 3. AppEntry.java 去除空行．
    - 4. StartupMenu左侧视图--> start_menu_left_common_list
    - 5. StartupMenu右侧视图--> start_menu_right_app_grid
    - 6. row --> item . item_start_menu_list item_start_menu_grid.
    - StartupMenuDialog.java
      - common + list + adapter
      - app + gride + adapter
      - refreshApps 方法多考虑优化．

    - OpenthosStatusBarView.java 代码需要优化．
      - 可以将最小化和和dialog放在OpenthosStatusBarView中．

### October - 31
  - 通知栏语言适配
  - 任务栏显示与隐藏

### November - 01
  - 已买烧水壶．
  - http://bj.58.com/zufang/31928850640181x.shtml?from=1-list-2&iuType=_undefined&PGTID=0d300008-004d-5214-3b54-2c12a1a7e868&ClickID=6//58
  - 整理dialog 的长按弹出hide/show的代码．
  - 三个分之:
    - 1. multiwindow: 用于保留补丁/提交
    - 2. TestOpenthos: 用于开发实践
    - 3. NewOpenthos: 用于原始版本．

### November -02
  - 整理文档
  - 通知栏点击启动的　后，要消失．
  - 任务栏的显示/隐藏 控制.
  - 布局/字体/
  - 点击home键，通知栏不消失．
  - 可以充电3.5个小时.

### November - 03
  - Magic 2699
  - https://github.com/openthos/desktop-analysis/blob/master/instructions/%E9%94%AE%E7%9B%98%E6%98%A0%E5%B0%84.md
  - https://github.com/openthos/multiwin-analysis/tree/master/multiwindow

### November - 04
  - 找房: 张姐

### November - 05
  - 7.1上最小化实现与文档.
    - 系统的AIDL: 需要在Android.mk添加:
      - core/java/com/android/internal/statusbar/IStatusBar.aidl \
      - android 中的　stub
      - stub是为了方便client, service交互而生成出来的代码．
      - AIDL --> 运用而生．√

### November - 06
  - 通知栏实现方案确认．
  - 最小化文档完成
  - Oreo 8.0的bug列出并解决．
  - Oreo上通知消息显示是依附在通知栏上的．右上角的提示信息属于增加的不是修改
　　　　出现的bug.
  - 本周实现:
    - 通知栏消息出现的item有序不重叠.
    - 颜色和通知栏一致．
    - 调研 右上角增加消息．

### November - 07
  - c6c87b2accbcea34957c72dd6868a611a3a92e08
  - 获取一个补丁: git format-patch -1 commitId
+    <View
+        android:background="@drawable/system_bar_background"
+        android:layout_width="match_parent"
+       android:layout_height="match_parent"/>

### November - 08
  - packages/SystemUI/res/layout/status_bar_notification_row.xml
  -     android:background="e00402080"
  - 问题的关键在于: 白色是设置的，　设置的自然有color.
  - notification_info.xml  //长按弹出的布局.

### November - 09
  - 通知栏怎么接收到的通知消息.
  - 再次点击home键进行复原.
  - 重新编译不需要make clean 只是进行删除out里面的system
  - U型枕头套拿来．
  - 笔记本信息:
    - 型号：　T5-SKYLAKE-970M-67SH2
    - 黑色/intel
    - cup: i7-6700HQ  / 2.6HZ
    - 三级缓存: 6M 
    - 核心: 4核
    - 内存: 2 * 8 / DDR4 2133MHZ
    - 显示芯片:  NVIDIA GeForce GTX970M  / 显存：　3G
    - 15.6寸/ 16 : 9   1920 * 1080
    - 屏幕: LED背光
    - 全尺寸巧克力单色背光键盘
    - 4芯聚合物电池，60WH   电源适配器 :100-240V自适应交流电源适配器
    - > 2.5kg

### November - 10
  - 设置-强制使用从右向左的布局方向:  通知栏布局出现问题.
  - 字体调整到最大: 任务栏消失．
  - 打开文件管理器有时任务栏出现两个图标.
  - 关机界面存在问题
  - StartupMenu弹出dialog, 在任务栏点击startupMenu消失dialog不消失．
  - 通知栏出现概率性弹出失败．
  - 通知栏启动一个例如: 通知管理. 通知栏不消失．
  - 任务栏长按弹出的dialog，空白区域点击不消失．
  - 点击home键需要将SysemUI的dialog也消失，再次点击已经打开的窗口复原．
  - 任务栏启动应用时, 消失dialog.

### November - 11
  - 见了聂丽一个南方女孩

### November - 12
  - 去森林公园
  - 学习j死
  - 看天才引导历程

### November - 13
  - 分析下面三个问题：
  　　- 1、fotomanager 进入图片->右上角选项->更多->关于照片管理器->向下拖动页面以查看未显示内容时，页面退出
  　　- 2、fotomanager 进入图片->编辑图片并按esc保存->按esc退回 到相册列表没有修改后的图片，重启fotomanager才能查看
  　　- 3、fotomanager 设置标签功能不可用
  - //debugger --> 从左至右
  - 下一步/ 进入方法　/ 进入源码 / 返回　/ 进入下一个debugger点．

### November - 14
  -  WebSettings settings = wv.getSettings();//控制webview;
  - 修改hosts
    - 原有的存为: hosts.copy
    - sudo /etc/init.d/networking restart //刷新
    - vim /etc/shadowsocks.json

### November - 15
    - git branch -a  //查看所有分之．
    - git push origin master:refs/heads/qa-master //解释：将自己的分之推送到QA团队中．

SystemUI-Notification

1736 VLC播放mp3文件后需要在通知栏点两次叉才能关闭．×
1183 如附件截图所示，通知栏在有通知的情况下，清楚所有的按钮置灰不可用　偶现
1962 解锁一个任务栏的图标，旁边图标也跟着一起解锁 偶现
1849 任务栏时间会突然出错,再变为正常时间,偶现
1756 打开VLC播放视频,任务栏时间日历变暗,关闭播放界面,时间颜色正常．×
1740 设置字体为超大时，电源菜单选项显示不全. √
1717 20170720版本按win键弹出开始菜单,再次按开始菜单不消失,连续按win键,开始菜单会有闪烁,鼠标点击桌面空白处,开始菜单也不消失. 偶现
SystemUI-start/status

1705 改变窗口大小和拖动窗口左右停靠时，任务栏显示系统应用图标，如图　×
1594 锁屏后马上进入黑屏状态。锁屏时间长些，比如半个小时，需要手动更改输入法，才能输入密码。偶现
1353 锁定任务栏,打开菜单图标,点击电源退出后,任务栏不显示.(隐藏任务栏情况下则可以)　√
1015 右下角日期显示不同步，前一天机器不休眠，过了零点后，任务栏上的日期变化，弹出的日历窗口日期不改变。√
873 通知中心切换到日期需要点击两次，其他（声音\电池等）均可正常切换. √
822 将声音关闭，用Fn调节音量时有声音，但是声音显示仍为关闭。
729 设置时间和日期后，右下角日历窗口中的日期天数阴影没有改变。√
716 自动隐藏的任务栏经常不会自动隐藏。×
702 开始菜单使用过程中，经常不会自己消失，比如，在开始菜单邮件弹出一个选项菜单，然后再底部任务栏随意切换一个应用或者alt＋tab 切换应用，然后alt＋tab 查看桌面，或者点击右下查看桌面。就会发现开始菜单的存在．
=======================

localhost.localdomain 
176.122.158.69

Install new OS

Operating system is currently being reinstalled, and it can take up to 15 minutes to complete.

Once finished, you will receive an e-mail notification at m18410261910@163.com

You will need a new root password to access your VPS: OvdjV9CvWTmp   caoyongren00

New SSH Port: 26012

root

ssh 用户名@IP地址 -p 端口号


{
"server":"176.122.158.69",
"server_port":26012,
"local_port":1080,
"password":"caoyongren00",
"timeout":600,
"method":"aes-256-cfb"
}

caoyongren00

### ### November - 16
  - telnet 176.122.158.69 8888 //测试
  - 翻墙服务器搭建:
  - 1. 购买服务器
    - 1. 服务器上选择centerOs/ubuntu系统
    - 2. 启动/修改密码且记住/记住端口号/记住ip /root名字host name
      - ip: 176.122.158.69
      - port: 26012
      - 密码: caoyongren00
    - 2. 运行脚本:install_shadowsocks
      - 启动: sserver
      - 查看ip; curl ip.cn
      脚本中有配置：
　　　　　　  1   {                                                                         
  2       "server":"0.0.0.0",
  3       "port_password":{
  4          ┊   ┊   ┊   ┊"8888":"shadowsocks",
  5          ┊   ┊   ┊   ┊"9999":"shadowsocks"     
  6     }, 
  7     ┊   "timeout":300,
  8     ┊   "method":"aes-256-cfb",
  9     ┊   "fast_open":false,
 10     ┊   "workers":1
 11 　｝
  - 2. 配置客户端shadowsocks
    0. ssh root@176.122.158.69　登录/密码: caoyongren00
    1. 安装: shadowsocks-Qt5(百度很多)
      apt-get install python-gevent python-pip
      apt-get install python-m2crypto 
      pip install shadowsocks
    2. 配置shadowSocks 对应--> 服务器端的配置
      Server adress: 176.122.158.69
      Server port: 8888
      password: shadowsocks  切记：不是申请服务器的密码
      local address: 127.0.0.1
      local port: 1080
      选择: socks
      加密方式: AES-256-CFB
      aoto / debug : 打钩
  - 3 配置google插件:
    - 1. 云盘　工作必备: google翻墙
　　　　- 2. 新建profile
       - 1. socks5  127.0.0.1 1080
       - 2. 下面默认
　　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
补充：
服务器: 重装系统
修改密码: root shell-interactive.
使用: ssh 
rm known_hosts


wU2UHOu9BejY
------
  - 报错: - dagger-compiler-2.0.2.jar (com.google.dagger:dagger-compiler:2.0.2)
  - 解决: annotationProcessor"com.google.dagger:dagger-compiler:2.0.2"
  - 袜子下周五查看，没有送到，退货！

### November - 17
  - ToInfinityAndBeyond
  - 宋青来清华看舞蹈
  - 买了服务器 要加强服务器的学习．

### November - 18
  - js 函数与对象
  - 洗衣服
  - 看重返狼群


### November - 19
  - js 学DOM　√
  - Ghost学习主流框架√
  - 写下周计划；
  - 蓝牙耳机在关机状态进行长按10秒，就可以做到重置，重新连接．

### November - 20
  - 1. fotomanager去掉功能，完善需要的feature;
  - 2. 分析 fotomanager 和　editer
    - 需要文档

### November - 21
  - 分析: 开源项目
  - EventBus
  - android studio中本类中修改一个变量
    1. ctrl + f进行搜索
    2. 点击后面的框, 进入修改
    3. studio 定制: settings --> live temples
      - 点击 + --> 添加: 快捷方式　--> 点击define --> 写实现什么
      1. 翻译插件: z + x
      2. 文件头标注: author
      3. fori --> for (){}
      4. ifi  --> if () {} else {}
      5. tag --> TAG
      6. Toast --> Toast.makeText().show();
      7. ifd --> if (MainActivity.DEBUG) { Log.i();}
  - 代码对比:
    Menu → VCS → Git → Compare With Branch
  - ctrl + u //定位到父类;
　　- ctrl + tab //选择框
　　- alt + shift --> 移动
　　- key-map --> plugin //设置快捷键
====================================
### November - 22
  - dagger
  - 写代码注意判断空指针；
    - 比如: 当接受广播，但控件没有初始化问题；
  - key0

### November - 23
  - studio中的签名配置文件
　　- dialog已经new了但是没有走onCreate方法；
    - dialog的init but, only show --> oncreate() 
    - from source code. //show method.

      - 将新建本地分支推送到远程分之(新建远程分支)
      -  git push orign -u newBranch (在当前要推送的分支上)
    - 删除远程分支：　本地分支删除后，　git push origin : newBranch (冒号代表删除)
    - git push origin local_branch:remote_branch (简洁)
    - 在本地目录下关联远程repository ：
       git remote add origin git@github.com:git_username/repository_name.git

    - 取消本地目录下关联的远程库：
       git remote remove origin

==================================

### November - 24
  - 另一个github账号: OnlyMatthew 密码: coayongren00 邮箱: 941636391@qq.com
    - 验证:
      - 基本协作开发流程:
        - 1. Collaborators --> 邮箱认证
        - 2. git 安装配置
        - 3. git clone --> git init
        - 4. git config
        - 5. git test
  - openthos上开发app需要导入jar包，　直接新建libs　然后import就可以;
    - 在studio中也是直接新建libs就可以
  - 提交补丁
    - 需求: 本地很多commit 需要push, 方法： 
      - 1. git fetch (放到缓存中) 
      - 2. git checkout remotes/openthos/multiwindow-oreo -b multiwindow-oreo (此时的分支和远程分之一致 应用了缓存)
      - 3. git merge 需要提补丁的分支　(所在分支是multiwindow-oreo)
      - 4. git push openthos multiwindow-oreo : multiwindow-oreo

    - git pull (拉代码)　和　git fetch --> git checkout --> git merge的区别
      - git fetch 可以指定分支 　git pull 默认
    - 在push 的时候: git push devorg multiwindow-oreo:refs/heads/multiwindow-oreo 做个解释
    - refs/heads/  和 remotes/openthos 一致
    - git merge 做个扩展(其实就是对之前的知识的)
      - 当服务器代码> 本地
      git fetch openthos --> git checkout remote_branch -b local_branch
      git checkout old_local_branch
      git merge local_branch

### November - 25
  - 请小烨吃饭
  - 看苹果体验店
  - 聚餐
  - NVIDIA GeForce GTX 970

### November - 26
  - 1. 帮潘月新安装win7
    - 小马激活工具 --> C盘需要格式化
  - 2. 签合同　周六搬家

### Nobember - 27
  - 重构FotoManager
    - GalleryCursorAdapterFromArray.java //refreshLocal()
  - AndroidStudio 3.0新建工程出现的问题:
    - Error:Unable to resolve dependency for ':app@debugAndroidTest/compileClasspath': 
      Could not resolve com.android.support.test:runner:1.0.1.
    - 解决:
      1- implementation 'com.android.support:appcompat-v7:26.1.0'
        ----> com.android.support:appcompat-v7:26.+
      2- 'com.android.support.test.espresso:espresso-core:3.0.1'
        ----->  androidTestImplementation 'com.android.support.test.espresso:espresso-core:2.2.2'
      3- androidTestImplementation 'com.android.support.test:runner:1.0.1'
        ------> androidTestImplementation 'com.android.support.test:runner:0.4'
  - Realm的使用--> 原理
  - 任务:
    1. 系统预装 mopria print service软件包 （从play store下载）
    2. 在软件商店中增加 canon print inkjet/selphie, epson iprint, brother print & scan, hp eprint等软件，
       上述列举只是实例，如果用户有反馈，需要不断增加支持的打印程序（均可从play store下载)
    3. android studio 在project模式可以查看所有的文件。
  - Your IntelliJ IDE evaluation has expired
  - 万里是副总理 泰安东平人  15年去世。

### November - 28
  - 安装: sqlite
  - pkg: org.mopria.printplugin    cmp: org.mopria.printplugin/.MoppriaInfoActivity
  -  adb shell monkey -p com.master.old.tv.view.activitys -v 
  - 代码检查
    - Analyse --> Inspect Code //只是建议
  - 分析依赖
    - Analyse --> Analyze Dependencies
  - 分析栈轨迹
    - Analyse --> Analyse stacktrace

### November -29
  - FotoGalleryActivity.java ---> 首页
    - reloadGui();//刷新

### November - 30
  - 	sudo apt-get install openshot
  - 关机界面使用--> dialog;


### December - 01
 - dialog --> 不能启动dialog;
 - 当Activity关闭时，立即取消掉网络请求结果处理。

### December - 02
  - 搬家

### December - 03
  - 新家收拾完毕

### December - 04
  - Version code 更改--> 应用商店进行升级。
  - editor -->　运行
    - ui 重构

  - 签名:
    - build - generate sign -> new jks(选择一个文件夹保存, keystore)
    - 填写密码　keyAlias等信息
    ---> f4 --> sign --> 选择jks　--name release --> gradle 会生成；

### December - 05
个人clone code 后为了正常运行进行了一些配置:

注释: //def GOOGLE_BILLING_KEY = properties.getProperty('GOOGLE_BILLING_KEY')

替换了KEYSTORE_ALIAS KEYSTORE_PASSWORD

修改
def GITHUB_USER = "caoyongren"
def GITHUB_PWD = "*******"

更改了gradle版本。

AppUtils.java中 verifySign修改－－> 注释检测直接 return true;

工具: studio 2.3.0 ubuntu 16.04系统

问题:

在小米手机上，7.1系统 MIUI9.1
可以正常运行，可以编辑,但是进行另存为出现奔溃下面图片为crash 提示(null object) [(官方应用可以)]
crash点击看图

我们定制的开源系统则更是出现点击就奔溃(错误显示我们系统底层原因)，但是官方应用则正常。

所以，我们想请教一下 出现这些问题的原因或者一些解决的意见。(目前除了上面配置的修改，其他没有修改)
说的有点啰嗦，希望您能得到回复。

### December - 06
  - 检测是否是官方发布的应用
  -  Signed-off-by: CaoYongren <m18410261910@163.com>
  - 推送报错:
    - 'git pull ...') before pushing again
    - 需要更新
    - git push x86 mutliwindow:multiwindow (简单写就可以)
　　　　- git fetch/pull/　需要写urｌ时，写x86(就是写分之就可以)

### December - 07
  - 920富文本编辑器，内核是用的ace(https://github.com/ajaxorg/ace), 我们build项目前需要先编译ace(node Makefile.dryice.js), 
    - 这样就可以把js文件写入项目，
    - 项目就能运行了， 如果　throw　error, 就需要安装npm, 安装了npm 还是报错：https://github.com/nodejs/help/issues/663
    - 我是通过npm install 来解决的，　上面链接还有其他解决方案；
    
### December - 08
  - 1. 锁定8.0可以920使用的版本.
  - 2. 锁定openthos上的editor出现问题的版本.
  - 3. code中出现问题的原因.
  - 4. 第一场话剧

### December - 09
  - 1. 给老王搬家

### December - 10
  - 陪宋看电影吃龙腾轩。

### December - 11
  - java.lang.AbstractMethodError: 问题
  - 因为系统增加api IsLauncherFocus()
    - AbstractMethodError问题: 由于系统api调用出现问题造成。
  - 使用3.0的性能分析
    - 1. Memory 
      1. 右上角垃圾桶代表gc, 当内存泄露时省略的白线会一直增加。
        - 1实践: 一个app反复关闭开启五次，　点击垃圾桶看变化。
      2. 下载图标是堆栈调用
        - 实践: 选择package然后点击一个activity，在右上角看到几个实例；
  - 忠于自己。
  - ijkplayer:    属于软解码
    - 软解码就是占用cpu的运行，耗费性能；
    - 硬解码则是通过GPU模块来解，　需要硬件支持；

### December - 12
  - android 3.0适配项目解决的问题:
    - 1. rror:Unable to start the daemon process.
      - 解决: 1.打开 gradle.properties 
              2. 增加: org.gradle.jvmargs=-Xmx1024m 
      blog: https://stackoverflow.com/questions/25009717/android-studio-gradle-project-unable-to-start-the-daemon-process-initializatio
    - 2. Error:All flavors must now belong to a named flavor dimension.
      - 解决: 
          android { 
              ...
                  flavorDimensions "default"
              ...
          }
      - blog：　https://stackoverflow.com/questions/44105127/android-studio-3-0-flavor-dimension-issue
　　　　- 3. Warning:Using incompatible plugins for the annotation processing: android-apt. This may result in an unexpected behavior.
        - 解决: compile 'com.jakewharton:butterknife:8.8.1'
                annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
阿里是如何支撑 17.5万笔/秒的下单峰值的？
数万台服务器是如何在十分钟内快速部署的？
3000万用户使用的“拍立淘”是怎么做图像搜索与识别的？
7秒交易过亿的苏宁易购如何保证库存系统的稳定？
以闪购为卖点的唯品会是如何应对线上压测的？
  - git remote add origin git://192.168.0.185/TextEditor.git
  - git push origin multiwindow:multiwindow
     
### December - 13
  - 配置不可卸载的应用
    - 举例: fennec
      - 1. device/generic/common/prebuilt-app/
          新建: Fennec/fennec-49.0.zh-rCN.android-i386.apk
          add: Android.mk
 11 LOCAL_PATH := $(call my-dir)
 12 
 13 include $(CLEAR_VARS)
 14 LOCAL_MODULE := Fennec
 15 LOCAL_SRC_FILES := fennec-49.0.zh-rCN.android-i386.apk
 16 LOCAL_MODULE_CLASS := APPS
 17 LOCAL_MODULE_SUFFIX := $(COMMON_ANDROID_PACKAGE_SUFFIX)
 18 LOCAL_MODULE_TAGS := optional
 19 LOCAL_CERTIFICATE := PRESIGNED
 20 #LOCAL_OVERRIDES_PACKAGES := Browser
 21 
 22 LOCAL_LIBS := $(shell zipinfo -1 $(LOCAL_PATH)/$(LOCAL_SRC_FILES) | grep ^lib/ | grep -v /$$)
 23 LOCAL_MODULE_TARGET_ARCH := x86
 24 LOCAL_PREBUILT_JNI_LIBS := $(addprefix @,$(filter lib/$(LOCAL_MODULE_TARGET_ARCH)/%,$(LOCAL_LIBS)))
 25 
 26 include $(BUILD_PREBUILT)

       - 2. /common/package.mk --> add Fennec    //Third party apps


### December -14
  - adb connect ip : 5555
  - ExternalApp remove 920editor/de.k3b.android.androFotoFinder/org.mopria.printplugin/VLC-Android-2.5.12-x86_64
  - 清理system / 清理　obj/APP/inter*

### December - 15
  - 忽略文件(在本地文件中添加后, git status就不再出现)
  - vim .gitignore 
  - 操作:
    - 当你本地的配置和服务器不一致
    - 你clone 服务器的code 
    - 然后进行本地配置，将配置的文件添加到.gitinore
    - 然后就会自动忽略配置文件的修改；
  - C6KVDMX9JC6F S青青
荣耀Magic(NTS-AL00)
型号 NTS-AL00
IMEI/SN S3V0217912000730
您的设备可以支持 中国

  - 使用手机自带email需要使用授权码进行登录；
  - 父: 37292429911969 0608 3918

### December - 16
  - 模仿实现轮播;
  - 跑步去邮电
  - 剪发办理了会员还有５次
  - 明天分析ijkplayer;

### December - 17
  - 陪S看城市之光见面会;


### December - 18
  - 尝试移植fotomanager到系统；
  - 绿色守护
    - 1. 分析绿色守护的作用
      - 手机已root的状态
        - 1. 主要针对: 不经常使用的应用和一些关闭之后后台还在运行的应用。
        - 2. 效果: 就是当你在绿色守护中添加了该应用，然后再设置休眠，当你关闭该应用后则杀死进程
          - 则释放了资源和减少了电量的消耗。
    - 2. 具体的功能
      - 启动界面
        1. 选择设备是root设备或未root设备
        2. 服务启动
      - 添加进行休眠的应用
        1. 点击＋ 后选择需要设置休眠的应用，然后点击√
        2. 在已经休眠的list列表中，选中可以启动应用。
        3. 添加的应用分为已经休眠和前台运行两种。
    - 3. 在绿色守护中的list列表界面
      - 设置 (很多设置基本不需要执行默认就可以)
        - 1. 刷新
        - 2. 去绿化
          - 恢复正常状态。
        - 3. 置于休眠状态
          - 杀死进程；
        - 4. 创建休眠快捷方式(openthos没有生成快捷方式)
          - 关闭屏幕并休眠；
          - 立即休眠；
        - 5. 设置
          - 工作模式
          - 唤醒追踪及切断
          - 全自动化休眠
          - 特殊方式关屏幕
          - 通知栏便捷控制
          ...
        - 6. 疑难问题
        - 7. 关于

    - 4. 实现
      - 绿色守护根据Xposed实现.
    - 操作注意:
      - 1. 屏幕锁定前有一个小的延时(至少５秒)
      - 2. 请勿开启“电源按钮立即锁定”
    - 3. 开源实现调研

### December - 19
  - 绿色守护文档完成。
  - 确认锁屏和绿色守护的功能是否存在冲突；
  - android 3.0中有些项目不适合upade就使用ignore;

### December - 20
  - 分析休眠功能，让其不直接进入锁屏；
  - 问题点:
    - 1. 当app被绿色守护添加后，系统休眠，app后台需要结束进程；
    - 2. 获取设备上所有已安装的应用作为数据源；
    - 3. 获取正在运行的应用；
    - 4. 刷新
  - 1298 自动睡眠时，唤醒后直接进入桌面，没有要求输入密码.
  - 1962 解锁一个任务栏的图标，旁边图标也跟着一起解锁.
  - 2072 自动化过程中，系统界面停止运行，必现，log见附件×
  - 1353 锁定任务栏,打开菜单图标,点击电源退出后,任务栏不显示.(隐藏任务栏情况下则可以).×

  - 将app预装到系统: 模仿: prebuilts/maven_repo/android/Android.mk的配置；
  - 学习githup上的项目: 然后　patchs式学习；

### December - 21
  - 晕车：
    1. 不能空胃坐车,但坐车前不能吃太饱.
    2. 坐车前喝加温水的醋.
    3. 保持愉快心情与人聊天.
    4. 靠前座靠车窗坐.
    5. 含糖果.薄荷味

### December - 22
  - 感冒休息

### December - 23
  - 分析SleepHelpter.














