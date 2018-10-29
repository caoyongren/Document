### 一．Vim
  - 1.进入编辑： i
  - 2.强制退出(不保存)： :q!
  - 3.保存退出:  :wq
  - 4.补全键: Tab
  - 5.终止命令: ctrl + c
  - 6.查看文件前几行: head + number
  - 7.当前行的行首: ctrl + a
  - 8.当前行的尾行: ctrl + e
  - 9.置底： shift + g
  - 10.置顶: 双击 gg
  - 11.返回一般模式: esc
  - 12.撤销操作: u
  - 13.关闭未保存文件: .swp文件
  - 14.查找代码: shift + *  --> n
  - 15.检索word名: grep -rn "\<name\>"
  - 16.查找文件和文件夹: find -iname PhoneStatusBar.java
    find ./ -name Phone* //在某个目录中搜索
  - 17.对比源码: vimdiff
  - 18.分屏显示代码: vsp
    - 在一个文件的编辑中使用Vsp 另一个文件
  - 19.显示行号: set number
  - 20.删除粘贴： dd + p
  - 21.复制粘贴: y + number + p
  - 22.尾行输入: shift + a
  - 23.翻页(前): ctrl + b
  - 24.翻页(后): ctrl + f
  - 25.VISUAL模式:排版
    最好组合: shift + v；　+ shift + i ; + 空格移动．+ esc
    复制/粘贴: shift + v; + y + p
  - 26.字符串替换: :%s/aa/bb/g
  - 27.显示历史指令: :history
  - 28.查看磁盘信息: df -kh
  - 29.浏览文件内容：　cat XX.txt
  - 30.显示登录名: hostname
  - 31.只列出目录：　ls -F | grep /
  - 32.分屏: more
  - 33.vim　+ 行号：　vim filePath + number // vim PhoneStatusBar.java 353
  - 34.git 指令和vim指令结合: git log | grep "MasterMan"
  - 35.安装ctags跳转函数: sudo apt-get install ctags // ctags -R *//做标记
    ctrl + ] // 返回: ctrl + t
  - 36.vim -on file1 file2 //水平分屏幕
  - 37. vim -On file file2 //垂直分屏幕
  - 38. find ./ | grep "" | grep "" 逐级搜索
  - 39. 括号匹配: shift + %
  - 40. 

### 二. Git
  - 1.下载: git clone + GitPath
  - 2.git初始化: git init
  - 3.查看用户: git config --get-all user.name 
    git config --global user.name "name"
    git config --global user.email "email"
  - 4.删除配置: git config --unset --global user.name "Matthew"
  - 5.查看修改状态: git status
  - 6.查看修改: git diff //也可以看某行　git diff + path
  - 7.创建分之: git checkout -b multiwindow
  - 8.切换分之: git checkout MasterMan
  - 9.删除分之: git branch -D MasterMan
  - 10.增加新文件: git add new_file
  - 11.提交文件: git commit -a -m "patch name" // git commit -a -s //写补丁描述
  - 12.打补丁: git format-patch -M HEAD^
  - 13.推送补丁: 
    - git push origin 本地分之 : 远程分之
    - git pull devorg multiwindow:refs/heads/multiwindow
      在本地将本地A分之中的修改 提交到 远程 分之  B中
      git push origin A : B
      // origin 代表 远程地址
    - 将新建本地分支推送到远程分之(新建远程分支)
      -  git push orign -u newBranch (在当前要推送的分支上)
    - 删除远程分支：　本地分支删除后，　git push origin : newBranch (冒号代表删除)
    - git push origin local_branch:remote_branch (简洁)
    - 在本地目录下关联远程repository ：
       git remote add origin git@github.com:git_username/repository_name.git

    - 取消本地目录下关联的远程库：
       git remote remove origin
    
  - 14.回退当前版本: git reset HEAD^
    git revert HEAD^
　　　　git revert id_commit  //退到某个版本．
  - 15.现场保存: git stash
    恢复：　git stash apply
  - 16.应用本地补丁： git apply patch
  - 17.显示所有指令: git add -i
  - 18.git log --state online  ?????????
  - 19.标签 ?
  - 20.查看git分之: 
    vi .repo/manifests.git/config
    vi .repo/manifest.xml
  - 21.推送代码到服务器(firefox)
    1. git am patch
    2. git push origin multiwindow:refs/heads/multiwindow
    3. 发邮件
　　　　4. git pull devorg multiwindow:refs/heads/multiwindow(强行推送)
  - 22.查看提交的补丁: git log -p
  - 23.官方(githup)：
    首次：
    git init
    git add README.md
    git commit -m "first commit"
    git remote add origin git remote add origin https://github.com/caoyongren/Document.git
    git push -u origin master

    已存在
    git commit -a -s //写补丁描述
    git format-patch -M HEAD^
    git push -u origin master

  - 24.git提交代码冲突和解决方案
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

  - 25.查看git 地址: git remote -v

  - 26.回滚版本: git reset --hard HEAD~100
  - 27. 显示一行的log信息：　git log --oneline
  - 28.获取git配置信息: git config --list
  - 29. 将A分之合并到B分之: git checkout B  git merge A
  - 30. 打标签
    - 打标签  git tag  1.0-r1
    - 附加标注　　git tag -a 1.0-r1 -m "0.1.2版本"
    - 切换标签  git checkout []
    - 删除标签  git tag -d v1.0-r1
    - 推送标签到服务器  git push origin 1.0-r1  / git push origin -tags
    - 查看标签　git tab -l
    - 删除远程仓库中生成的标签  git push origin --delete tag tagname

  - 31. 二分查找
    - git bisect start
    - git bisect bad
    //确定一个坏的版本(一般就是当前版本)
    - git bisect good v1.0
    //确定一个好的版本
    - git bisect reset //重置你的HEAD指针到最开始的位置．
  - 32.取消暂存的文件
    - git reset HEAD file
    - 应用:
      - 当git add *后有文件不需要提交, 则进行git reset HEAD file取消

  - 33.修改提交
    - git commit --amend //主要应用修改commit描述
  - 34.数据恢复
    - 前提: 当master分之丢失，你需要他的两次最新提交
    - 1. git reflog //从log缓存中读取commit id
    - 2. git log -g //详细显示
    - 3. git branch recover_branch commit id//恢复到分之: recover_branch
    - 4. 成功恢复 commit id
   - 查看所有分之的最后一次的提交 
    - git branch -v
   - 从服务器中更新代码
    - git pull (git fetch git merge　之外) origin(远程仓库)　branch(远程分之)
   - 显示所有分支：　包括远程：　git branch -a
   - 对比另外的分之和当前分之的区别：　git diff multiwindow  .

  - 35. git push devorg multiwindow:refs/heads/multiwindow
    - 注意事项：　devorg
      - 利用：　git remote -v
      - 出现　　　aosp	git://192.168.0.185/lollipop/platform/frameworks/base (push)
      - 所以不要写　devorg　写　aosp
    - 要有本地branch． --> multiwindow
    - refs/heads/multiwindow  -- > 远程分支；
    - 补丁当前目录提交．
  - 36.将前面的几次提交的做成一个补丁:
    - 1. git checkout -b dev
    - 2. git reset --hard commitId
    - 3. git merge master --squash
    - 4. commit / format-patch
  - 37. 添加所有的要提交的文件: git add .
    - 添加了错误的文件: git reset HEAD^ file
  - 38. githup上团队协作
    - 1. 仓库--> settings --> Collaborators --> 写队员的账号--> 等他同意
        - 1. Collaborators --> 邮箱认证
        - 2. git 安装配置
        - 3. git clone --> git init
        - 4. git config
        - 5. git test
  - git push x86 mutliwindow:multiwindow //工作
  - git am --resolved //直接按照原有的补丁描述进行提交
  -  git push origin --delete Chapater6   可以删除远程分支Chapater6 
  - 要关联一个远程库，使用命令git remote add origin git@server-name:path/repo-name.git；

### 三．ubuntu
  - 1.进入文件夹: cd cyr/
  - 2.删除文件: rm debug.txt
  - 3.复制文件: cp -r object/ source/
  - 4.返回上一级: cd ..
  - 5.查看文件：
    - 1. ls
    - 2. ls-F //查看目录中的文件
    - 3. ls-I //显示文件和目录的详细资料
    - 4. ls-a //显示隐藏的文件
  - 6.创建文件夹： mkdir 
  - 7.赋予权限: sudo
  - 8.切换不同窗口: alt + tab
  - 9.解压和压缩:
    - tar -cf all.tar *.fiel //压缩
    - tar -xvf file.tar //解压
    - zip name.zip *.file //压缩
    - unzip file.zip　//解压

  - 10.查看目录: pwd
  - 11.显示日历: date
  - 12.关机: sudo shutdown -h now
  - 13.重启: sudo reboot -f
  - 14.查看磁盘: sudo fdisk -l
  - 15.将本地文件上传到服务器：
    scp ubunt.txt lh@192.168.0.180:/home/lh/cyr/
  - 16.将服务器文件拷贝到本地:
    scp -r lh@192.168.0.180:/home/lh/cyr/frameworks/
  - 17.重命名: mv A B
  - 18.开启终端: ctrl + shift + t
  - 19.解决文件管理器卡死:
    - ps -A | grep nautilus
    - sudo kill pid
  - 20.删除所有软件安装包: 
    sudo apt-get clean 
    sudo apt-get autoclean
    sudo apt-get remove + 软件名
    sudo apt-get autoremove
    sudo apt-get purge + 软件名
  - 切换JDK:
    - sudo update-java-alternatives -s java-8-oracle
    - sudo update-java-alternatives -s java-7-oracle
    - update-alternatives --config java
    - update-alternatives --config javac
    - 位置: /usr/lib/jvm
    - sudo vim /etc/profile
  - 超级键 + 方向键 // 打开窗口
  - 锁定屏幕: ctrl + alt + l
  - 截图: shift + printSc 
  - 启动qemu:
    qemu-system-x86_64 -cdrom out/target/product/x86_64/android_x86_64.iso -enable-kvm -serial stdio -m 1G -vga std
    qemu-system-x86_64 --enable-kvm -m 1024 -cdrom openthos/out/target/product/x86_64/android_x86_64.iso  //正常
  - 查看进程: ps aux
  - 简洁输出磁盘信息: df -h
  - 26 挂载：//手动将U盘/dev/sdb1挂载到/media/disk中。
    mount -t vfat /dev/sdb /media/disk
  - 27.查看ubuntu的log信息： dmesg | more
  - 28.查找文件位置: whereis file. 
  - 29.重启网络: /etc/init.d/networking restart
  - 30.安装无线网卡驱动:
    sudo apt-get install linux-headers-generic build-essential dkms    
    sudo apt-get update(optional maybe)    
    sudp apt-get install linux-source    
    sudo apt-get install --reinstall bcmwl-kernel-source （有可能只需要执行该步骤即可成功）  
    sudo modprobe wl
    sudo dpkg -i wireless-bcm43142-dkms_6.20.55.19-1_amd64.deb 
  - 31.安装音乐播放器: sudo apt-get install moc //打开: mocp
  - 32.安装terminator．
  - 33.修改terminator配置:sudo vim ~/.config/terminator/config
  - 34.安装软件: sudo apt-get install +apk
  - 35.任务栏换位置: gsettings set com.canonical.Unity.Launcher launcher-position Bottom
  - 36. 将一个文件夹中所有文件写入一个文件中:
    - ll >> aa.txt

  - 37.查看文件：
       ls
	ls-F  查看目录中的文件
        ls-I显示文件和目录的详细资料
	ls-a显示隐藏文件
  - 38.加权限:
    - chmod 777 文件夹
  - synaptic //删除孤立包


### git rebase 和 git merge 区别
  - git merge 是用来合并两个分之的．
    - git merge b
      - 将ｂ分之合并到当前分之．

  - git rebase b
   - 也是把ｂ分之合并到当前分支．

案例：

        origin

  c1<-- c2 

        myWork

然后，有人在origin上做了提交，　myWork也做了提交

                       origin

c1 <-- c2 < ---c3 <--- C4

               C5 <----C6
                        myWork

你可以git pull把origin上修改的的code拉下来，　然后　git merge.

                        origin

c1 <-- c2 < -- c3 < --- c4

       c2< --  c5 < --- c6< --- c7

                                myWork

但是，提交历史记录发生改变，如果要想保持和origin一样的提交历史：

　　- git checkout myWork
    - git rebase origin

原理：
　　- 把你的myWork分支里的每个提交取消掉，并且临时保存为补丁，
　　- ./git/rebase目录中，　然后再应用上．

    

### 解决冲突
  - git-add
  - git rebase --continue


***
gitHup账号: caoyongren  密码: caoyongren00
邮箱: m18410261910@163.com 密码:caoyongren00
CSDN: MatthewCaoYongren caoyongren00  or zhenxi2735768804 
  - Apple ID
    - matthewcaoyongren@163.com
    - Caoyongren00
    - 禹朴勇
    - 产品经理
    - 成武县

***

### 代码格式(源码风格)
  - 1. 逐级空格4个．
  - 2. 长度(不超过90)
  - 3. 括号中两个参数(a, b) 第二个要加空格．
  - 4. if () else () 要加空格．
  - 5. 方法名 () 加空格．
  - 6. 全局变量加m. mIsGood.
    全局布尔变量: mIs + name
  - 7.驼峰命名法:
    - 1. 类名: 首字母大写．(后面一样)
    - 2. 方法名: 首字母小写．(后面大写)
    - 3. 布局文件: 类型(item/fragment/layout) + 作用　+ (位置(main/))
    - 4. 布局文件中控件命名: 位置 + 控件缩写(tv/ig/ll) + 作用
  - 8. 连个方法间要加空行．
  - 9. 软编码(5.0课本)
  - 10. 字符串常量
    - 只有本类中使用: 定义全局静态变量大写．KEY_CONTANTS
    - 同包的两个类使用: 在一个类中定义，然后通过类调用．
    - Intent变量，写在　Intent类中．
    - 必要时, 定义在一个类中．
  - 11. 编码中不要出现静态变量．
  - 12. 多使用单利模式/ 工厂模式．
  - 13. 封装使用get/set 对外调用．(一个变量也要这样做)
  - 14. 代码要短:
    - 使用三目运算
  - 15. 代码方法和特殊变量要加英文注释．
  - 16. 封装方法考虑扩展性．
  - 17. 提交代码考虑全面(健壮性)

### Log调试
  - 模拟器调试(adb 指令)
    - 杀死其他进程: adb kill-server 
    - 新建日志文件: adb logcat > debug.log
    - 另起终端: tail -f debug.log  + 操作模拟器．

    - 安装apk: adb install xxx.apk
    - 重新安装: adb install -r XXX.apk
    - 卸载apk: adb uninstall xxx.apk
    - 查看连接的设备: adb devices
    - 导入文件到模拟器: adb push 文件　模拟器路径
    - 远程取Log： 
      - 远程连接: adb connect ip
      - adb logcat > debug.log
      - adb logcat | grep "MasterMan"
    - adb shell(进入模拟器) + 在SDK 中，tools-platform中的adb
    - pm指令
      - 禁用:pm disable packagePath 
    - 开启服务: adb start-server
    - 访问数据库: adb shell ; sqlites
    - 重启系统: adb reboot
    - 杀死adb: killall -9 adb
    - 打印Log堆栈: Log.d((TAG,Log.getStackTraceString(new Throwable()));
    - emulator //启动image模拟器
    -  

***

### Mysql
  - mysql root --root
  - mysql -u root -p
  - 密码: root

### docker
  - docker ps
  - 概念　??
  - 问题: 当无法进入docker
    - sudo docker kill dockerId
    - sudo docker kill -9 dockerId

### android studio 使用
  - ctrl + E ; 最近编辑的文件列表。
  
  - ctrl + [/]; 可以跳到大括号的开头 结尾

  - Ctrl+Shift+Backspace ；可以跳转到上次编辑的地方

  - Ctrl+F12，可以显示当前文件的结构。

  - Ctrl+F7可以查询当前元素在当前文件中的引用，然后按F3可以选择

  - ctrl+N，可以快速打开类 -- > 输入类名

  - Ctrl+Shift+N，可以快速打开文件 -- > 输入文件名

  - Alt+Q可以看到当前方法的声明

  - Ctrl+P，可以显示参数信息

  - Alt+Insert可以生成构造器/Getter/Setter等
  
  - Ctrl+Alt+T可以把代码包在一块内，例如try/catch

  - Alt+Up and Alt+Down可在方法间快速移动

  - Alt + Enter ; 导入包，自动修正

  - ctrl + R 替换文本

  - ctrl + f 本文件中查找 / ctrl + Shift + f 本工程中查找

  - Alt + Shift + c 对比最近修改的代码

  - Shift + F6 重构 - 重命名

  - ctrl + D 复制行

  - ctrl + /  ; 注释  ctrl + Shift + /  块注释

  - ctrl + shift + up /down ; 移动代码块

  - Shift + f2 ; 高亮错误快速定位

  - ctrl + g ; 输入行号；

  - ctrl + o 可以选择父类的方法进行重写；

  - ctrl + alt + space 类名自动完成；

  - ctrl + alt + o 删除多余包；

  - alt + f7 ;  -- > 选中右键 find usage 查找方法的调用处;

  - alt + f8 ;  -- > 选中右键 Evalute Expresion  ;deBUG 查看变量中的数据;

  - 连续点击两次 shift ---> 可以进行快速查找类.

  - Gson 快捷键: Alt + s

  - Alt+shift+C：查看工程的最近修改。

  - Ctrl+J  自动代码

  - Ctrl+E 最近打开的文件

  - Ctrl+H 显示类结构图

  - Ctrl+Q 显示注释文档

  - ctrl + {}  进行跳转
  - ctrl + alt + M　抽取为方法
  - ctrl + alt + A // git add

  - ctrl + K  //git commit

  - android studio中本类中修改一个变量
    1. ctrl + f进行搜索
    2. 点击后面的框, 进入修改

=================================================================
插件：
Lifecycle Sorter：
可以根据Activity或者fragment的生命周期对其生命周期方法位置进行先后排序，快捷键Ctrl + alt + K 

==================================================================
  ** android studio出现的异常及解决： **
  - 出现异常，找不到SDK 
  - 解决：：左上角File >> Setting >> Plugins >> 把Android Support勾选上，点击Apply，再点OK，会提示重启，重启完就好。
  - 运行按钮变暗
  - 解决： “Run”->“Edit Configurations  
    - 打开Run/Debug Configuration窗口。在窗口右侧找到“target device”部分，勾选“USB device”前面的单选框。点击“ok”。

内存泄露就是指,本应该回收的内存,还驻留在内存中。
  - android studio中在terminal中进行测试:
    - 测试：
  adb shell monkey -p 包名

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

***

### 反编译
  - 1. apktool d xx.apk
  - 2. apktool b xx ((xxx 为反编译apk出来的文件夹))

### firefox
  - 编译之前先进行make clean
  - ./mach build ./mach package ./mach install


===================
Ore 8.0开发文档
---
目前Android-8.0已经可以运行在原生Android emulator中。
为方便开发人员使用，已把需要的部分打包好，并写好执行的脚本方便调用：
下载：http://192.168.0.180/dl/sdk/emulator_oreo.tar.gz

1. 先在docker 7.1环境中，同步并编译好Android-8.0源码，将在out/target/product/emu_x86_64/生成需要的img；
2. 下载并解压emulator_oreo.tar.gz，将新编译生成的out/target/product/emu_x86_64/system-qemu.img和out/target/product/emu_x86_64/system/build.prop替换当前位置对应的文件。
3. 运行模拟器./run_emulator.sh


repo源码同步编译说明：
Android-8.0 的开发分支为multiwindow-oreo
repo init -u git://192.168.0.185/android-x86/manifest.git -b multiwindow-oreo 
repo sync --no-tags --no-clone-bundle --no-repo-verify
建立multiwindow-oreo开发分支：

repo start multiwindow-oreo --all
编译

source build/envsetup.sh
lunch openthos_emu_x86_64-eng
m -j20

======================
fennec开发文档
---
您好：

https://github.com/openthos/firefox-analysis/blob/master/README.md

环境搭建
目前是在ubuntu15下搭建的环境(16jdk太新，14太旧较难找到32位的libstdc++)

sudo add-apt-repository ppa:openjdk-r/ppa

sudo apt-get update

sudo apt-get install yasm git python-dbus mercurial automake autoconf autoconf2.13 build-essential ccache python-dev python-pip python-setuptools unzip uuid zip zlib1g-dev openjdk-7-jdk wget libncurses5:i386 libstdc++6:i386 zlib1g:i386

mkdir /firefox

cd /firefox

curl -sf -L https://static.rust-lang.org/rustup.sh > rustup.sh

chmod +x rustup.sh

./rustup.sh

./rustup.sh --add-target=i686-linux-android

源码下载
git clone https://github.com/mozilla/gecko-dev.git

 git://192.168.0.185/gecko-dev.git (实验室)

cd gecko-dev

git checkout -b r49-2016101919 remotes/origin/MOBILE4902_2016101919_RELBRANCH


预处理
./mach bootstrap

选择4（Firefox for android）

等下载完ndk后，即可强行停止（ctrl+c），对于r49分支，必须要用此对应的ndk，高版本的工具链内部会报错，低版本的功能不全。

此时ndk的路径是/root/.mozbuild/android-ndk-r11b



然后再找一个尽可能高版本的SDK，例如在180服务器上有一个，

cd ../

scp lh@192.168.0.180:/home/lh/wjx/sdk.tar.gz .

tar -zxvf sdk.tar.gz

解压后会在/firefox/Sdk目录下。



cd gecko-dev

vi mozconfig

增加以下内容

ac_add_options --enable-application=mobile/android

ac_add_options --target=i386-linux-android

ac_add_options --with-android-sdk="/firefox/Sdk"

ac_add_options --with-android-ndk="/root/.mozbuild/android-ndk-r11b"

mk_add_options MOZ_OBJDIR=./objdir-all

mk_add_options MOZ_MAKE_FLAGS="-j4"



关闭mozconfig，然后再。

vi mobile/android/confvars.sh

注释掉MOZ_INSTALL_TRACKING（在第49行），否则编译失败。

编译打包安装 
./mach build

./mach package

./mach install

大概需要1个小时左右（硬盘较快，40分钟左右；硬盘较慢，则1小时20分钟左右）。

如果是在OPENTHSO chroot ubuntu15下，则直接安装到本机，并可在开始菜单中直接运行。

参考链接
https://github.com/openthos/system-analysis/edit/master/firefox/build.md

https://developer.mozilla.org/en-US/docs/Mozilla/Developer_guide/Build_Instructions/Simple_Firefox_for_Android_build



####
- 1. AMS 和WMS的关系
- 2. TaskBar的进入freeform栈.
- 3. 获取Status bar 的实例。
- 4. memory jni.
- 5. android系统中有一个文件 proc / cat 进行查看
- 6. mount -t ext4 -o rw sdb /storage/disk0 ## 挂载移动硬盘到openthos.
- 7. 设计模式

谢谢


  



