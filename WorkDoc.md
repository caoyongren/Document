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
    1.修改不同的文件

    user1:
      git add -u
      git commit -m "update"
      git push

    user2:
      git add -u
      git commit -m "update"
      git push
  ....
    error: failed to push some refs to file ..
  ....
    解决：
      git fetch    //获取到的提交更新到本地用于跟踪共享版本库
  
      git merge origin/master

      git push

       git log -3 --graph --stat //查看


    2.修改相同文件的不同区域 / 同时修改文件名和内容

      user1.
        git push
  

      user2.
      ...
        git fetch
        git merge refs/remotes/origin/master
        git push
   3.同一个文件，同一区域
     user1:
       git add -u
       git commit -m "Say hello to "
       git push
 

     user2:
       git add -u
       git commit -m ""
       git pull
    ...
    error
    ...
    git status
    //最好是先同步---》

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
  - 36.

***
gitHup账号: caoyongren  密码: caoyongren00
邮箱: m18410261910@163.com 密码:caoyongren00
CSDN: MatthewCaoYongren caoyongren00  or zhenxi2735768804 

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
  - 概念　??





  



