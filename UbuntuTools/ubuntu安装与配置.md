## ubuntu 16.04 安装配置
#### 初入掘金，多多关照！
##### 扎实现在，遥望远方！
***
##### 写在前面的话:
  一年前刚入Openthos开发团队，给我分配一部台式机，我正要给它重装win7系统，一个前辈说，“我们这里不可以使用windows”, 我一脸懵逼的说，“那使用什么？”  “Linux系统， 你装一个ubuntu16.04吧”。 “哦哦”， 之前从没使用ubuntu16.04进行过开发，各种百度，各种折腾 ... 当初心想要有一套完整的教程该有多好！一年后，我喜欢上了ubuntu 16.04，然后我把之前零碎的记录，汇总在这里；
  
#### 安装
  [推荐双系统安装教程](https://blog.csdn.net/qq_28205153/article/details/52203512)
  
#### 和硬件相关的坑
*关机卡死*

*原因：基本就是显卡驱动太旧或硬件和kernal版本存在代沟!*

**解决：**

升级显卡，后文我会介绍，现在讲怎么升级kernal内核！

**方法:**

  - 1、 查看当前使用的内核版本:
  
  ``uname -a``
  - 下载新的内核，这里举例4.8
  
[下载4.8内核](http://kernel.ubuntu.com/~kernel-ppa/mainline/)

  - 三个文件
  
```
linux-headers-4.8.11-040811_4.8.11-040811.201611260431_all.deb 
linux-headers-4.8.11-040811-generic_4.8.11-040811.201611260431_amd64.deb 
linux-image-4.8.11-040811-generic_4.8.11-040811.201611260431_amd64.deb 
```

  - 下载后安装:
```
sudo dpkg -i ...
```

  - 再次查看已经安装的内核
```
sudo dpkg --get-selections | grep linux
```

  - 若没有效果，常规思路重启！
  
#### 安装后首先要做的事
  - 1、安装输入法: 推荐sogou输入法
  
[linux版本](https://pinyin.sogou.com/linux/?r=pinyin)
```
sudo apt update
sudo dpkg -i sogoupinyin_2.2.0.0102_amd64.deb
```

*安装之后需要再设置里面配置 / 还需要一次重启*

[更详细的sogou配置](http://www.linuxdiyf.com/linux/22075.html)

  - 2 、 安装goolge

```
sudo wget https://repo.fdzh.org/chrome/google-chrome.list -P /etc/apt/sources.list.d/
wget -q -O - https://dl.google.com/linux/linux_signing_key.pub  | sudo apt-key add -
sudo apt-get update
sudo apt-get install google-chrome-stable
//如果出现，google启动异常-再加一条
sudo apt install --reinstall libnss3
```

  - 更新显卡(特殊用户例如: 未来人类的笔记本)

```
sudo add-apt-repository ppa:graphics-drivers/ppa
sudo apt-get install nvidia-361
```

  - 清理不常用的软件

```
sudo apt-get remove libreoffice-common
sudo apt-get remove unity-webapps-common
sudo apt-get remove thunderbird totem rhythmbox empathy brasero simple-scan gnome-mahjongg aisleriot gnome-mines transmission-common gnome-orca webbrowser-app gnome-sudoku
sudo apt-get remove onboard deja-dup
sudo apt remove nano
```

  - 安装 vim / git / adb / android-tools-adb

```
sudo apt install vim
sudo apt install git
sudo apt install adb
sudo apt install android-tools-abd
```

*git和adb和vim的常用操作后面的文章会独立出来写*

  - 安装docky (模仿mac的底部锁定栏)

```
sudo apt-get install docky
```

**备注 安装的图形化软件，在launcher中检索(键盘win点击键)**

  - 安装 atom(因为感觉：markdown模式很爽)

```
sudo add-apt-repository ppa:webupd8team/atom
sudo apt-get update
sudo apt-get install atom
```

*注意: 预览crtl + shift + m不建议ubuntu上使用sublime编辑器，不支持中文，配置好了，之后使用也很别扭*

  - 安装 Shadowsocks-Qt5 （目前google翻墙最好用的工具）
  
```
sudo add-apt-repository ppa:hzwhuang/ss-qt5
sudo apt-get update
sudo apt-get install shadowsocks-qt5
```

  - google利用Shadowsocks-Qt5 + 搬瓦工翻墙
  
[推荐搬瓦工使用博客](https://blog.csdn.net/lym152898/article/details/69211302)

  - 安装 wps
  
[下载](http://linux.wps.cn/)

[字体配置推荐博客](https://www.cnblogs.com/EasonJim/p/7146587.html)

  - 一整套android-5.1源码编译的配置(只多不少)
  
```
1.安装openjdk
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-7-jdk

2.安装vim编辑器(前面已经安装)
sudo apt-get install vim

3.配置环境变量
sudo vim /etc/profile
在该文件最下方加入如下代码：
  JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
  PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
  export JAVA_HOME  
  export PATH 
保存退出

4.安装编译所需要的工具
sudo apt-get install gnupg flex bison gperf build-essential zip curl libc6-dev libncurses5-dev:i386 x11proto-core-dev libx11-dev:i386 libreadline6-dev:i386  libgl1-mesa-dev g++-multilib tofrodos python-markdown libxml2-utils xsltproc zlib1g-dev:i386 dpkg-dev

5.配置必要的编译信息
sudo ln -s /usr/lib/i386-linux-gnu/mesa/libGL.so.1 /usr/lib/i386-linux-gnu/libGL.so
sudo apt-get install ccache 
source ~/.bashrc

6.安装git
sudo apt-get install git
git config --global  user.email "potatomagic@163.com"
git config --global  user.name "wangzhixu"

7.安装wget和repo用于同步
sudo apt-get install wget
sudo apt-get install wget --fix-missing
cd /usr/bin/
## 本人工作的服务器:sudo wget  http://192.168.0.185/git-repo-downloads/repo 
curl http://gerrit.googlesource.com/git-repo/repo
sudo chmod a+x  repo

8.创建目录
cd ~
mkdir openthos
cd openthos/

9.同步代码
## 本人工作的服务器repo init -u git://192.168.0.185/lollipop-x86/manifest.git -b multiwindow
## 该网站搜索想要的版本: https://mirrors.tuna.tsinghua.edu.cn/help/AOSP/
repo sync

10.编译
source build/envsetup.sh 
lunch 10
makee -j32 iso_img

11.编译报错，继续安装或更新缺少的补丁 
sudo apt-get install libgl1-mesa-dri:i386
wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32-binutils/mingw32-binutils_2.20-0.2ubuntu1_amd64.deb
wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32/mingw32_4.2.1.dfsg-2ubuntu1_amd64.deb
wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32-runtime/mingw32-runtime_3.15.2-0ubuntu1_all.deb
sudo apt-get install -f
sudo dpkg -i *.deb

12.检查是否全部安装
sudo apt-get install git gnupg flex bison gperf build-essential zip curl libc6-dev libncurses5-dev:i386 x11proto-core-dev libx11-dev:i386 libreadline6-dev:i386 libgl1-mesa-dri:i386 libgl1-mesa-dev g++-multilib mingw32 tofrodos python-markdown libxml2-utils xsltproc zlib1g-dev:i386 dpkg-dev

12.清理无用补丁/工具
sudo apt autoremove

13.安装其他补丁/工具
sudo apt-get install python-mako
sudo apt-get install git-core bison zlib1g-dev flex libx11-dev gperf sudo aptitude  git-core gnupg flex bison gperf  libesd0-dev  build-essential zip curl libncurses5-dev zlib1g-dev
sudo apt-get update
sudo apt install gdebi-core
sudo apt-get install synaptic
sudo apt-get install ia32-libs

sudo apt-get install libssl-dev libelf-dev

14.修改编译文件覆盖编译文件
cp /usr/bin/ld.gold prebuilts/gcc/linux-x86/host/x86_64-linux-glibc2.11-4.8/x86_64-linux/bin/ld
vim art/build/Android.common_build.mk
修改第119行（true改为false）
-ifneq ($(WITHOUT_HOST_CLANG),true)
+ifneq ($(WITHOUT_HOST_CLANG),false)

15编译，针对某些机器，可能多线程编译会依然报错
make -j4 iso_img
make  iso_img

16安装模拟器，并运行镜像
sudo apt install qemu-system-x86
qemu-system-x86_64 --enable-kvm -m 1024 -cdrom ~/openthos/out/target/product/x86_64/android_x86_64.iso -vga cirrus -redir tcp:5555::5555 &

17. 提示: ubuntu16.04不能编译android-5.1可以使用14.04，但可以编译android-7.0 / (配置都是这一套)
曾看过的: https://blog.csdn.net/u014485786/article/details/51556655
```

- 安装: 音乐播放器 /视频播放器

```
sudo add-apt-repository ppa:forkotov02/ppa
sudo apt update
sudo apt-get install qmmp qmmp-plugin-pack
## 视频
sudo apt-add-repository ppa:rvm/smplayer
sudo apt-get update
sudo apt-get install smplayer smplayer-skins smplayer-themes
```

  - 安装android-studio / webstorm / 
 
[下载地址](https://developer.android.com/studio/?hl=zh-cn)
  
*创建快捷方式： 创建:/usr/share/applications/Studio.desktop*

```
[Desktop Entry]
Name = Studio
comment= android studio
Exec=/home/smaster/Sdisk/android-studio/bin/studio.sh
Icon=/home/smaster/Sdisk/android-studio/bin/studio.png
Terminal=false
Type=Application
```

**注意: 不能有任何空格，否则图标是白色！ webstorm自己不是太专业自行google吧！
扩展内存: vim android-studio/bin/studio64.vmoptions  //将Xmx后面的数值改大一些, 然后在 android-studio中settings/appearance/window options/ 勾上Show memory indicate**

***
##### 到这里配置完成/ 就可以歇歇;

#### ubuntu上快捷使用
  - 窗口控制的快捷键
 
*ctrl + win + up / ctrl + win + down / ctrl + win + left / ctrl + win + right   //自行尝试*

  - alt + tab / alt + ` 
  
***

##### 补充： 最近进军小程序(ubuntu上配置开发小程序)
  - 微信开发工具
```
git clone https://github.com/cytle/wechat_web_devtools.git
cd wechat_web_devtools
./bin/wxdt
```
  - 安装兼容层(wine)
```
sudo apt install wine
WINEARCH=win32 WINEPREFIX=~/.wine32 winecfg
cd wechat_web_devtools
./bin/wxdt install
## 启动
./bin/wxdt
```

[参考博客](https://www.jianshu.com/p/fe6ef14b02a3)

  - 安装sublime 2.02
  - 破解码：
```
----- BEGIN LICENSE ----- 
Andrew Weber 
Single User License 
EA7E-855605 
813A03DD 5E4AD9E6 6C0EEB94 BC99798F 
942194A6 02396E98 E62C9979 4BB979FE 
91424C9D A45400BF F6747D88 2FB88078 
90F5CC94 1CDC92DC 8457107A F151657B 
1D22E383 A997F016 42397640 33F41CFC 
E1D0AE85 A0BBD039 0E9C8D55 E1B89D5D 
5CDB7036 E56DE1C0 EFCC0840 650CD3A6 
B98FC99C 8FAC73EE D2B95564 DF450523 
------ END LICENSE ------ 
```

[汉子输入参考这个博文/3/2/通用](https://blog.csdn.net/ajianyingxiaoqinghan/article/details/78910182)

  - 安装node / npm /wepy
  [参考博文](https://blog.csdn.net/mrwangweijin/article/details/78106955)

  - 注意: 建立软连接
  - [WePy安装](https://tencent.github.io/wepy/document.html#/)
