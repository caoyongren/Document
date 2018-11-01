## ubuntu 16.04 编译 android-5.1 android-6.0 android-8.1
***
1.安装openjdk
  - sudo add-apt-repository ppa:openjdk-r/ppa
  - sudo apt-get update
  - sudo apt-get install openjdk-7-jdk

2.安装vim编辑器
  - sudo apt-get install vim

3.配置环境变量
  - sudo vim /etc/profile
```
在该文件最下方加入如下代码：
  JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
  PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
  export JAVA_HOME  
  export PATH 
保存退出
```

4.安装编译所需要的工具
  - sudo apt-get install git gnupg flex bison gperf build-essential zip curl libc6-dev libncurses5-dev:i386 x11proto-core-dev libx11-dev:i386 libreadline6-dev:i386  libgl1-mesa-dev g++-multilib tofrodos python-markdown libxml2-utils xsltproc zlib1g-dev:i386 dpkg-dev

5.配置必要的编译信息
  - sudo ln -s /usr/lib/i386-linux-gnu/mesa/libGL.so.1 /usr/lib/i386-linux-gnu/libGL.so
  - sudo apt-get install ccache 
  - source ~/.bashrc

6.安装git
  - sudo apt-get install git
  - git config --global  user.email "potatomagic@163.com"
  - git config --global  user.name "wangzhixu"

7.安装wget和repo用于同步
  - sudo apt-get install wget
  - sudo apt-get install wget --fix-missing
  - cd /usr/bin/
  - curl https://storage.googleapis.com/git-repo-downloads/repo
  - sudo chmod a+x  repo

8.创建目录
  - cd ~
  - mkdir openthos
  - cd openthos/

9.同步代码
  - repo init -u ssh://sunny.wang@192.168.144.122:29418/mtk_3561_bsp/atc/android/m/manifest   -b android-customer-m0.3561-smartauto  --repo-url=ssh://sunny.wang@192.168.144.122:29418/mtk_3561_bsp/git-repo
  - repo sync

10.编译
  - source build/envsetup.sh 
  - lunch 10
  - make -j32 iso_img
**备注**
  - 上面是传统的，bsp使用的自己写脚本: ./allmake.sh eng

11.编译报错，继续安装或更新缺少的补丁 
  - sudo apt-get install libgl1-mesa-dri:i386
  - wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32-binutils/mingw32-binutils_2.20-0.2ubuntu1_amd64.deb
  - wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32/mingw32_4.2.1.dfsg-2ubuntu1_amd64.deb
  - wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mingw32-runtime/mingw32-runtime_3.15.2-0ubuntu1_all.deb
  - sudo apt-get install -f
  - sudo dpkg -i *.deb

12.检查是否全部安装
  - sudo apt-get install git gnupg flex bison gperf build-essential zip curl libc6-dev libncurses5-dev:i386 x11proto-core-dev libx11-dev:i386 libreadline6-dev:i386 libgl1-mesa-dri:i386 libgl1-mesa-dev g++-multilib mingw32 tofrodos python-markdown libxml2-utils xsltproc zlib1g-dev:i386 dpkg-dev

12.清理无用补丁/工具
  - sudo apt autoremove

13.安装其他补丁/工具
  - sudo apt-get install python-mako
  - sudo apt-get install git-core bison zlib1g-dev flex libx11-dev gperf sudo aptitude  git-core gnupg flex bison gperf  libesd0-dev  build-essential zip curl libncurses5-dev zlib1g-dev
  - sudo apt-get update
  - sudo apt install gdebi-core
  - sudo apt-get install synaptic
  - sudo apt-get install ia32-libs
  
**卑职**
  - android 6.0还需要:
  - sudo apt-get install git-core gnupg flex bison gperf build-essential \ zip curl zlib1g-dev gcc-multilib g++-multilib libc6-dev-i386 \ lib32ncurses5-dev x11proto-core-dev libx11-dev lib32z-dev ccache \ libgl1-mesa-dev libxml2-utils xsltproc unzip m4

14.修改编译文件覆盖编译文件    (如果前面是编译报错则make clean后执行这一步)
  - cp /usr/bin/ld.gold prebuilts/gcc/linux-x86/host/x86_64-linux-glibc2.11-4.8/x86_64-linux/bin/ld
  - vim art/build/Android.common_build.mk
```
修改第119行（true改为false）(行号不是确定的)
-ifneq ($(WITHOUT_HOST_CLANG),true)
+ifneq ($(WITHOUT_HOST_CLANG),false)
```
--------------------- 
***
### 18.04系统编译android 6.0　-> BSP
***
#### 工具jdk-7和repo
  - 百度网盘: https://pan.baidu.com/s/10FkhhSAry8YoW_1NO--hJQ
  - sudo dpkg -i *.deb
  - 出错也继续执行: sudp apt-get -f install
#### 配置环境变量
  - 打开home目录下的~/.baserc文件，在文件最下面加入以下环境变量，注意修改成自己电脑对应的目录。保存后，在命令行下 source ~/.profile
  - export JRE_HOME=$JAVA_HOME/jre
  - export CLASSPATH=.:$JAVA_HOME/lib.tools.jar:$JRE_HOME/lib:$CLASSPATH
  - export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
  - export JAVA_HOME CLASSPATH PATH JRE_HOME
  - export LC_ALL=C
#### 安装依赖
```
sudo apt-get install -y git flex bison gperf build-essential libncurses5-dev:i386 
sudo apt-get install libx11-dev:i386 libreadline6-dev:i386 libgl1-mesa-dev g++-multilib 
sudo apt-get install tofrodos python-markdown libxml2-utils xsltproc zlib1g-dev:i386 
sudo apt-get install dpkg-dev libsdl1.2-dev libesd0-dev
sudo apt-get install git-core gnupg flex bison gperf build-essential  
sudo apt-get install zip curl zlib1g-dev gcc-multilib g++-multilib 
sudo apt-get install libc6-dev-i386 
sudo apt-get install lib32ncurses5-dev x11proto-core-dev libx11-dev 
sudo apt-get install lib32z-dev ccache
sudo apt-get install libgl1-mesa-dev libxml2-utils xsltproc unzip m4
sudo apt-get install git ccache automake lzop bison gperf build-essential zip curl zlib1g-dev zlib1g-dev:i386 g++-multilib python-networkx libxml2-utils bzip2 libbz2-dev libbz2-1.0 libghc-bzlib-dev squashfs-tools pngcrush schedtool dpkg-dev liblz4-tool make optipng maven
```
#### 特殊修改
```
/art/build/Android.common_build.mk
# Host.
ART_HOST_CLANG := false
ifneq ($(WITHOUT_HOST_CLANG),true)
  # By default, host builds use clang for better warnings.
  ART_HOST_CLANG := false (true 改为false)
endif
```
  - 若编译不过，则上面的true->false
  - cp /usr/bin/ld.gold prebuilts/gcc/linux-x86/host/x86_64-linux-glibc2.11-4.6/x86_64-linux/bin/ld 










